package i.see.you.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import i.see.you.configuration.ConfigConfiguration;

@EventBusSubscriber
public class GodBreakBlockProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}
	public static void execute(EntityTickEvent.Pre event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (ConfigConfiguration.BREAKBLOCK.get() && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:god")))) {
			BlockPos _pos = BlockPos.containing(x + entity.getLookAngle().x, y + entity.getLookAngle().y + 1, z + entity.getLookAngle().z);
			Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + entity.getLookAngle().x, y + entity.getLookAngle().y + 1, z + entity.getLookAngle().z), null);
			world.destroyBlock(_pos, false);
			event.setCanceled(false);
		}
	}
}
