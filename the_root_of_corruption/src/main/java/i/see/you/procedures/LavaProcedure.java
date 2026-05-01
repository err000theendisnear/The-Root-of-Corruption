package i.see.you.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

public class LavaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.LAVA.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x, y, z), Blocks.LAVA.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.LAVA.defaultBlockState(), 3);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.forceAddEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 150, 1, false, false), entity);
	}
}
