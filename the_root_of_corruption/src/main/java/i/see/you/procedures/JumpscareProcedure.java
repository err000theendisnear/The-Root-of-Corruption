package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.TheRootOfCorruptionMod;

public class JumpscareProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		TheRootOfCorruptionMod.LOGGER.info("Event : Jumpscare");
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:jumpscare")), SoundSource.PLAYERS, 100, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:jumpscare")), SoundSource.PLAYERS, 100, 1, false);
			}
		}
		TheRootOfCorruptionModVariables.MapVariables.get(world).j = true;
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		TheRootOfCorruptionMod.queueServerWork(20, () -> {
			TheRootOfCorruptionModVariables.MapVariables.get(world).j = false;
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		});
	}
}
