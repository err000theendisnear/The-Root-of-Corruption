package i.see.you.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class FakeBreakblockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState block = Blocks.AIR.defaultBlockState();
		double xx = 0;
		double yy = 0;
		double zz = 0;
		xx = x + Mth.nextInt(RandomSource.create(), -16, 16);
		yy = y + Mth.nextInt(RandomSource.create(), -16, 16);
		zz = z + Mth.nextInt(RandomSource.create(), -16, 16);
		while (world.isEmptyBlock(BlockPos.containing(xx, yy, zz))) {
			xx = x + Mth.nextInt(RandomSource.create(), -16, 16);
			yy = y + Mth.nextInt(RandomSource.create(), -16, 16);
			zz = z + Mth.nextInt(RandomSource.create(), -16, 16);
		}
		block = (world.getBlockState(BlockPos.containing(xx, yy, zz)));
		PlaySoundProcedure.execute(world, x, y, z, 1, 1000, block.getSoundType().getBreakSound().getLocation().toString());
	}
}
