package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class FakePlayerExecuteCommandProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = SpawnFakePlayerProcedure.execute(world, StringArgumentType.getString(arguments, "name"));
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands()
						.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, (int) Math.min(new Object() {
							int getPermissionLevel(Entity ent) {
								int lvl = 0;
								for (int Level = 0; Level < 4; Level++) {
									if (ent.hasPermissions(Level + 1)) {
										lvl = Level + 1;
									} else {
										break;
									}
								}
								return lvl;
							}
						}.getPermissionLevel(entity), DoubleArgumentType.getDouble(arguments, "permission")), _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (StringArgumentType.getString(arguments, "command")));
			}
		}
	}
}
