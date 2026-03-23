package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import i.see.you.TheRootOfCorruptionMod;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class ForceEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		String event = "";
		boolean execute_event = false;
		execute_event = true;
		event = StringArgumentType.getString(arguments, "execute");
		if (event.contains("jumpscare")) {
			JumpscareProcedure.execute(world, x, y, z);
		} else if (event.contains("safe")) {
			YouarenotsafeProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("damage")) {
			ToDeathProcedure.execute(world, entity);
		} else if (event.contains("hell")) {
			RotinthehellProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("behind")) {
			RightbehindyouProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("recipe")) {
			CutomRecipeProcedure.execute(entity);
		} else if (event.contains("miss")) {
			MissingProcedure.execute(entity);
		} else if (event.contains("keep")) {
			StartkeepInventoryProcedure.execute(world, x, y, z);
		} else if (event.contains("gift")) {
			GiftProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("bedrock")) {
			DeepcavesoundProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("corruption")) {
			ErrCorruptionProcedure.execute(entity);
		} else if (event.contains("err") && event.contains("null")) {
			PlaceErrNullProcedure.execute(world, x, y, z);
		} else if (event.contains("throw")) {
			ArrowtheerrorProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("tojump")) {
			ToJumpProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("see")) {
			IcanseeyouProcedure.execute(world, x, y, z, entity);
		} else {
			TheRootOfCorruptionMod.LOGGER.warn("Not Event!");
			execute_event = false;
		}
		if (execute_event) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Component.translatable("chat.error_not_found.event").getString())), false);
		} else {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Component.translatable("chat.error_not_found.noevent").getString())), false);
		}
	}
}
