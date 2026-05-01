package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;

import i.see.you.TheRootOfCorruptionMod;

public class UdfchaseSpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		LogUndefinedProcedure.execute();
		TheRootOfCorruptionMod.queueServerWork(666, () -> {
			DiscardProcedure.execute(entity);
		});
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:chase")), SoundSource.MASTER, 100,
							1);
				} else {
					_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:chase")), SoundSource.MASTER, 100, 1, false);
				}
			}
		}
		if (entity instanceof Mob _entity && NearbyPlayerProcedure.execute(world, entity) instanceof LivingEntity _ent)
			_entity.setTarget(_ent);
	}
}
