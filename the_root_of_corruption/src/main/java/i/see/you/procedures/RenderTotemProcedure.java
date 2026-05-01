package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.commands.CommandSourceStack;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.world.entity.Entity;

public class RenderTotemProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		Entity entity = arguments.getSource().getEntity();
		TotemAnimationProcedure.execute(world, entity, ItemArgument.getItem(arguments, "item").getItem().getDefaultInstance());
	}
}
