package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class FakePlayerAttackProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		player = SpawnFakePlayerProcedure.execute(world, "Undefined");
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), player), entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
	}
}
