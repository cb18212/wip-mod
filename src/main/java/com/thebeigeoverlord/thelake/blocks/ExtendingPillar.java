package com.thebeigeoverlord.thelake.blocks;

import com.thebeigeoverlord.thelake.blockentities.ExtendingPillarEntity;
import com.thebeigeoverlord.thelake.blockentities.ModBlockEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ExtendingPillar extends BaseEntityBlock {
	public ExtendingPillar(Properties pProperties) {
		super(pProperties);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		Minecraft.getInstance().player.sendSystemMessage(Component.literal("io;ghrsaihuogrfs;aisukrjhgbdszgfriluhjk;b"));
		return new ExtendingPillarEntity(pPos, pState);
	}
	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
		if(pBlockEntityType == ModBlockEntities.EXTENDING_PILLAR.get()) {
			Minecraft.getInstance().player.sendSystemMessage(Component.literal("1"));
			return createTickerHelper(pBlockEntityType, ModBlockEntities.EXTENDING_PILLAR.get(),
					(pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
		}
		else {
			Minecraft.getInstance().player.sendSystemMessage(Component.literal("Failed creating pillar"));
			return null;
		}
	}

	@Override
	public void destroy(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
		super.destroy(pLevel, pPos, pState);
		Minecraft.getInstance().player.sendSystemMessage(Component.literal("Removed strut block"));
	}
}
