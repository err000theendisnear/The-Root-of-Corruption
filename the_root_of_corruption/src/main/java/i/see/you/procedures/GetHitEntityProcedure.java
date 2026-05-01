package i.see.you.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class GetHitEntityProcedure {
	public static Entity execute(Entity entity, double maxDistance) {
		if (entity == null || maxDistance < 0)
			return null;
		if (entity instanceof Player player) {
			Vec3 eyePosition = player.getEyePosition();
        	Vec3 lookAngle = player.getLookAngle();
        	Vec3 endPoint = eyePosition.add(lookAngle.scale(maxDistance));
        	EntityHitResult hitResult = ProjectileUtil.getEntityHitResult(
            	player.level(),
            	player,
            	eyePosition,
            	endPoint,
            	player.getBoundingBox().expandTowards(lookAngle.scale(maxDistance)).inflate(1.0D),
            	(target) -> !target.isSpectator()
        	);
        	if (hitResult != null && hitResult.getEntity() != player) {
            	return hitResult.getEntity();
        	}
        	return null;
		}
		return null;
	}
}
