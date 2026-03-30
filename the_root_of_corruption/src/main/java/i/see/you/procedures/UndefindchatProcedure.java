package i.see.you.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.neoforge.event.ServerChatEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import java.util.Calendar;
import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.entity.CustomDeathWatchEntity;
import i.see.you.TheRootOfCorruptionMod;

@EventBusSubscriber
public class UndefindchatProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		Entity entity = event.getPlayer();
		LevelAccessor world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		String text = event.getRawText();
		if (event.getPlayer() == null || text == null || event == null)
			return;
		if (!world.getEntitiesOfClass(CustomDeathWatchEntity.class, AABB.ofSize(new Vec3(x, y, z), 1280, 1280, 1280), e -> true).isEmpty()) {
			event.setCanceled(true);
			SayProcedure.execute(entity);
			return;
		}
		String chat = "";
		if (!TheRootOfCorruptionModVariables.MapVariables.get(world).left) {
			chat = text;
			if (TheRootOfCorruptionModVariables.MapVariables.get(world).undefined_join) {
				if (chat.contains("hello") || chat.contains("hi")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> \u00A7cerror: cannot find symbol"), false);
						TheRootOfCorruptionMod.queueServerWork(100, () -> {
							if (!world.isClientSide() && world.getServer() != null)
								world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> \u00A7aHello."), false);
						});
					});
				} else if ((chat).equals("undefined") || (chat).equals("undefind")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						TheRootOfCorruptionMod.queueServerWork(25, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.PLAYERS, 10, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.PLAYERS, 10, 1, false);
								}
							}
						});
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> \u00A7cerror: \u00A7k_rot_in_hell."), false);
						TheRootOfCorruptionMod.queueServerWork(20, () -> {
							entity.kill();
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("kick @s " + Component.translatable("multiplayer.disconnect.banned").getString()));
								}
							}
						});
					});
				} else if (chat.contains("\u00A7k")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> that's me."), false);
					});
				} else if (chat.contains("who are you")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> \u00A7cerror: cannot find symbol"), false);
						TheRootOfCorruptionMod.queueServerWork(100, () -> {
							if (!world.isClientSide() && world.getServer() != null)
								world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> \u00A7a\u00A7kUndefind"), false);
						});
					});
				} else if (chat.contains("what do you want")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> \u00A7cerror: cannot find symbol"), false);
						TheRootOfCorruptionMod.queueServerWork(120, () -> {
							if (!world.isClientSide() && world.getServer() != null)
								world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> \u00A7ahelp."), false);
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7cplease."), true);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.breath")), SoundSource.PLAYERS, 10, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.breath")), SoundSource.PLAYERS, 10, 1, false);
								}
							}
							for (int index0 = 0; index0 < 4; index0++) {
								TheRootOfCorruptionMod.queueServerWork(20, () -> {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.breath")), SoundSource.PLAYERS, 10, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.breath")), SoundSource.PLAYERS, 10, 1, false);
										}
									}
								});
							}
						});
					});
				} else if (chat.contains("fuck you")) {
					TheRootOfCorruptionMod.queueServerWork(160, () -> {
						TheRootOfCorruptionModVariables.MapVariables.get(world).ban = true;
						TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
					});
				} else if ((entity.getDisplayName().getString()).contains("null")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						for (int index1 = 0; index1 < 10; index1++) {
							TheRootOfCorruptionMod.LOGGER.error("java.lang.NullPointerException");
							TheRootOfCorruptionMod.LOGGER.fatal("java.lang.NullPointerException");
							entity.kill();
							if (!entity.level().isClientSide())
								entity.discard();
							TheRootOfCorruptionMod.LOGGER.info("this is all you fault, " + entity);
						}
						if (!world.isClientSide() && world.getServer() != null)
							ServerLifecycleHooks.getCurrentServer().stopServer();
					});
				} else if (chat.contains("mojang")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> \u00A7cerror: cannot find symbol"), false);
						TheRootOfCorruptionMod.queueServerWork(50, () -> {
							if (!world.isClientSide() && world.getServer() != null)
								world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> \u00A7aThey are \u00A7k_wo_ye_bu_zhi_dao"), false);
						});
					});
				} else if (chat.contains("1.7.10") || chat.contains("alpha") || chat.contains("beta")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> \u00A7cerror: cannot find symbol"), false);
						TheRootOfCorruptionMod.queueServerWork(100, () -> {
							if (!world.isClientSide() && world.getServer() != null)
								world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> \u00A7ahome."), false);
						});
					});
				} else if (chat.contains("the broken script") || chat.contains("mark101")) {
					TheRootOfCorruptionMod.queueServerWork(175, () -> {
						if (Calendar.getInstance().get(Calendar.MONTH) == 3 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 0) {
							if (ModList.get().isLoaded("thebrokenscript")) {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> :)"), false);
								TheRootOfCorruptionMod.queueServerWork(50, () -> {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "say null");
										}
									}
									TheRootOfCorruptionMod.LOGGER.info("<Null> the end is nigh.");
									TheRootOfCorruptionMod.LOGGER.info("<Null> the end is null.");
								});
								TheRootOfCorruptionMod.queueServerWork(250, () -> {
									if (entity.isAlive()) {
										if (!world.isClientSide() && world.getServer() != null)
											world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> >:("), false);
										TheRootOfCorruptionMod.queueServerWork(50, () -> {
											{
												Entity _ent = entity;
												if (!_ent.level().isClientSide() && _ent.getServer() != null) {
													_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
															_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "say Xxram2diexX");
												}
											}
											TheRootOfCorruptionMod.LOGGER.info("<Null> Rot in hell.");
										});
									}
								});
							}
						} else {
							if (!world.isClientSide() && world.getServer() != null)
								world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> ([{<err.die>}])"), false);
						}
					});
				} else if (chat.contains("null")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> friend."), false);
					});
					TheRootOfCorruptionMod.queueServerWork(200, () -> {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "publish");
							}
						}
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(((Component.translatable("commands.publish.started").getString()).replace("%s", "[\u00A7a\u00A7k00000\u00A7r]"))), false);
					});
				} else if (chat.contains("herobrine")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> \u00A7cerror: cannot find symbol"), false);
						TheRootOfCorruptionMod.queueServerWork(100, () -> {
							if (!world.isClientSide() && world.getServer() != null)
								world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Undefind> \u00A7ahe right behind you."), false);
						});
					});
				}
			}
		}
	}
}
