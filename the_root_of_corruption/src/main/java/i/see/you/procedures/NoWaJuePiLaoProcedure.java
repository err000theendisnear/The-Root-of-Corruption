package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.init.TheRootOfCorruptionModMobEffects;

public class NoWaJuePiLaoProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		MendingProcedure.execute(itemstack);
		TheRootOfCorruptionModVariables.MapVariables.get(world).on_surface = 0;
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 1));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 1));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 0));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 60, 3));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 60, 1));
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.WEAKNESS);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.DIG_SLOWDOWN);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(TheRootOfCorruptionModMobEffects.CORRUPTION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.WITHER);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.POISON);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.HUNGER);
	}
}
