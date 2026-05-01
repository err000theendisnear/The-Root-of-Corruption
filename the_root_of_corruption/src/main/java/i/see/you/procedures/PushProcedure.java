package i.see.you.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class PushProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "entity")) {
				entityiterator.push((DoubleArgumentType.getDouble(arguments, "x")), (DoubleArgumentType.getDouble(arguments, "y")), (DoubleArgumentType.getDouble(arguments, "z")));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
