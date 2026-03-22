
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import i.see.you.fluid.ErrNullFluid;
import i.see.you.TheRootOfCorruptionMod;

public class TheRootOfCorruptionModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, TheRootOfCorruptionMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> ERR_NULL = REGISTRY.register("err_null", () -> new ErrNullFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ERR_NULL = REGISTRY.register("flowing_err_null", () -> new ErrNullFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(ERR_NULL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ERR_NULL.get(), RenderType.translucent());
		}
	}
}
