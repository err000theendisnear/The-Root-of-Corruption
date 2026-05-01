package i.see.you.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class GiveHarmfulEffectProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "entity")) {
				GiveAllDebuffToEntityProcedure.execute(entityiterator, BoolArgumentType.getBool(arguments, "beacon"), BoolArgumentType.getBool(arguments, "particle"), DoubleArgumentType.getDouble(arguments, "level"),
						DoubleArgumentType.getDouble(arguments, "time"));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
