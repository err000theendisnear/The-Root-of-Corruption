
package i.see.you.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import i.see.you.procedures.StartCorruptionProcedure;
import i.see.you.procedures.CorruptProcedure;

public class CorruptionRootBlock extends Block {
	public CorruptionRootBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:the_end_is_undefined")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:exception_hunt")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:the_end_is_undefined")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:failed")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:goaway"))))
				.strength(-1, 3600000).randomTicks());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		CorruptProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState blockstate, Level world, BlockPos pos, RandomSource random) {
		super.animateTick(blockstate, world, pos, random);
		Player entity = Minecraft.getInstance().player;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		StartCorruptionProcedure.execute(world, x, y, z, blockstate);
	}
}
