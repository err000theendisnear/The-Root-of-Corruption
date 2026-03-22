package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

import i.see.you.init.TheRootOfCorruptionModBlocks;

public class StartCorruptionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		Entity player = null;
		if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
			world.setBlock(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 1, -1), y + Mth.nextInt(RandomSource.create(), 1, -1), z + Mth.nextInt(RandomSource.create(), 1, -1)),
					TheRootOfCorruptionModBlocks.EXECUTEROOT.get().defaultBlockState(), 3);
		} else {
			if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
				world.setBlock(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 1, -1), y + Mth.nextInt(RandomSource.create(), 1, -1), z + Mth.nextInt(RandomSource.create(), 1, -1)), Blocks.BEDROCK.defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 1, -1), y + Mth.nextInt(RandomSource.create(), 1, -1), z + Mth.nextInt(RandomSource.create(), 1, -1)), blockstate, 3);
			}
		}
		player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null);
		if (!(player == null)) {
			player.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), 1);
			if (player instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.NIGHT_VISION);
			if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 255));
			if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
			if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 4));
			if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 255));
			player.setSprinting(false);
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 4); index0++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.PHANTOM.spawn(_level,
							BlockPos.containing(player.getX() + Mth.nextInt(RandomSource.create(), 2, -2), player.getY() + Mth.nextInt(RandomSource.create(), 8, 15), player.getZ() + Mth.nextInt(RandomSource.create(), 2, -2)),
							MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
			if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
				if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(player.getX(), player.getY(), player.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_shrieker.shriek")), SoundSource.PLAYERS, 100, 1);
						} else {
							_level.playLocalSound((player.getX()), (player.getY()), (player.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_shrieker.shriek")), SoundSource.PLAYERS, 100, 1, false);
						}
					}
				} else {
					if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(player.getX(), player.getY(), player.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.PLAYERS, 100, 1);
							} else {
								_level.playLocalSound((player.getX()), (player.getY()), (player.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.PLAYERS, 100, 1, false);
							}
						}
					} else {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(player.getX(), player.getY(), player.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:void")), SoundSource.PLAYERS, 100, 1);
							} else {
								_level.playLocalSound((player.getX()), (player.getY()), (player.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:void")), SoundSource.PLAYERS, 100, 1, false);
							}
						}
					}
				}
			}
		}
	}
}
