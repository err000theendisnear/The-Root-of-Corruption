package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.entity.Entity;

public class GetAllEntitiesProcedure {
	public static List execute(LevelAccessor world) {
		List<Entity> entity = new ArrayList<>();
		if (world instanceof ServerLevel server) {
			server.getEntities().getAll().forEach(entity::add);
		}
		return entity;
	}
}
