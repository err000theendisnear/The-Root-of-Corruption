
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CowModel;

import i.see.you.entity.UndefindchaseEntity;

public class UndefindchaseRenderer extends MobRenderer<UndefindchaseEntity, CowModel<UndefindchaseEntity>> {
	public UndefindchaseRenderer(EntityRendererProvider.Context context) {
		super(context, new CowModel<UndefindchaseEntity>(context.bakeLayer(ModelLayers.COW)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(UndefindchaseEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/white.png");
	}
}
