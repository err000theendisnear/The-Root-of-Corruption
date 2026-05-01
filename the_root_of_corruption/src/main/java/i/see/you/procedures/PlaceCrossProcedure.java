package i.see.you.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import java.util.ArrayList;

import i.see.you.init.TheRootOfCorruptionModBlocks;

public class PlaceCrossProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ArrayList<Object> blocks = new ArrayList<>();
		if (Mth.nextInt(RandomSource.create(), 0, 375) == 1) {
			blocks.add(TheRootOfCorruptionModBlocks.THE_WORLD_IS_DYING.get().defaultBlockState());
			blocks.add(TheRootOfCorruptionModBlocks.ADMINISTRATOR.get().defaultBlockState());
			blocks.add(TheRootOfCorruptionModBlocks.BLOCK_IS_WATCHING_YOU.get().defaultBlockState());
			blocks.add(Blocks.NETHERRACK.defaultBlockState());
			blocks.add(Blocks.RED_NETHER_BRICKS.defaultBlockState());
			blocks.add(Blocks.REDSTONE_BLOCK.defaultBlockState());
			blocks.add(TheRootOfCorruptionModBlocks.GLOWINGOBSIDIAN.get().defaultBlockState());
			blocks.add(Blocks.MOSSY_COBBLESTONE.defaultBlockState());
			blocks.add(Blocks.BEDROCK.defaultBlockState());
			blocks.add(TheRootOfCorruptionModBlocks.FINISHED_NETHERREACTOR.get().defaultBlockState());
			blocks.add(Blocks.OBSIDIAN.defaultBlockState());
			blocks.add(Blocks.COBBLESTONE.defaultBlockState());
			blocks.add(Blocks.CRYING_OBSIDIAN.defaultBlockState());
			blocks.add(TheRootOfCorruptionModBlocks.EXECUTEROOT.get().defaultBlockState());
			blocks.add(Blocks.SMOOTH_BASALT.defaultBlockState());
			blocks.add(TheRootOfCorruptionModBlocks.CORRUPTIONBEDROCK.get().defaultBlockState());
			blocks.add(TheRootOfCorruptionModBlocks.MISSINGNO.get().defaultBlockState());
			blocks.add(TheRootOfCorruptionModBlocks.ERRUNDEFINED.get().defaultBlockState());
			blocks.add(Blocks.OAK_SIGN.defaultBlockState());
			blocks.add(Blocks.JIGSAW.defaultBlockState());
			CrossProcedure.execute(world, x, y, z, (blocks.get(Mth.nextInt(RandomSource.create(), 0, (int) (blocks.size() - 1))) instanceof BlockState _state23 ? _state23 : Blocks.AIR.defaultBlockState()));
		}
		DiscardProcedure.execute(entity);
	}
}
