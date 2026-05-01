package i.see.you.procedures;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

import java.util.ArrayList;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.TheRootOfCorruptionMod;

@EventBusSubscriber
public class UndefindjointhegameProcedure {
	@SubscribeEvent
	public static void onWorldLoad(net.neoforged.neoforge.event.level.LevelEvent.Load event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (!(TheRootOfCorruptionModVariables.MapVariables.get(world).undefined_join || TheRootOfCorruptionModVariables.MapVariables.get(world).left)) {
			TheRootOfCorruptionMod.queueServerWork(18000, () -> {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					UndefinedJoinProcedure.execute(world, entityiterator);
				}
				if (!(TheRootOfCorruptionModVariables.MapVariables.get(world).undefined_join || TheRootOfCorruptionModVariables.MapVariables.get(world).left)) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A7e" + (Component.translatable("multiplayer.player.joined").getString()).replace("%s", "Undefined"))), false);
					TheRootOfCorruptionModVariables.MapVariables.get(world).undefined_join = true;
					TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
					for (Entity entityiterator : new ArrayList<>(world.players())) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.MASTER, 100, 1);
							} else {
								_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.MASTER, 100, 1, false);
							}
						}
						if ((entityiterator.getDisplayName().getString()).equals("Undefind") || (entityiterator.getDisplayName().getString()).equals("Undefined")) {
							{
								Entity _ent = entityiterator;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("kick @s " + Component.translatable("multiplayer.disconnect.name_taken").getString()));
								}
							}
						}
					}
				}
			});
		}
	}
}
