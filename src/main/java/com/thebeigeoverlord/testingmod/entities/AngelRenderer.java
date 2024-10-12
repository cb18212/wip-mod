package com.thebeigeoverlord.testingmod.entities;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AngelRenderer extends GeoEntityRenderer<Angel> {
	public AngelRenderer(EntityRendererProvider.Context context) {
		super(context, new AngelGeoModel());
	}
}