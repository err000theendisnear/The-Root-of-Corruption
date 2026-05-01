package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import java.util.UUID;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.common.util.FakePlayer;
import net.neoforged.neoforge.common.util.FakePlayerFactory;

public class SpawnFakePlayerProcedure {
	public static Entity execute(LevelAccessor world, String name) {
		if (name == null || world == null) return null;
		String a = name;
		GameProfile profile = new GameProfile(UUID.nameUUIDFromBytes(a.getBytes()), a);
		if (world instanceof ServerLevel server) {
			FakePlayer fakePlayer = new FakePlayer(server, profile);
			return (Entity) fakePlayer;
		}
		return null;
	}
}
