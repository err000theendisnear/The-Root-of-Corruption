package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class ErrsoulProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		BlockPos pos = BlockPos.ZERO;
		player = NearbyPlayerProcedure.execute(world, entity);
		if (!(player == null)) {
			pos = BlockPos.containing((x + Mth.nextDouble(RandomSource.create(), -16, 16)), (y + Mth.nextDouble(RandomSource.create(), -16, 16)), (z + Mth.nextDouble(RandomSource.create(), -16, 16)));
			if (!world.isEmptyBlock(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ()))
					&& 0 < world.getBlockState(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ())).getDestroySpeed(world, BlockPos.containing(pos.getX(), pos.getY(), pos.getZ()))) {
				world.setBlock(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ()), (Math.random() < 0.5 ? Blocks.SOUL_SAND.defaultBlockState() : Blocks.SOUL_SOIL.defaultBlockState()), 3);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SOUL, (x + Mth.nextDouble(RandomSource.create(), -2, 2)), y, (z + Mth.nextDouble(RandomSource.create(), -2, 2)), 2, 0, 1, 0, 0);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("the_root_of_corruption:null_pointer_damage")))), 1);
					}
				}
			}
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo((player.getX()), (player.getY()), (player.getZ()), 1);
		}
	}
}
