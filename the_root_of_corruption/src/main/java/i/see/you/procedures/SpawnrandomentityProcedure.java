package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import java.util.Comparator;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.init.TheRootOfCorruptionModEntities;

public class SpawnrandomentityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (0 == Mth.nextInt(RandomSource.create(), 0, 5) && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null)) == null && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && (entity.level().dimension()) == Level.OVERWORLD) {
			if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.UNDEFINDSTARE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else if (Minecraft.getInstance().getFps() > 120 && 1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.WATCHDOG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 3)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.SERVER_OWNER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 3)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.MISSING_ONE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else if (0 == Mth.nextInt(RandomSource.create(), 0, 4) && TheRootOfCorruptionModVariables.MapVariables.get(world).look_player) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.CUSTOM_DEATH_WATCH.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.BASE_0.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.INVADE_CRASHREPORT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.GLITCH_CODE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else if (0 == Mth.nextInt(RandomSource.create(), 0, 3)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.SOUL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.WATCHER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.STEVE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.RANDOM_CROSS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.YOURJAVAISDIE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else if (0 == Mth.nextInt(RandomSource.create(), 0, 1)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.INVALID_CREEPER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
		if (!entity.level().isClientSide())
			entity.discard();
	}
}
