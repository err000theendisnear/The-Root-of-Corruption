package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import i.see.you.network.TheRootOfCorruptionModVariables;

public class ShowoverlayProcedure {
	public static boolean execute(LevelAccessor world) {
		return Mth.nextInt(RandomSource.create(), 1, 10) == 1 && TheRootOfCorruptionModVariables.MapVariables.get(world).javachase;
	}
}
