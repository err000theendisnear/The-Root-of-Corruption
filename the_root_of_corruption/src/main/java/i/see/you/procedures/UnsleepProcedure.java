package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;

public class UnsleepProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _player)
			_player.setGameMode(GameType.SURVIVAL);
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (entity instanceof Player _player)
			_player.getFoodData().setSaturation(0);
		if (entity instanceof Player _player)
			_player.getFoodData().setFoodLevel(5);
		if (entity instanceof Player _plr4)
			_plr4.resetAttackStrengthTicker();
		if (entity instanceof Player _plr && _plr.isFallFlying()) {
			_plr.stopFallFlying();
		}
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), 1);
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1));
		entity.igniteForSeconds(15);
		if (entity instanceof Player _plr)
			_plr.jumpFromGround();
	}
}
