package i.see.you.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.Minecraft;

public class OpenChatScreenProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		try {
			Minecraft mc = Minecraft.getInstance();
			if (mc.player != null) {
				if (entity instanceof Player _player)
					_player.closeContainer();
				mc.execute(() -> {
					mc.setScreen((Screen) new ChatScreen("You shouldn't have come here."));
				});
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
