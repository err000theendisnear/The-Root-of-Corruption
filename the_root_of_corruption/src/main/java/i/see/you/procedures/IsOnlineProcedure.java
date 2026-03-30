package i.see.you.procedures;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.level.ServerPlayer;
import java.util.UUID;
import net.minecraft.world.entity.Entity;

public class IsOnlineProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof ServerPlayer _player) {
			GameProfile gameProfile = _player.getGameProfile();
			UUID playerId = gameProfile.getId();
    		String playerName = gameProfile.getName();
			return gameProfile.getId().version() != 3 && playerId != null && playerName != null && !playerName.isEmpty();
		}
		return false;
	}
}
