package i.see.you.init;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;

import i.see.you.configuration.ConfigConfiguration;
import i.see.you.TheRootOfCorruptionMod;

@EventBusSubscriber(modid = TheRootOfCorruptionMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class TheRootOfCorruptionModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModList.get().getModContainerById("the_root_of_corruption").get().registerConfig(ModConfig.Type.COMMON, ConfigConfiguration.SPEC, "the_root_of_corruption_config.toml");
		});
	}
}
