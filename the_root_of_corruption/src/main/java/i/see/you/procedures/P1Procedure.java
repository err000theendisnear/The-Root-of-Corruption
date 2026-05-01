package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;

import i.see.you.network.TheRootOfCorruptionModVariables;

public class P1Procedure {
	public static boolean execute(LevelAccessor world) {
		return TheRootOfCorruptionModVariables.MapVariables.get(world).screen_phase == 1;
	}
}
