package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.Comparator;

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
		player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null);
		if (player == null) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			player.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
			TheRootOfCorruptionModVariables.MapVariables.get(world).javachase = true;
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
			if (player instanceof ServerPlayer _player)
				_player.setGameMode(GameType.ADVENTURE);
		}
	}
}
