package i.see.you.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import i.see.you.init.TheRootOfCorruptionModBlocks;
import i.see.you.TheRootOfCorruptionMod;

public class WatchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		player = NearbyPlayerProcedure.execute(world, entity);
		for (int index0 = 0; index0 < 5; index0++) {
			for (int index1 = 0; index1 < 4; index1++) {
				for (int index2 = 0; index2 < 4; index2++) {
					world.setBlock(BlockPos.containing(player.getX() - 2 + index2, player.getY() + index0, player.getZ() - 2 + index1), Blocks.AIR.defaultBlockState(), 3);
				}
			}
		}
		for (int index3 = 0; index3 < 3; index3++) {
			for (int index4 = 0; index4 < 4; index4++) {
				for (int index5 = 0; index5 < 4; index5++) {
					x1 = player.getX() - 2 + index4;
					y1 = player.getY() + 2 + index3;
					z1 = player.getZ() - 2 + index5;
					if (world instanceof ServerLevel _level)
						FallingBlockEntity.fall(_level, BlockPos.containing(Math.ceil(x1), y1, Math.floor(z1)), TheRootOfCorruptionModBlocks.BLOCK_IS_WATCHING_YOU.get().defaultBlockState());
					if (world instanceof ServerLevel _level)
						FallingBlockEntity.fall(_level, BlockPos.containing(Math.floor(x1), y1, Math.floor(z1)), TheRootOfCorruptionModBlocks.BLOCK_IS_WATCHING_YOU.get().defaultBlockState());
					if (world instanceof ServerLevel _level)
						FallingBlockEntity.fall(_level, BlockPos.containing(Math.ceil(x1), y1, Math.ceil(z1)), TheRootOfCorruptionModBlocks.BLOCK_IS_WATCHING_YOU.get().defaultBlockState());
					if (world instanceof ServerLevel _level)
						FallingBlockEntity.fall(_level, BlockPos.containing(Math.floor(x1), y1, Math.ceil(z1)), TheRootOfCorruptionModBlocks.BLOCK_IS_WATCHING_YOU.get().defaultBlockState());
				}
			}
		}
		TheRootOfCorruptionMod.queueServerWork(100, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.use")), SoundSource.VOICE, 1000, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.use")), SoundSource.VOICE, 1000, 1, false);
				}
			}
		});
	}
}
