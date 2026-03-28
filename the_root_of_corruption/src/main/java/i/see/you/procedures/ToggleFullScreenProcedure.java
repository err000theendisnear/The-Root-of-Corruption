package i.see.you.procedures;

import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.platform.Window;

public class ToggleFullScreenProcedure {
	public static void execute(boolean exit) {
		Minecraft mc = Minecraft.getInstance();
		Window window = mc.getWindow();
		if (exit) {
			if (window.isFullscreen()) {
				window.toggleFullScreen();
			}
		} else {
			if (!window.isFullscreen()) {
				window.toggleFullScreen();
			}
		}
	}
}
