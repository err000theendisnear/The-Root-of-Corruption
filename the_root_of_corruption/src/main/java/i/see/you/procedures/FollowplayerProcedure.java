package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.Comparator;

import i.see.you.entity.UndefinedOnSurfaceEntity;

public class FollowplayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null);
		if (player == null) {
			player = (Entity) world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null);
		}
		if (player == null) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo((player.getX()), (player.getY()), (player.getZ()), 3);
			player.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			player.setSprinting(false);
			player.setShiftKeyDown(true);
			if (player instanceof Player _player) {
				_player.getAbilities().flying = false;
				_player.onUpdateAbilities();
			}
			if (player instanceof Player _plr13)
				_plr13.resetAttackStrengthTicker();
			if (player instanceof Player _plr && _plr.isFallFlying()) {
				_plr.stopFallFlying();
			}
			if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 255));
			if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 255));
			if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100, 255));
			if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 4));
			player.stopRiding();
			if (entity instanceof UndefinedOnSurfaceEntity _datEntSetI)
				_datEntSetI.getEntityData().set(UndefinedOnSurfaceEntity.DATA_a, (int) (1 + (entity instanceof UndefinedOnSurfaceEntity _datEntI ? _datEntI.getEntityData().get(UndefinedOnSurfaceEntity.DATA_a) : 0)));
			if ((entity instanceof UndefinedOnSurfaceEntity _datEntI ? _datEntI.getEntityData().get(UndefinedOnSurfaceEntity.DATA_a) : 0) == 100) {
				player.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
				if (entity instanceof UndefinedOnSurfaceEntity _datEntSetI)
					_datEntSetI.getEntityData().set(UndefinedOnSurfaceEntity.DATA_a, 0);
				player.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			}
		}
	}
}
