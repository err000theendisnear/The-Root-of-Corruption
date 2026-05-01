package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.TheRootOfCorruptionMod;

public class CanyouseemyselfProcedure {
	public static void execute(LevelAccessor world) {
		TheRootOfCorruptionModVariables.MapVariables.get(world).canyouseeme = true;
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		TheRootOfCorruptionMod.queueServerWork(50, () -> {
			TheRootOfCorruptionModVariables.MapVariables.get(world).canyouseeme = false;
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		});
	}
}
