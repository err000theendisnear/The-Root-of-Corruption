
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import i.see.you.entity.CustomDeathWatchEntity;
import i.see.you.client.model.animations.CustomModelAnimation;
import i.see.you.client.model.ModelCustomModel;

public class CustomDeathWatchRenderer extends MobRenderer<CustomDeathWatchEntity, ModelCustomModel<CustomDeathWatchEntity>> {
	public CustomDeathWatchRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelCustomModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CustomDeathWatchEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/agag.png");
	}

	@Override
	protected boolean isShaking(CustomDeathWatchEntity entity) {
		return true;
	}

	private static final class AnimatedModel extends ModelCustomModel<CustomDeathWatchEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<CustomDeathWatchEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(CustomDeathWatchEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, CustomModelAnimation.animation, ageInTicks, 1f);
				this.animate(entity.animationState1, CustomModelAnimation.head, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(CustomDeathWatchEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
