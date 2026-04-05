package i.see.you.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

import i.see.you.init.TheRootOfCorruptionModItems;

@EventBusSubscriber
public class ToLaughProcedure {
	@SubscribeEvent
	public static void onGemDropped(ItemTossEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(), event.getEntity().getItem());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, world, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == TheRootOfCorruptionModItems.FAKE_LAUGH.get()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == TheRootOfCorruptionModItems.FAKE_LAUGH.get()) {
						DiscardProcedure.execute(entity);
						break;
					}
				}
			}
			if (Math.random() < 0.1) {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
					entityToSpawn.setVisualOnly(true);
					_level.addFreshEntity(entityToSpawn);
				}
				world.setBlock(BlockPos.containing(x, y, z), Blocks.CAVE_AIR.defaultBlockState(), 3);
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(TheRootOfCorruptionModItems.LAUGH.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else {
				TerrorProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
