package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.network.chat.Component;

import java.util.UUID;
import java.util.ArrayList;

import com.mojang.authlib.GameProfile;

public class AddPlayerInPlayerListProcedure {
	public static void execute(LevelAccessor world, Entity entity, String name) {
		if (entity == null || name == null)
			return;
		String a = "";
		if (entity instanceof ServerPlayer) {
			a = name;
			UUID fakeUUID = UUID.randomUUID();
			GameProfile fakeProfile = new GameProfile(fakeUUID, a);
			ClientboundPlayerInfoUpdatePacket.Entry entry = new ClientboundPlayerInfoUpdatePacket.Entry(fakeUUID, fakeProfile, true, 0, GameType.SURVIVAL, Component.literal(a), null);
			ClientboundPlayerInfoUpdatePacket packet = new ClientboundPlayerInfoUpdatePacket(ClientboundPlayerInfoUpdatePacket.Action.ADD_PLAYER, ((ServerPlayer) entity));
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entityiterator instanceof ServerPlayer) {
					((ServerPlayer) entityiterator).connection.send(packet);
				}
			}
		}
	}
}
