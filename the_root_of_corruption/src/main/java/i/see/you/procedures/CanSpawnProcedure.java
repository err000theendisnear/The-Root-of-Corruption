package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class CanSpawnProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return ((world.getLevelData().getGameTime() % 24000)) > (13000) && ((world.getLevelData().getGameTime() % 24000)) < (20000) && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && Mth.nextInt(RandomSource.create(), 0, 100) == 1;
	}
}
