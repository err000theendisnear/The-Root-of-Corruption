package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import i.see.you.TheRootOfCorruptionMod;

public class ToJumpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			_player.getAbilities().mayfly = false;
			_player.onUpdateAbilities();
		}
		for (int index0 = 0; index0 < 10; index0++) {
			TheRootOfCorruptionMod.queueServerWork((int) (20 * index0), () -> {
				if (entity instanceof ServerPlayer _player)
					_player.setGameMode(GameType.SURVIVAL);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.heartbeat")), SoundSource.VOICE, 100, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.heartbeat")), SoundSource.VOICE, 100, 1, false);
					}
				}
				if (entity instanceof Player _player)
					_player.closeContainer();
				if (entity instanceof Player _plr4)
					_plr4.resetAttackStrengthTicker();
				if (entity instanceof Player _plr && _plr.isFallFlying()) {
					_plr.stopFallFlying();
				}
				if (entity instanceof Player _player) {
					_player.getAbilities().flying = false;
					_player.onUpdateAbilities();
				}
				if (entity instanceof Player _plr)
					_plr.jumpFromGround();
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), 3);
			});
		}
	}
}
