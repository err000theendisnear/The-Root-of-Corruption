package i.see.you.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import i.see.you.init.TheRootOfCorruptionModItems;
import i.see.you.init.TheRootOfCorruptionModBlocks;

@EventBusSubscriber
public class AscensionToLaughProcedure {
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
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheRootOfCorruptionModBlocks.ERR_NULL.get()) {
			if (entity instanceof ItemEntity && (world.getBlockState(BlockPos.containing(x, y, z))).getFluidState().isSource()) {
				if ((entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == TheRootOfCorruptionModItems.ITEM_IS_MISSING_ID.get()) {
					DiscardProcedure.execute(entity);
					if (Math.random() < 0.2) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheRootOfCorruptionModItems.FAKE_LAUGH.get()));
							entityToSpawn.setPickUpDelay(10);
							entityToSpawn.setUnlimitedLifetime();
							_level.addFreshEntity(entityToSpawn);
						}
					} else {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheRootOfCorruptionModBlocks.TEXTURELESS.get()));
							entityToSpawn.setPickUpDelay(10);
							entityToSpawn.setUnlimitedLifetime();
							_level.addFreshEntity(entityToSpawn);
						}
					}
				} else if ((entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Items.ELYTRA) {
					DiscardProcedure.execute(entity);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheRootOfCorruptionModItems.FLY.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				} else if ((entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Blocks.AMETHYST_BLOCK.asItem()) {
					DiscardProcedure.execute(entity);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheRootOfCorruptionModItems.ITEM_IS_MISSING_ID.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				} else if ((entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Blocks.NETHERITE_BLOCK.asItem()) {
					DiscardProcedure.execute(entity);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheRootOfCorruptionModBlocks.INITIALIZEDNETHERREACTOR.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				} else if ((entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Blocks.SCULK.asItem()) {
					DiscardProcedure.execute(entity);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheRootOfCorruptionModBlocks.MISSINGNO.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				} else if ((entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Items.NETHER_STAR) {
					DiscardProcedure.execute(entity);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheRootOfCorruptionModBlocks.CORRUPTIONBEDROCK.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				} else if ((entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Blocks.SCULK_CATALYST.asItem()) {
					DiscardProcedure.execute(entity);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheRootOfCorruptionModBlocks.EXECUTEROOT.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				} else if ((entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == TheRootOfCorruptionModItems.THE_BROKEN_MEMORY.get()) {
					DiscardProcedure.execute(entity);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheRootOfCorruptionModBlocks.CORRUPTION_ROOT.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				} else if ((entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Blocks.DIAMOND_BLOCK.asItem()) {
					DiscardProcedure.execute(entity);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.BEDROCK));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				} else if ((entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Blocks.CRYING_OBSIDIAN.asItem()) {
					DiscardProcedure.execute(entity);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheRootOfCorruptionModBlocks.GLOWINGOBSIDIAN.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else {
				if (entity instanceof LivingEntity) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeAllEffects();
					HorrorProcedure.execute(entity);
					entity.setAirSupply(0);
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getFluidState().isSource()) {
						entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("the_root_of_corruption:null_pointer_damage")))), 7);
					} else {
						entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("the_root_of_corruption:null_pointer_damage")))), 4);
					}
				}
			}
		}
	}
}
