package i.see.you.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import java.util.ArrayList;

public class InventoryHelperProcedure {
	public static ArrayList execute(LevelAccessor world, Entity entity, boolean copy) {
		if (entity == null)
			return new ArrayList<>();
		ArrayList<Object> item = new ArrayList<>();
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx);
				if (copy) {
					item.add((itemstackiterator.copy()));
				} else {
					item.add(itemstackiterator);
				}
			}
		}
		return item;
	}
}
