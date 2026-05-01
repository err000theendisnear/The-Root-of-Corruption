package i.see.you.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class PlaceSoulFireProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x, y - 1, z)).getDestroySpeed(world, BlockPos.containing(x, y - 1, z)) > 0) {
			world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.SOUL_SAND.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y, z), Blocks.SOUL_FIRE.defaultBlockState(), 3);
		}
	}
}
