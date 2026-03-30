
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import i.see.you.entity.MissingOneChaseEntity;
import i.see.you.client.model.ModelUndefined;

public class MissingOneChaseRenderer extends MobRenderer<MissingOneChaseEntity, ModelUndefined<MissingOneChaseEntity>> {
	public MissingOneChaseRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelUndefined<MissingOneChaseEntity>(context.bakeLayer(ModelUndefined.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MissingOneChaseEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/1101000_1100101_1101100_1110000.png");
	}

	@Override
	protected boolean isShaking(MissingOneChaseEntity entity) {
		return true;
	}
}
