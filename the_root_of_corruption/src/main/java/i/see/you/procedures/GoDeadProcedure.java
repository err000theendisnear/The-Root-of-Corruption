package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class GoDeadProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).isEmpty()) {
			DiscardProcedure.execute(entity);
			CavesoundProcedure.execute(world, x, y, z);
			if (Math.random() < 0.01) {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, y, z, 10, Level.ExplosionInteraction.TNT);
			}
		}
	}
}
