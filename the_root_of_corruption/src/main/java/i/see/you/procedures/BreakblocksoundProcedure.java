package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import java.lang.Exception;
import i.see.you.TheRootOfCorruptionMod;

public class BreakblocksoundProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		try {
	 		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 4, 7); index0++) {
				TheRootOfCorruptionMod.queueServerWork((int) (index0 * 9), () -> {
					FakeBreakblockProcedure.execute(world, x, y, z);
				});
			}
	 	} catch (Exception e) {
	 		e.printStackTrace();
	 	}
	}
}
