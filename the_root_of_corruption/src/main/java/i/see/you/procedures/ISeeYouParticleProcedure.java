package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import i.see.you.init.TheRootOfCorruptionModParticleTypes;
import i.see.you.TheRootOfCorruptionMod;

public class ISeeYouParticleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
		world.addParticle((SimpleParticleType) (TheRootOfCorruptionModParticleTypes.I.get()), x, y, z, 0, 0, 0);
		TheRootOfCorruptionMod.queueServerWork(20, () -> {
			world.addParticle((SimpleParticleType) (TheRootOfCorruptionModParticleTypes.SEE.get()), x, y, z, 0, 0, 0);
			TheRootOfCorruptionMod.queueServerWork(20, () -> {
				world.addParticle((SimpleParticleType) (TheRootOfCorruptionModParticleTypes.YOU.get()), x, y, z, 0, 0, 0);
				TheRootOfCorruptionMod.queueServerWork(50, () -> {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
						_level.addFreshEntity(entityToSpawn);
					}
				});
			});
		});
	}
}
