package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import i.see.you.network.TheRootOfCorruptionModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class LookatplayerProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		TheRootOfCorruptionModVariables.MapVariables.get(world).look_player = BoolArgumentType.getBool(arguments, "look");
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
	}
}
