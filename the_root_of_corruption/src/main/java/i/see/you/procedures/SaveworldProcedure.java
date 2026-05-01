package i.see.you.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import java.util.Map;
import java.util.HashMap;

import i.see.you.init.TheRootOfCorruptionModItems;
import i.see.you.init.TheRootOfCorruptionModBlocks;
import i.see.you.TheRootOfCorruptionMod;

public class SaveworldProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double range) {
		if (entity == null)
			return;
		double xx = 0;
		double yy = 0;
		double zz = 0;
		BlockState replace = Blocks.AIR.defaultBlockState();
		Map<BlockState, BlockState> replaceMap = new HashMap<>();
		replaceMap.put(TheRootOfCorruptionModBlocks.CORRUPTIONBEDROCK.get().defaultBlockState(), Blocks.BEDROCK.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.DAY_NEGATIVE_ONE.get().defaultBlockState(), Blocks.LAVA.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.EXECUTEROOT.get().defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.MISSINGNO.get().defaultBlockState(), Blocks.AMETHYST_BLOCK.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.ERR_NULL.get().defaultBlockState(), Blocks.WATER.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.GLOWINGOBSIDIAN.get().defaultBlockState(), Blocks.CRYING_OBSIDIAN.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.NETHERREACTOR.get().defaultBlockState(), Blocks.IRON_BLOCK.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.FINISHED_NETHERREACTOR.get().defaultBlockState(), Blocks.IRON_BLOCK.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.INITIALIZEDNETHERREACTOR.get().defaultBlockState(), Blocks.IRON_BLOCK.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.CORRUPTION_ROOT.get().defaultBlockState(), Blocks.DIAMOND_BLOCK.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.HEART_LESS.get().defaultBlockState(), Blocks.WITHER_ROSE.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.BLOCK_IS_WATCHING_YOU.get().defaultBlockState(), Blocks.DARK_PRISMARINE.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.ERRUNDEFINED.get().defaultBlockState(), Blocks.EMERALD_BLOCK.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.ADMINISTRATOR.get().defaultBlockState(), Blocks.NETHERITE_BLOCK.defaultBlockState());
		replaceMap.put(TheRootOfCorruptionModBlocks.THE_WORLD_IS_DYING.get().defaultBlockState(), Blocks.GOLD_BLOCK.defaultBlockState());
		ClearAllGodProcedure.execute(world);
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheRootOfCorruptionModItems.HOPE.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TheRootOfCorruptionModItems.HOPE.get()
				|| (entity instanceof LivingEntity _entUseItem4 ? _entUseItem4.getUseItem() : ItemStack.EMPTY).getItem() == TheRootOfCorruptionModItems.HOPE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(TheRootOfCorruptionModItems.HOPE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(TheRootOfCorruptionModItems.ITEM_IS_MISSING_ID.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 64, _player.inventoryMenu.getCraftSlots());
		}
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
		RemoveHarmfulEffectProcedure.execute(entity);
		entity.setTicksFrozen(0);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 50000, 255));
		entity.clearFire();
		xx = x - range / 2;
		for (int index0 = 0; index0 < (int) range; index0++) {
			yy = y - range / 2;
			for (int index1 = 0; index1 < (int) range; index1++) {
				zz = z - range / 2;
				for (int index2 = 0; index2 < (int) range; index2++) {
					replace = (world.getBlockState(BlockPos.containing(xx, yy, zz)));
					if (replaceMap.containsKey(replace)) {
						world.setBlock(BlockPos.containing(xx, yy, zz), replaceMap.get(replace).getBlock().defaultBlockState(), 3);
					}
					zz = zz + 1;
				}
				yy = yy + 1;
			}
			xx = xx + 1;
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("=)"), true);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.PLAYERS, 100, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.PLAYERS, 100, 1, false);
			}
		}
		TheRootOfCorruptionMod.LOGGER.info("Clear Corruption");
		if (entity instanceof ServerPlayer _player) {
			AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("the_root_of_corruption:you_help_all_soul"));
			if (_adv != null) {
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
	}
}
