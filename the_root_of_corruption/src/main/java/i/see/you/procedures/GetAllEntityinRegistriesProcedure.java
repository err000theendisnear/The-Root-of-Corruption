package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.Set;
import java.util.Map;
import java.util.ArrayList;

public class GetAllEntityinRegistriesProcedure {
	public static ArrayList execute(LevelAccessor world, double x, double y, double z) {
		ArrayList<Object> allEntity = new ArrayList<>();
		BlockPos pos = BlockPos.ZERO;
		if (world instanceof ServerLevel _lvl) {
			pos = BlockPos.containing(x, y, z);
			Set<Map.Entry<ResourceKey<EntityType<?>>, EntityType<?>>> allEntries = BuiltInRegistries.ENTITY_TYPE.entrySet();
			for (var entry : allEntries) {
				allEntity.add(entry.getValue().spawn(_lvl, pos, MobSpawnType.MOB_SUMMONED));
			}
		}
		return allEntity;
	}
}
