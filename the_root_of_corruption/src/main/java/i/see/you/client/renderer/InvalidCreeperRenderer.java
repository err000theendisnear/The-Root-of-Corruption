
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CreeperModel;

import i.see.you.entity.InvalidCreeperEntity;

public class InvalidCreeperRenderer extends MobRenderer<InvalidCreeperEntity, CreeperModel<InvalidCreeperEntity>> {
	public InvalidCreeperRenderer(EntityRendererProvider.Context context) {
		super(context, new CreeperModel<InvalidCreeperEntity>(context.bakeLayer(ModelLayers.CREEPER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(InvalidCreeperEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/1101000_1100101_1101100_1110000.png");
	}

	@Override
	protected boolean isShaking(InvalidCreeperEntity entity) {
		return true;
	}
}
