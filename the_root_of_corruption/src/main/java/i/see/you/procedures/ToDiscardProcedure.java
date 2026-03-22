package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class ToDiscardProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		double i = 0;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "todiscard")) {
				if (!(entityiterator instanceof Player || entityiterator instanceof ServerPlayer)) {
					if (!entityiterator.level().isClientSide())
						entityiterator.discard();
					i = i + 1;
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(((Component.translatable("chat.error_not_found.discard").getString()).replace("num", "" + i))), false);
	}
}
