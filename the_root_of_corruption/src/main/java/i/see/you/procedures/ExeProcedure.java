package i.see.you.procedures;

import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class ExeProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		RunEXEFileProcedure.execute(StringArgumentType.getString(arguments, "path"));
	}
}
