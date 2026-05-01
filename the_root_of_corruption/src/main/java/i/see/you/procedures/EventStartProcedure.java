package i.see.you.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import javax.annotation.Nullable;
import i.see.you.network.TheRootOfCorruptionModVariables;
import net.minecraft.server.level.ServerPlayer;

@EventBusSubscriber
public class EventStartProcedure {
	
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null || !(entity instanceof ServerPlayer))
			return;
		if (TheRootOfCorruptionModVariables.MapVariables.get(world).event_count <= 0) {
			TriggerEventProcedure.execute(world, x, y, z, entity, true);
		} else {
			TheRootOfCorruptionModVariables.MapVariables.get(world).event_count = TheRootOfCorruptionModVariables.MapVariables.get(world).event_count - 1;
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
