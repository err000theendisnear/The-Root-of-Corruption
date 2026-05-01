package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import i.see.you.TheRootOfCorruptionMod;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.NeoForge;

public class RightclickentityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		Entity targetEntity = null;
		player = SpawnFakePlayerProcedure.execute(world, StringArgumentType.getString(arguments, "name"));
		if (!world.isClientSide()) {
			targetEntity = new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "entity");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity();
			{
				Entity _ent = player;
				_ent.teleportTo(x, y, z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
			}
			{
				Entity _ent = player;
				_ent.setYRot(entity.getYRot());
				_ent.setXRot(entity.getXRot());
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (player instanceof Player _player) {
				PlayerInteractEvent.EntityInteract event = new PlayerInteractEvent.EntityInteract(_player, InteractionHand.MAIN_HAND, targetEntity);
				NeoForge.EVENT_BUS.post(event);
				if (event.isCanceled()) {
					TheRootOfCorruptionMod.LOGGER.warn("Right Click Falied");
				} else {
					TheRootOfCorruptionMod.LOGGER.info("Right Click Success");
				}
			}
		}
	}
}
