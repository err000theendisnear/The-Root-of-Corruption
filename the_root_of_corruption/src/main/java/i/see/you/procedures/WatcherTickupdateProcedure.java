package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

import i.see.you.TheRootOfCorruptionMod;

public class WatcherTickupdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double z1 = 0;
		double y1 = 0;
		double x1 = 0;
		Entity player = null;
		Entity boat = null;
		player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24, 24, 24), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null);
		if (!(player == null)) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (Math.random() < 0.25) {
				CanyouseemyselfProcedure.execute(world);
			} else {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.BOAT.spawn(_level, BlockPos.containing(player.getX(), player.getY(), player.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				boat = (Entity) world.getEntitiesOfClass(Boat.class, AABB.ofSize(new Vec3((player.getX()), (player.getY()), (player.getZ())), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((player.getX()), (player.getY()), (player.getZ()))).findFirst().orElse(null);
				if (!(boat == null)) {
					boat.getPersistentData().putBoolean("Invulnerable", true);
					player.startRiding(boat);
					if (player instanceof ServerPlayer _player)
						_player.setGameMode(GameType.SURVIVAL);
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
						_level.addFreshEntity(entityToSpawn);
					}
					if (player instanceof Player _player)
						_player.closeContainer();
					if (player instanceof Player _player)
						_player.getFoodData().setFoodLevel(0);
					if (player instanceof Player _player)
						_player.getFoodData().setSaturation(0);
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
					if (player instanceof LivingEntity _entity)
						_entity.removeAllEffects();
					if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5000, 255));
					if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 5000, 255));
					if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 5000, 255));
					if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 5000, 255));
					if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 5000, 255));
					TheRootOfCorruptionMod.queueServerWork(50, () -> {
						WatchProcedure.execute(world, x, y, z, entity);
					});
				}
			}
		}
	}
}
