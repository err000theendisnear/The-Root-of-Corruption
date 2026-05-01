
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CowModel;

import i.see.you.entity.UndefindchaseEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class UndefindchaseRenderer extends MobRenderer<UndefindchaseEntity, CowModel<UndefindchaseEntity>> {
	public UndefindchaseRenderer(EntityRendererProvider.Context context) {
		super(context, new CowModel<UndefindchaseEntity>(context.bakeLayer(ModelLayers.COW)), 0.5f);
		this.addLayer(new RenderLayer<UndefindchaseEntity, CowModel<UndefindchaseEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("the_root_of_corruption:textures/entities/white.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, UndefindchaseEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(UndefindchaseEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/white.png");
	}
}
