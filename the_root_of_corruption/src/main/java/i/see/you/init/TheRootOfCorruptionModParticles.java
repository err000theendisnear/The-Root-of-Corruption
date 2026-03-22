
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import i.see.you.client.particle.ThisIsNotFairParticle;
import i.see.you.client.particle.ErrorParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheRootOfCorruptionModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(TheRootOfCorruptionModParticleTypes.ERROR.get(), ErrorParticle::provider);
		event.registerSpriteSet(TheRootOfCorruptionModParticleTypes.THIS_IS_NOT_FAIR.get(), ThisIsNotFairParticle::provider);
	}
}
