package i.see.you.procedures;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import i.see.you.init.TheRootOfCorruptionModMobEffects;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveAllNeutralEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity target) {
		    List<MobEffectInstance> harmfulEffects = target.getActiveEffects().stream()
            		.filter(effectInstance -> effectInstance.getEffect().value().getCategory() == MobEffectCategory.NEUTRAL)
            		.collect(Collectors.toList());
   	 		harmfulEffects.forEach(effectInstance -> target.removeEffect(effectInstance.getEffect()));
		}
	}
}
