package i.see.you.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class ToDiscardProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		double i = 0;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "todiscard")) {
				if (!(entityiterator instanceof Player || entityiterator instanceof ServerPlayer)) {
					DiscardProcedure.execute(entityiterator);
					i = i + 1;
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
		{
			final String _success = ((Component.translatable("chat.error_not_found.discard").getString()).replace("%5", "" + i));
			final boolean _informAdmins = true;
			arguments.getSource().sendSuccess(() -> Component.literal(_success), _informAdmins);
		}
	}
}
