package net.prizowo.exmaplemod.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.prizowo.exmaplemod.Exmaplemod;
import net.prizowo.exmaplemod.block.SphereBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, Exmaplemod.MOD_ID);

    public static final Supplier<Block> SPHERE = BLOCKS.register("sphere",
            () -> new SphereBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(5.0F, 6.0F)
                    .noOcclusion()
            ));
} 