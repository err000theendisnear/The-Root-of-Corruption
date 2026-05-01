package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import i.see.you.network.TheRootOfCorruptionModVariables;

import com.mojang.brigadier.context.CommandContext;

public class SfProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		{
			final String _success = ((Component.translatable("chat.error_not_found.surface").getString()).replace("%5", "" + TheRootOfCorruptionModVariables.MapVariables.get(world).on_surface));
			final boolean _informAdmins = true;
			arguments.getSource().sendSuccess(() -> Component.literal(_success), _informAdmins);
		}
	}
}
