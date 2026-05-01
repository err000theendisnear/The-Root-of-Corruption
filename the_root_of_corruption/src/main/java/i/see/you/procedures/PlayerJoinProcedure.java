package i.see.you.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.configuration.ConfigConfiguration;
import i.see.you.TheRootOfCorruptionMod;

@EventBusSubscriber
public class PlayerJoinProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TheRootOfCorruptionMod.queueServerWork(120, () -> {
			if (world.getLevelData().isHardcore()) {
				{
					Entity _ent = SpawnFakePlayerProcedure.execute(world, "Undefined");
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tell @a \"I strongly do not recommend you turn on hardcore mode, because you will be in a lot of pain.\"");
					}
				}
			} else if (!((!world.isClientSide() && world.getServer() != null) ? (ServerLifecycleHooks.getCurrentServer().isSingleplayer()) : true)) {
				{
					Entity _ent = SpawnFakePlayerProcedure.execute(world, "Undefined");
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tell @a \"Multiplayer may not support this mod.\"");
					}
				}
			} else if (IsOptfineProcedure.execute()) {
				{
					Entity _ent = SpawnFakePlayerProcedure.execute(world, "Undefined");
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								"tell @a \"Optfine has very poor compatibility. You might need to uninstall Optfine and then install the Sodium mod (although Sodium may not be very compatible with this mod).\"");
					}
				}
			}
		});
		TheRootOfCorruptionModVariables.MapVariables.get(world).left = ConfigConfiguration.UNDEFINED_CHAT.get();
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		if (TheRootOfCorruptionModVariables.MapVariables.get(world).event_count == 0) {
			ResetpercentProcedure.execute(world);
		}
		if (entity instanceof Player _player) {
			_player.getAbilities().mayBuild = true;
			_player.onUpdateAbilities();
		}
		if (entity instanceof Player _player) {
			_player.getAbilities().invulnerable = false;
			_player.onUpdateAbilities();
		}
		TheRootOfCorruptionModVariables.MapVariables.get(world).javachase = false;
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		TheRootOfCorruptionModVariables.MapVariables.get(world).look_player = Mth.nextInt(RandomSource.create(), 0, 5) == 1;
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		if (TheRootOfCorruptionModVariables.MapVariables.get(world).undefined_join) {
			if ((entity.getDisplayName().getString()).equals("Undefind") || (entity.getDisplayName().getString()).equals("Undefined")) {
				KickplayerProcedure.execute(entity, Component.translatable("multiplayer.disconnect.name_taken").getString());
			} else if ((!world.isClientSide() && world.getServer() != null) ? (ServerLifecycleHooks.getCurrentServer().isSingleplayer()) : true) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A7e" + (Component.translatable("multiplayer.player.joined").getString()).replace("%s", entity.getDisplayName().getString()))), false);
			}
		}
		if (TheRootOfCorruptionModVariables.MapVariables.get(world).online && !IsOnlineProcedure.execute(entity) && ConfigConfiguration.BAN.get()) {
			KickplayerProcedure.execute(entity, Component.translatable("mco.error.invalid.session.message").getString() + "(" + Component.translatable("mco.error.invalid.session.title").getString() + ")");
		}
	}
}
