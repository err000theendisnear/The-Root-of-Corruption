package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import i.see.you.configuration.ConfigConfiguration;
import i.see.you.TheRootOfCorruptionMod;

public class CrashProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		KillentityProcedure.execute(world, entity);
		KillentityProcedure.execute(world, sourceentity);
		if (!sourceentity.level().isClientSide())
			sourceentity.discard();
		if (!entity.level().isClientSide())
			entity.discard();
		NotchaseProcedure.execute(world);
		if (ConfigConfiguration.CRASH.get()) {
			TruecrashProcedure.execute();
		} else {
			TheRootOfCorruptionMod.LOGGER.info("failed to crash, because configuration variable \"crash\" is false");
		}
	}
}
