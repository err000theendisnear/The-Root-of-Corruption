package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import i.see.you.init.TheRootOfCorruptionModEntities;

@EventBusSubscriber
public class EntityspawnProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Mth.nextInt(RandomSource.create(), 0, 100) == 0 && entity instanceof LivingEntity) {
			entity.setCustomName(Component.literal("1"));
		} else if (Mth.nextInt(RandomSource.create(), 0, 100) == 0 && entity instanceof LivingEntity) {
			entity.setCustomName(Component.literal("err"));
		} else if (Mth.nextInt(RandomSource.create(), 0, 100) == 0 && entity instanceof LivingEntity) {
			entity.setCustomName(Component.literal("null"));
		} else if (Mth.nextInt(RandomSource.create(), 0, 100) == 0 && entity instanceof LivingEntity) {
			entity.setCustomName(Component.literal("0"));
		} else if (Mth.nextInt(RandomSource.create(), 0, 200) == 0 && entity instanceof LivingEntity) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheRootOfCorruptionModEntities.RANDOM_CROSS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.breath")), SoundSource.VOICE, 1000, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.breath")), SoundSource.VOICE, 1000, 1, false);
				}
			}
		} else if (Mth.nextInt(RandomSource.create(), 0, 100) == 0 && entity instanceof LivingEntity) {
			entity.setCustomName(Component.literal("hello"));
		}
		if (Mth.nextInt(RandomSource.create(), 0, 25000) == 0) {
			AnotherSelfProcedure.execute(world, x, y, z, entity);
		}
	}
}
