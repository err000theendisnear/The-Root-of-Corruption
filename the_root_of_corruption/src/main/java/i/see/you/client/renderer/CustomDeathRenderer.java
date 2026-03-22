
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import i.see.you.entity.CustomDeathEntity;
import i.see.you.client.model.animations.CustomModelAnimation;
import i.see.you.client.model.ModelCustomModel;

public class CustomDeathRenderer extends MobRenderer<CustomDeathEntity, ModelCustomModel<CustomDeathEntity>> {
	public CustomDeathRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelCustomModel.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(CustomDeathEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/agag.png");
	}

	@Override
	protected boolean isShaking(CustomDeathEntity entity) {
		return true;
	}

	private static final class AnimatedModel extends ModelCustomModel<CustomDeathEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<CustomDeathEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(CustomDeathEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animateWalk(CustomModelAnimation.animation, limbSwing, limbSwingAmount, 1f, 1f);
				this.animateWalk(CustomModelAnimation.head, limbSwing, limbSwingAmount, 1f, 1f);
				this.animate(entity.animationState2, CustomModelAnimation.animation, ageInTicks, 1f);
				this.animate(entity.animationState3, CustomModelAnimation.head, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(CustomDeathEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
