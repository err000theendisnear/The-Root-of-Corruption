package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import java.lang.Math;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;

@EventBusSubscriber
public class GoawayProcedure {
	@SubscribeEvent
	public static void onEntityTeleportation(EntityTeleportEvent event) {
		if (event.getEntity() instanceof Player && Math.random() < 0.025) {
			event.setCanceled(true);
			DieProcedure.execute(event.getEntity().level(),event.getEntity());
		}
	}
}
