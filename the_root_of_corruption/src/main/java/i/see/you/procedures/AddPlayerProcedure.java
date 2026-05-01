package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class AddPlayerProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			AddPlayerInPlayerListProcedure.execute(world, entity, StringArgumentType.getString(arguments, "name"));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
