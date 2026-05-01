
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import i.see.you.fluid.types.ErrNullFluidType;
import i.see.you.fluid.types.DayNegativeOneFluidType;
import i.see.you.TheRootOfCorruptionMod;

public class TheRootOfCorruptionModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, TheRootOfCorruptionMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> ERR_NULL_TYPE = REGISTRY.register("err_null", () -> new ErrNullFluidType());
	public static final DeferredHolder<FluidType, FluidType> DAY_NEGATIVE_ONE_TYPE = REGISTRY.register("day_negative_one", () -> new DayNegativeOneFluidType());
}
