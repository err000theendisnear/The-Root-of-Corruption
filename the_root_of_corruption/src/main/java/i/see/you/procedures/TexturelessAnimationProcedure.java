package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import i.see.you.init.TheRootOfCorruptionModItems;
import i.see.you.TheRootOfCorruptionMod;

public class TexturelessAnimationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.MUSIC, 1000, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.MUSIC, 1000, 1, false);
			}
		}
		if (Math.random() < 0.5) {
			TotemAnimationProcedure.execute(world, entity, new ItemStack(TheRootOfCorruptionModItems.SERVER.get()));
		} else {
			TotemAnimationProcedure.execute(world, entity, new ItemStack(TheRootOfCorruptionModItems.NULLNULLNULL.get()));
		}
		if (Math.random() < 0.1) {
			TheRootOfCorruptionMod.queueServerWork(100, () -> {
				TexturelessAnimationProcedure.execute(world, x, y, z, entity);
			});
		}
	}
}
