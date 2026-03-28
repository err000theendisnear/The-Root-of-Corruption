
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

import i.see.you.entity.SoulEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class SoulRenderer extends MobRenderer<SoulEntity, VillagerModel<SoulEntity>> {
	public SoulRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel<SoulEntity>(context.bakeLayer(ModelLayers.VILLAGER)), 0f);
	}

	@Override
	protected void scale(SoulEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.9375f, 0.9375f, 0.9375f);
	}

	@Override
	public ResourceLocation getTextureLocation(SoulEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/noise_white.png");
	}

	@Override
	protected boolean isShaking(SoulEntity entity) {
		return true;
	}
}
