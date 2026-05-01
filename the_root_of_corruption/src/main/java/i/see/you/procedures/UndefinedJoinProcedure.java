package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class UndefinedJoinProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		try {
			AddPlayerInPlayerListProcedure.execute(world, entity, "Undefined");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		LogUndefinedProcedure.execute();
	}
}
