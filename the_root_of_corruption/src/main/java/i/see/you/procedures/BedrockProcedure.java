package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;

import i.see.you.init.TheRootOfCorruptionModMobEffects;
import i.see.you.init.TheRootOfCorruptionModBlocks;
import i.see.you.TheRootOfCorruptionMod;

public class BedrockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xx = 0;
		double yy = 0;
		double zz = 0;
		BlockState replace_to_bedrock = Blocks.AIR.defaultBlockState();
		boolean replace = false;
		if (world instanceof ServerLevel _level) {
			LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
			entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
			_level.addFreshEntity(entityToSpawn);
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SOUL, x, y, z, 15, 2, 2, 2, 1);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.13")), SoundSource.RECORDS, 100, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.13")), SoundSource.RECORDS, 100, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.11")), SoundSource.RECORDS, 100, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.11")), SoundSource.RECORDS, 100, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.5")), SoundSource.RECORDS, 100, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("music_disc.5")), SoundSource.RECORDS, 100, 1, false);
			}
		}
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 2147000000, 255));
		xx = x - 8;
		for (int index0 = 0; index0 < 16; index0++) {
			yy = y - 8;
			for (int index1 = 0; index1 < 16; index1++) {
				zz = z - 8;
				for (int index2 = 0; index2 < 16; index2++) {
					replace_to_bedrock = (world.getBlockState(BlockPos.containing(xx, yy, zz)));
					replace = false;
					if (!(world.isEmptyBlock(BlockPos.containing(xx, yy, zz)) || replace_to_bedrock.getBlock() instanceof LiquidBlock)) {
						if ((BuiltInRegistries.BLOCK.getKey(replace_to_bedrock.getBlock()).toString()).contains("ore")) {
							replace = true;
						} else {
							if (Mth.nextInt(RandomSource.create(), 1, 2) == 1 && world.getBlockState(BlockPos.containing(xx, yy, zz)).getDestroySpeed(world, BlockPos.containing(xx, yy, zz)) > 0) {
								replace = true;
							}
						}
					}
					if (replace) {
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							world.setBlock(BlockPos.containing(xx, yy, zz), TheRootOfCorruptionModBlocks.CORRUPTIONBEDROCK.get().defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(xx, yy, zz), Blocks.BEDROCK.defaultBlockState(), 3);
						}
					}
					zz = zz + 1;
				}
				yy = yy + 1;
			}
			xx = xx + 1;
		}
		TheRootOfCorruptionMod.queueServerWork(5000, () -> {
			world.setBlock(BlockPos.containing(x, y, z), TheRootOfCorruptionModBlocks.CORRUPTIONBEDROCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.BEDROCK.defaultBlockState(), 3);
			DiscardProcedure.execute(entity);
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheRootOfCorruptionModMobEffects.CORRUPTION, 100, 1));
			}
		});
	}
}
