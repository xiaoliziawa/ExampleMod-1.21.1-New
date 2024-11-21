package net.prizowo.exmaplemod.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.FoxModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.LightTexture;
import org.jetbrains.annotations.NotNull;

public class RainbowFoxLayer extends RenderLayer<Fox, FoxModel<Fox>> {
    private final RenderLayerParent<Fox, FoxModel<Fox>> parent;

    public RainbowFoxLayer(RenderLayerParent<Fox, FoxModel<Fox>> parent) {
        super(parent);
        this.parent = parent;
    }

    @Override
    public void render(@NotNull PoseStack matrixStack, @NotNull MultiBufferSource buffer, int packedLight, Fox fox,
                        float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks,
                        float netHeadYaw, float headPitch) {
        if ("jeb_".equals(fox.getName().getString())) {
            float time = fox.tickCount * 0.05F;

            float r = (float) (Math.sin(time) * 0.5 + 0.5);
            float g = (float) (Math.sin(time + 2.0944) * 0.5 + 0.5);
            float b = (float) (Math.sin(time + 4.1888) * 0.5 + 0.5);

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(parent.getTextureLocation(fox)));

            this.getParentModel().prepareMobModel(fox, limbSwing, limbSwingAmount, partialTicks);
            this.getParentModel().setupAnim(fox, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

            int rInt = (int)(r * 255);
            int gInt = (int)(g * 255);
            int bInt = (int)(b * 255);

            int maxLight = LightTexture.pack(15, 15);

            this.getParentModel().renderToBuffer(
                    matrixStack,
                    vertexConsumer,
                    maxLight,
                    LivingEntityRenderer.getOverlayCoords(fox, 0.0F),
                    rInt | (gInt << 8) | (bInt << 16)
            );
        }
    }
} 