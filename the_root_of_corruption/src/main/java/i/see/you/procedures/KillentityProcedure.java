package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class KillentityProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		while (entity.isAlive()) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(0);
			entity.kill();
		}
	}
}
