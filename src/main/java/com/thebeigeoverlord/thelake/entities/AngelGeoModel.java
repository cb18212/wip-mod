package com.thebeigeoverlord.thelake.entities;

import com.thebeigeoverlord.thelake.TheLake;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class AngelGeoModel extends GeoModel {
	private final ResourceLocation model = new ResourceLocation(TheLake.MODID, "geo/angel.geo.json");
	private final ResourceLocation texture = new ResourceLocation(TheLake.MODID, "textures/entities/angel/texture.png");
	private final ResourceLocation animations = new ResourceLocation(TheLake.MODID, "animations/angel/model.animation.idle.json");

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