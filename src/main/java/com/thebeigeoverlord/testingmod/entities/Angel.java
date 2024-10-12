package com.thebeigeoverlord.testingmod.entities;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class Angel extends FlyingMob implements GeoEntity, Enemy, RangedAttackMob {
	protected static final RawAnimation HOVER_ANIM = RawAnimation.begin().thenLoop("animation.model.idle");
	private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
	public Angel(EntityType<? extends Angel> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);

	}

	public static AttributeSupplier setAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 300)
				.add(Attributes.FLYING_SPEED, 300).build();
	}

//	@Override
//	public void tick() {
//		super.tick();
//		for(int x = 0; x < 10; x++){
//			for(int y = 0; y < 10; y++){
//				for(int z = 0; z < 10; z++) {
//					level().getBlockState(blockPosition().offset(, , ))
//				}
//			}
//		}
//	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(5, new FloatGoal(this));
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
		controllerRegistrar.add(new AnimationController<>(this, 0, this::eyeAnimController));
	}

	protected PlayState eyeAnimController(final AnimationState<Angel> event) {
		event.setAndContinue(HOVER_ANIM);
		return PlayState.CONTINUE;
	}
	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.geoCache;
	}

	@Override
	public void performRangedAttack(LivingEntity livingEntity, float v) {

	}
}
