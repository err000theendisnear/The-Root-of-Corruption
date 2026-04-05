package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class DoKnockbackProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		KnockbackProcedure.execute(entity, 3);
		entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("the_root_of_corruption:null_pointer_damage"))), entity), Mth.nextInt(RandomSource.create(), 2, 3));
		sourceentity.setTicksFrozen(0);
		if (sourceentity instanceof LivingEntity _entity)
			_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + Math.random() * Mth.nextInt(RandomSource.create(), 1, 5)));
	}
}
