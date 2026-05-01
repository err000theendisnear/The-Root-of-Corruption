package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.ArrayList;

public class NearbyPlayerProcedure {
	public static Entity execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return null;
		Entity return_entity = null;
		double min_distance = 0;
		double distance = 0;
		min_distance = 2147483647;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			distance = entityiterator != null ? entity.distanceTo(entityiterator) : -1;
			if (distance < min_distance) {
				min_distance = distance;
				return_entity = entityiterator;
			}
		}
		return return_entity;
	}
}
