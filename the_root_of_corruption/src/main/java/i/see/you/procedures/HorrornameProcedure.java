package i.see.you.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class HorrornameProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).set(DataComponents.CUSTOM_NAME, Component.literal("null"));
		(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).set(DataComponents.CUSTOM_NAME, Component.literal("null"));
		(entity instanceof LivingEntity _entUseItem4 ? _entUseItem4.getUseItem() : ItemStack.EMPTY).set(DataComponents.CUSTOM_NAME, Component.literal("null"));
	}
}
