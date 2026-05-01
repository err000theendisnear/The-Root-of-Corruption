package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import i.see.you.init.TheRootOfCorruptionModEntities;
import i.see.you.entity.WatcherEntity;

public class WatcherModelProcedure {
	public static Entity execute(LevelAccessor world) {
		return world instanceof Level _level ? new WatcherEntity(TheRootOfCorruptionModEntities.WATCHER.get(), _level) : null;
	}
}
