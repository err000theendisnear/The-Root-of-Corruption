package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import i.see.you.init.TheRootOfCorruptionModBlocks;
import net.minecraft.server.level.ServerPlayer;

@EventBusSubscriber
public class EntityDiePlaceHeartLessProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), BlockPos.containing(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ()), event.getEntity());
		}
	}

	private static void execute(LivingDeathEvent event, LevelAccessor world, BlockPos pos, LivingEntity entity) {
		if ((event.getSource().getEntity() instanceof Player) && !(entity instanceof Player || entity instanceof ServerPlayer) && entity instanceof LivingEntity && Math.random() < 0.000666) {
			event.setCanceled(true);
			entity.setHealth(Float.NaN);
			entity.kill();
			if (world.isEmptyBlock(pos)) {
				i.see.you.TheRootOfCorruptionMod.LOGGER.info("place heartless at : " + pos);
				world.setBlock(pos, TheRootOfCorruptionModBlocks.HEART_LESS.get().defaultBlockState(), 3);
			}
		}
	}
}
