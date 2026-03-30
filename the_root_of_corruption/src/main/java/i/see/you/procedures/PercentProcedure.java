package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import i.see.you.network.TheRootOfCorruptionModVariables;

public class PercentProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList()
					.broadcastSystemMessage(Component.literal(((Component.translatable("chat.error_not_found.percent").getString()).replace("%s", "" + (int) TheRootOfCorruptionModVariables.MapVariables.get(world).event_count))), false);
	}
}
