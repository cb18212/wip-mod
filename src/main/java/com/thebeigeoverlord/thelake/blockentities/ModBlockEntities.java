package com.thebeigeoverlord.thelake.blockentities;

import com.thebeigeoverlord.thelake.TheLake;
import com.thebeigeoverlord.thelake.blocks.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TheLake.MODID);

	public static final RegistryObject<BlockEntityType<ExtendingPillarEntity>> EXTENDING_PILLAR =
			BLOCK_ENTITIES.register("extending_pillar", () ->
					BlockEntityType.Builder.of(ExtendingPillarEntity::new,
						ModBlocks.EXTENDING_PILLAR.get()).build(null));
	public static void register(IEventBus eventBus) {
		BLOCK_ENTITIES.register(eventBus);
	}

}
