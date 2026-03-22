package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import i.see.you.TheRootOfCorruptionMod;

public class UndefinedleaveProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (Mth.nextInt(RandomSource.create(), 1, 10) < 10) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			TheRootOfCorruptionMod.queueServerWork(80, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
	}
}
