package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.WorldGenLevel;
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
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

import i.see.you.TheRootOfCorruptionMod;

public class StartCorruptionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		Entity player = null;
		double xx = 0;
		double yy = 0;
		double zz = 0;
		if (Math.random() / (Math.random() / (Math.random() / 1.2)) < Math.random() * 1.2 * Math.random() * Math.random()
				&& !((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey.create(Registries.DIMENSION,
						ResourceLocation.parse("the_root_of_corruption:last_fight"))
						|| (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey.create(Registries.DIMENSION,
								ResourceLocation.parse("the_root_of_corruption:err_void")))) {
			world.setBlock(BlockPos.containing(xx, yy, zz), blockstate, 3);
			xx = x + Mth.nextInt(RandomSource.create(), 2, -2);
			yy = y + Mth.nextInt(RandomSource.create(), 2, -2);
			zz = z + Mth.nextInt(RandomSource.create(), 2, -2);
			if (!world.isEmptyBlock(BlockPos.containing(xx, yy, zz))) {
				player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1145, 1145, 1145), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null);
				if (!(player == null)) {
					if (!(AllNotextureProcedure.execute(player) || AllMissnoAromrProcedure.execute(player))) {
						TheRootOfCorruptionMod.LOGGER.info("Corruption");
						player.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), 3);
						if (player instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.NIGHT_VISION);
						if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 250, 255));
						if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 250, 0));
						if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 250, 4));
						if (player instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 250, 255));
						player.setSprinting(false);
						for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 4); index0++) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.PHANTOM.spawn(_level,
										BlockPos.containing(player.getX() + Mth.nextInt(RandomSource.create(), 2, -2), player.getY() + Mth.nextInt(RandomSource.create(), 4, 11), player.getZ() + Mth.nextInt(RandomSource.create(), 2, -2)),
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
											_level.playSound(null, BlockPos.containing(player.getX(), player.getY(), player.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:void")), SoundSource.PLAYERS, 100,
													1);
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
		}
	}
}
