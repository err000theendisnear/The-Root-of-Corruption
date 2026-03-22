
package i.see.you.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import i.see.you.procedures.SummonbossProcedure;

public class RotInHellBlock extends Block {
	public RotInHellBlock() {
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

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		SummonbossProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}
}
