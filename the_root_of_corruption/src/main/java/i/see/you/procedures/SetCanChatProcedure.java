package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.configuration.ConfigConfiguration;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class SetCanChatProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		TheRootOfCorruptionModVariables.MapVariables.get(world).left = !BoolArgumentType.getBool(arguments, "chat");
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		if (!ConfigConfiguration.UNDEFINED_CHAT.get()) {
			TheRootOfCorruptionModVariables.MapVariables.get(world).left = false;
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
