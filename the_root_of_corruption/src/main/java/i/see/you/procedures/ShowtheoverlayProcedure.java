package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;

import i.see.you.network.TheRootOfCorruptionModVariables;

public class ShowtheoverlayProcedure {
	public static void execute(LevelAccessor world) {
		TheRootOfCorruptionModVariables.MapVariables.get(world).javachase = true;
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
	}
}
