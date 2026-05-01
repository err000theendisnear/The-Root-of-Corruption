package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import i.see.you.entity.YourjavaisdieChaseEntity;
import i.see.you.TheRootOfCorruptionMod;

@EventBusSubscriber
public class JavaChaseProcedure {
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
		if (entity instanceof YourjavaisdieChaseEntity) {
			new Object() {
				void timedLoop(int timedloopiterator, int timedlooptotal, int ticks) {
					if (!(entity == null) && !entity.isAlive() && ((entity instanceof LivingEntity _livEnt ? _livEnt.deathTime : 0) >= 20 || !(entity instanceof LivingEntity)) || !entity.isAlive()) {
						if (true) {
							return;
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:chase")), SoundSource.MASTER, 500, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:chase")), SoundSource.MASTER, 500, 1, false);
						}
					}
					final int tick2 = ticks;
					TheRootOfCorruptionMod.queueServerWork(tick2, () -> {
						if (timedlooptotal > timedloopiterator + 1) {
							timedLoop(timedloopiterator + 1, timedlooptotal, tick2);
						}
					});
				}
			}.timedLoop(0, 5, 500);
		}
	}
}
