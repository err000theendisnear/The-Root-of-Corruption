package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;

import javax.annotation.Nullable;

import i.see.you.init.TheRootOfCorruptionModItems;
import i.see.you.entity.UndefinedBossEntity;
import i.see.you.entity.Base0Entity;

@EventBusSubscriber
public class RunProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, Entity sourceentity, double amount) {
		execute(null, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Base0Entity && (sourceentity instanceof ServerPlayer || sourceentity instanceof Player)) {
			if (TheRootOfCorruptionModItems.ITEM_IS_MISSING_ID.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				if (sourceentity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(TheRootOfCorruptionModItems.LAUGH.get()).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (sourceentity instanceof Player _plr6)
					_plr6.resetAttackStrengthTicker();
			}
		} else if (entity instanceof UndefinedBossEntity) {
			if (amount > 20) {
				if (entity instanceof UndefinedBossEntity _datEntSetI)
					_datEntSetI.getEntityData().set(UndefinedBossEntity.DATA_hp, (int) Math.ceil((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - 20));
			} else {
				if (entity instanceof UndefinedBossEntity _datEntSetI)
					_datEntSetI.getEntityData().set(UndefinedBossEntity.DATA_hp, (int) Math.ceil((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - amount));
			}
		}
	}
}
