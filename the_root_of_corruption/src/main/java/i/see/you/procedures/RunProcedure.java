package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import i.see.you.init.TheRootOfCorruptionModEntities;
import i.see.you.entity.UndefinedBossEntity;
import i.see.you.entity.SmallBombEntity;
import i.see.you.configuration.ConfigConfiguration;

@EventBusSubscriber
public class RunProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, damagesource, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		if (entity instanceof UndefinedBossEntity) {
			if (Math.random() < 0.05) {
				for (int index0 = 0; index0 < 20; index0++) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
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
							}.getArrow(projectileLevel, 25, 4, (byte) 100);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 0.3, 100);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			}
			if (!(sourceentity instanceof UndefinedBossEntity)) {
				sourceentity.getPersistentData().putBoolean("Invulnerable", false);
				sourceentity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("the_root_of_corruption:null_pointer_damage")))), Mth.nextInt(RandomSource.create(), 7, 15));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:error")), SoundSource.MASTER, 1000, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:error")), SoundSource.MASTER, 1000, 1, false);
				}
			}
			if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("the_root_of_corruption:null_pointer_damage")))) {
				if (entity instanceof UndefinedBossEntity _datEntSetI)
					_datEntSetI.getEntityData().set(UndefinedBossEntity.DATA_hp, (int) Math.ceil((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + amount / 3));
			} else {
				if (amount > (double) ConfigConfiguration.UNDEFINED_DAMAGECAP.get()) {
					if (entity instanceof UndefinedBossEntity _datEntSetI)
						_datEntSetI.getEntityData().set(UndefinedBossEntity.DATA_hp, (int) Math.ceil((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - (double) ConfigConfiguration.UNDEFINED_DAMAGECAP.get()));
				} else {
					if (entity instanceof UndefinedBossEntity _datEntSetI)
						_datEntSetI.getEntityData().set(UndefinedBossEntity.DATA_hp, (int) Math.ceil((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - amount));
				}
			}
		}
	}
}
