
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import i.see.you.entity.YourjavaisdieEntity;
import i.see.you.entity.YourjavaisdieChaseEntity;
import i.see.you.entity.WatcherEntity;
import i.see.you.entity.UndefinedleftthegameEntity;
import i.see.you.entity.UndefinedOnSurfaceEntity;
import i.see.you.entity.UndefinedBossEntity;
import i.see.you.entity.UndefindstareEntity;
import i.see.you.entity.UndefindchaseEntity;
import i.see.you.entity.TamedBase0Entity;
import i.see.you.entity.SteveEntity;
import i.see.you.entity.SoulEntity;
import i.see.you.entity.RandomCrossEntity;
import i.see.you.entity.MinecraftRootEntity;
import i.see.you.entity.LostMemoryEntity;
import i.see.you.entity.InvalidCreeperEntity;
import i.see.you.entity.InvadeCrashreportEntity;
import i.see.you.entity.GlitchCodeEntity;
import i.see.you.entity.GameCrashEntity;
import i.see.you.entity.ForgottenPlayerEntity;
import i.see.you.entity.ErrEntity;
import i.see.you.entity.EntitySpawnerEntity;
import i.see.you.entity.CustomDeathWatchEntity;
import i.see.you.entity.CustomDeathEntity;
import i.see.you.entity.ClearbombEntity;
import i.see.you.entity.BrokenErrEntity;
import i.see.you.entity.BedrockStalkerEntity;
import i.see.you.entity.Base0Entity;
import i.see.you.TheRootOfCorruptionMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TheRootOfCorruptionModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, TheRootOfCorruptionMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<UndefindchaseEntity>> UNDEFINDCHASE = register("undefindchase",
			EntityType.Builder.<UndefindchaseEntity>of(UndefindchaseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(999).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<UndefindstareEntity>> UNDEFINDSTARE = register("undefindstare",
			EntityType.Builder.<UndefindstareEntity>of(UndefindstareEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<YourjavaisdieEntity>> YOURJAVAISDIE = register("yourjavaisdie",
			EntityType.Builder.<YourjavaisdieEntity>of(YourjavaisdieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(666).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<YourjavaisdieChaseEntity>> YOURJAVAISDIE_CHASE = register("yourjavaisdie_chase",
			EntityType.Builder.<YourjavaisdieChaseEntity>of(YourjavaisdieChaseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<EntitySpawnerEntity>> ENTITY_SPAWNER = register("entity_spawner",
			EntityType.Builder.<EntitySpawnerEntity>of(EntitySpawnerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BedrockStalkerEntity>> BEDROCK_STALKER = register("bedrock_stalker",
			EntityType.Builder.<BedrockStalkerEntity>of(BedrockStalkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<UndefinedOnSurfaceEntity>> UNDEFINED_ON_SURFACE = register("undefined_on_surface",
			EntityType.Builder.<UndefinedOnSurfaceEntity>of(UndefinedOnSurfaceEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(514).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<UndefinedleftthegameEntity>> UNDEFINEDLEFTTHEGAME = register("undefinedleftthegame",
			EntityType.Builder.<UndefinedleftthegameEntity>of(UndefinedleftthegameEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<RandomCrossEntity>> RANDOM_CROSS = register("random_cross",
			EntityType.Builder.<RandomCrossEntity>of(RandomCrossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ErrEntity>> ERR = register("err",
			EntityType.Builder.<ErrEntity>of(ErrEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ForgottenPlayerEntity>> FORGOTTEN_PLAYER = register("forgotten_player",
			EntityType.Builder.<ForgottenPlayerEntity>of(ForgottenPlayerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(250).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GlitchCodeEntity>> GLITCH_CODE = register("glitch_code",
			EntityType.Builder.<GlitchCodeEntity>of(GlitchCodeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BrokenErrEntity>> BROKEN_ERR = register("broken_err",
			EntityType.Builder.<BrokenErrEntity>of(BrokenErrEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LostMemoryEntity>> LOST_MEMORY = register("lost_memory",
			EntityType.Builder.<LostMemoryEntity>of(LostMemoryEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(514).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<Base0Entity>> BASE_0 = register("base_0",
			EntityType.Builder.<Base0Entity>of(Base0Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(514).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SteveEntity>> STEVE = register("steve",
			EntityType.Builder.<SteveEntity>of(SteveEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<WatcherEntity>> WATCHER = register("watcher",
			EntityType.Builder.<WatcherEntity>of(WatcherEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(5f, 7f));
	public static final DeferredHolder<EntityType<?>, EntityType<InvalidCreeperEntity>> INVALID_CREEPER = register("invalid_creeper",
			EntityType.Builder.<InvalidCreeperEntity>of(InvalidCreeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(640).setUpdateInterval(3).fireImmune().sized(0.6f, 1.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<InvadeCrashreportEntity>> INVADE_CRASHREPORT = register("invade_crashreport",
			EntityType.Builder.<InvadeCrashreportEntity>of(InvadeCrashreportEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(640).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<UndefinedBossEntity>> UNDEFINED_BOSS = register("undefined_boss",
			EntityType.Builder.<UndefinedBossEntity>of(UndefinedBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(640).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<TamedBase0Entity>> TAMED_BASE_0 = register("tamed_base_0",
			EntityType.Builder.<TamedBase0Entity>of(TamedBase0Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(514).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MinecraftRootEntity>> MINECRAFT_ROOT = register("minecraft_root",
			EntityType.Builder.<MinecraftRootEntity>of(MinecraftRootEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(640).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ClearbombEntity>> CLEARBOMB = register("clearbomb",
			EntityType.Builder.<ClearbombEntity>of(ClearbombEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CustomDeathEntity>> CUSTOM_DEATH = register("custom_death",
			EntityType.Builder.<CustomDeathEntity>of(CustomDeathEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(640).setUpdateInterval(3).fireImmune().sized(0.9f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<CustomDeathWatchEntity>> CUSTOM_DEATH_WATCH = register("custom_death_watch",
			EntityType.Builder.<CustomDeathWatchEntity>of(CustomDeathWatchEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SoulEntity>> SOUL = register("soul",
			EntityType.Builder.<SoulEntity>of(SoulEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(640).setUpdateInterval(3).fireImmune().sized(0.6f, 1.95f));
	public static final DeferredHolder<EntityType<?>, EntityType<GameCrashEntity>> GAME_CRASH = register("game_crash",
			EntityType.Builder.<GameCrashEntity>of(GameCrashEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		UndefindchaseEntity.init(event);
		UndefindstareEntity.init(event);
		YourjavaisdieEntity.init(event);
		YourjavaisdieChaseEntity.init(event);
		EntitySpawnerEntity.init(event);
		BedrockStalkerEntity.init(event);
		UndefinedOnSurfaceEntity.init(event);
		UndefinedleftthegameEntity.init(event);
		RandomCrossEntity.init(event);
		ForgottenPlayerEntity.init(event);
		GlitchCodeEntity.init(event);
		LostMemoryEntity.init(event);
		Base0Entity.init(event);
		SteveEntity.init(event);
		WatcherEntity.init(event);
		InvalidCreeperEntity.init(event);
		InvadeCrashreportEntity.init(event);
		UndefinedBossEntity.init(event);
		TamedBase0Entity.init(event);
		MinecraftRootEntity.init(event);
		CustomDeathEntity.init(event);
		CustomDeathWatchEntity.init(event);
		SoulEntity.init(event);
		GameCrashEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(UNDEFINDCHASE.get(), UndefindchaseEntity.createAttributes().build());
		event.put(UNDEFINDSTARE.get(), UndefindstareEntity.createAttributes().build());
		event.put(YOURJAVAISDIE.get(), YourjavaisdieEntity.createAttributes().build());
		event.put(YOURJAVAISDIE_CHASE.get(), YourjavaisdieChaseEntity.createAttributes().build());
		event.put(ENTITY_SPAWNER.get(), EntitySpawnerEntity.createAttributes().build());
		event.put(BEDROCK_STALKER.get(), BedrockStalkerEntity.createAttributes().build());
		event.put(UNDEFINED_ON_SURFACE.get(), UndefinedOnSurfaceEntity.createAttributes().build());
		event.put(UNDEFINEDLEFTTHEGAME.get(), UndefinedleftthegameEntity.createAttributes().build());
		event.put(RANDOM_CROSS.get(), RandomCrossEntity.createAttributes().build());
		event.put(FORGOTTEN_PLAYER.get(), ForgottenPlayerEntity.createAttributes().build());
		event.put(GLITCH_CODE.get(), GlitchCodeEntity.createAttributes().build());
		event.put(LOST_MEMORY.get(), LostMemoryEntity.createAttributes().build());
		event.put(BASE_0.get(), Base0Entity.createAttributes().build());
		event.put(STEVE.get(), SteveEntity.createAttributes().build());
		event.put(WATCHER.get(), WatcherEntity.createAttributes().build());
		event.put(INVALID_CREEPER.get(), InvalidCreeperEntity.createAttributes().build());
		event.put(INVADE_CRASHREPORT.get(), InvadeCrashreportEntity.createAttributes().build());
		event.put(UNDEFINED_BOSS.get(), UndefinedBossEntity.createAttributes().build());
		event.put(TAMED_BASE_0.get(), TamedBase0Entity.createAttributes().build());
		event.put(MINECRAFT_ROOT.get(), MinecraftRootEntity.createAttributes().build());
		event.put(CUSTOM_DEATH.get(), CustomDeathEntity.createAttributes().build());
		event.put(CUSTOM_DEATH_WATCH.get(), CustomDeathWatchEntity.createAttributes().build());
		event.put(SOUL.get(), SoulEntity.createAttributes().build());
		event.put(GAME_CRASH.get(), GameCrashEntity.createAttributes().build());
	}
}
