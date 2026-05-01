package i.see.you.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import i.see.you.init.TheRootOfCorruptionModItems;
import i.see.you.entity.ForgottenPlayerEntity;
import i.see.you.TheRootOfCorruptionMod;

@EventBusSubscriber
public class TheBrokenMemoryKillPlayerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof ForgottenPlayerEntity && ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheRootOfCorruptionModItems.THE_BROKEN_MEMORY.get()
				|| (sourceentity instanceof LivingEntity _entUseItem3 ? _entUseItem3.getUseItem() : ItemStack.EMPTY).getItem() == TheRootOfCorruptionModItems.THE_BROKEN_MEMORY.get()
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TheRootOfCorruptionModItems.THE_BROKEN_MEMORY.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(0);
			TheRootOfCorruptionMod.LOGGER.info(("kill " + entity));
			TheRootOfCorruptionMod.queueServerWork(150, () -> {
				if (!(sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TheRootOfCorruptionModItems.HOPE.get())) : false)) {
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(TheRootOfCorruptionModItems.HOPE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			});
		}
	}
}
