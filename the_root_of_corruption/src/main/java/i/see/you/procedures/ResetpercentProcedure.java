package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.configuration.ConfigConfiguration;

public class ResetpercentProcedure {
	public static void execute(LevelAccessor world) {
		TheRootOfCorruptionModVariables.MapVariables.get(world).event_count = (double) ConfigConfiguration.EVENT_INTERVAL.get();
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
	}
}
