package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import i.see.you.init.TheRootOfCorruptionModBlocks;

public class WhyProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		world.setBlock(new BlockPos(0, 99, 0), TheRootOfCorruptionModBlocks.FIGHT_GEN.get().defaultBlockState(), 3);
		world.setBlock(new BlockPos(0, 100, -3), TheRootOfCorruptionModBlocks.ROT_IN_HELL.get().defaultBlockState(), 3);
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(), new BlockPos(0, 100, 0), _serverPlayer.getYRot(), true, false);
		entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(0, 0, (-3)));
		{
			Entity _ent = entity;
			_ent.teleportTo(0, 100, 0);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(0, 100, 0, _ent.getYRot(), _ent.getXRot());
		}
	}
}
