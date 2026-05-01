
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

public abstract class ErrNullFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> TheRootOfCorruptionModFluidTypes.ERR_NULL_TYPE.get(), () -> TheRootOfCorruptionModFluids.ERR_NULL.get(),
			() -> TheRootOfCorruptionModFluids.FLOWING_ERR_NULL.get()).explosionResistance(100f).slopeFindDistance(1).bucket(() -> TheRootOfCorruptionModItems.ERR_NULL_BUCKET.get())
			.block(() -> (LiquidBlock) TheRootOfCorruptionModBlocks.ERR_NULL.get());

	private ErrNullFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (TheRootOfCorruptionModParticleTypes.ERROR.get());
	}

	public static class Source extends ErrNullFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends ErrNullFluid {
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
