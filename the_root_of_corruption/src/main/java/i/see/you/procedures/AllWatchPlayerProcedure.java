package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.ArrayList;

public class AllWatchPlayerProcedure {
	public static void execute(LevelAccessor world) {
		Entity player = null;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			player = entityiterator;
			break;
		}
		for (Object arraylistiterator : GetAllEntitiesProcedure.execute(world)) {
			(arraylistiterator instanceof Entity _entity5 ? _entity5 : null).lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((player.getX()), (player.getY() + 1), (player.getZ())));
		}
	}
}
