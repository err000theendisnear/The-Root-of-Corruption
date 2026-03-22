
package i.see.you.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import i.see.you.procedures.BecomefinishedProcedure;

public class InitializednetherreactorBlock extends Block {
	public InitializednetherreactorBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(3f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		BecomefinishedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
