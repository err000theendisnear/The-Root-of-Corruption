
package i.see.you.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

import i.see.you.init.TheRootOfCorruptionModParticleTypes;
import i.see.you.init.TheRootOfCorruptionModItems;
import i.see.you.init.TheRootOfCorruptionModFluids;
import i.see.you.init.TheRootOfCorruptionModFluidTypes;
import i.see.you.init.TheRootOfCorruptionModBlocks;

public abstract class DayNegativeOneFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> TheRootOfCorruptionModFluidTypes.DAY_NEGATIVE_ONE_TYPE.get(), () -> TheRootOfCorruptionModFluids.DAY_NEGATIVE_ONE.get(),
			() -> TheRootOfCorruptionModFluids.FLOWING_DAY_NEGATIVE_ONE.get()).explosionResistance(100f).tickRate(20).slopeFindDistance(5).bucket(() -> TheRootOfCorruptionModItems.DAY_NEGATIVE_ONE_BUCKET.get())
			.block(() -> (LiquidBlock) TheRootOfCorruptionModBlocks.DAY_NEGATIVE_ONE.get());

	private DayNegativeOneFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (TheRootOfCorruptionModParticleTypes.THIS_IS_NOT_FAIR.get());
	}

	public static class Source extends DayNegativeOneFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends DayNegativeOneFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
