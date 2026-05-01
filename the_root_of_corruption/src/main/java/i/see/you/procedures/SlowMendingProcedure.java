package i.see.you.procedures;

import net.minecraft.world.item.ItemStack;

public class SlowMendingProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.setDamageValue((int) (itemstack.getDamageValue() - (Math.random() < 0.075 ? 1 : 0)));
	}
}
