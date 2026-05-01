package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import java.util.Calendar;
import java.util.ArrayList;

public class RandomMessageProcedure {
	public static void execute(LevelAccessor world) {
		ArrayList<Object> message = new ArrayList<>();
		message.add("(>) (?) (|)");
		message.add("{+]==null");
		message.add("undefined");
		message.add("=)");
		message.add("_^|=$-");
		message.add("[@] can you see me?");
		message.add("[@] behind you.");
		message.add("[@] I see you.");
		message.add("[@] go away.");
		message.add(
				"01110110 10001010 01001110 01101110 11001010 10001010 00000110 11111110 00100110 10110010 00110010 01011110 10110110 11000001 00110010 11111110 11010110 10000110 01110110 10011110 01101010 10110010 00110010 01011100 11010110 10001010 11111010 10001110 00100110 10000110 11111100 10101110 11001010 10001010 01101110 00100001 11001010 01001010 00000110 11111110 00100110 10001010 00000110 11101110 11010110 10000110 11111100 01101110 00100110 10110010 01111100 11100010");
		message.add(("\u00A7e" + (Component.translatable("multiplayer.player.joined").getString()).replace("%s", "StackOverFlowError")));
		if (Calendar.getInstance().get(Calendar.MONTH) == 3 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 0) {
			message.add(
					"11111100 01011110 11000001 00101010 11111100 00111110 11110110 01000001 11111100 11000110 11001110 10000010 11111100 11111100 11011110 11110010 11111100 01011110 10000110 00100110 00000010 11001010 10101010 11000001 11111100 10011110 10111010 01011010 11111100 01101010 11101110 00101010");
			message.add("00000010 01101010 10101100 00100110 11111100 01011110 11000001 00001110 11111100 00000010 10000110 11110110 11111100 01101010 11011110 10001010");
			message.add(("\u00A7e" + (Component.translatable("multiplayer.player.joined").getString()).replace("%s", "CoollessPlayer303")));
		}
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((message.get(Mth.nextInt(RandomSource.create(), 0, (int) (message.size() - 1))) instanceof String _str18 ? _str18 : "")), false);
	}
}
