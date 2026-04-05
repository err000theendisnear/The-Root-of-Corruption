package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;

import java.util.Comparator;

import i.see.you.network.TheRootOfCorruptionModVariables;

public class OwnerTickupdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		Entity goaway = null;
		entity.setCustomName(Component.literal(GetUserNameProcedure.execute()));
		player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 444, 444, 444), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null);
		if (!(player == null)) {
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo((player.getX()), (player.getY()), (player.getZ()), 1);
			player.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), (float) 0.1);
			goaway = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null);
			if (!(goaway == null)) {
				DiscardProcedure.execute(entity);
				TheRootOfCorruptionModVariables.MapVariables.get(world).online = true;
				TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A7e" + (Component.translatable("multiplayer.player.left").getString()).replace("%s", GetUserNameProcedure.execute()))), false);
			}
		}
	}
}
