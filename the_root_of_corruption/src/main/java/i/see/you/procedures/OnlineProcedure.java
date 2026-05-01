package i.see.you.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class OnlineProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		Entity player = null;
		player = new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "player");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity();
		{
			final String _success = ((Component.translatable(("chat.error_not_found.online." + ("" + IsOnlineProcedure.execute(player)))).getString()).replace("%s", player.getDisplayName().getString()));
			final boolean _informAdmins = true;
			arguments.getSource().sendSuccess(() -> Component.literal(_success), _informAdmins);
		}
	}
}
