package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class EntityToSpawnProcedure {
		public static Entity execute(LevelAccessor world, double x, double y, double z, MobSpawnType spawntype, String type) {
		if (type == null || world == null || spawntype == null)
			return null;
		if (world instanceof ServerLevel _level) {
			try {
				Entity entityToSpawn = BuiltInRegistries.ENTITY_TYPE.get(ResourceLocation.parse(type)).spawn(_level, BlockPos.containing(x, y, z), spawntype);
				return entityToSpawn;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
