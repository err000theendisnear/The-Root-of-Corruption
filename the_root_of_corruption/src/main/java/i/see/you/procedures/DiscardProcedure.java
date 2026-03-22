package i.see.you.procedures;

import net.minecraft.world.entity.Entity;

public class DiscardProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.level().isClientSide())
			entity.discard();
	}
}
