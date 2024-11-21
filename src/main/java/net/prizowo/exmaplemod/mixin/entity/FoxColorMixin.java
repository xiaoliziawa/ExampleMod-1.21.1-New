package net.prizowo.exmaplemod.mixin.entity;

import net.minecraft.client.renderer.entity.FoxRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.prizowo.exmaplemod.client.render.layer.RainbowFoxLayer;

@Mixin(FoxRenderer.class)
public abstract class FoxColorMixin {
    @Inject(
        method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V",
        at = @At("TAIL")
    )
    private void init(EntityRendererProvider.Context context, CallbackInfo ci) {
        ((FoxRenderer)(Object)this).addLayer(new RainbowFoxLayer((FoxRenderer)(Object)this));
    }
} 