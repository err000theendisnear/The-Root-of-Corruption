package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

public class UsernameProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(((Component.translatable("chat.error_not_found.username").getString()).replace("%5", GetUserNameProcedure.execute()))), false);
	}
}
