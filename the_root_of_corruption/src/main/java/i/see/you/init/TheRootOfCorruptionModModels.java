
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import i.see.you.client.model.Modelwatch;
import i.see.you.client.model.Modelnothingiswatching;
import i.see.you.client.model.Modelinvade_crash_report;
import i.see.you.client.model.ModelUndefined;
import i.see.you.client.model.ModelCustomModel;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TheRootOfCorruptionModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelCustomModel.LAYER_LOCATION, ModelCustomModel::createBodyLayer);
		event.registerLayerDefinition(Modelwatch.LAYER_LOCATION, Modelwatch::createBodyLayer);
		event.registerLayerDefinition(Modelnothingiswatching.LAYER_LOCATION, Modelnothingiswatching::createBodyLayer);
		event.registerLayerDefinition(Modelinvade_crash_report.LAYER_LOCATION, Modelinvade_crash_report::createBodyLayer);
		event.registerLayerDefinition(ModelUndefined.LAYER_LOCATION, ModelUndefined::createBodyLayer);
	}
}
