
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import i.see.you.entity.SteveEntity;

public class SteveRenderer extends HumanoidMobRenderer<SteveEntity, HumanoidModel<SteveEntity>> {
	public SteveRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<SteveEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(SteveEntity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/steve_classic_texture_je6.png");
	}
}
