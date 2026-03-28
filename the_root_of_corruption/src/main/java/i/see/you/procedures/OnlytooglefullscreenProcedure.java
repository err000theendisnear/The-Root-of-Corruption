package i.see.you.procedures;

import net.minecraft.client.Minecraft;

public class OnlytooglefullscreenProcedure {
	public static void execute() {
		ToggleFullScreenProcedure.execute(Minecraft.getInstance().getWindow().isFullscreen());
	}
}
