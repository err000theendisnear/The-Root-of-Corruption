package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import i.see.you.configuration.ConfigConfiguration;
import net.minecraft.world.entity.LivingEntity;

@EventBusSubscriber
public class DamagecapProcedure {
	@SubscribeEvent
	public static void onLivingIncomingDamage(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			Entity entity = event.getEntity();
			if (isgod(entity)) {
				event.setCanceled(true);
				return;
			}
			float amount = event.getAmount();
			Entity sourceentity = event.getSource().getEntity();
			float damagecap = ConfigConfiguration.MISSING_DAMAGECAP.get().floatValue();
			if (AllMissnoAromrProcedure.execute(entity) && amount > damagecap) {
				if (isgod(sourceentity)) {
					if (entity instanceof LivingEntity _entity) {
						_entity.setHealth(0.0f);
					}
					entity.kill();
				} else {
					event.setAmount(damagecap);
				}
			}
		}
	}
	public static boolean isgod(Entity ent) {
		if (ent == null) return false;
		return ent.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:god")));
	}
}