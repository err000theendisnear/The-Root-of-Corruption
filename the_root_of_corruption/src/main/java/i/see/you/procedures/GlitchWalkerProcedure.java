package i.see.you.procedures;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import i.see.you.init.TheRootOfCorruptionModBlocks;

public class GlitchWalkerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.isUnderWater()) {
			for (int index0 = 0; index0 < 3; index0++) {
				for (int index1 = 0; index1 < 3; index1++) {
					if ((world.getBlockState(BlockPos.containing(x - 1 + index0, Math.floor(y) - 1, z - 1 + index1))).getBlock() instanceof LiquidBlock) {
						world.setBlock(BlockPos.containing(x - 1 + index0, Math.floor(y) - 1, z - 1 + index1), TheRootOfCorruptionModBlocks.GLOWINGOBSIDIAN.get().defaultBlockState(), 3);
					}
				}
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60, 1));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 0));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 60, 0));
	}
}
