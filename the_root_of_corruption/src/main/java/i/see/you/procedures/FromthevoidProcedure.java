package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.TheRootOfCorruptionMod;

public class FromthevoidProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == Level.OVERWORLD) {
			TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = true;
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			entity.clearFire();
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 255));
			entity.fallDistance = 0;
			world.getLevelData().getGameRules().getRule(GameRules.RULE_KEEPINVENTORY).set(true, world.getServer());
			TheRootOfCorruptionMod.queueServerWork(100, () -> {
				if (entity instanceof LivingEntity _entity)
					_entity.removeAllEffects();
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 666, 10));
				{
					Entity _ent = entity;
					_ent.teleportTo(x, (world instanceof ServerLevel _level10 && _level10.isFlat() ? -65 : -60), z);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(x, (world instanceof ServerLevel _level10 && _level10.isFlat() ? -65 : -60), z, _ent.getYRot(), _ent.getXRot());
				}
				TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = false;
				TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
				TheRootOfCorruptionMod.queueServerWork(500, () -> {
					world.getLevelData().getGameRules().getRule(GameRules.RULE_KEEPINVENTORY).set(false, world.getServer());
				});
			});
		}
	}
}
