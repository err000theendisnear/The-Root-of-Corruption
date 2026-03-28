package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;

import i.see.you.network.TheRootOfCorruptionModVariables;

public class BanplayerProcedure {
	public static void execute(LevelAccessor world) {
		TheRootOfCorruptionModVariables.MapVariables.get(world).ban = true;
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
	}
}
