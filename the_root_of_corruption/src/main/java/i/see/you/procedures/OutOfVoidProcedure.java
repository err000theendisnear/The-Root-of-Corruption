package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import javax.annotation.Nullable;

import i.see.you.init.TheRootOfCorruptionModItems;

@EventBusSubscriber
public class OutOfVoidProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		Entity entity = event.getEntity();
		DamageSource damagesource = event.getSource();
		if (damagesource == null || entity == null)
			return;
		if (damagesource.is(DamageTypes.FELL_OUT_OF_WORLD) && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TheRootOfCorruptionModItems.LAUGH.get())) : false)) {
			event.setCanceled(true);
		}
	}
}
