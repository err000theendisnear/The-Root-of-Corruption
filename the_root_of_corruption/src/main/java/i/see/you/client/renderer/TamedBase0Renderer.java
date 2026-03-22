
package i.see.you.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import i.see.you.entity.TamedBase0Entity;

public class TamedBase0Renderer extends HumanoidMobRenderer<TamedBase0Entity, HumanoidModel<TamedBase0Entity>> {
	public TamedBase0Renderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<TamedBase0Entity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(TamedBase0Entity entity) {
		return ResourceLocation.parse("the_root_of_corruption:textures/entities/null.png");
	}
}
