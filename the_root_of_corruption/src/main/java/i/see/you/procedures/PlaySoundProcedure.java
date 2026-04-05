package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import java.lang.Exception;

public class PlaySoundProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double pitch, double volume, String sound) {
		if (sound == null)
			return;
		try {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse(sound)), SoundSource.MASTER, (float) volume, (float) pitch);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse(sound)), SoundSource.MASTER, (float) volume, (float) pitch, false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
