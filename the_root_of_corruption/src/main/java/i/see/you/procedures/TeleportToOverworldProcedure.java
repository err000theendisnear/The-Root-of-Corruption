package i.see.you.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

public class TeleportToOverworldProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		TeleportDimensionProcedure.execute(Level.OVERWORLD, entity);
	}
}
