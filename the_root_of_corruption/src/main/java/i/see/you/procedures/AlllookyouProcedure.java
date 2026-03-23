package i.see.you.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.configuration.ConfigConfiguration;

@EventBusSubscriber
public class AlllookyouProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xx = 0;
		double yy = 0;
		double zz = 0;
		double cave = 0;
		BlockState block = Blocks.AIR.defaultBlockState();
		xx = x - 8;
		for (int index0 = 0; index0 < 16; index0++) {
			yy = y - 8;
			for (int index1 = 0; index1 < 16; index1++) {
				zz = z - 8;
				for (int index2 = 0; index2 < 16; index2++) {
					block = (world.getBlockState(BlockPos.containing(xx, yy, zz)));
					if ((BuiltInRegistries.BLOCK.getKey(block.getBlock()).toString()).contains("stone") || (BuiltInRegistries.BLOCK.getKey(block.getBlock()).toString()).contains("rock")
							|| (BuiltInRegistries.BLOCK.getKey(block.getBlock()).toString()).contains("ore")) {
						cave = cave + 1;
					}
					zz = zz + 1;
				}
				yy = yy + 1;
			}
			xx = xx + 1;
		}
		if (!((entity.level().dimension()) == Level.OVERWORLD)) {
			TheRootOfCorruptionModVariables.MapVariables.get(world).on_surface = 0;
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		} else {
			if (world instanceof ServerLevel _level7 && _level7.isVillage(BlockPos.containing(x, y, z))) {
				TheRootOfCorruptionModVariables.MapVariables.get(world).on_surface = TheRootOfCorruptionModVariables.MapVariables.get(world).on_surface + 0.01;
				TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
			} else {
				if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 4 && y > 20 && cave < 2048) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK) {
						TheRootOfCorruptionModVariables.MapVariables.get(world).on_surface = TheRootOfCorruptionModVariables.MapVariables.get(world).on_surface + 0.02;
						TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
					} else {
						TheRootOfCorruptionModVariables.MapVariables.get(world).on_surface = TheRootOfCorruptionModVariables.MapVariables.get(world).on_surface + 0.01;
						TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
					}
				} else {
					TheRootOfCorruptionModVariables.MapVariables.get(world).on_surface = 0;
					TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
				}
			}
		}
		if (TheRootOfCorruptionModVariables.MapVariables.get(world).ban && ConfigConfiguration.BAN.get()) {
			KickplayerProcedure.execute(entity, "kick @s " + Component.translatable("multiplayer.disconnect.not_whitelisted").getString());
		}
		if (TheRootOfCorruptionModVariables.MapVariables.get(world).look_player) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator instanceof ServerPlayer || entityiterator instanceof Player)) {
						entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, (y + 1), z));
					}
				}
			}
		}
		if (Mth.nextInt(RandomSource.create(), 1, 1000000) == 1) {
			ExecuteEventProcedure.execute(world, x, y, z, entity);
		}
	}
}
