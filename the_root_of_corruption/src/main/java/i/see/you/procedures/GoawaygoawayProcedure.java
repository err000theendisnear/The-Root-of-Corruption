package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class GoawaygoawayProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		PlaySoundProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), 1, 1000, "the_root_of_corruption:goaway");
		for (Object item : InventoryHelperProcedure.execute(world, entity, false)) {
			if (item instanceof ItemStack _item) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(_item.getItem(), 100);
				_item.set(DataComponents.CUSTOM_NAME, Component.literal("Go away"));
			}	
		}
	}
}
