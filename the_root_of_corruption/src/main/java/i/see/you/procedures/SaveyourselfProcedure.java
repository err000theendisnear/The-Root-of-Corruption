package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class SaveyourselfProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.HEART, x, y, z, 10, 2, 2, 2, 1);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == sourceentity) {
					if (entityiterator instanceof Mob _entity)
						_entity.getNavigation().stop();
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeAllEffects();
					entityiterator.igniteForSeconds(15);
					entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					entityiterator.invulnerableTime = 0;
				} else if ((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entity) {
					if (entityiterator instanceof LivingEntity _entity)
						_entity.setHealth((float) (Math.max(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1, sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 3));
				}
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 15, 255));
		sourceentity.clearFire();
		sourceentity.setTicksFrozen(0);
		if (sourceentity instanceof LivingEntity _entity)
			_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
					+ Math.random() * ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) - (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1))));
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == Double.NaN) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
		}
	}
}
