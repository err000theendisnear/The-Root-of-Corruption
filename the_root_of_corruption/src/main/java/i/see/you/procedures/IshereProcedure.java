package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import i.see.you.entity.MissingOneChaseEntity;

public class IshereProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return !world.getEntitiesOfClass(MissingOneChaseEntity.class, AABB.ofSize(new Vec3(x, y, z), 444, 444, 444), e -> true).isEmpty();
	}
}
