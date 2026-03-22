package i.see.you.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import i.see.you.init.TheRootOfCorruptionModMobEffects;
import i.see.you.TheRootOfCorruptionMod;

public class ErrCorruptionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(TheRootOfCorruptionModMobEffects.CORRUPTION, 1000, 1));
		TheRootOfCorruptionMod.LOGGER.info("Event : Corruption");
	}
}
