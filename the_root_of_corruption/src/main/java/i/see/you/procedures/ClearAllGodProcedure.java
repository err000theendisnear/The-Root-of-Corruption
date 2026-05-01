package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class ClearAllGodProcedure {
	public static void execute(LevelAccessor world) {
		Entity entity = null;
		for (Object arraylistiterator : GetAllEntitiesProcedure.execute(world)) {
			entity = arraylistiterator instanceof Entity _entity1 ? _entity1 : null;
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:god")))) {
				DiscardProcedure.execute(entity);
			}
		}
	}
}
