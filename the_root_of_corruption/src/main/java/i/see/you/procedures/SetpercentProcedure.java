package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import i.see.you.network.TheRootOfCorruptionModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetpercentProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		TheRootOfCorruptionModVariables.MapVariables.get(world).event_count = DoubleArgumentType.getDouble(arguments, "percent");
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
	}
}
