package i.see.you.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class LookentityProcedure {
	public static boolean execute(Entity observer, Entity target) {
    	if (!(observer instanceof LivingEntity)) return false;
    	Vec3 eyePosition = observer.getEyePosition(1.0f);
    	Vec3 lookAngle = observer.getLookAngle();
    	AABB targetBoundingBox = target.getBoundingBox().inflate(1.0);
    	Vec3 traceEnd = eyePosition.add(lookAngle.x * 32, lookAngle.y * 32, lookAngle.z * 32);
    	EntityHitResult hitResult = ProjectileUtil.getEntityHitResult(
        	observer.level(), observer, eyePosition, traceEnd, targetBoundingBox,
        	(e) -> e == target
    	);
    	return hitResult != null && hitResult.getEntity() == target;
	}
}