package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import java.util.UUID;


public class UUIDToEntityProcedure {
	public static Entity execute(LevelAccessor world, String uuid) {
		if (uuid == null || world == null)
			return null;
		Entity entity = null;
		if (world instanceof ServerLevel level) {
			try {
				entity = level.getEntity(UUID.fromString(uuid));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return entity;
	}
}
