package i.see.you.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class ClearHarmfulEffectProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "entity")) {
				RemoveHarmfulEffectProcedure.execute(entityiterator);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
