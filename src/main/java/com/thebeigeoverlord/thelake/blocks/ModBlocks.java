package com.thebeigeoverlord.thelake.blocks;

import com.thebeigeoverlord.thelake.TheLake;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.thebeigeoverlord.thelake.TheLake.MODID;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	public static final RegistryObject<Block> EXTENDING_PILLAR = BLOCKS.register("extending_pillar", () -> new ExtendingPillar(BlockBehaviour.Properties.of()));
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
