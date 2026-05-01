
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import i.see.you.block.entity.OPCommandBlockBlockEntity;
import i.see.you.block.entity.LockedChestBlockEntity;
import i.see.you.TheRootOfCorruptionMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TheRootOfCorruptionModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TheRootOfCorruptionMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> OP_COMMAND_BLOCK = register("op_command_block", TheRootOfCorruptionModBlocks.OP_COMMAND_BLOCK, OPCommandBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> LOCKED_CHEST = register("locked_chest", TheRootOfCorruptionModBlocks.LOCKED_CHEST, LockedChestBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, OP_COMMAND_BLOCK.get(), (blockEntity, side) -> ((OPCommandBlockBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LOCKED_CHEST.get(), (blockEntity, side) -> ((LockedChestBlockEntity) blockEntity).getItemHandler());
	}
}
