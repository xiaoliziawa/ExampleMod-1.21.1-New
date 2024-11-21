package net.prizowo.exmaplemod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.prizowo.exmaplemod.registry.ModBlockEntities;

public class SphereBlockEntity extends BlockEntity {
    public SphereBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SPHERE.get(), pos, state);
    }
} 