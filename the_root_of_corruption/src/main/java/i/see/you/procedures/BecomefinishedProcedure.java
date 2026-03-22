package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import i.see.you.init.TheRootOfCorruptionModBlocks;
import i.see.you.TheRootOfCorruptionMod;

public class BecomefinishedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		TheRootOfCorruptionMod.queueServerWork(900, () -> {
			world.setBlock(BlockPos.containing(x, y, z), TheRootOfCorruptionModBlocks.FINISHED_NETHERREACTOR.get().defaultBlockState(), 3);
		});
	}
}
