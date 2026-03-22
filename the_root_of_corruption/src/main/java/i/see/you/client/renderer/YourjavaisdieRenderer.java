
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import i.see.you.entity.YourjavaisdieEntity;
import i.see.you.client.model.Modelnothingiswatching;

public class YourjavaisdieRenderer extends MobRenderer<YourjavaisdieEntity, Modelnothingiswatching<YourjavaisdieEntity>> {
	public YourjavaisdieRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnothingiswatching<YourjavaisdieEntity>(context.bakeLayer(Modelnothingiswatching.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(YourjavaisdieEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/t.png");
	}

	@Override
	protected boolean isShaking(YourjavaisdieEntity entity) {
		return true;
	}
}
