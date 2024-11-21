package net.prizowo.exmaplemod.client.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.prizowo.exmaplemod.block.entity.SphereBlockEntity;
import org.joml.Matrix4f;

public class SphereBlockRenderer implements BlockEntityRenderer<SphereBlockEntity> {
    public SphereBlockRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(SphereBlockEntity blockEntity, float partialTicks, PoseStack poseStack, 
                      MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        poseStack.pushPose();
        
        Matrix4f matrix = poseStack.last().pose();
        VertexConsumer builder = buffer.getBuffer(RenderType.translucent());
        
        for (int i = 0; i <= 32; i++) {
            float lat = (float) (i * Math.PI / 32);
            float sinLat = (float) Math.sin(lat);
            float cosLat = (float) Math.cos(lat);
            
            for (int j = 0; j <= 32; j++) {
                float lon = (float) (j * 2 * Math.PI / 32);
                float sinLon = (float) Math.sin(lon);
                float cosLon = (float) Math.cos(lon);
                
                float x = cosLon * sinLat;
                float y = cosLat;
                float z = sinLon * sinLat;
                
                builder.addVertex(matrix, x * 0.5f, y * 0.5f + 0.5f, z * 0.5f)
                       .setColor(255, 255, 255, 255)
                       .setUv(j / 32.0f, i / 32.0f)
                       .setOverlay(combinedOverlay)
                       .setLight(combinedLight)
                       .setNormal(x, y, z);
                
                float nextLat = (float) ((i + 1) * Math.PI / 32);
                float nextSinLat = (float) Math.sin(nextLat);
                float nextCosLat = (float) Math.cos(nextLat);
                float nextX = cosLon * nextSinLat;
                float nextY = nextCosLat;
                float nextZ = sinLon * nextSinLat;
                
                builder.addVertex(matrix, nextX * 0.5f, nextY * 0.5f + 0.5f, nextZ * 0.5f)
                       .setColor(255, 255, 255, 255)
                       .setUv(j / 32.0f, (i + 1) / 32.0f)
                       .setOverlay(combinedOverlay)
                       .setLight(combinedLight)
                       .setNormal(nextX, nextY, nextZ);
            }
        }
        
        poseStack.popPose();
    }
} 