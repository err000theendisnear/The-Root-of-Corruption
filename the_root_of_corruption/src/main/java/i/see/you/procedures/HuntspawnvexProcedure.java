package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

import i.see.you.entity.UndefinedBossEntity;
import i.see.you.TheRootOfCorruptionMod;

public class HuntspawnvexProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof UndefinedBossEntity) {
			LogUndefinedProcedure.execute();
			entity.getPersistentData().putBoolean("Invulnerable", true);
			TheRootOfCorruptionMod.queueServerWork(20, () -> {
				entity.getPersistentData().putBoolean("Invulnerable", false);
			});
			if (entity instanceof UndefinedBossEntity _datEntSetI)
				_datEntSetI.getEntityData().set(UndefinedBossEntity.DATA_hp, (int) ((entity instanceof UndefinedBossEntity _datEntI ? _datEntI.getEntityData().get(UndefinedBossEntity.DATA_hp) : 0) + Mth.nextInt(RandomSource.create(), 1, 3)));
			if (0 == Mth.nextInt(RandomSource.create(), 0, 5)) {
				entity.push((Math.random() * Mth.nextInt(RandomSource.create(), -3, 3)), 0, (Math.random() * Mth.nextInt(RandomSource.create(), -3, 3)));
				if (0 == Mth.nextInt(RandomSource.create(), 0, 3)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.ELDER_GUARDIAN.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.GUARDIAN.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		} else {
			if (0 == Mth.nextInt(RandomSource.create(), 0, 10)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.VEX.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (0 == Mth.nextInt(RandomSource.create(), 0, 20)) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getPotion(Level level, Entity shooter, double ax, double ay, double az) {
									ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
									entityToSpawn.setItem(PotionContents.createItemStack(Items.SPLASH_POTION, Potions.STRONG_HEALING));
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setDeltaMovement(new Vec3(ax, ay, az));
									entityToSpawn.hasImpulse = true;
									return entityToSpawn;
								}
							}.getPotion(projectileLevel, entity, 0, (-3), 0);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				} else if (0 == Mth.nextInt(RandomSource.create(), 0, 10)) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getPotion(Level level, Entity shooter) {
									ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
									entityToSpawn.setItem(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.STRONG_HARMING));
									entityToSpawn.setOwner(shooter);
									return entityToSpawn;
								}
							}.getPotion(projectileLevel, entity);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
			}
		}
	}
}
