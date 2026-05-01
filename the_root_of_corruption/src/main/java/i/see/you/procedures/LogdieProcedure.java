package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import i.see.you.init.TheRootOfCorruptionModParticleTypes;
import i.see.you.TheRootOfCorruptionMod;

public class LogdieProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String reportlog = "";
		Entity player = null;
		player = NearbyPlayerProcedure.execute(world, entity);
		if (player == null) {
			DiscardProcedure.execute(entity);
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.VOICE, 1000, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.VOICE, 1000, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:cave")), SoundSource.VOICE, 1000, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:cave")), SoundSource.VOICE, 1000, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.resonate")), SoundSource.VOICE, 1000, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.resonate")), SoundSource.VOICE, 1000, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:noise")), SoundSource.VOICE, 1000, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:noise")), SoundSource.VOICE, 1000, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheRootOfCorruptionModParticleTypes.ERROR.get()), x, y, z, Mth.nextInt(RandomSource.create(), 1, 2), 3, 3, 3, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SOUL, x, y, z, Mth.nextInt(RandomSource.create(), 1, 2), 3, 3, 3, 1);
			entity.stopRiding();
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			player.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			player.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), 1);
			player.igniteForSeconds(15);
			player.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			player.setAirSupply(0);
			if (player instanceof Player _plr && _plr.isFallFlying()) {
				_plr.stopFallFlying();
			}
			if (player instanceof Player _plr19)
				_plr19.resetAttackStrengthTicker();
			if (player instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
			if (player instanceof Player _player)
				_player.getFoodData().setSaturation(0);
			if (player instanceof Player _player)
				_player.getFoodData().setFoodLevel(0);
			if (player instanceof Player _player)
				_player.closeContainer();
			if (player instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("err"), true);
			if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 60, 255));
			if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 60, 255));
			if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 255));
			if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 255));
			if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 255));
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 10); index0++) {
				if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					reportlog = "run";
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					reportlog = "i see you";
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					reportlog = "null";
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					reportlog = "go away";
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					reportlog = "behind you";
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					reportlog = "get out";
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					reportlog = "error";
				} else {
					reportlog = "undefined";
				}
				TheRootOfCorruptionMod.LOGGER.info(reportlog);
				TheRootOfCorruptionMod.LOGGER.debug(reportlog);
				TheRootOfCorruptionMod.LOGGER.warn(reportlog);
				TheRootOfCorruptionMod.LOGGER.error(reportlog);
				TheRootOfCorruptionMod.LOGGER.fatal(reportlog);
			}
		}
	}
}
