
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TheRootOfCorruptionModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> ENABLE_EVENT;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		ENABLE_EVENT = GameRules.register("enableEvent", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	}
}
