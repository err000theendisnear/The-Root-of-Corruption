package i.see.you.procedures;

import net.neoforged.neoforge.event.ServerChatEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

import i.see.you.init.TheRootOfCorruptionModEntities;
import i.see.you.TheRootOfCorruptionMod;

@EventBusSubscriber
public class AdministratorChatProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(), event.getRawText());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, String text) {
		execute(null, world, x, y, z, entity, text);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, String text) {
		if (entity == null || text == null)
			return;
		if (text.contains("help") || text.contains("what can i do") || text.contains("what should i do")) {
			TheRootOfCorruptionMod.queueServerWork(200, () -> {
				{
					Entity _ent = SpawnFakePlayerProcedure.execute(world, "@");
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("say " + "waiting to die."));
					}
				}
			});
		} else {
			if (text.contains("get out") || text.contains("go away")) {
				TheRootOfCorruptionMod.queueServerWork(100, () -> {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
						_level.addFreshEntity(entityToSpawn);
					}
					{
						Entity _ent = SpawnFakePlayerProcedure.execute(world, "@");
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("say " + "=)"));
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:goaway")), SoundSource.MUSIC, 10000, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:goaway")), SoundSource.MUSIC, 10000, 1, false);
						}
					}
				});
			} else if (text.contains("nothing_left")) {
				TheRootOfCorruptionMod.queueServerWork(100, () -> {
					{
						Entity _ent = SpawnFakePlayerProcedure.execute(world, "@");
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("say " + "corrupted in the moon."));
						}
					}
				});
			} else if (text.contains("corrupt")) {
				TheRootOfCorruptionMod.queueServerWork(100, () -> {
					{
						Entity _ent = SpawnFakePlayerProcedure.execute(world, "@");
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("say " + "that's \u00A7k\u53EF\u80FD\u5C31\u8FDEAI\u4E5F\u4E0D\u77E5\u9053\u5427"));
						}
					}
				});
			} else if (text.contains("\u533F\u540D\u738B\u516B") || text.contains("\u533F\u540Dtian")) {
				TheRootOfCorruptionMod.queueServerWork(150, () -> {
					{
						Entity _ent = SpawnFakePlayerProcedure.execute(world, "@");
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("say " + "\u539F\u6765\u4F60\u4E5F\u770B\u533F\u540Dtian\u7684\u89C6\u9891\uD83E\uDD2F"));
						}
					}
					TheRootOfCorruptionMod.queueServerWork(75, () -> {
						{
							Entity _ent = SpawnFakePlayerProcedure.execute(world, "@");
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("say " + "\u4E0D\u8FC7\u4ED6\u88AB\u5C0F\u7EA2\u4EBA\u6740\u4E86:("));
							}
						}
					});
				});
			} else if (text.contains("i love you")) {
				TheRootOfCorruptionMod.queueServerWork(123, () -> {
					{
						Entity _ent = SpawnFakePlayerProcedure.execute(world, "@");
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("say " + "import ???;"));
						}
					}
					TheRootOfCorruptionMod.queueServerWork(100, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:the_end_is_undefined")), SoundSource.MUSIC, 10000, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:the_end_is_undefined")), SoundSource.MUSIC, 10000, 1, false);
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.forceAddEffect(new MobEffectInstance(MobEffects.DARKNESS, 150, 255, false, false), entity);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.forceAddEffect(new MobEffectInstance(MobEffects.BLINDNESS, 150, 255, false, false), entity);
						world.getLevelData().setRaining(true);
					});
				});
			} else if (text.contains("can you see me")) {
				TheRootOfCorruptionMod.queueServerWork(135, () -> {
					{
						Entity _ent = SpawnFakePlayerProcedure.execute(world, "@");
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("say " + "yes."));
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.resonate")), SoundSource.MUSIC, 1000, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.resonate")), SoundSource.MUSIC, 1000, 1, false);
						}
					}
					TheRootOfCorruptionMod.queueServerWork(66, () -> {
						{
							Entity _ent = SpawnFakePlayerProcedure.execute(world, "@");
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("say " + "We can all see you."));
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheRootOfCorruptionModEntities.SMALL_BOMB.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					});
				});
			} else if (text.contains("bitch")) {
				TheRootOfCorruptionMod.queueServerWork(150, () -> {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheRootOfCorruptionModEntities.ERR.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				});
			}
		}
	}
}
