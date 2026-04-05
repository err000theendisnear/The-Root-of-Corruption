package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import java.lang.reflect.Method;

public class KillentityProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null) return;
		DamageSource source = new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL));
		while (entity.isAlive()) {
			entity.hurt(source, Float.MAX_VALUE);
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), Float.MAX_VALUE);
			if (entity instanceof LivingEntity _ent)
				_ent.setHealth(0);
			entity.kill();
		}
	}
}
