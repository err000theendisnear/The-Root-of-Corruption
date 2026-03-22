
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import i.see.you.entity.YourjavaisdieChaseEntity;
import i.see.you.client.model.Modelnothingiswatching;

public class YourjavaisdieChaseRenderer extends MobRenderer<YourjavaisdieChaseEntity, Modelnothingiswatching<YourjavaisdieChaseEntity>> {
	public YourjavaisdieChaseRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnothingiswatching<YourjavaisdieChaseEntity>(context.bakeLayer(Modelnothingiswatching.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(YourjavaisdieChaseEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/t.png");
	}
}
