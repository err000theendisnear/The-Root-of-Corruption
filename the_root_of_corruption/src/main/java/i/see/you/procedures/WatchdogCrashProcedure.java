package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import i.see.you.configuration.ConfigConfiguration;
import i.see.you.TheRootOfCorruptionMod;

public class WatchdogCrashProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setCustomName(Component.literal("Watchdog"));
		entity.push(1, 1, 1);
		CavesoundProcedure.execute(world, x, y, z);
		TheRootOfCorruptionMod.queueServerWork((int) (double) ConfigConfiguration.WATCHDOG_CRASHTIME.get(), () -> {
			DiscardProcedure.execute(entity);
			if (ConfigConfiguration.CRASH.get()) {
				System.err.println("[Server Watchdog] A single server tick took watchdogtime seconds (should be max 0.05)".replace("watchdogtime", "" + (double) ConfigConfiguration.WATCHDOG_CRASHTIME.get() / 20));
				System.err.println("[Server Watchdog] Watching the server, this server is probably frozen");
				throw new Error("Watchdog");
			}
		});
	}
}
