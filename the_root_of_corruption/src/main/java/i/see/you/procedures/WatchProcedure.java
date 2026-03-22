package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

import i.see.you.TheRootOfCorruptionMod;

public class WatchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		Entity boat = null;
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24, 24, 24), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null);
		if (!(player == null)) {
			if (!entity.level().isClientSide())
				entity.discard();
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
				for (int index0 = 0; index0 < 5; index0++) {
					for (int index1 = 0; index1 < 4; index1++) {
						for (int index2 = 0; index2 < 4; index2++) {
							world.setBlock(BlockPos.containing(player.getX() - 2 + index2, player.getY() + index0, player.getZ() - 2 + index1), Blocks.AIR.defaultBlockState(), 3);
						}
					}
				}
				for (int index3 = 0; index3 < 3; index3++) {
					for (int index4 = 0; index4 < 4; index4++) {
						for (int index5 = 0; index5 < 4; index5++) {
							x1 = player.getX() - 2 + index4;
							y1 = player.getY() + 2 + index3;
							z1 = player.getZ() - 2 + index5;
							if (world instanceof ServerLevel _level)
								FallingBlockEntity.fall(_level, BlockPos.containing(Math.ceil(x1), y1, Math.floor(z1)), Blocks.BEDROCK.defaultBlockState());
							if (world instanceof ServerLevel _level)
								FallingBlockEntity.fall(_level, BlockPos.containing(Math.floor(x1), y1, Math.floor(z1)), Blocks.BEDROCK.defaultBlockState());
							if (world instanceof ServerLevel _level)
								FallingBlockEntity.fall(_level, BlockPos.containing(Math.ceil(x1), y1, Math.ceil(z1)), Blocks.BEDROCK.defaultBlockState());
							if (world instanceof ServerLevel _level)
								FallingBlockEntity.fall(_level, BlockPos.containing(Math.floor(x1), y1, Math.ceil(z1)), Blocks.BEDROCK.defaultBlockState());
						}
					}
				}
				TheRootOfCorruptionMod.queueServerWork(100, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.use")), SoundSource.VOICE, 1000, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.use")), SoundSource.VOICE, 1000, 1, false);
						}
					}
				});
			}
		}
	}
}
