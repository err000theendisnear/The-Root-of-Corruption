package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import i.see.you.network.TheRootOfCorruptionModVariables;

public class SfProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Component.translatable("chat.error_not_found.surface").getString() + "" + TheRootOfCorruptionModVariables.MapVariables.get(world).on_surface)), false);
	}
}
