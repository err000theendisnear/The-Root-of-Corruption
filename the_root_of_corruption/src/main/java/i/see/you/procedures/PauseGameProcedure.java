package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.Minecraft;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.TheRootOfCorruptionMod;

public class PauseGameProcedure {
	public static void execute(LevelAccessor world) {
		if (TheRootOfCorruptionModVariables.MapVariables.get(world).unpauseable) {
			TheRootOfCorruptionMod.LOGGER.warn("Cannot to pause game");
		} else {
			try {
				Minecraft.getInstance().execute(() -> {
					Minecraft.getInstance().pauseGame(false);
				});
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}
