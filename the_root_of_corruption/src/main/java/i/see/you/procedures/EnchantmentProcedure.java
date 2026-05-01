package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class EnchantmentProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		for (Object arraylistiterator : InventoryHelperProcedure.execute(world, entity, false)) {
			(arraylistiterator instanceof ItemStack _stack1 ? _stack1 : ItemStack.EMPTY)
					.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("the_root_of_corruption:behind_you_curse"))), 1);
		}
	}
}
