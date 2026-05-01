package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class NearestPlayerProcedure {
	public static Entity execute(LevelAccessor world, double x, double y, double z) {
		Entity player = null;
		player = SpawnFakePlayerProcedure.execute(world, "null");
		player.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
		{
			Entity _ent = player;
			_ent.teleportTo(x, y, z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
		}
		return NearbyPlayerProcedure.execute(world, player);
	}
}
