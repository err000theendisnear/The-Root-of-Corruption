package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import i.see.you.init.TheRootOfCorruptionModBlocks;

public class PlaceErrNullProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 10, 5), y + Mth.nextInt(RandomSource.create(), 10, 20), z + Mth.nextInt(RandomSource.create(), 10, 5)), TheRootOfCorruptionModBlocks.ERR_NULL.get().defaultBlockState(),
				3);
	}
}
