package com.thebeigeoverlord.thelake.entities;

import com.thebeigeoverlord.thelake.TheLake;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheLake.MODID);
	public static final RegistryObject<EntityType<Angel>> ANGEL = ENTITY_TYPES.register("angel", () -> EntityType.Builder.of(Angel::new, MobCategory.MONSTER).build("angel"));

	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}
