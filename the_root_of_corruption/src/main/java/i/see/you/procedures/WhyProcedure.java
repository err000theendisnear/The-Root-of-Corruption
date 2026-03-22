package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import i.see.you.init.TheRootOfCorruptionModBlocks;

public class WhyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.setBlock(BlockPos.containing(x, y - 1, z), TheRootOfCorruptionModBlocks.FIGHT_GEN.get().defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x, y, z - 3), TheRootOfCorruptionModBlocks.ROT_IN_HELL.get().defaultBlockState(), 3);
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(), BlockPos.containing(x, y, z), _serverPlayer.getYRot(), true, false);
		entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, (z - 3)));
	}
}
