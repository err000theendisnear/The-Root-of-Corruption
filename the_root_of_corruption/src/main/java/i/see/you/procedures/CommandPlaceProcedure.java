package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.arguments.blocks.BlockStateArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;

public class CommandPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		CrossProcedure.execute(world, x, y, z, BlockStateArgument.getBlock(arguments, "cross").getState());
	}
}
