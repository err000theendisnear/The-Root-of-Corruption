package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

public class SoulspawnProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return Math.random() < 0.1 && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty());
	}
}
