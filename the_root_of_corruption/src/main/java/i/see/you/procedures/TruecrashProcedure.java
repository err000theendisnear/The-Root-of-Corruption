package i.see.you.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Display;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class TruecrashProcedure {
	public static void execute(LevelAccessor world) {
		while (true) {
			if (!((Entity) world.getEntitiesOfClass(Display.TextDisplay.class, AABB.ofSize(new Vec3(2147000000, 2147000000, 2147000000), 0.01, 0.01, 0.01), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(2147000000, 2147000000, 2147000000)).findFirst().orElse(null)).level().isClientSide())
				((Entity) world.getEntitiesOfClass(Display.TextDisplay.class, AABB.ofSize(new Vec3(2147000000, 2147000000, 2147000000), 0.01, 0.01, 0.01), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(2147000000, 2147000000, 2147000000)).findFirst().orElse(null)).discard();
			((Entity) world.getEntitiesOfClass(Display.BlockDisplay.class, AABB.ofSize(new Vec3(2147000000, 2147000000, 2147000000), 0.01, 0.01, 0.01), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(2147000000, 2147000000, 2147000000)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) Double.NaN);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(2147000000, 2147000000, 2147000000)));;
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof Level _level)
				_level.updateNeighborsAt(new BlockPos(2147000000, 2147000000, 2147000000), _level.getBlockState(new BlockPos(2147000000, 2147000000, 2147000000)).getBlock());
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.ITEM_DISPLAY.spawn(_level, new BlockPos(2147000000, 2147000000, 2147000000), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			{
				final Vec3 _center = new Vec3(0, 0, 0);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2147000000 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof TamableAnimal _toTame && ((Entity) world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(2147000000, 2147000000, 2147000000), 0.01, 0.01, 0.01), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(2147000000, 2147000000, 2147000000)).findFirst().orElse(null)) instanceof Player _owner)
						_toTame.tame(_owner);
				}
			}
			if (!world.isClientSide() && world.getServer() != null)
				ServerLifecycleHooks.getCurrentServer().stopServer();
			throw new NullPointerException("It was all your fault.");
		}
	}
}
