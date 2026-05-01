package i.see.you.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class RenameitemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null || AllMissnoAromrProcedure.execute(entity))
			return;
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx);
				itemstackiterator.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7m" + itemstackiterator.getDisplayName().getString() + "\u00A7r\u00A78Corruption")));
			}
		}
	}
}
