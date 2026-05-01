package i.see.you.procedures;

import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import javax.annotation.Nullable;

import i.see.you.configuration.ConfigConfiguration;
import i.see.you.TheRootOfCorruptionMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class HelloProcedure {
	@SubscribeEvent
	public static void init(FMLClientSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		if (ConfigConfiguration.TRASH_LOG.get()) {
			if (Math.random() < 0.05) {
				TheRootOfCorruptionMod.LOGGER.warn("Hello World?");
			} else {
				TheRootOfCorruptionMod.LOGGER.info("Hello World!");
			}
		}
	}
}
