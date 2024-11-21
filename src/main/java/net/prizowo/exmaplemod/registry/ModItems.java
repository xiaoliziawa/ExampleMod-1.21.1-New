package net.prizowo.exmaplemod.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.prizowo.exmaplemod.Exmaplemod;
import net.prizowo.exmaplemod.item.custom.CustomHelmetItem;
import net.prizowo.exmaplemod.item.custom.ModArmorMaterials;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, Exmaplemod.MOD_ID);

    public static final Supplier<Item> SPHERE = ITEMS.register("sphere",
            () -> new BlockItem(ModBlocks.SPHERE.get(), new Item.Properties()));

    public static final Supplier<Item> CUSTOM_HELMET = ITEMS.register("custom_helmet",
            () -> new CustomHelmetItem(Holder.direct(ModArmorMaterials.CUSTOM), 
                new Item.Properties().stacksTo(1).durability(384)));
} 