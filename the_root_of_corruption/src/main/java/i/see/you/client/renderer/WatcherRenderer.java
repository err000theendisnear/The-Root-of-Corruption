
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import i.see.you.entity.WatcherEntity;
import i.see.you.client.model.animations.watcherAnimation;
import i.see.you.client.model.Modelwatch;

public class WatcherRenderer extends MobRenderer<WatcherEntity, Modelwatch<WatcherEntity>> {
	public WatcherRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelwatch.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WatcherEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/texture.png");
	}

	@Override
	protected boolean isShaking(WatcherEntity entity) {
		return true;
	}

	private static final class AnimatedModel extends Modelwatch<WatcherEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<WatcherEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(WatcherEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, watcherAnimation.animation, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(WatcherEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
