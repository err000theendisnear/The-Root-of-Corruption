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
			if (entity instanceof Player _player && !_player.level().isClientSide()) {
				_player.displayClientMessage(Component.literal("\u00A7cerror : package net.neoforged.neoforge.event.ServerChatEvent does not exist"), true);
			}
			return;
		}
		String chat = "";
		if (!TheRootOfCorruptionModVariables.MapVariables.get(world).left) {
			chat = text;
			if (TheRootOfCorruptionModVariables.MapVariables.get(world).undefined_join) {
				if (chat.contains("hello") || chat.contains("hi")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						errSay(world);
						TheRootOfCorruptionMod.queueServerWork(100, () -> {
							UndefinedSay("\u00A7aHello.", world);
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
						UndefinedSay("\u00A7cerror: \u00A7k_rot_in_hell.", world);
						TheRootOfCorruptionMod.queueServerWork(20, () -> {
							entity.kill();
							KickplayerProcedure.execute(entity, Component.translatable("multiplayer.disconnect.banned").getString());
						});
					});
				} else if (chat.contains("\u00A7k")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						UndefinedSay("that's me.", world);;
					});
				} else if (chat.contains("who are you")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						errSay(world);
						TheRootOfCorruptionMod.queueServerWork(100, () -> {
							UndefinedSay("\u00A7a\u00A7kUndefined", world);
						});
					});
				} else if (chat.contains("what do you want")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						errSay(world);
						TheRootOfCorruptionMod.queueServerWork(120, () -> {
							
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
						errSay(world);
						TheRootOfCorruptionMod.queueServerWork(50, () -> {
							UndefinedSay("\u00A7aThey regret not fixing this bug.", world);
						});
					});
				} else if (chat.contains("1.7.10") || chat.contains("alpha") || chat.contains("beta")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						errSay(world);
						TheRootOfCorruptionMod.queueServerWork(100, () -> {
							UndefinedSay("\u00A7ahome.", world);
						});
					});
				} else if (chat.contains("the broken script") || chat.contains("mark101")) {
					TheRootOfCorruptionMod.queueServerWork(175, () -> {
						if (Calendar.getInstance().get(Calendar.MONTH) == 3 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 0) {
							if (ModList.get().isLoaded("thebrokenscript")) {
								UndefinedSay(":)", world);
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
										UndefinedSay(">:(", world);
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
							UndefinedSay("([<err.go_away>})", world);
						}
					});
				} else if (chat.contains("null")) {
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						UndefinedSay("friend.", world);
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
						errSay(world);
						TheRootOfCorruptionMod.queueServerWork(100, () -> {
							UndefinedSay("\u00A7ahe is right behind you.", world);
						});
					});
				}
			}
		}
	}
	
	private static void UndefinedSay(String message, LevelAccessor world) {
		Entity _ent = SpawnFakePlayerProcedure.execute(world, "Undefined");
		if (!world.isClientSide() && _ent.getServer() != null) {
			_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), world instanceof ServerLevel _svlvl ? _svlvl : null, 4,
					_ent.getName().getString(), _ent.getDisplayName(), world.getServer(), _ent), ("say " + message));
		}
	}

	private static void errSay(LevelAccessor world) {
		LogUndefinedProcedure.execute();
		UndefinedSay("\u00A7cerror: cannot find symbol", world);
	}
}
