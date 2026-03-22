package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import i.see.you.init.TheRootOfCorruptionModBlocks;

public class GenfightProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), TheRootOfCorruptionModBlocks.THIS_IS_ALL_THEBLOCK_FAULT.get().defaultBlockState(), 3);
		if (Math.abs(x) + Math.abs(z) < 5000) {
			if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
				world.setBlock(BlockPos.containing(x, y, z + 1), TheRootOfCorruptionModBlocks.FIGHT_GEN.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
				world.setBlock(BlockPos.containing(x + 1, y, z), TheRootOfCorruptionModBlocks.FIGHT_GEN.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
				world.setBlock(BlockPos.containing(x, y, z - 1), TheRootOfCorruptionModBlocks.FIGHT_GEN.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
				world.setBlock(BlockPos.containing(x - 1, y, z), TheRootOfCorruptionModBlocks.FIGHT_GEN.get().defaultBlockState(), 3);
			}
		}
	}
}
