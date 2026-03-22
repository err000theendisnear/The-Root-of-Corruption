
package i.see.you.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class MissingnoBlock extends Block {
	public MissingnoBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave"))))
				.strength(-1, 3600000));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
