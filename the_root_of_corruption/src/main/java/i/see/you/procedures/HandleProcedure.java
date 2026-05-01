package i.see.you.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;

public class HandleProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		{
			final String _success = ((Component.translatable("chat.error_not_found.handle").getString()).replace("%s", "" + WindowHandleProcedure.execute()));
			final boolean _informAdmins = true;
			arguments.getSource().sendSuccess(() -> Component.literal(_success), _informAdmins);
		}
	}
}
