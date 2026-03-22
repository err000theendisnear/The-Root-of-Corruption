
package i.see.you.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import i.see.you.procedures.RomoveblockProcedure;

public class TexturelessBlock extends Block {
	public TexturelessBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:error")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:error")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:error")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:error")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:error"))))
				.strength(500f, 10000000f).noCollission());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		RomoveblockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
