package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.util.Collections;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.init.TheRootOfCorruptionModBlocks;

public class FaultProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		TheRootOfCorruptionModVariables.MapVariables.get(world).blockx = x + Mth.nextInt(RandomSource.create(), -1000, 1000);
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		TheRootOfCorruptionModVariables.MapVariables.get(world).blocky = Mth.nextInt(RandomSource.create(), -59, 256);
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		TheRootOfCorruptionModVariables.MapVariables.get(world).blockz = z + Mth.nextInt(RandomSource.create(), -1000, 1000);
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		world.setBlock(BlockPos.containing(TheRootOfCorruptionModVariables.MapVariables.get(world).blockx, TheRootOfCorruptionModVariables.MapVariables.get(world).blocky, TheRootOfCorruptionModVariables.MapVariables.get(world).blockz),
				TheRootOfCorruptionModBlocks.THIS_IS_ALL_THEBLOCK_FAULT.get().defaultBlockState(), 3);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
					("you need to:" + TheRootOfCorruptionModVariables.MapVariables.get(world).blockx + " " + TheRootOfCorruptionModVariables.MapVariables.get(world).blocky + " " + TheRootOfCorruptionModVariables.MapVariables.get(world).blockz)),
					false);
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("error_not_found:miss")));
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("error_not_found:errr")));
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("error_not_found:headmiss")));
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("error_not_found:erorr")));
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("error_not_found:missrecipe")));
	}
}
