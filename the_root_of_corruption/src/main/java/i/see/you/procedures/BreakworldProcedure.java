package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import i.see.you.init.TheRootOfCorruptionModEntities;
import i.see.you.init.TheRootOfCorruptionModBlocks;
import i.see.you.entity.SmallBombEntity;
import i.see.you.TheRootOfCorruptionMod;

public class BreakworldProcedure {
	private static final RandomSource RANDOM = RandomSource.create();
	
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		try {
			run(world, x, y, z, entity);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private static void run(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.getLevelData().setRaining(true);
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.MOB);
		for (int index0 = 0; index0 < 10; index0++) {
			world.setBlock(BlockPos.containing(x + Mth.nextInt(RANDOM, -5, 5), y + Mth.nextInt(RANDOM, 10, 20), z + Mth.nextInt(RANDOM, -5, 5)), Blocks.LAVA.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + Mth.nextInt(RANDOM, -5, 5), y + Mth.nextInt(RANDOM, 10, 20), z + Mth.nextInt(RANDOM, -5, 5)), Blocks.LAVA.defaultBlockState(), 3);
		}
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
		for (int index1 = 0; index1 < 50; index1++) {
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
						AbstractArrow entityToSpawn = new SmallBombEntity(TheRootOfCorruptionModEntities.SMALL_BOMB.get(), level) {
							@Override
							public byte getPierceLevel() {
								return piercing;
							}

							@Override
							protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
								if (knockback > 0) {
									double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
									Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
									if (vec3.lengthSqr() > 0.0) {
										livingEntity.push(vec3.x, 0.1, vec3.z);
									}
								}
							}
						};
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setSilent(true);
						entityToSpawn.igniteForSeconds(100);
						entityToSpawn.setCritArrow(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, (float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 100), 100, (byte) 100);
				_entityToSpawn.setPos(x, y, z);
				_entityToSpawn.shoot(1, 1, 1, 1, 100);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + Mth.nextInt(RANDOM, -10, 10), y + Mth.nextInt(RANDOM, -10, 10), z + Mth.nextInt(RANDOM, -10, 10))));;
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new LargeFireball(EntityType.FIREBALL, projectileLevel);
				_entityToSpawn.setPos(x, y, z);
				_entityToSpawn.shoot(1, 1, 1, 1, 100);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, projectileLevel);
				_entityToSpawn.setPos(x, y, z);
				_entityToSpawn.shoot(1, 1, 1, 1, 100);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			world.setBlock(BlockPos.containing(x + Mth.nextInt(RANDOM, -10, 10), y + Mth.nextInt(RANDOM, -10, 10), z + Mth.nextInt(RANDOM, -10, 10)),
					TheRootOfCorruptionModBlocks.EXECUTEROOT.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + Mth.nextInt(RANDOM, -10, 10), y + Mth.nextInt(RANDOM, -10, 10), z + Mth.nextInt(RANDOM, -10, 10)),
					TheRootOfCorruptionModBlocks.CORRUPTIONBEDROCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + Mth.nextInt(RANDOM, -10, 10), y + Mth.nextInt(RANDOM, -10, 10), z + Mth.nextInt(RANDOM, -10, 10)),
					TheRootOfCorruptionModBlocks.MISSINGNO.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + Mth.nextInt(RANDOM, -10, 10), y + Mth.nextInt(RANDOM, -10, 10), z + Mth.nextInt(RANDOM, -10, 10)), Blocks.BEDROCK.defaultBlockState(), 3);
		}
		TheRootOfCorruptionMod.queueServerWork(100, () -> {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheRootOfCorruptionModEntities.MINECRAFT_ROOT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			}
		});
	}
}
