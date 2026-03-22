package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

import i.see.you.init.TheRootOfCorruptionModEntities;
import i.see.you.entity.BrokenErrEntity;

public class CorruptProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity player = null;
		Entity the_entity = null;
		player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 128, 128, 128), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null);
		if (!(player == null)) {
			if (player instanceof Player _plr2)
				_plr2.resetAttackStrengthTicker();
			if (player instanceof Player _plr && _plr.isFallFlying()) {
				_plr.stopFallFlying();
			}
			if (player instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
			if (Mth.nextInt(RandomSource.create(), 0, 1000) == 0) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BrokenErrEntity(TheRootOfCorruptionModEntities.BROKEN_ERR.get(), level) {
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
					}.getArrow(projectileLevel, 50, 10, (byte) 100);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(0, 1, 0, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BrokenErrEntity(TheRootOfCorruptionModEntities.BROKEN_ERR.get(), level) {
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
					}.getArrow(projectileLevel, 50, 10, (byte) 100);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(1, 0, 1, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BrokenErrEntity(TheRootOfCorruptionModEntities.BROKEN_ERR.get(), level) {
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
					}.getArrow(projectileLevel, 50, 10, (byte) 100);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(0, 0, 1, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BrokenErrEntity(TheRootOfCorruptionModEntities.BROKEN_ERR.get(), level) {
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
					}.getArrow(projectileLevel, 50, 10, (byte) 100);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(1, 0, 0, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BrokenErrEntity(TheRootOfCorruptionModEntities.BROKEN_ERR.get(), level) {
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
					}.getArrow(projectileLevel, 50, 10, (byte) 100);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot((-1), 0, 1, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BrokenErrEntity(TheRootOfCorruptionModEntities.BROKEN_ERR.get(), level) {
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
					}.getArrow(projectileLevel, 50, 10, (byte) 100);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot((-1), 0, (-1), 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BrokenErrEntity(TheRootOfCorruptionModEntities.BROKEN_ERR.get(), level) {
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
					}.getArrow(projectileLevel, 50, 10, (byte) 100);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(1, 0, (-1), 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BrokenErrEntity(TheRootOfCorruptionModEntities.BROKEN_ERR.get(), level) {
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
					}.getArrow(projectileLevel, 50, 10, (byte) 100);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(0, 0, (-1), 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BrokenErrEntity(TheRootOfCorruptionModEntities.BROKEN_ERR.get(), level) {
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
					}.getArrow(projectileLevel, 50, 10, (byte) 100);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot((-1), 0, 0, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (Mth.nextInt(RandomSource.create(), 0, 500) == 0) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(0, 1, 0, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(1, 0, 1, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(0, 0, 1, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(1, 0, 0, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot((-1), 0, 1, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot((-1), 0, (-1), 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(1, 0, (-1), 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(0, 0, (-1), 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot((-1), 0, 0, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (Mth.nextInt(RandomSource.create(), 0, 500) == 0) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getPotion(Level level) {
							ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
							entityToSpawn.setItem(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.STRONG_HARMING));
							return entityToSpawn;
						}
					}.getPotion(projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(0, 1, 0, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getPotion(Level level) {
							ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
							entityToSpawn.setItem(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.STRONG_HARMING));
							return entityToSpawn;
						}
					}.getPotion(projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(1, 0, 1, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getPotion(Level level) {
							ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
							entityToSpawn.setItem(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.STRONG_HARMING));
							return entityToSpawn;
						}
					}.getPotion(projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(0, 0, 1, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getPotion(Level level) {
							ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
							entityToSpawn.setItem(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.STRONG_HARMING));
							return entityToSpawn;
						}
					}.getPotion(projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(1, 0, 0, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getPotion(Level level) {
							ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
							entityToSpawn.setItem(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.STRONG_HARMING));
							return entityToSpawn;
						}
					}.getPotion(projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot((-1), 0, 1, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getPotion(Level level) {
							ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
							entityToSpawn.setItem(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.STRONG_HARMING));
							return entityToSpawn;
						}
					}.getPotion(projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot((-1), 0, (-1), 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getPotion(Level level) {
							ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
							entityToSpawn.setItem(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.STRONG_HARMING));
							return entityToSpawn;
						}
					}.getPotion(projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(1, 0, (-1), 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getPotion(Level level) {
							ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
							entityToSpawn.setItem(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.STRONG_HARMING));
							return entityToSpawn;
						}
					}.getPotion(projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(0, 0, (-1), 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getPotion(Level level) {
							ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
							entityToSpawn.setItem(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.STRONG_HARMING));
							return entityToSpawn;
						}
					}.getPotion(projectileLevel);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot((-1), 0, 0, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (Mth.nextInt(RandomSource.create(), 0, 1800) == 0) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.INVALID_CREEPER.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
			if (Mth.nextInt(RandomSource.create(), 0, 5000) == 0) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.WARDEN.spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				the_entity = (Entity) world.getEntitiesOfClass(Warden.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null);
				if (!(the_entity == null)) {
					if (the_entity instanceof Mob _entity && player instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
				}
			}
			if (Mth.nextInt(RandomSource.create(), 0, 5000) == 0) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.TNT_MINECART.spawn(_level, BlockPos.containing(x, y + 10, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
	}
}
