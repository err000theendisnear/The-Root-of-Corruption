package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TrashCodeProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:god")))) {
			if (entity instanceof Player _player)
				_player.getFoodData().setSaturation(0);
			if (entity instanceof Player _player)
				_player.getFoodData().setFoodLevel(0);
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			if (entity instanceof LivingEntity _entity)
				_entity.setAbsorptionAmount(0);
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(0);
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("the_root_of_corruption:null_pointer_damage"))), sourceentity, entity),
					entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
			entity.kill();
			while (entity.isAlive()) {
				KillentityProcedure.execute(world, entity);
			}
		}
	}
}
