package i.see.you.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;

public class TeleportDimensionProcedure {
	private static void run(ResourceKey<Level> dimension, Entity entity) {
		if (dimension == null || entity == null || entity.level().dimension() == dimension || entity.getServer() == null || entity.level() == null)
			return;
		ServerLevel nextLevel = entity.getServer().getLevel(dimension);
		if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
			if (nextLevel != null) {
				_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
				_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
				_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
				for (MobEffectInstance _effectinstance : _player.getActiveEffects())
					_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
				_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
			}
		} else {
			if (nextLevel != null) {
				DimensionTransition transition = new DimensionTransition(
        			nextLevel,
        			new Vec3(entity.getX(), entity.getY(), entity.getZ()),
        			Vec3.ZERO,
        			entity.getYRot(),
        			entity.getXRot(),
        			DimensionTransition.DO_NOTHING
    			);
    			entity.changeDimension(transition);
			}
		}
	}
	public static void execute(ResourceKey<Level> dimension, Entity entity) {
		try {
			TeleportDimensionProcedure.run(dimension, entity);
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
}
