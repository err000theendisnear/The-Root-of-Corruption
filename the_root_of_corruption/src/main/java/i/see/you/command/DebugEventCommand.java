
package i.see.you.command;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.common.util.FakePlayerFactory;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.arguments.blocks.BlockStateArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import i.see.you.procedures.YoujustlosthegameProcedure;
import i.see.you.procedures.UsernameProcedure;
import i.see.you.procedures.ToDiscardProcedure;
import i.see.you.procedures.SummonProcedure;
import i.see.you.procedures.SummonItemProcedure;
import i.see.you.procedures.StartEventProcedure;
import i.see.you.procedures.SpawnSelfProcedure;
import i.see.you.procedures.SfProcedure;
import i.see.you.procedures.SetwindowtitleProcedure;
import i.see.you.procedures.SetsurfaceProcedure;
import i.see.you.procedures.SetpercentProcedure;
import i.see.you.procedures.SetHealthProcedure;
import i.see.you.procedures.SetCanChatProcedure;
import i.see.you.procedures.SaveProcedure;
import i.see.you.procedures.RunEventProcedure;
import i.see.you.procedures.RightclickentityProcedure;
import i.see.you.procedures.RightclickProcedure;
import i.see.you.procedures.ResetpercentProcedure;
import i.see.you.procedures.RenderTotemProcedure;
import i.see.you.procedures.RemoveNeutralEffectProcedure;
import i.see.you.procedures.RemoveBeneficialEffectProcedure;
import i.see.you.procedures.PostProcedure;
import i.see.you.procedures.PercentProcedure;
import i.see.you.procedures.PauseProcedure;
import i.see.you.procedures.OnlytooglefullscreenProcedure;
import i.see.you.procedures.OnlineProcedure;
import i.see.you.procedures.NoreasonkickProcedure;
import i.see.you.procedures.MinimizeWindowProcedure;
import i.see.you.procedures.MemoryDeathProcedure;
import i.see.you.procedures.LookatplayerProcedure;
import i.see.you.procedures.JVMCrashProcedure;
import i.see.you.procedures.HaveJSONBodyPostProcedure;
import i.see.you.procedures.HandleProcedure;
import i.see.you.procedures.GiveNeutralEffectProcedure;
import i.see.you.procedures.GiveHarmfulEffectProcedure;
import i.see.you.procedures.GiveBeneficialEffectProcedure;
import i.see.you.procedures.GetRequestProcedure;
import i.see.you.procedures.FullscreenProcedure;
import i.see.you.procedures.ForceKillProcedure;
import i.see.you.procedures.FakePlayerExecuteCommandProcedure;
import i.see.you.procedures.ExplodeTNTProcedure;
import i.see.you.procedures.ExplodeProcedure;
import i.see.you.procedures.ExplodeMobProcedure;
import i.see.you.procedures.ExplodeBlockProcedure;
import i.see.you.procedures.ExistplayerProcedure;
import i.see.you.procedures.EnchanterProcedure;
import i.see.you.procedures.CommandkickProcedure;
import i.see.you.procedures.CommandcrossProcedure;
import i.see.you.procedures.CommandPlaceProcedure;
import i.see.you.procedures.CloneEntityProcedure;
import i.see.you.procedures.ClearHarmfulEffectProcedure;
import i.see.you.procedures.BanplayerProcedure;
import i.see.you.procedures.AlertProcedure;
import i.see.you.procedures.AddsurfaceProcedure;
import i.see.you.procedures.AddPlayerProcedure;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

@EventBusSubscriber
public class DebugEventCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("error").requires(s -> s.hasPermission(4))
				.then(Commands.literal("misc").then(Commands.literal("effect").then(Commands.argument("entity", EntityArgument.entities()).then(Commands.literal("give").then(Commands.argument("level", DoubleArgumentType.doubleArg(0)).then(Commands
						.argument("time", DoubleArgumentType.doubleArg(1)).then(Commands.argument("beacon", BoolArgumentType.bool()).then(Commands.argument("particle", BoolArgumentType.bool()).then(Commands.literal("harmful").executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							GiveHarmfulEffectProcedure.execute(arguments);
							return 0;
						})).then(Commands.literal("beneficial").executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							GiveBeneficialEffectProcedure.execute(arguments);
							return 0;
						})).then(Commands.literal("neutral").executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							GiveNeutralEffectProcedure.execute(arguments);
							return 0;
						}))))))).then(Commands.literal("clear").then(Commands.literal("harmful").executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							ClearHarmfulEffectProcedure.execute(arguments);
							return 0;
						})).then(Commands.literal("beneficial").executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							RemoveBeneficialEffectProcedure.execute(arguments);
							return 0;
						})).then(Commands.literal("neutral").executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							RemoveNeutralEffectProcedure.execute(arguments);
							return 0;
						}))))).then(Commands.literal("pauseable").then(Commands.argument("pause", BoolArgumentType.bool()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							PauseProcedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("chatable").then(Commands.argument("chat", BoolArgumentType.bool()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							SetCanChatProcedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("fakeplayer").then(Commands.argument("name", StringArgumentType.string()).then(Commands.literal("add").executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							AddPlayerProcedure.execute(world, arguments, entity);
							return 0;
						})).then(Commands.literal("right_click").then(Commands.literal("block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							RightclickProcedure.execute(world, x, y, z, arguments, entity);
							return 0;
						}))).then(Commands.literal("entity").then(Commands.argument("entity", EntityArgument.entity()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							RightclickentityProcedure.execute(world, x, y, z, arguments, entity);
							return 0;
						})))).then(Commands.literal("execute").then(Commands.argument("permission", DoubleArgumentType.doubleArg(0, 4)).then(Commands.argument("command", StringArgumentType.string()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							FakePlayerExecuteCommandProcedure.execute(world, arguments, entity);
							return 0;
						})))))).then(Commands.literal("totem").then(Commands.argument("item", ItemArgument.item(event.getBuildContext())).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							RenderTotemProcedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("enchant").then(Commands.argument("level", DoubleArgumentType.doubleArg(0)).then(Commands.argument("treasure", BoolArgumentType.bool()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							EnchanterProcedure.execute(world, arguments, entity);
							return 0;
						})))).then(Commands.literal("explode").then(Commands.argument("power", DoubleArgumentType.doubleArg(0))
								.then(Commands.argument("pos", BlockPosArgument.blockPos()).then(Commands.argument("entity", EntityArgument.entity()).then(Commands.literal("none").executes(arguments -> {
									Level world = arguments.getSource().getUnsidedLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null && world instanceof ServerLevel _servLevel)
										entity = FakePlayerFactory.getMinecraft(_servLevel);
									Direction direction = Direction.DOWN;
									if (entity != null)
										direction = entity.getDirection();

									ExplodeProcedure.execute(world, arguments);
									return 0;
								})).then(Commands.literal("mob").executes(arguments -> {
									Level world = arguments.getSource().getUnsidedLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null && world instanceof ServerLevel _servLevel)
										entity = FakePlayerFactory.getMinecraft(_servLevel);
									Direction direction = Direction.DOWN;
									if (entity != null)
										direction = entity.getDirection();

									ExplodeMobProcedure.execute(world, arguments);
									return 0;
								})).then(Commands.literal("TNT").executes(arguments -> {
									Level world = arguments.getSource().getUnsidedLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null && world instanceof ServerLevel _servLevel)
										entity = FakePlayerFactory.getMinecraft(_servLevel);
									Direction direction = Direction.DOWN;
									if (entity != null)
										direction = entity.getDirection();

									ExplodeTNTProcedure.execute(world, arguments);
									return 0;
								})).then(Commands.literal("block").executes(arguments -> {
									Level world = arguments.getSource().getUnsidedLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null && world instanceof ServerLevel _servLevel)
										entity = FakePlayerFactory.getMinecraft(_servLevel);
									Direction direction = Direction.DOWN;
									if (entity != null)
										direction = entity.getDirection();

									ExplodeBlockProcedure.execute(world, arguments);
									return 0;
								}))))))
						.then(Commands.literal("save_world").then(Commands.argument("range", DoubleArgumentType.doubleArg(0)).then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							SaveProcedure.execute(world, arguments, entity);
							return 0;
						})))).then(Commands.literal("get_response").then(Commands.argument("url", StringArgumentType.string()).then(Commands.literal("GET").executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							GetRequestProcedure.execute(world, arguments);
							return 0;
						})).then(Commands.literal("POST").then(Commands.argument("json", StringArgumentType.string()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							HaveJSONBodyPostProcedure.execute(world, arguments);
							return 0;
						})).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							PostProcedure.execute(world, arguments);
							return 0;
						})))))
				.then(Commands.literal("event").then(Commands.literal("progress").then(Commands.literal("add").then(Commands.argument("percent", DoubleArgumentType.doubleArg()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetpercentProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("set").then(Commands.argument("percent", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetpercentProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("reset").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					ResetpercentProcedure.execute(world);
					return 0;
				})).then(Commands.literal("query").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					PercentProcedure.execute(world, arguments);
					return 0;
				})).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					PercentProcedure.execute(world, arguments);
					return 0;
				})).then(Commands.literal("random").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					StartEventProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("specified").then(Commands.argument("event", StringArgumentType.string()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					RunEventProcedure.execute(world, x, y, z, arguments, entity);
					return 0;
				})))).then(Commands.literal("entity").then(Commands.literal("kill").then(Commands.argument("entity", EntityArgument.entities()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					ForceKillProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("push")
						.then(Commands.argument("entity", EntityArgument.entities())
								.then(Commands.argument("x", DoubleArgumentType.doubleArg()).then(Commands.argument("y", DoubleArgumentType.doubleArg()).then(Commands.argument("z", DoubleArgumentType.doubleArg()))))))
						.then(Commands.literal("summon").then(Commands.argument("pos", BlockPosArgument.blockPos()).then(Commands.literal("clone").then(Commands.argument("entity", EntityArgument.entity()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							CloneEntityProcedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("lightning_bolt").then(Commands.argument("visualonly", BoolArgumentType.bool()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							SummonProcedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("item").then(Commands.argument("item", ItemArgument.item(event.getBuildContext()))
								.then(Commands.argument("pickupdelay", DoubleArgumentType.doubleArg(0)).then(Commands.argument("limitedlifetime", BoolArgumentType.bool()).executes(arguments -> {
									Level world = arguments.getSource().getUnsidedLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null && world instanceof ServerLevel _servLevel)
										entity = FakePlayerFactory.getMinecraft(_servLevel);
									Direction direction = Direction.DOWN;
									if (entity != null)
										direction = entity.getDirection();

									SummonItemProcedure.execute(world, arguments);
									return 0;
								})))))))
						.then(Commands.literal("cross").then(Commands.argument("cross", BlockStateArgument.block(event.getBuildContext())).then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							CommandcrossProcedure.execute(world, arguments);
							return 0;
						})).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							CommandPlaceProcedure.execute(world, x, y, z, arguments);
							return 0;
						}))).then(Commands.literal("another_self").then(Commands.argument("self", EntityArgument.entity()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							SpawnSelfProcedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("discard").then(Commands.argument("todiscard", EntityArgument.entities()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							ToDiscardProcedure.execute(arguments);
							return 0;
						}))).then(Commands.literal("setHealth").then(Commands.argument("entity", EntityArgument.entities()).then(Commands.argument("health", DoubleArgumentType.doubleArg()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							SetHealthProcedure.execute(arguments);
							return 0;
						})))))
				.then(Commands.literal("surface").then(Commands.literal("query").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SfProcedure.execute(world, arguments);
					return 0;
				})).then(Commands.literal("set").then(Commands.argument("surface", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetsurfaceProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("add").then(Commands.argument("surface", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					AddsurfaceProcedure.execute(world, arguments);
					return 0;
				})))).then(Commands.literal("look_player").then(Commands.argument("look", BoolArgumentType.bool()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					LookatplayerProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("player").then(Commands.literal("exist").then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					ExistplayerProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.literal("online").then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					OnlineProcedure.execute(arguments);
					return 0;
				}))).then(Commands.literal("kick").then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("reason", StringArgumentType.string()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					CommandkickProcedure.execute(arguments);
					return 0;
				})).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					NoreasonkickProcedure.execute(arguments);
					return 0;
				}))).then(Commands.literal("ban").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					BanplayerProcedure.execute(world);
					return 0;
				}))).then(Commands.literal("dangerous").then(Commands.literal("crash").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					YoujustlosthegameProcedure.execute();
					return 0;
				})).then(Commands.literal("username").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					UsernameProcedure.execute(world);
					return 0;
				})).then(Commands.literal("OOM").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					MemoryDeathProcedure.execute();
					return 0;
				})).then(Commands.literal("JVMcrash").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JVMCrashProcedure.execute();
					return 0;
				})).then(Commands.literal("window").then(Commands.literal("alert").then(Commands.argument("message", StringArgumentType.string()).then(Commands.argument("title", StringArgumentType.string()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					AlertProcedure.execute(arguments);
					return 0;
				})))).then(Commands.literal("minimize").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					MinimizeWindowProcedure.execute();
					return 0;
				})).then(Commands.literal("fullscreen").then(Commands.argument("isexit", BoolArgumentType.bool()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					FullscreenProcedure.execute(arguments);
					return 0;
				})).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					OnlytooglefullscreenProcedure.execute();
					return 0;
				})).then(Commands.literal("handle").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					HandleProcedure.execute(arguments);
					return 0;
				})).then(Commands.literal("set_title").then(Commands.argument("title", StringArgumentType.string()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetwindowtitleProcedure.execute(arguments);
					return 0;
				}))))));
	}
}
