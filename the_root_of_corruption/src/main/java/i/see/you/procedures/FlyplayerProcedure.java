package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import i.see.you.init.TheRootOfCorruptionModItems;

public class FlyplayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.push((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z));
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheRootOfCorruptionModItems.FLY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TheRootOfCorruptionModItems.FLY.get()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.riptide_3")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.riptide_3")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
				entity.push((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z));
			}
		} else {
			CavesoundProcedure.execute(world, x, y, z);
		}
	}
}
