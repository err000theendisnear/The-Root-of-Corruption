package i.see.you.procedures;

import net.minecraft.world.item.ItemStack;

public class MendingProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.setDamageValue((int) (itemstack.getDamageValue() - 1));
	}
}
