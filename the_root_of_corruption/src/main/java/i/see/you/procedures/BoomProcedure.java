package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;

public class BoomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, Mth.nextInt(RandomSource.create(), 1, 4), Level.ExplosionInteraction.NONE);
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, Mth.nextInt(RandomSource.create(), 1, 4), Level.ExplosionInteraction.MOB);
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, Mth.nextInt(RandomSource.create(), 1, 4), Level.ExplosionInteraction.BLOCK);
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, Mth.nextInt(RandomSource.create(), 1, 4), Level.ExplosionInteraction.TNT);
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:cave_noise_loud")),
							SoundSource.MASTER, 1000, 1);
				} else {
					_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:cave_noise_loud")), SoundSource.MASTER, 1000, 1,
							false);
				}
			}
		}
	}
}
