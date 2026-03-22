package i.see.you.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class ToCorruptionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (0 == Mth.nextInt(RandomSource.create(), 0, 1200)) {
			StartCorruptionProcedure.execute(world, x, y, z, blockstate);
		}
	}
}
