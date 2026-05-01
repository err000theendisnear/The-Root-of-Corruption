package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import i.see.you.init.TheRootOfCorruptionModEntities;

public class UdfstaretickupdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		player = NearbyPlayerProcedure.execute(world, entity);
		if (!(player == null)) {
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((player.getX()), (player.getY() + 1), (player.getZ())));
			if (LookentityProcedure.execute(player, entity)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheRootOfCorruptionModEntities.UNDEFINDCHASE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
				DiscardProcedure.execute(entity);
			}
		}
	}
}
