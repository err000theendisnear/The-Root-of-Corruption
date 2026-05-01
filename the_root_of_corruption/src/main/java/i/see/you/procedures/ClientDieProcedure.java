package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import i.see.you.TheRootOfCorruptionMod;

public class ClientDieProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.isClientSide()) {
			entity.kill();
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) Double.NaN);
			TheRootOfCorruptionMod.queueServerWork(666, () -> {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(0);
			});
		}
	}
}
