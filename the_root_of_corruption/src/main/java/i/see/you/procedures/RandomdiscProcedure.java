package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class RandomdiscProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity.isShiftKeyDown()) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.NOTE, x, y, z, 15, 1, 3, 1, 1);
			if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.blocks")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.blocks")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.relic")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.relic")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.stal")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.stal")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.strad")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.strad")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.ward")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.ward")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.far")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.far")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.mall")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.mall")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.mellohi")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.mellohi")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.cat")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.cat")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.chirp")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.chirp")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.creator")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.creator")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.pigstep")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.pigstep")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.wait")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.wait")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.otherside")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.otherside")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.creator_music_box")), SoundSource.RECORDS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.creator_music_box")), SoundSource.RECORDS, 1, 1, false);
					}
				}
			}
		} else {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.HEART, x, y, z, 7, 1, 3, 1, 1);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1));
		}
	}
}
