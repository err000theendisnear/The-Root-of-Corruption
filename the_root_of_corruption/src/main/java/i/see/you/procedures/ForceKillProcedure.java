package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import java.util.List;
import java.util.Collection;

public class ForceKillProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "entity")) {
				KillentityProcedure.execute(world, entityiterator);
			}
			msg(EntityArgument.getEntities(arguments, "entity"), arguments);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
	private static void msg(Collection<? extends Entity> ent, CommandContext<CommandSourceStack> arguments) {
		if (ent.size() == 1) {
			arguments.getSource().sendSuccess(() -> Component.translatable("commands.kill.success.single", ent.iterator().next().getDisplayName()), true);
		} else {
			arguments.getSource().sendSuccess(() -> Component.translatable("commands.kill.success.multiple", ent.size(), true), true);
		}
	}
}
