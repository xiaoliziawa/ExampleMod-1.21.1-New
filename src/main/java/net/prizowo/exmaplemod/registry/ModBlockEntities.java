package net.prizowo.exmaplemod.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.prizowo.exmaplemod.Exmaplemod;
import net.prizowo.exmaplemod.block.entity.SphereBlockEntity;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = 
        DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Exmaplemod.MOD_ID);

    public static final Supplier<BlockEntityType<SphereBlockEntity>> SPHERE = BLOCK_ENTITIES.register("sphere",
            () -> BlockEntityType.Builder.of(SphereBlockEntity::new, ModBlocks.SPHERE.get())
                    .build(null));
} 