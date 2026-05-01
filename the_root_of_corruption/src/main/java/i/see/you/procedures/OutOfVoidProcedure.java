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
import i.see.you.init.TheRootOfCorruptionModItems;
import i.see.you.entity.LostMemoryEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber
public class OutOfVoidProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		Entity entity = event.getEntity();
		DamageSource damagesource = event.getSource();
		if (damagesource == null || entity == null)
			return;
		if ((damagesource.is(DamageTypes.FELL_OUT_OF_WORLD) || damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("the_root_of_corruption:null_pointer_damage")))) && (entity instanceof LostMemoryEntity || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TheRootOfCorruptionModItems.LAUGH.get())) : false))) {
			event.setCanceled(true);
		}
	}
}
