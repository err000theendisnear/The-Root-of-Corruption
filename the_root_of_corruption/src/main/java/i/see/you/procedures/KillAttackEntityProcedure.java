package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class KillAttackEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		KillentityProcedure.execute(world, entity);
		entity.getPersistentData().putBoolean("die", true);
		sourceentity.getPersistentData().putBoolean("die", false);
		MissTortureProcedure.execute(world, x, y, z, entity, sourceentity);
	}
}
