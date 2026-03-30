package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import i.see.you.entity.UndefinedBossEntity;
import i.see.you.configuration.ConfigConfiguration;

@EventBusSubscriber
public class RunProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		if (entity instanceof UndefinedBossEntity) {
			if (amount > (double) ConfigConfiguration.UNDEFINED_DAMAGECAP.get()) {
				if (entity instanceof UndefinedBossEntity _datEntSetI)
					_datEntSetI.getEntityData().set(UndefinedBossEntity.DATA_hp, (int) Math.ceil((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - (double) ConfigConfiguration.UNDEFINED_DAMAGECAP.get()));
			} else {
				if (entity instanceof UndefinedBossEntity _datEntSetI)
					_datEntSetI.getEntityData().set(UndefinedBossEntity.DATA_hp, (int) Math.ceil((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - amount));
			}
		}
	}
}
