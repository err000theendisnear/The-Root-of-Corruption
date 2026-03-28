
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import i.see.you.block.VoidAlterBlock;
import i.see.you.block.ThisIsAllTheblockFaultBlock;
import i.see.you.block.TexturelessBlock;
import i.see.you.block.RotInHellBlock;
import i.see.you.block.OPCommandBlockBlock;
import i.see.you.block.NetherreactorBlock;
import i.see.you.block.MissingnoBlock;
import i.see.you.block.InitializednetherreactorBlock;
import i.see.you.block.GlowingobsidianBlock;
import i.see.you.block.FinishedNetherreactorBlock;
import i.see.you.block.FightGenBlock;
import i.see.you.block.ExecuterootBlock;
import i.see.you.block.ErrNullBlock;
import i.see.you.block.CorruptionbedrockBlock;
import i.see.you.block.CorruptionRootBlock;
import i.see.you.TheRootOfCorruptionMod;

public class TheRootOfCorruptionModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(TheRootOfCorruptionMod.MODID);
	public static final DeferredBlock<Block> CORRUPTIONBEDROCK = REGISTRY.register("corruptionbedrock", CorruptionbedrockBlock::new);
	public static final DeferredBlock<Block> EXECUTEROOT = REGISTRY.register("executeroot", ExecuterootBlock::new);
	public static final DeferredBlock<Block> TEXTURELESS = REGISTRY.register("textureless", TexturelessBlock::new);
	public static final DeferredBlock<Block> ERR_NULL = REGISTRY.register("err_null", ErrNullBlock::new);
	public static final DeferredBlock<Block> GLOWINGOBSIDIAN = REGISTRY.register("glowingobsidian", GlowingobsidianBlock::new);
	public static final DeferredBlock<Block> NETHERREACTOR = REGISTRY.register("netherreactor", NetherreactorBlock::new);
	public static final DeferredBlock<Block> INITIALIZEDNETHERREACTOR = REGISTRY.register("initializednetherreactor", InitializednetherreactorBlock::new);
	public static final DeferredBlock<Block> FINISHED_NETHERREACTOR = REGISTRY.register("finished_netherreactor", FinishedNetherreactorBlock::new);
	public static final DeferredBlock<Block> MISSINGNO = REGISTRY.register("missingno", MissingnoBlock::new);
	public static final DeferredBlock<Block> THIS_IS_ALL_THEBLOCK_FAULT = REGISTRY.register("this_is_all_theblock_fault", ThisIsAllTheblockFaultBlock::new);
	public static final DeferredBlock<Block> FIGHT_GEN = REGISTRY.register("fight_gen", FightGenBlock::new);
	public static final DeferredBlock<Block> VOID_ALTER = REGISTRY.register("void_alter", VoidAlterBlock::new);
	public static final DeferredBlock<Block> ROT_IN_HELL = REGISTRY.register("rot_in_hell", RotInHellBlock::new);
	public static final DeferredBlock<Block> CORRUPTION_ROOT = REGISTRY.register("corruption_root", CorruptionRootBlock::new);
	public static final DeferredBlock<Block> OP_COMMAND_BLOCK = REGISTRY.register("op_command_block", OPCommandBlockBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
