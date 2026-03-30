package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

public class HandleProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(((Component.translatable("chat.error_not_found.handle").getString()).replace("%s", "" + WindowHandleProcedure.execute()))), false);
	}
}
