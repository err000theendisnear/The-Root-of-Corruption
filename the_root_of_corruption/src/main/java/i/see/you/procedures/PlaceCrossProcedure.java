package i.see.you.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import i.see.you.init.TheRootOfCorruptionModBlocks;

public class PlaceCrossProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState block = Blocks.AIR.defaultBlockState();
		if (Mth.nextInt(RandomSource.create(), 1, 250) == 1) {
			if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				block = Blocks.NETHERRACK.defaultBlockState();
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				block = Blocks.RED_NETHER_BRICKS.defaultBlockState();
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				block = Blocks.REDSTONE_BLOCK.defaultBlockState();
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				block = TheRootOfCorruptionModBlocks.FINISHED_NETHERREACTOR.get().defaultBlockState();
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				block = TheRootOfCorruptionModBlocks.CORRUPTIONBEDROCK.get().defaultBlockState();
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				block = TheRootOfCorruptionModBlocks.GLOWINGOBSIDIAN.get().defaultBlockState();
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				block = Blocks.OBSIDIAN.defaultBlockState();
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				block = Blocks.CRYING_OBSIDIAN.defaultBlockState();
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				block = Blocks.SMOOTH_BASALT.defaultBlockState();
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				block = TheRootOfCorruptionModBlocks.EXECUTEROOT.get().defaultBlockState();
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				block = Blocks.BEDROCK.defaultBlockState();
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				block = Blocks.COBBLESTONE.defaultBlockState();
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				block = TheRootOfCorruptionModBlocks.MISSINGNO.get().defaultBlockState();
			} else {
				block = Blocks.MOSSY_COBBLESTONE.defaultBlockState();
			}
			CrossProcedure.execute(world, x, y, z, block);
		}
		DiscardProcedure.execute(entity);
	}
}
