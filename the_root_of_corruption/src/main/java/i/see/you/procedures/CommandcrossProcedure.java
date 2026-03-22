package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.arguments.blocks.BlockStateArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CommandcrossProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		CrossProcedure.execute(world, DoubleArgumentType.getDouble(arguments, "x"), DoubleArgumentType.getDouble(arguments, "y"), DoubleArgumentType.getDouble(arguments, "z"), BlockStateArgument.getBlock(arguments, "cross").getState());
	}
}
