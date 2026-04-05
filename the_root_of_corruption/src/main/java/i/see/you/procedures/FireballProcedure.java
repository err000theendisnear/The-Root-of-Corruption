package i.see.you.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class FireballProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.stopRiding();
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
		entity.clearFire();
		if (Mth.nextInt(RandomSource.create(), 0, 175) == 0) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getFireball(Level level, Entity shooter) {
							AbstractHurtingProjectile entityToSpawn = new LargeFireball(EntityType.FIREBALL, level);
							entityToSpawn.setOwner(shooter);
							return entityToSpawn;
						}
					}.getFireball(projectileLevel, entity);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			entity.push(0, 0.5, 0);
		} else if (Mth.nextInt(RandomSource.create(), 0, 50) == 0) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getFireball(Level level, Entity shooter) {
							AbstractHurtingProjectile entityToSpawn = new SmallFireball(EntityType.SMALL_FIREBALL, level);
							entityToSpawn.setOwner(shooter);
							return entityToSpawn;
						}
					}.getFireball(projectileLevel, entity);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		}
	}
}
