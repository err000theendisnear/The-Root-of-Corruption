package i.see.you.mixins;

import net.minecraft.client.sounds.MusicManager;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import net.minecraft.core.registries.BuiltInRegistries;

@OnlyIn(Dist.CLIENT)
@Mixin(MusicManager.class)
public class MusicManagerMixin {
    @Redirect(
            method = "tick",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sounds/MusicManager;startPlaying(Lnet/minecraft/sounds/Music;)V")
    )
    private void redirectStartPlaying(MusicManager instance, Music originalMusic) {
        if (originalMusic == null) {
            System.err.println("Unexpected null Music in startPlaying!");
            new NullPointerException().printStackTrace();
            return;
        }
        Music musicToPlay = originalMusic;
        if (isMainMenuMusic(originalMusic)) {
            musicToPlay = createCustomMenuMusic(originalMusic);
        }
        instance.startPlaying(musicToPlay);
    }
    private boolean isMainMenuMusic(Music music) {
        return music.getEvent().unwrapKey()
                .map(key -> key.location().equals(ResourceLocation.parse("minecraft:music.menu")))
                .orElse(false);
    }
    private Music createCustomMenuMusic(Music original) {
        Holder<SoundEvent> customHolder = getCustomMenuMusicHolder();
        return new Music(
                customHolder,
                original.getMinDelay(),
                original.getMaxDelay(),
                original.replaceCurrentMusic()
        );
    }
    private Holder<SoundEvent> getCustomMenuMusicHolder() {
        SoundEvent soundEvent = BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:die"));
        if (soundEvent == null) {
            System.err.println("SoundEvent is null! Falling back to menu music.");
            return SoundEvents.MUSIC_MENU;
        }
        return BuiltInRegistries.SOUND_EVENT.wrapAsHolder(soundEvent);
    }
}