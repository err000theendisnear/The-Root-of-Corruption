package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.DragonFireball;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

import i.see.you.init.TheRootOfCorruptionModItems;
import i.see.you.init.TheRootOfCorruptionModEntities;
import i.see.you.entity.UndefinedBossEntity;
import i.see.you.entity.BrokenErrEntity;

public class TickupdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		ItemStack a = ItemStack.EMPTY;
		if (entity.getPersistentData().getBoolean("EVE")) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity || !(entityiterator instanceof Player)) {
						player = entityiterator;
						break;
					}
				}
			}
		} else {
			player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null);
		}
		if (!(player == null)) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) (entity instanceof UndefinedBossEntity _datEntI ? _datEntI.getEntityData().get(UndefinedBossEntity.DATA_hp) : 0));
			a = new ItemStack(TheRootOfCorruptionModItems.SAVE_THE_WORLD.get()).copy();
			a.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = a.copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			a.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), 1);
			a.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
			a = new ItemStack(TheRootOfCorruptionModItems.MISSING_ARMOR_BOOTS.get()).copy();
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, a);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, a);
				}
			}
			a.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), 1);
			a.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
			a = new ItemStack(TheRootOfCorruptionModItems.MISSING_ARMOR_LEGGINGS.get()).copy();
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, a);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, a);
				}
			}
			a.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), 1);
			a.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
			a = new ItemStack(TheRootOfCorruptionModItems.MISSING_ARMOR_CHESTPLATE.get()).copy();
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, a);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, a);
				}
			}
			a.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), 1);
			a.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
			a = new ItemStack(TheRootOfCorruptionModItems.MISSING_ARMOR_HELMET.get()).copy();
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, a);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, a);
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			player.setAirSupply(0);
			if (player instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (player instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.OFF_HAND, true);
			entity.stopRiding();
			if (player instanceof Player _player) {
				_player.getAbilities().flying = false;
				_player.onUpdateAbilities();
			}
			if (player instanceof Player _player) {
				_player.getAbilities().mayfly = false;
				_player.onUpdateAbilities();
			}
			if (player instanceof Player _plr && _plr.isFallFlying()) {
				_plr.stopFallFlying();
			}
			if (player instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
			if (0 == Mth.nextInt(RandomSource.create(), 0, 100)) {
				if (0 == Mth.nextInt(RandomSource.create(), 0, 100)) {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(player.getX(), player.getY(), player.getZ())));;
						_level.addFreshEntity(entityToSpawn);
					}
				}
				if (0 == Mth.nextInt(RandomSource.create(), 0, 500)) {
					if (player instanceof LivingEntity _entity)
						_entity.removeAllEffects();
					world.setBlock(BlockPos.containing(player.getX(), player.getY(), player.getZ()), Blocks.LAVA.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(player.getX(), player.getY() + 1, player.getZ()), Blocks.LAVA.defaultBlockState(), 3);
				}
				if (0 == Mth.nextInt(RandomSource.create(), 0, 750)) {
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, (player.getX()), (player.getY()), (player.getZ()), 12, Level.ExplosionInteraction.BLOCK);
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, (player.getX()), (player.getY()), (player.getZ()), 12, Level.ExplosionInteraction.MOB);
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, (player.getX()), (player.getY()), (player.getZ()), 12, Level.ExplosionInteraction.TNT);
				}
				if (0 == Mth.nextInt(RandomSource.create(), 0, 750)) {
					for (int index0 = 0; index0 < 10; index0++) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.EVOKER_FANGS.spawn(_level, BlockPos.containing(player.getX(), player.getY(), player.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				}
				if (0 == Mth.nextInt(RandomSource.create(), 0, 500)) {
					for (int index1 = 0; index1 < 4; index1++) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(player.getX(), player.getY(), player.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				}
				if (0 == Mth.nextInt(RandomSource.create(), 0, 2500)) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
									AbstractArrow entityToSpawn = new SpectralArrow(EntityType.SPECTRAL_ARROW, level) {
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
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.igniteForSeconds(100);
									entityToSpawn.setCritArrow(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 150, 10, (byte) 10);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					player.push(0, 2, 0);
					player.igniteForSeconds(1000);
				} else if (0 == Mth.nextInt(RandomSource.create(), 0, 200)) {
					for (int index2 = 0; index2 < 3; index2++) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.EVOKER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.ENDERMAN.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.BLAZE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Mob _entity && player instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
						}
					}
				}
				if (0 == Mth.nextInt(RandomSource.create(), 0, 1500)) {
					if (player instanceof LivingEntity _entity)
						_entity.setHealth((float) (Mth.nextDouble(RandomSource.create(), (player instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / 3, player instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)));
				}
				if (0 == Mth.nextInt(RandomSource.create(), 0, 900)) {
					player.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), (float) (Mth.nextDouble(RandomSource.create(), 1, player instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)));
				}
				if (0 == Mth.nextInt(RandomSource.create(), 0, 5000)) {
					for (int index3 = 0; index3 < Mth.nextInt(RandomSource.create(), 3, 5); index3++) {
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getFireball(Level level, Entity shooter) {
									AbstractHurtingProjectile entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, level);
									entityToSpawn.setOwner(shooter);
									return entityToSpawn;
								}
							}.getFireball(projectileLevel, entity);
							_entityToSpawn.setPos(x, y, z);
							_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), 2, 1);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getFireball(Level level, Entity shooter) {
									AbstractHurtingProjectile entityToSpawn = new SmallFireball(EntityType.SMALL_FIREBALL, level);
									entityToSpawn.setOwner(shooter);
									return entityToSpawn;
								}
							}.getFireball(projectileLevel, entity);
							_entityToSpawn.setPos(x, y, z);
							_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), 2, 1);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getFireball(Level level, Entity shooter) {
									AbstractHurtingProjectile entityToSpawn = new LargeFireball(EntityType.FIREBALL, level);
									entityToSpawn.setOwner(shooter);
									return entityToSpawn;
								}
							}.getFireball(projectileLevel, entity);
							_entityToSpawn.setPos(x, y, z);
							_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), 2, 1);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getFireball(Level level, Entity shooter) {
									AbstractHurtingProjectile entityToSpawn = new DragonFireball(EntityType.DRAGON_FIREBALL, level);
									entityToSpawn.setOwner(shooter);
									return entityToSpawn;
								}
							}.getFireball(projectileLevel, entity);
							_entityToSpawn.setPos(x, y, z);
							_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), 2, 1);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					for (int index4 = 0; index4 < Mth.nextInt(RandomSource.create(), 12, 20); index4++) {
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getPotion(Level level, Entity shooter) {
									ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
									entityToSpawn.setItem(PotionContents.createItemStack(Items.SPLASH_POTION, Potions.STRONG_HARMING));
									entityToSpawn.setOwner(shooter);
									return entityToSpawn;
								}
							}.getPotion(projectileLevel, entity);
							_entityToSpawn.setPos(x, y, z);
							_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), 1, -1)), (Mth.nextDouble(RandomSource.create(), 1, -1)), (Mth.nextDouble(RandomSource.create(), 1, -1)), 2, 1);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
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
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setSilent(true);
									entityToSpawn.igniteForSeconds(100);
									entityToSpawn.setCritArrow(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 5, 3, (byte) 3);
							_entityToSpawn.setPos(x, y, z);
							_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), 1, -1)), (Mth.nextDouble(RandomSource.create(), 1, -1)), (Mth.nextDouble(RandomSource.create(), 1, -1)), 2, 1);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			}
		}
	}
}
