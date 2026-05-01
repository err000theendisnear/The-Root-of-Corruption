package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class RunEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (ForceEventProcedure.execute(world, x, y, z, entity, StringArgumentType.getString(arguments, "event"))) {
			{
				final String _success = (Component.translatable("chat.error_not_found.event").getString());
				final boolean _informAdmins = true;
				arguments.getSource().sendSuccess(() -> Component.literal(_success), _informAdmins);
			}
		} else {
			arguments.getSource().sendFailure(Component.literal((Component.translatable("chat.error_not_found.noevent").getString())));
		}
	}
}
