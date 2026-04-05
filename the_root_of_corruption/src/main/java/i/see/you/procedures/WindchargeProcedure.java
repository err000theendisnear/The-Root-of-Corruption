package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.windcharge.WindCharge;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class WindchargeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide() && world instanceof Level level) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.death")), SoundSource.AMBIENT, 1000, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.death")), SoundSource.AMBIENT, 1000, 1, false);
				}
			}
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 3, 5); index0++) {
				WindCharge windCharge = new WindCharge(level, x, y + 1, z, new Vec3(0, -5, 0));
				level.addFreshEntity(windCharge);
			}
		}
	}
}
