
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import i.see.you.TheRootOfCorruptionMod;

public class TheRootOfCorruptionModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, TheRootOfCorruptionMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ERROR = REGISTRY.register("error", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> THIS_IS_NOT_FAIR = REGISTRY.register("this_is_not_fair", () -> new SimpleParticleType(false));
}
