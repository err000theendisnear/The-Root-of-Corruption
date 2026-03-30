package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.player.CanPlayerSleepEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import i.see.you.entity.YourjavaisdieEntity;
import i.see.you.entity.WatcherEntity;
import i.see.you.entity.UndefinedOnSurfaceEntity;
import i.see.you.entity.UndefindstareEntity;
import i.see.you.entity.SteveEntity;
import i.see.you.entity.SoulEntity;
import i.see.you.entity.InvalidCreeperEntity;
import i.see.you.entity.InvadeCrashreportEntity;
import i.see.you.entity.GlitchCodeEntity;
import i.see.you.entity.CustomDeathWatchEntity;
import i.see.you.entity.Base0Entity;

@EventBusSubscriber
public class SleepProcedure {
	@SubscribeEvent
	public static void onPlayerInBed(CanPlayerSleepEvent event) {
		execute(event, event.getEntity().level(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(UndefindstareEntity.class, AABB.ofSize(new Vec3(x, y, z), 8000, 8000, 8000), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(UndefinedOnSurfaceEntity.class, AABB.ofSize(new Vec3(x, y, z), 8000, 8000, 8000), e -> true).isEmpty()) {
			UnsleepProcedure.execute(world, entity);
			AlertWindowsProcedure.execute("err.undefined", "err");
		} else if (!world.getEntitiesOfClass(YourjavaisdieEntity.class, AABB.ofSize(new Vec3(x, y, z), 10000, 10000, 10000), e -> true).isEmpty()) {
			if (!world.getEntitiesOfClass(YourjavaisdieEntity.class, AABB.ofSize(new Vec3(x, y, z), 8000, 8000, 8000), e -> true).isEmpty()) {
				AlertWindowsProcedure.execute("err.java_version=6.66", "err");
			} else {
				AlertWindowsProcedure.execute("err.wrong_java", "err");
			}
			UnsleepProcedure.execute(world, entity);
		} else if (!world.getEntitiesOfClass(SteveEntity.class, AABB.ofSize(new Vec3(x, y, z), 5000, 5000, 5000), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(SoulEntity.class, AABB.ofSize(new Vec3(x, y, z), 5000, 5000, 5000), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(Base0Entity.class, AABB.ofSize(new Vec3(x, y, z), 8000, 8000, 8000), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(InvadeCrashreportEntity.class, AABB.ofSize(new Vec3(x, y, z), 8000, 8000, 8000), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(WatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 8000, 8000, 8000), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(InvalidCreeperEntity.class, AABB.ofSize(new Vec3(x, y, z), 5000, 5000, 5000), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(GlitchCodeEntity.class, AABB.ofSize(new Vec3(x, y, z), 8000, 8000, 8000), e -> true).isEmpty()) {
			AlertWindowsProcedure.execute("err.invalid_entity", "err");
			UnsleepProcedure.execute(world, entity);
		} else if (!world.getEntitiesOfClass(CustomDeathWatchEntity.class, AABB.ofSize(new Vec3(x, y, z), 15000, 15000, 15000), e -> true).isEmpty()) {
			UnsleepProcedure.execute(world, entity);
			AlertWindowsProcedure.execute("I Watch you.", "err");
		}
	}
}
