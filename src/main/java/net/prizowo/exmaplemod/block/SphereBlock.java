package net.prizowo.exmaplemod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.prizowo.exmaplemod.block.entity.SphereBlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SphereBlock extends BaseEntityBlock {
    public static final MapCodec<SphereBlock> CODEC = simpleCodec(SphereBlock::new);
    private static final VoxelShape SHAPE = makeShape();

    public SphereBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SphereBlockEntity(pos, state);
    }

    private static VoxelShape makeShape() {
        VoxelShape shape = Shapes.empty();
        double radius = 6.0;
        double centerX = 8.0;
        double centerY = 8.0;
        double centerZ = 8.0;
        double step = 1.0;

        for (double x = 0; x <= 16; x += step) {
            for (double y = 0; y <= 16; y += step) {
                for (double z = 0; z <= 16; z += step) {
                    double distanceSquared = 
                        Math.pow(x - centerX, 2) +
                        Math.pow(y - centerY, 2) +
                        Math.pow(z - centerZ, 2);
                    
                    if (distanceSquared <= radius * radius) {
                        shape = Shapes.or(shape, 
                            Shapes.box(
                                x/16.0, y/16.0, z/16.0,
                                (x+step)/16.0, (y+step)/16.0, (z+step)/16.0
                            ));
                    }
                }
            }
        }
        
        return shape.optimize();
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean useShapeForLightOcclusion(@NotNull BlockState state) {
        return true;
    }
} 