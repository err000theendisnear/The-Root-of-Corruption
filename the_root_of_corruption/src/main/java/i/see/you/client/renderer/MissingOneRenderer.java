
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import i.see.you.entity.MissingOneEntity;
import i.see.you.client.model.animations.GoawayModelAnimation;
import i.see.you.client.model.ModelUndefined;

public class MissingOneRenderer extends MobRenderer<MissingOneEntity, ModelUndefined<MissingOneEntity>> {
	public MissingOneRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelUndefined.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MissingOneEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/1101000_1100101_1101100_1110000.png");
	}

	private static final class AnimatedModel extends ModelUndefined<MissingOneEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<MissingOneEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(MissingOneEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, GoawayModelAnimation.animation, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(MissingOneEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
