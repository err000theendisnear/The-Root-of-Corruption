package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import i.see.you.entity.EmptyRendererEntity;
import i.see.you.configuration.ConfigConfiguration;

public class RendererExistProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return !world.getEntitiesOfClass(EmptyRendererEntity.class, AABB.ofSize(new Vec3(x, y, z), 1000, 1000, 1000), e -> true).isEmpty() && Math.random() < 0.5 && ConfigConfiguration.ALLOW_FLICKERING_SCREEN.get();
	}
}
