package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import i.see.you.TheRootOfCorruptionMod;

public class ResetyourscreenProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TheRootOfCorruptionMod.queueServerWork(1200, () -> {
			DiscardProcedure.execute(entity);
		});
	}
}
