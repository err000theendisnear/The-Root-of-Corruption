package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class FlyplayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.push((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z));
		CavesoundProcedure.execute(world, x, y, z);
	}
}
