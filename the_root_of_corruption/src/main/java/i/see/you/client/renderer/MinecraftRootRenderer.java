
package i.see.you.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import i.see.you.procedures.ReturnTrueProcedure;
import i.see.you.entity.MinecraftRootEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MinecraftRootRenderer extends HumanoidMobRenderer<MinecraftRootEntity, HumanoidModel<MinecraftRootEntity>> {
	public MinecraftRootRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<MinecraftRootEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		this.addLayer(new RenderLayer<MinecraftRootEntity, HumanoidModel<MinecraftRootEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("the_root_of_corruption:textures/entities/1101000_1100101_1101100_1110000.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MinecraftRootEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (ReturnTrueProcedure.execute()) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(MinecraftRootEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/1101000_1100101_1101100_1110000.png");
	}

	@Override
	protected boolean isShaking(MinecraftRootEntity entity) {
		return true;
	}
}
