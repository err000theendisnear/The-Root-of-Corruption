
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import i.see.you.TheRootOfCorruptionMod;

public class TheRootOfCorruptionModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, TheRootOfCorruptionMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> NOISE = REGISTRY.register("noise", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "noise")));
	public static final DeferredHolder<SoundEvent, SoundEvent> JUMPSCARE = REGISTRY.register("jumpscare", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "jumpscare")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CAVE = REGISTRY.register("cave", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "cave")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CHASE = REGISTRY.register("chase", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "chase")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ERROR = REGISTRY.register("error", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "error")));
	public static final DeferredHolder<SoundEvent, SoundEvent> VOID = REGISTRY.register("void", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "void")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GOAWAY = REGISTRY.register("goaway", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "goaway")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GLITCH = REGISTRY.register("glitch", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "glitch")));
	public static final DeferredHolder<SoundEvent, SoundEvent> THE_END_IS_UNDEFINED = REGISTRY.register("the_end_is_undefined",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "the_end_is_undefined")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DIE = REGISTRY.register("die", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "die")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HOPE = REGISTRY.register("hope", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "hope")));
	public static final DeferredHolder<SoundEvent, SoundEvent> NOTHING = REGISTRY.register("nothing", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "nothing")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WRONG_SOUND = REGISTRY.register("wrong_sound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "wrong_sound")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FAILED = REGISTRY.register("failed", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "failed")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HAL1 = REGISTRY.register("hal1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "hal1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HELLO = REGISTRY.register("hello", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "hello")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EXCEPTION_HUNT = REGISTRY.register("exception_hunt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "exception_hunt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ANONYMITY_TIAN_SOUND = REGISTRY.register("anonymity_tian_sound",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "anonymity_tian_sound")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CAVE_NOISE_LOUD = REGISTRY.register("cave_noise_loud", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "cave_noise_loud")));
}
