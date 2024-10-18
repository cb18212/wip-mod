package com.thebeigeoverlord.thelake;

import com.mojang.logging.LogUtils;
import com.thebeigeoverlord.thelake.entities.Angel;
import com.thebeigeoverlord.thelake.entities.AngelRenderer;
import com.thebeigeoverlord.thelake.entities.ModEntities;
import com.thebeigeoverlord.thelake.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestingMod.MODID)
public class TestingMod
{
	// Define mod id in a common place for everything to reference
	public static final String MODID = "thelake";
	// Directly reference a slf4j logger
	private static final Logger LOGGER = LogUtils.getLogger();
	// Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	// Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	public static final RegistryObject<Block> STRUT_BLOCK = BLOCKS.register("strut", () -> new Block(BlockBehaviour.Properties.of()));
	public static final RegistryObject<Item> STRUT_BLOCK_ITEM = ITEMS.register("strut", () -> new BlockItem(STRUT_BLOCK.get(), new Item.Properties()));
	public TestingMod()
	{
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
		ModItems.register(modEventBus);
		ModEntities.register(modEventBus);

		// Register the commonSetup method for modloading
		modEventBus.addListener(this::commonSetup);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);

		// Register the item to a creative tab
		modEventBus.addListener(this::addCreative);
	}

	private void commonSetup(final FMLCommonSetupEvent event)
	{

	}

	// Add the example block item to the building blocks tab
	private void addCreative(BuildCreativeModeTabContentsEvent event)
	{
		if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.accept(ModItems.WTF);
			event.accept(ModItems.YEAH);
		}
	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event)
	{
		// Do something when the server starts
		LOGGER.info("HELLO from server starting");
	}

	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event)
	{
		Entity corpse = event.getEntity();
		Level level = corpse.level();
		System.out.println("Killed entity: " + corpse.getName().getString());
		if (!level.isClientSide)
		{
			Entity ghost = EntityType.ALLAY.create(level);
			if(ghost != null)
			{
				ghost.moveTo(corpse.blockPosition(),0.0f,0.0f);
				level.addFreshEntity(ghost);
			}

		}
	}

	// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
	@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents
	{
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event)
		{
			EntityRenderers.register(ModEntities.ANGEL.get(), AngelRenderer::new);
		}

		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
			event.put(ModEntities.ANGEL.get(), Angel.setAttributes());
		}

	}
}
