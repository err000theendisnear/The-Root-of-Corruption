package i.see.you.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class RideboatProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		if (entity instanceof Boat && entity.getPersistentData().getBoolean("Invulnerable")) {
			player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null);
			if (!(player == null)) {
				if (player instanceof Mob _entity)
					_entity.aiStep();
				entity.setOnGround(true);
				player.setOnGround(true);
				entity.fallDistance = 0;
				player.fallDistance = 0;
				for (Entity entityiterator : player.getIndirectPassengers()) {
					entityiterator.stopRiding();
				}
				entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
				player.stopRiding();
				player.startRiding(entity);
				player.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
				if (player instanceof Player _plr && _plr.isFallFlying()) {
					_plr.stopFallFlying();
				}
				if (player instanceof Player _plr16)
					_plr16.resetAttackStrengthTicker();
				if (player instanceof ServerPlayer _player)
					_player.setGameMode(GameType.SURVIVAL);
				if (player instanceof Player _player)
					_player.getFoodData().setSaturation(0);
				if (player instanceof Player _player)
					_player.getFoodData().setFoodLevel(0);
				if (player.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
					for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
						ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
						if (player instanceof Player _player)
							_player.getCooldowns().addCooldown(itemstackiterator.getItem(), 1000);
					}
				}
			} else {
				DiscardProcedure.execute(entity);
			}
		}
	}
}
