package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
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
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Comparator;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.init.TheRootOfCorruptionModEntities;
import i.see.you.init.TheRootOfCorruptionModBlocks;
import i.see.you.entity.UndefinedBossEntity;
import i.see.you.TheRootOfCorruptionMod;

public class SummonbossProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.setBlock(BlockPos.containing(x, y, z), TheRootOfCorruptionModBlocks.CORRUPTION_ROOT.get().defaultBlockState(), 3);
		if (world instanceof ServerLevel _level) {
			LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
			entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y + 1, z)));;
			_level.addFreshEntity(entityToSpawn);
		}
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("err"), false);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1000, 255));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 1000, 255));
		TheRootOfCorruptionMod.queueServerWork(200, () -> {
			{
				Entity _ent = SpawnFakePlayerProcedure.execute(world, "Undefined");
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "say err.");
				}
			}
		});
		TheRootOfCorruptionMod.queueServerWork(300, () -> {
			{
				Entity _ent = SpawnFakePlayerProcedure.execute(world, "Undefined");
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "say type.");
				}
			}
		});
		TheRootOfCorruptionMod.queueServerWork(400, () -> {
			{
				Entity _ent = SpawnFakePlayerProcedure.execute(world, "Undefined");
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "say undefined=");
				}
			}
		});
		TheRootOfCorruptionMod.queueServerWork(450, () -> {
			{
				Entity _ent = SpawnFakePlayerProcedure.execute(world, "Undefined");
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "say go_");
				}
			}
		});
		TheRootOfCorruptionMod.queueServerWork(550, () -> {
			{
				Entity _ent = SpawnFakePlayerProcedure.execute(world, "Undefined");
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "say away");
				}
			}
		});
		/*这个对话十分甚至九分的尴尬*/
		TheRootOfCorruptionMod.queueServerWork(600, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:the_end_is_undefined")), SoundSource.MASTER, 1000, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:the_end_is_undefined")), SoundSource.MASTER, 1000, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheRootOfCorruptionModEntities.UNDEFINED_BOSS.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		});
		TheRootOfCorruptionMod.queueServerWork(601, () -> {
			{
				TheRootOfCorruptionModVariables.PlayerVariables _vars = entity.getData(TheRootOfCorruptionModVariables.PLAYER_VARIABLES);
				_vars.undefined_uuid = ((Entity) world.getEntitiesOfClass(UndefinedBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getStringUUID();
				_vars.syncPlayerVariables(entity);
			}
		});
	}
}
