package net.prizowo.exmaplemod;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.bus.api.IEventBus;
import net.prizowo.exmaplemod.client.render.block.SphereBlockRenderer;
import net.prizowo.exmaplemod.registry.ModBlocks;
import net.prizowo.exmaplemod.registry.ModItems;
import net.prizowo.exmaplemod.registry.ModBlockEntities;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

@Mod(Exmaplemod.MOD_ID)
public class Exmaplemod {
    public static final String MOD_ID = "exmaplemod";
    
    public Exmaplemod(IEventBus modEventBus) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        
        modEventBus.addListener(this::clientSetup);
    }
    
    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            BlockEntityRenderers.register(ModBlockEntities.SPHERE.get(), SphereBlockRenderer::new);
        });
    }
}
