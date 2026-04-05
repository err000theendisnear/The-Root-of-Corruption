package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.client.Minecraft;

import java.util.List;
import java.util.Comparator;

import i.see.you.TheRootOfCorruptionMod;

public class WatchdogtickupdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Minecraft mc = Minecraft.getInstance();
		if (world.isClientSide()) {
			mc.options.framerateLimit().set(10);
			mc.options.save();
		}
		TheRootOfCorruptionMod.LOGGER.info("Watchdog is here:" + Minecraft.getInstance().getFps() + " Watchdog is here:" + Minecraft.getInstance().options.framerateLimit().get());
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			}
		}
		entity.setSprinting(true);
	}
}
