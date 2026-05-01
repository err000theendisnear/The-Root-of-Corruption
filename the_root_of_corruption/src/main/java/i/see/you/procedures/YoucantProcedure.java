package i.see.you.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.Difficulty;

import javax.annotation.Nullable;

@EventBusSubscriber
public class YoucantProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (world.getDifficulty() == Difficulty.PEACEFUL) {
			if (world.getServer() != null) {
				world.getServer().setDifficulty(Difficulty.EASY, true);
			}
		}
	}
}
