package i.see.you.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class ErrerrProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level().getServer(), _ent),
						"/setblock ~ ~1 ~ minecraft:standing_sign 0 replace {Text1:\"[{\\\"text\\\":\\\"err\\\",\\\"color\\\":\\\"dark_red\\\",\\\"bold\\\":false,\\\"italic\\\":false,\\\"underlined\\\":false,\\\"strikethrough\\\":false,\\\"obfuscated\\\":true}]\",Text2:\"[{\\\"text\\\":\\\"\\\",\\\"bold\\\":false,\\\"italic\\\":false,\\\"underlined\\\":false,\\\"strikethrough\\\":false,\\\"obfuscated\\\":false}]\",Text3:\"[{\\\"text\\\":\\\"\\\",\\\"bold\\\":false,\\\"italic\\\":false,\\\"underlined\\\":false,\\\"strikethrough\\\":false,\\\"obfuscated\\\":false}]\",Text4:\"[{\\\"text\\\":\\\"\\\",\\\"bold\\\":false,\\\"italic\\\":false,\\\"underlined\\\":false,\\\"strikethrough\\\":false,\\\"obfuscated\\\":false}]\"}");
			}
		}
	}
}
