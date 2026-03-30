package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import i.see.you.init.TheRootOfCorruptionModItems;
import net.minecraft.world.InteractionHand;

@EventBusSubscriber
public class TotemProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(LivingDeathEvent event, Entity entity) {
		if (entity == null)
			return;
		if (AllMissnoAromrProcedure.execute(entity)) {
			event.setCanceled(true);
		} else if (AllNotextureProcedure.execute(entity) && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.BEDROCK.asItem()) {
			event.setCanceled(true);
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(TheRootOfCorruptionModItems.ITEM_IS_MISSING_ID.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
	}
}
