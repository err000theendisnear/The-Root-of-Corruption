package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import i.see.you.network.TheRootOfCorruptionModVariables;

public class JavatickupdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		if (!(Level.OVERWORLD == (entity.level().dimension()))) {
			TheRootOfCorruptionModVariables.MapVariables.get(world).javachase = false;
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
			if (!entity.level().isClientSide())
				entity.discard();
		}
		player = NearbyPlayerProcedure.execute(world, entity);
		if (player == null) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			CavesoundProcedure.execute(world, x, y, z);
			player.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
			TheRootOfCorruptionModVariables.MapVariables.get(world).javachase = true;
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
			if (player instanceof ServerPlayer _player)
				_player.setGameMode(GameType.ADVENTURE);
			ToggleFullScreenProcedure.execute(true);
		}
	}
}
