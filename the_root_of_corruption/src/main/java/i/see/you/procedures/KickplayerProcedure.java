package i.see.you.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

public class KickplayerProcedure {
	public static void execute(Entity entity, String kickreason) {
		if (entity == null || kickreason == null)
			return;
		if (!entity.level().isClientSide() && entity instanceof ServerPlayer srveplyr_071) {
			srveplyr_071.connection.disconnect(Component.literal(kickreason));
		}
	}
}
