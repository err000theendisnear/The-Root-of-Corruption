package i.see.you.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

public class KickplayerProcedure {
	public static void execute(Entity entity, String kickreason) {
		if (entity == null || kickreason == null)
			return;
		String reason = "";
		if (!entity.level().isClientSide() && entity instanceof ServerPlayer srveplyr_071) {
			reason = kickreason;
			srveplyr_071.connection.disconnect(Component.literal(reason));//孩子们我原本要用Mixin改写kick命令的，但是太难了我不会，Man!
		}
	}
}

