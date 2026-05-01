package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

import i.see.you.init.TheRootOfCorruptionModParticleTypes;

public class WorldIsDyingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheRootOfCorruptionModParticleTypes.ERROR.get()), x, y, z, 5, 3, 3, 3, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheRootOfCorruptionModParticleTypes.THIS_IS_NOT_FAIR.get()), x, y, z, 5, 3, 3, 3, 0);
		entity.invulnerableTime = 1;
		entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("the_root_of_corruption:null_pointer_damage")))), (float) 0.025);
		if (entity instanceof Player _plr5)
			_plr5.setArrowCount(30);
		if (entity instanceof Player _plr6)
			_plr6.setStingerCount(30);
		if (entity instanceof Player _player)
			_player.getFoodData().setFoodLevel(0);
		if (entity instanceof Player _player)
			_player.getFoodData().setSaturation(0);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("THE WORLD IS DYING"), true);
		HorrorProcedure.execute(entity);
	}
}
