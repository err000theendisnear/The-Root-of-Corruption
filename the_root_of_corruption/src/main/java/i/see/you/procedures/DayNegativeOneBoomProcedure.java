package i.see.you.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import i.see.you.init.TheRootOfCorruptionModBlocks;

@EventBusSubscriber
public class DayNegativeOneBoomProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheRootOfCorruptionModBlocks.DAY_NEGATIVE_ONE.get()) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
			if (entity instanceof Player _player)
				_player.getFoodData().setSaturation(0);
			if (entity instanceof Player _player)
				_player.getFoodData().setFoodLevel(0);
			if (entity instanceof Player _player) {
				_player.getAbilities().flying = false;
				_player.onUpdateAbilities();
			}
			if (entity instanceof Player _player) {
				_player.getAbilities().mayfly = false;
				_player.onUpdateAbilities();
			}
			if (entity instanceof Player _plr7)
				_plr7.resetAttackStrengthTicker();
			if (entity instanceof Player _plr && _plr.isFallFlying()) {
				_plr.stopFallFlying();
			}
			if (entity instanceof Player _player)
				_player.giveExperienceLevels(-(5));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.forceAddEffect(new MobEffectInstance(MobEffects.DARKNESS, 1000, 255, true, true), entity);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.forceAddEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1000, 255, true, true), entity);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.forceAddEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1000, 255, true, true), entity);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.forceAddEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1000, 255, true, true), entity);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.forceAddEffect(new MobEffectInstance(MobEffects.UNLUCK, 1000, 255, true, true), entity);
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD), (world instanceof Level _level ? new Warden(EntityType.WARDEN, _level) : null),
					(world instanceof Level _level ? new EnderDragon(EntityType.ENDER_DRAGON, _level) : null)), 7);
			entity.setCustomName(Component.literal("Day -1"));
			entity.invulnerableTime = 1;
			if (Math.random() < 0.01) {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
					_level.addFreshEntity(entityToSpawn);
				}
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, y, z, (float) ((world.getBlockState(BlockPos.containing(x, y, z))).getFluidState().isSource() ? 4 : 2), Level.ExplosionInteraction.TNT);
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getFireball(Level level, Entity shooter, double ax, double ay, double az) {
							AbstractHurtingProjectile entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setDeltaMovement(new Vec3(ax, ay, az));
							entityToSpawn.hasImpulse = true;
							return entityToSpawn;
						}
					}.getFireball(projectileLevel, (world instanceof Level _level ? new WitherBoss(EntityType.WITHER, _level) : null), 0, (-1), 0);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot(0, (-1), 0, 1, 15);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		}
	}
}
