package i.see.you.procedures;

import net.neoforged.neoforge.common.NeoForge;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.init.TheRootOfCorruptionModGameRules;
import i.see.you.configuration.ConfigConfiguration;
import i.see.you.TriggerRandomEvent;
import i.see.you.TheRootOfCorruptionMod;

public class TriggerEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, boolean reset) {
		if (entity == null)
			return;
		String name = "";
		if (!reset || world.getLevelData().getGameRules().getBoolean(TheRootOfCorruptionModGameRules.ENABLE_EVENT)) {
			name = ExecuteEventProcedure.execute(world, y, entity);
			TriggerRandomEvent event = new TriggerRandomEvent(entity, name, TheRootOfCorruptionModVariables.MapVariables.get(world).event_count);
			NeoForge.EVENT_BUS.post(event);
			if (event.isCanceled()) {
				TheRootOfCorruptionMod.LOGGER.info(("Event has been canceled : " + name));
			} else {
				ForceEventProcedure.execute(world, x, y, z, entity, name);
				TheRootOfCorruptionMod.LOGGER
						.info(("event : " + name + ", player : " + entity + ", dimension : " + (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))));
			}
		}
		if (reset) {
			TheRootOfCorruptionModVariables.MapVariables.get(world).event_count = Math
					.round((double) ConfigConfiguration.EVENT_INTERVAL.get() * Mth.nextDouble(RandomSource.create(), (double) ConfigConfiguration.MIN_EVENT_SPEED.get(), (double) ConfigConfiguration.MAX_EVENT_SPEED.get())) * world.players().size();
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
			if (TheRootOfCorruptionModVariables.MapVariables.get(world).event_count <= 0) {
				TheRootOfCorruptionModVariables.MapVariables.get(world).event_count = (double) ConfigConfiguration.EVENT_INTERVAL.get() * world.players().size();
				TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
			}
			if (TheRootOfCorruptionModVariables.MapVariables.get(world).event_count <= 0) {
				TheRootOfCorruptionModVariables.MapVariables.get(world).event_count = 10000;
				TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
