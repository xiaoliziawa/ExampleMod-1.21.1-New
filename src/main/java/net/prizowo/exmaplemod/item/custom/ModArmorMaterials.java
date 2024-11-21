package net.prizowo.exmaplemod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.prizowo.exmaplemod.Exmaplemod;

import java.util.List;

public class ModArmorMaterials {
    private static final int DURABILITY_MULTIPLIER = 33; // 这会让头盔的耐久度为 33 * 11 = 363

    public static final ArmorMaterial CUSTOM = new ArmorMaterial(
            ImmutableMap.of(
                    ArmorItem.Type.HELMET, 3,      // 防御值
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.BOOTS, 3
            ),
            19, // 附魔值
            Holder.direct(SoundEvents.ARMOR_EQUIP_NETHERITE.value()),
            () -> Ingredient.EMPTY,
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Exmaplemod.MOD_ID, "custom"))),
            2.0f,  // 韧性
            0.1f   // 击退抗性
    );
} 