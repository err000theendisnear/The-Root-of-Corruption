package i.see.you.procedures;

import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class AlertProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		AlertWindowsProcedure.execute(StringArgumentType.getString(arguments, "message"), StringArgumentType.getString(arguments, "title"));
	}
}
