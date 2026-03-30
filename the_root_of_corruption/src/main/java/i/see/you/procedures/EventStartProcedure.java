package i.see.you.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.init.TheRootOfCorruptionModGameRules;
import i.see.you.configuration.ConfigConfiguration;
import i.see.you.TheRootOfCorruptionMod;

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
		if (entity == null)
			return;
		if (TheRootOfCorruptionModVariables.MapVariables.get(world).event_count == 0) {
			TheRootOfCorruptionModVariables.MapVariables.get(world).event_count = Math.round((double) ConfigConfiguration.EVENT_INTERVAL.get() * Mth.nextDouble(RandomSource.create(), 0.5, 2)) * world.players().size();
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
			if (world.getLevelData().getGameRules().getBoolean(TheRootOfCorruptionModGameRules.ENABLE_EVENT)) {
				ExecuteEventProcedure.execute(world, x, y, z, entity);
				TheRootOfCorruptionMod.LOGGER.info("event");
			}
		} else {
			TheRootOfCorruptionModVariables.MapVariables.get(world).event_count = TheRootOfCorruptionModVariables.MapVariables.get(world).event_count - 1;
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
