package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;
import java.util.ArrayList;

@EventBusSubscriber
public class PlayerRespawnProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null && Math.random() < 0.015) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LivingDeathEvent event, LevelAccessor world, Entity entity) {
		if (entity == null || world == null || event == null || event.isCanceled() || world.isClientSide())
			return;
		double z = 0;
		double x = 0;
		double y = 0;
		Level level = ((Level) world);
		if (entity instanceof Player _plr) {
			event.setCanceled(true);
			_plr.setHealth(_plr.getMaxHealth());
			_plr.displayClientMessage(Component.literal("Your soul was saved by \u00A7kUnknown\u00A7r."), false);
			_plr.removeAllEffects();
			_plr.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 255));
			_plr.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 255));
			if (entity instanceof ServerPlayer _player) {
				ResourceKey<Level> destinationType = _player.getRespawnDimension();
				if (!(_player.level().dimension().equals(destinationType))) {
					ServerLevel nextLevel = _player.server.getLevel(destinationType);
					if (!(nextLevel == null)) {
						_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
						_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
						_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
						for (MobEffectInstance _effectinstance : _player.getActiveEffects()) {
							_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
						}
						_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
				if (_player.getRespawnPosition() != null) {
					x = _player.getRespawnPosition().getX();
					x = _player.getRespawnPosition().getY();
					x = _player.getRespawnPosition().getZ();
					entity.teleportTo(x, y, z);
					_player.connection.teleport(x, y, z, _plr.getYRot(), _plr.getXRot());
					level = _player.level();
				}
				level.playSound(_plr, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.death")), SoundSource.MASTER, 1000, 1);
			}
			for (int index0 = 0; index0 < 15; index0++) {
				level.addParticle(ParticleTypes.TOTEM_OF_UNDYING, (x + Mth.nextDouble(RandomSource.create(), -3, 3)), y, (z + Mth.nextDouble(RandomSource.create(), -3, 3)), 0, (-1), 0);
			}
			i.see.you.TheRootOfCorruptionMod.LOGGER.info("saved a player : " + entity);
		}
	}
}
