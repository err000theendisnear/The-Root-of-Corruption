package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import i.see.you.init.TheRootOfCorruptionModItems;

public class BombProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:die")), SoundSource.BLOCKS, 100, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:die")), SoundSource.BLOCKS, 100, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:the_end_is_undefined")), SoundSource.VOICE, 100, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:the_end_is_undefined")), SoundSource.VOICE, 100, 1, false);
			}
		}
		for (int index0 = 0; index0 < 8; index0++) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, (float) index0, Level.ExplosionInteraction.NONE);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, (float) index0, Level.ExplosionInteraction.BLOCK);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, (float) index0, Level.ExplosionInteraction.MOB);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, (float) index0, Level.ExplosionInteraction.TNT);
		}
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheRootOfCorruptionModItems.ITEM_IS_MISSING_ID.get()));
			entityToSpawn.setPickUpDelay(0);
			entityToSpawn.setUnlimitedLifetime();
			_level.addFreshEntity(entityToSpawn);
		}
	}
}
