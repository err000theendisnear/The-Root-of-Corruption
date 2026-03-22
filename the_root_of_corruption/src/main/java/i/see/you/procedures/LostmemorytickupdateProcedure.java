package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.Items;
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
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

import i.see.you.init.TheRootOfCorruptionModEntities;
import i.see.you.init.TheRootOfCorruptionModBlocks;
import i.see.you.entity.BrokenErrEntity;

public class LostmemorytickupdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		double xx = 0;
		double zz = 0;
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
		if (!((entity.level().dimension()) == Level.END) || player == null) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			entity.stopRiding();
			if (player instanceof Player _player) {
				_player.getAbilities().flying = false;
				_player.onUpdateAbilities();
			}
			if (player instanceof Player _plr && _plr.isFallFlying()) {
				_plr.stopFallFlying();
			}
			if (player instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
			entity.setSprinting(true);
			player.igniteForSeconds(15);
			if (player instanceof LivingEntity _entity)
				_entity.setAbsorptionAmount(0);
			if (player.getY() >= y && world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
				world.setBlock(BlockPos.containing(x, y - 1, z), TheRootOfCorruptionModBlocks.MISSINGNO.get().defaultBlockState(), 3);
			}
			if (0 == Mth.nextInt(RandomSource.create(), 0, 500)) {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(player.getX(), player.getY(), player.getZ())));;
					_level.addFreshEntity(entityToSpawn);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.thunder")), SoundSource.PLAYERS, 1000, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.thunder")), SoundSource.PLAYERS, 1000, 1, false);
					}
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
					}.getArrow(projectileLevel, 25, 1, (byte) 0);
					_entityToSpawn.setPos((player.getX()), (player.getY() + 1), (player.getZ()));
					_entityToSpawn.shoot(0, (-1), 0, 3, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (0 == Mth.nextInt(RandomSource.create(), 0, 750)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.ENDERMAN.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (((Entity) world.getEntitiesOfClass(EnderMan.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _entity && player instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
				for (int index0 = 0; index0 < 3; index0++) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.PHANTOM.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
			if (0 == Mth.nextInt(RandomSource.create(), 0, 1250)) {
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
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getPotion(Level level, Entity shooter) {
								ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
								entityToSpawn.setItem(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.LONG_WEAKNESS));
								entityToSpawn.setOwner(shooter);
								return entityToSpawn;
							}
						}.getPotion(projectileLevel, entity);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getPotion(Level level, Entity shooter) {
							ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
							entityToSpawn.setItem(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.HEALING));
							entityToSpawn.setOwner(shooter);
							return entityToSpawn;
						}
					}.getPotion(projectileLevel, entity);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(0, 1, 0, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (0 == Mth.nextInt(RandomSource.create(), 0, 800)) {
				if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 10, 0));
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getFireball(Level level, Entity shooter) {
								AbstractHurtingProjectile entityToSpawn = new DragonFireball(EntityType.DRAGON_FIREBALL, level);
								entityToSpawn.setOwner(shooter);
								return entityToSpawn;
							}
						}.getFireball(projectileLevel, entity);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				for (int index1 = 0; index1 < 4; index1++) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getFireball(Level level, Entity shooter) {
									AbstractHurtingProjectile entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, level);
									entityToSpawn.setOwner(shooter);
									return entityToSpawn;
								}
							}.getFireball(projectileLevel, entity);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 3);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
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
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 3);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
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
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 3);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			}
			if (player.getY() - 5 > y) {
				entity.push(0, 1, 0);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, (player.getY()), z, 10, Level.ExplosionInteraction.MOB);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, (player.getY()), z, 10, Level.ExplosionInteraction.NONE);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, (player.getY()), z, 10, Level.ExplosionInteraction.TNT);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, (player.getY()), z, 10, Level.ExplosionInteraction.BLOCK);
			}
			world.destroyBlock(BlockPos.containing(x + entity.getLookAngle().x, y + entity.getLookAngle().y, z + entity.getLookAngle().z), false);
			player.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), (float) Mth.nextDouble(RandomSource.create(), 0.1, 2.5));
			player.setAirSupply(0);
			if (player instanceof Player _player)
				_player.getFoodData().setSaturation(0);
			if (0 == Mth.nextInt(RandomSource.create(), 0, 2000)) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:wrong_sound")), SoundSource.VOICE, 1000, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:wrong_sound")), SoundSource.VOICE, 1000, 1, false);
					}
				}
				for (int index2 = 0; index2 < 60; index2++) {
					player.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
					{
						Entity _ent = entity;
						_ent.setYRot(0);
						_ent.setXRot(6);
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
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
							}.getArrow(projectileLevel, entity, 5, 2, (byte) 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			}
			if (0 == Mth.nextInt(RandomSource.create(), 0, 1600)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.BASE_0.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				xx = player.getX() + 1;
				for (int index3 = 0; index3 < 3; index3++) {
					zz = player.getZ() + 1;
					for (int index4 = 0; index4 < 3; index4++) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.EVOKER_FANGS.spawn(_level, BlockPos.containing(xx, y, zz), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						zz = zz - 1;
					}
					xx = xx - 1;
				}
			}
		}
	}
}
