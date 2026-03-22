package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.Comparator;

public class NoiseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null);
		if (player == null) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((player.getX()), (player.getY()), (player.getZ())));
			CavesoundProcedure.execute(world, x, y, z);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(player.getX(), player.getY(), player.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:noise")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound((player.getX()), (player.getY()), (player.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:noise")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (world.getLevelData() instanceof ServerLevelData _levelData12)
				_levelData12.setGameTime((int) (Math.floor(world.getLevelData().getGameTime() / 24000) * 24000 + 18000));
			world.getLevelData().setRaining(true);
		}
	}
}
