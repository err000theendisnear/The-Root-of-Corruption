package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;

import i.see.you.network.TheRootOfCorruptionModVariables;

public class VProcedure {
	public static boolean execute(LevelAccessor world) {
		return TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid;
	}
}
