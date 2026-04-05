package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.EventPriority;

@EventBusSubscriber(modid = "the_root_of_corruption")
public class NeardeathPlayerProcedure {
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getSource().getEntity());
		}
	}

	public static void execute(LivingDeathEvent event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:god")))) {
			event.setCanceled(false);
		}
	}
}
