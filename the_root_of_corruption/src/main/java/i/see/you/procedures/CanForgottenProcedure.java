package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import i.see.you.entity.ForgottenPlayerEntity;

public class CanForgottenProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return Mth.nextInt(RandomSource.create(), 0, 50000) == 0 && !(!world.getEntitiesOfClass(ForgottenPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 66666, 66666, 66666), e -> true).isEmpty())
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 128, 128, 128), e -> true).isEmpty();
	}
}
