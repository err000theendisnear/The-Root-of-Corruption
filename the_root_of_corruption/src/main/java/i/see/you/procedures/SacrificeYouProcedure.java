package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

import i.see.you.init.TheRootOfCorruptionModParticleTypes;
import i.see.you.init.TheRootOfCorruptionModItems;
import i.see.you.init.TheRootOfCorruptionModBlocks;

@EventBusSubscriber
public class SacrificeYouProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == TheRootOfCorruptionModItems.MISSING_SWORD.get()
							&& TheRootOfCorruptionModBlocks.NETHERREACTOR.get() == (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock()
							&& TheRootOfCorruptionModBlocks.MISSINGNO.get() == (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock()
							&& TheRootOfCorruptionModBlocks.ERRUNDEFINED.get() == (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock()
							&& TheRootOfCorruptionModBlocks.EXECUTEROOT.get() == (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock()
							&& TheRootOfCorruptionModBlocks.CORRUPTIONBEDROCK.get() == (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).getBlock()
							&& Blocks.NETHERITE_BLOCK == (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() && Blocks.DIAMOND_BLOCK == (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock()
							&& TheRootOfCorruptionModBlocks.INITIALIZEDNETHERREACTOR.get() == (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock()
							&& TheRootOfCorruptionModBlocks.FINISHED_NETHERREACTOR.get() == (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), 100);
						world.setBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), TheRootOfCorruptionModBlocks.LOCKED_CHEST.get().defaultBlockState(), 3);
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (TheRootOfCorruptionModParticleTypes.ERROR.get()), x, y, z, 15, 1, 1, 1, 0);
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (TheRootOfCorruptionModParticleTypes.THIS_IS_NOT_FAIR.get()), x, y, z, 15, 1, 1, 1, 0);
						break;
					}
				}
			}
		}
	}
}
