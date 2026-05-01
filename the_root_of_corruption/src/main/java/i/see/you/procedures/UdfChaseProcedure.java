package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import i.see.you.init.TheRootOfCorruptionModParticleTypes;

public class UdfChaseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		player = NearbyPlayerProcedure.execute(world, entity);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheRootOfCorruptionModParticleTypes.ERROR.get()), x, y, z, 5, 1, 1, 1, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheRootOfCorruptionModParticleTypes.THIS_IS_NOT_FAIR.get()), x, y, z, 5, 1, 1, 1, 0);
		if (player == null) {
			if (player instanceof Player _player) {
				_player.getAbilities().flying = false;
				_player.onUpdateAbilities();
			}
			if (player instanceof ServerPlayer _player)
				_player.setGameMode(GameType.ADVENTURE);
			if (player instanceof Player _player) {
				_player.getAbilities().invulnerable = true;
				_player.onUpdateAbilities();
			}
			player.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), 1);
			if (player instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		} else {
			DiscardProcedure.execute(entity);
		}
	}
}
