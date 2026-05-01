package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;

import i.see.you.network.TheRootOfCorruptionModVariables;

public class CYSMProcedure {
	public static boolean execute(LevelAccessor world) {
		return TheRootOfCorruptionModVariables.MapVariables.get(world).canyouseeme;
	}
}
