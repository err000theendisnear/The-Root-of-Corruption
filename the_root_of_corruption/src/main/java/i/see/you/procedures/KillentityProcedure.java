package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.ai.attributes.Attributes;
import java.lang.reflect.Method;
import net.minecraft.world.entity.player.Player;

public class KillentityProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null) return;
		DamageSource killdamage = new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL));
		DamageSource voiddamage = new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD));
		LivingEntity livingEntity = (entity instanceof LivingEntity _ent ? _ent : null);
		while (entity.isAlive()) {
			entity.hurt(killdamage, Float.MAX_VALUE);
			entity.hurt(voiddamage, Float.MAX_VALUE);
			if (livingEntity != null) {
				livingEntity.setHealth(Float.NEGATIVE_INFINITY);
				livingEntity.die(killdamage);
				livingEntity.die(voiddamage);
				if (!(entity instanceof Player)) {
					livingEntity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(Float.NEGATIVE_INFINITY);
				}
			}
			entity.kill();
		}
	}
}
