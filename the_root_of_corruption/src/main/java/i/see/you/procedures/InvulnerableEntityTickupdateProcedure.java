package i.see.you.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class InvulnerableEntityTickupdateProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		entity.setInvulnerable(entity.getPersistentData().getBoolean("Invulnerable"));
		if (entity.getPersistentData().getBoolean("Invulnerable")) {
			entity.clearFire();
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			entity.setTicksFrozen(0);
			entity.invulnerableTime = 10000;
		}
	}
}
