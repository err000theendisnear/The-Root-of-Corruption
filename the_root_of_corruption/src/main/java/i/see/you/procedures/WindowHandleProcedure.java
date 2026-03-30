package i.see.you.procedures;

import net.minecraft.client.Minecraft;

public class WindowHandleProcedure {
	public static long execute() {
		return Minecraft.getInstance().getWindow().getWindow();
	}
}
