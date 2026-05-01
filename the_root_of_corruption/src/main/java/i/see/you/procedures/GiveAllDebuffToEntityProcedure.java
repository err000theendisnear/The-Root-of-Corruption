package i.see.you.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import i.see.you.init.TheRootOfCorruptionModMobEffects;

public class GiveAllDebuffToEntityProcedure {
	public static void execute(Entity entity, boolean beacon, boolean particle, double level, double time) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
			int _time = (int) time;
			int _level = (int) level;
			_entity.addEffect(new MobEffectInstance(TheRootOfCorruptionModMobEffects.CORRUPTION, _time, _level, beacon, particle));
			for (MobEffect effect : BuiltInRegistries.MOB_EFFECT) {
				if (BuiltInRegistries.MOB_EFFECT.wrapAsHolder(effect).value().getCategory() == net.minecraft.world.effect.MobEffectCategory.HARMFUL)
					_entity.addEffect(new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(effect), _time, _level, beacon, particle));
			}
		}
	}
}
