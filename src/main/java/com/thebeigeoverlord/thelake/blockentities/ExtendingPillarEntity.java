package com.thebeigeoverlord.thelake.blockentities;

import com.thebeigeoverlord.thelake.TheLake;
import com.thebeigeoverlord.thelake.blocks.ExtendingPillar;
import com.thebeigeoverlord.thelake.blocks.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.TagManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class ExtendingPillarEntity extends BlockEntity{
	public ExtendingPillarEntity(BlockPos pPos, BlockState pBlockState) {
		super(ModBlockEntities.EXTENDING_PILLAR.get(), pPos, pBlockState);
		Minecraft.getInstance().player.sendSystemMessage(Component.literal("Ticked"));
	}

	public static void tick(Level level, BlockPos blockPos, BlockState blockState) {
		Minecraft.getInstance().player.sendSystemMessage(Component.literal("Ticked"));
		if(level.getBlockState(blockPos.below()).is(ForgeRegistries.BLOCKS.tags().createTagKey(ResourceLocation.of("minecraft:replaceable", ':')))) {
			level.setBlock(blockPos.below(),level.getBlockState(blockPos), 0);
		} else {
			level.setBlock(blockPos, Blocks.OAK_LOG.defaultBlockState(), 0);
		}

	}
}
