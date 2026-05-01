package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.Comparator;

import i.see.you.TheRootOfCorruptionMod;

public class AttackNotTargetProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.TOTEM_OF_UNDYING)) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(Items.SHIELD).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if (!(entity instanceof Player || entity instanceof ServerPlayer)) {
			entity.push((sourceentity.getLookAngle().x), (sourceentity.getLookAngle().y), (sourceentity.getLookAngle().z));
			sourceentity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), (float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / 3.8));
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())));
			if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.TOTEM_OF_UNDYING)) {
				TheRootOfCorruptionMod.queueServerWork(40, () -> {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.TOTEM_OF_UNDYING).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				});
			}
			TheRootOfCorruptionMod.queueServerWork(20, () -> {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Items.SPLASH_POTION).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.OFF_HAND, true);
				for (int index0 = 0; index0 < 5; index0++) {
					TheRootOfCorruptionMod.queueServerWork((int) (index0 * 4), () -> {
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getPotion(Level level, Entity shooter, double ax, double ay, double az) {
									ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
									entityToSpawn.setItem(PotionContents.createItemStack(Items.SPLASH_POTION, Potions.STRONG_STRENGTH));
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setDeltaMovement(new Vec3(ax, ay, az));
									entityToSpawn.hasImpulse = true;
									return entityToSpawn;
								}
							}.getPotion(projectileLevel, entity, 0, (-1), 0);
							_entityToSpawn.setPos(x, y, z);
							_entityToSpawn.shoot(0, (-1), 0, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (sourceentity.getType().is(EntityTypeTags.UNDEAD)) {
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
									}.getPotion(projectileLevel, sourceentity, (entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z));
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 3);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
						} else {
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level();
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getPotion(Level level, Entity shooter, double ax, double ay, double az) {
											ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
											entityToSpawn.setItem(PotionContents.createItemStack(Items.SPLASH_POTION, Potions.STRONG_HARMING));
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setDeltaMovement(new Vec3(ax, ay, az));
											entityToSpawn.hasImpulse = true;
											return entityToSpawn;
										}
									}.getPotion(projectileLevel, sourceentity, (entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z));
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 3);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
						}
					});
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 3) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getPotion(Level level, Entity shooter, double ax, double ay, double az) {
								ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
								entityToSpawn.setItem(PotionContents.createItemStack(Items.SPLASH_POTION, Potions.STRONG_HEALING));
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setDeltaMovement(new Vec3(ax, ay, az));
								entityToSpawn.hasImpulse = true;
								return entityToSpawn;
							}
						}.getPotion(projectileLevel, sourceentity, 0, (-1), 0);
						_entityToSpawn.setPos(x, y, z);
						_entityToSpawn.shoot(0, (-1), 0, 1, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 7) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getPotion(Level level, Entity shooter, double ax, double ay, double az) {
								ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
								entityToSpawn.setItem(PotionContents.createItemStack(Items.SPLASH_POTION, Potions.HEALING));
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setDeltaMovement(new Vec3(ax, ay, az));
								entityToSpawn.hasImpulse = true;
								return entityToSpawn;
							}
						}.getPotion(projectileLevel, sourceentity, 0, (-1), 0);
						_entityToSpawn.setPos(x, y, z);
						_entityToSpawn.shoot(0, (-1), 0, 1, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (sourceentity instanceof LivingEntity _entity)
					_entity.removeAllEffects();
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1000, 2));
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1000, 2));
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 1000, 2));
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 1000, 2));
				sourceentity.setAirSupply(0);
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ())));;
					_level.addFreshEntity(entityToSpawn);
				}
				if (sourceentity instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1000, 1000, 1000), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
			});
		}
	}
}
