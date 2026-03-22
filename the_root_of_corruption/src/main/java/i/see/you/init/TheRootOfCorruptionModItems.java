
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import i.see.you.item.UndefinedHeartItem;
import i.see.you.item.TheBrokenMemoryItem;
import i.see.you.item.SaveTheWorldItem;
import i.see.you.item.NotextureToolItem;
import i.see.you.item.MissingSwordItem;
import i.see.you.item.MissingArmorItem;
import i.see.you.item.LaughItem;
import i.see.you.item.ItemIsMissingIDItem;
import i.see.you.item.HopeItem;
import i.see.you.TheRootOfCorruptionMod;

public class TheRootOfCorruptionModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TheRootOfCorruptionMod.MODID);
	public static final DeferredItem<Item> CORRUPTIONBEDROCK = block(TheRootOfCorruptionModBlocks.CORRUPTIONBEDROCK);
	public static final DeferredItem<Item> EXECUTEROOT = block(TheRootOfCorruptionModBlocks.EXECUTEROOT);
	public static final DeferredItem<Item> TEXTURELESS = block(TheRootOfCorruptionModBlocks.TEXTURELESS);
	public static final DeferredItem<Item> GLOWINGOBSIDIAN = block(TheRootOfCorruptionModBlocks.GLOWINGOBSIDIAN);
	public static final DeferredItem<Item> NETHERREACTOR = block(TheRootOfCorruptionModBlocks.NETHERREACTOR);
	public static final DeferredItem<Item> INITIALIZEDNETHERREACTOR = block(TheRootOfCorruptionModBlocks.INITIALIZEDNETHERREACTOR);
	public static final DeferredItem<Item> FINISHED_NETHERREACTOR = block(TheRootOfCorruptionModBlocks.FINISHED_NETHERREACTOR);
	public static final DeferredItem<Item> MISSINGNO = block(TheRootOfCorruptionModBlocks.MISSINGNO);
	public static final DeferredItem<Item> ITEM_IS_MISSING_ID = REGISTRY.register("item_is_missing_id", ItemIsMissingIDItem::new);
	public static final DeferredItem<Item> HOPE = REGISTRY.register("hope", HopeItem::new);
	public static final DeferredItem<Item> THIS_IS_ALL_THEBLOCK_FAULT = block(TheRootOfCorruptionModBlocks.THIS_IS_ALL_THEBLOCK_FAULT);
	public static final DeferredItem<Item> FIGHT_GEN = block(TheRootOfCorruptionModBlocks.FIGHT_GEN);
	public static final DeferredItem<Item> LAUGH = REGISTRY.register("laugh", LaughItem::new);
	public static final DeferredItem<Item> THE_BROKEN_MEMORY = REGISTRY.register("the_broken_memory", TheBrokenMemoryItem::new);
	public static final DeferredItem<Item> VOID_ALTER = block(TheRootOfCorruptionModBlocks.VOID_ALTER);
	public static final DeferredItem<Item> MISSING_ARMOR_HELMET = REGISTRY.register("missing_armor_helmet", MissingArmorItem.Helmet::new);
	public static final DeferredItem<Item> MISSING_ARMOR_CHESTPLATE = REGISTRY.register("missing_armor_chestplate", MissingArmorItem.Chestplate::new);
	public static final DeferredItem<Item> MISSING_ARMOR_LEGGINGS = REGISTRY.register("missing_armor_leggings", MissingArmorItem.Leggings::new);
	public static final DeferredItem<Item> MISSING_ARMOR_BOOTS = REGISTRY.register("missing_armor_boots", MissingArmorItem.Boots::new);
	public static final DeferredItem<Item> NOTEXTURE_TOOL = REGISTRY.register("notexture_tool", NotextureToolItem::new);
	public static final DeferredItem<Item> UNDEFINED_HEART = REGISTRY.register("undefined_heart", UndefinedHeartItem::new);
	public static final DeferredItem<Item> ROT_IN_HELL = block(TheRootOfCorruptionModBlocks.ROT_IN_HELL);
	public static final DeferredItem<Item> SAVE_THE_WORLD = REGISTRY.register("save_the_world", SaveTheWorldItem::new);
	public static final DeferredItem<Item> MISSING_SWORD = REGISTRY.register("missing_sword", MissingSwordItem::new);
	public static final DeferredItem<Item> CORRUPTION_ROOT = block(TheRootOfCorruptionModBlocks.CORRUPTION_ROOT);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
