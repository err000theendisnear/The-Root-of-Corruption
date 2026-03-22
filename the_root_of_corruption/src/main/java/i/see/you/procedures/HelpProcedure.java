package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import i.see.you.network.TheRootOfCorruptionModVariables;

public class HelpProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		TheRootOfCorruptionModVariables.MapVariables.get(world).look_player = false;
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
				}
				return false;
			}
		}.checkGamemode(sourceentity)) {
			if (sourceentity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
		}
		if (sourceentity instanceof Player _player) {
			_player.getAbilities().mayBuild = true;
			_player.onUpdateAbilities();
		}
		if (sourceentity instanceof Player _player) {
			_player.getAbilities().invulnerable = false;
			_player.onUpdateAbilities();
		}
		if (sourceentity instanceof Player _player)
			_player.getFoodData().setSaturation(20);
		if (sourceentity instanceof Player _player)
			_player.getFoodData().setFoodLevel(20);
		if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 60, 0));
		if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 60, 2));
		if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 2));
		if (sourceentity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.WEAKNESS);
		if (sourceentity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
		if (sourceentity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.SLOW_FALLING);
		if (sourceentity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.WITHER);
		if (sourceentity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.DIG_SLOWDOWN);
		if (sourceentity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.BLINDNESS);
		if (sourceentity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.DARKNESS);
		if (sourceentity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.CONFUSION);
		if (sourceentity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.POISON);
		if (sourceentity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.UNLUCK);
	}
}
