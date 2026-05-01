
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import i.see.you.TheRootOfCorruptionMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TheRootOfCorruptionModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheRootOfCorruptionMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> THE_CORRUPTION_ROOT = REGISTRY.register("the_corruption_root",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.the_root_of_corruption.the_corruption_root")).icon(() -> new ItemStack(TheRootOfCorruptionModBlocks.CORRUPTION_ROOT.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TheRootOfCorruptionModBlocks.CORRUPTIONBEDROCK.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.EXECUTEROOT.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.TEXTURELESS.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.GLOWINGOBSIDIAN.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.NETHERREACTOR.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.INITIALIZEDNETHERREACTOR.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.FINISHED_NETHERREACTOR.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.ROT_IN_HELL.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.MISSINGNO.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.ADMINISTRATOR.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.FIGHT_GEN.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.THIS_IS_ALL_THEBLOCK_FAULT.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.CORRUPTION_ROOT.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.VOID_ALTER.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.ERRUNDEFINED.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.BLOCK_IS_WATCHING_YOU.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.THE_WORLD_IS_DYING.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.LOCKED_CHEST.get().asItem());
				tabData.accept(TheRootOfCorruptionModBlocks.HEART_LESS.get().asItem());
				tabData.accept(TheRootOfCorruptionModItems.ITEM_IS_MISSING_ID.get());
				tabData.accept(TheRootOfCorruptionModItems.NULLNULLNULL.get());
				tabData.accept(TheRootOfCorruptionModItems.SERVER.get());
				tabData.accept(TheRootOfCorruptionModItems.LAUGH.get());
				tabData.accept(TheRootOfCorruptionModItems.FAKE_LAUGH.get());
				tabData.accept(TheRootOfCorruptionModItems.NOTEXTURE_HELMET.get());
				tabData.accept(TheRootOfCorruptionModItems.NOTEXTURE_CHESTPLATE.get());
				tabData.accept(TheRootOfCorruptionModItems.NOTEXTURE_LEGGINGS.get());
				tabData.accept(TheRootOfCorruptionModItems.NOTEXTURE_BOOTS.get());
				tabData.accept(TheRootOfCorruptionModItems.MISSING_ARMOR_HELMET.get());
				tabData.accept(TheRootOfCorruptionModItems.MISSING_ARMOR_CHESTPLATE.get());
				tabData.accept(TheRootOfCorruptionModItems.MISSING_ARMOR_LEGGINGS.get());
				tabData.accept(TheRootOfCorruptionModItems.MISSING_ARMOR_BOOTS.get());
				tabData.accept(TheRootOfCorruptionModItems.UNDEFINED_HEART.get());
				tabData.accept(TheRootOfCorruptionModItems.SAVE_THE_WORLD.get());
				tabData.accept(TheRootOfCorruptionModItems.THE_BROKEN_MEMORY.get());
				tabData.accept(TheRootOfCorruptionModItems.MISSING_SWORD.get());
				tabData.accept(TheRootOfCorruptionModItems.NOTEXTURE_TOOL.get());
				tabData.accept(TheRootOfCorruptionModItems.ARTIFACT.get());
				tabData.accept(TheRootOfCorruptionModItems.FLY.get());
				tabData.accept(TheRootOfCorruptionModItems.DEBUG_TOOL.get());
				tabData.accept(TheRootOfCorruptionModItems.HOPE.get());
				tabData.accept(TheRootOfCorruptionModItems.DAY_NEGATIVE_ONE_BUCKET.get());
				tabData.accept(TheRootOfCorruptionModItems.ERR_NULL_BUCKET.get());
				tabData.accept(TheRootOfCorruptionModItems.TO_OVER_WORLD.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
			if (tabData.hasPermissions()) {
				tabData.accept(TheRootOfCorruptionModBlocks.OP_COMMAND_BLOCK.get().asItem());
			}
		}
	}
}
