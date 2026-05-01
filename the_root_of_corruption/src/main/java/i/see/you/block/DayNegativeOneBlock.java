
package i.see.you.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

import i.see.you.init.TheRootOfCorruptionModFluids;

public class DayNegativeOneBlock extends LiquidBlock {
	public DayNegativeOneBlock() {
		super(TheRootOfCorruptionModFluids.DAY_NEGATIVE_ONE.get(), BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}
