package i.see.you.procedures;

import net.minecraft.world.entity.Entity;

public class TryCrashProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		DiscardProcedure.execute(entity);
		TruecrashProcedure.execute();
	}
}
