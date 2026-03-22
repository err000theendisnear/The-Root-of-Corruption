package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SpawnSelfProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		AnotherSelfProcedure.execute(world, DoubleArgumentType.getDouble(arguments, "x"), DoubleArgumentType.getDouble(arguments, "y"), DoubleArgumentType.getDouble(arguments, "z"), new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "self");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity());
	}
}
