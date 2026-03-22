package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import i.see.you.TheRootOfCorruptionMod;

public class RomoveblockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		TheRootOfCorruptionMod.queueServerWork(3, () -> {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
		});
	}
}
