package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

public class OwnerspawnProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A7e" + (Component.translatable("multiplayer.player.joined").getString()).replace("%s", GetUserNameProcedure.execute()))), false);
	}
}
