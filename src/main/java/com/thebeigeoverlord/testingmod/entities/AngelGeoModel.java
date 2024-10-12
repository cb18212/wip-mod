package com.thebeigeoverlord.testingmod.entities;

import com.thebeigeoverlord.testingmod.TestingMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.GeckoLib;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.util.GeckoLibUtil;

public class AngelGeoModel extends GeoModel {
	private final ResourceLocation model = new ResourceLocation(TestingMod.MODID, "geo/angel.geo.json");
	private final ResourceLocation texture = new ResourceLocation(TestingMod.MODID, "textures/entities/angel/texture.png");
	private final ResourceLocation animations = new ResourceLocation(TestingMod.MODID, "animations/angel/model.animation.idle.json");

	@Override
	public ResourceLocation getModelResource(GeoAnimatable geoAnimatable) {
		return this.model;
	}

	@Override
	public ResourceLocation getTextureResource(GeoAnimatable geoAnimatable) {
		return this.texture;
	}

	@Override
	public ResourceLocation getAnimationResource(GeoAnimatable geoAnimatable) {
		return this.animations;
	}
}