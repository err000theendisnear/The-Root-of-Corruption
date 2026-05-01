
package i.see.you.client.renderer;

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

import i.see.you.entity.UndefinedleftthegameEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class UndefinedleftthegameRenderer extends HumanoidMobRenderer<UndefinedleftthegameEntity, HumanoidModel<UndefinedleftthegameEntity>> {
	public UndefinedleftthegameRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<UndefinedleftthegameEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		this.addLayer(new RenderLayer<UndefinedleftthegameEntity, HumanoidModel<UndefinedleftthegameEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("the_root_of_corruption:textures/entities/white.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, UndefinedleftthegameEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(UndefinedleftthegameEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/white.png");
	}

	@Override
	protected boolean isShaking(UndefinedleftthegameEntity entity) {
		return true;
	}
}
