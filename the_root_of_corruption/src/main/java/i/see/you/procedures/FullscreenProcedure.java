package i.see.you.procedures;

import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class FullscreenProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		ToggleFullScreenProcedure.execute(BoolArgumentType.getBool(arguments, "isexit"));
	}
}
