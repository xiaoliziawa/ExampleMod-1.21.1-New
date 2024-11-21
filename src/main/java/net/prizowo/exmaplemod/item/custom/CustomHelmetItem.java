package net.prizowo.exmaplemod.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public class CustomHelmetItem extends ArmorItem {
    public CustomHelmetItem(Holder<ArmorMaterial> material, Item.Properties properties) {
        super(material, ArmorItem.Type.HELMET, properties);
    }
} 