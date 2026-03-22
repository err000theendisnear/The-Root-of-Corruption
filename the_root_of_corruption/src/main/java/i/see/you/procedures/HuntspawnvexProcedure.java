package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class HuntspawnvexProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
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
}
