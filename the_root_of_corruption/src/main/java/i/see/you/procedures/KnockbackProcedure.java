package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class KnockbackProcedure {
	public static void execute(Entity entity, double knockback) {
		if (entity == null)
			return;
		double kb = 0;
		double back = 0;
		if (entity instanceof LivingEntity) {
			back = knockback;
			kb = Math.max(0, 1 - (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE) ? _livingEntity1.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getValue() : 0));
			Vec3 vec3 = entity.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(back * 0.6 * kb);
			if (vec3.lengthSqr() > 0.0) {
				entity.push(vec3.x, 0.1, vec3.z);
			}
		}
	}
}
