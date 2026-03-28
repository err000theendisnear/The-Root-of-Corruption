package i.see.you.procedures;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.Minecraft;

public class SetTitleProcedure {
	public static void execute(String title) {
		if (title == "")
			return;
		String titles = "";
		Minecraft mc = Minecraft.getInstance();
		if (mc.getWindow() != null) {
			titles = title;
			long windowHandle = mc.getWindow().getWindow();
			GLFW.glfwSetWindowTitle(windowHandle, titles);
		}
	}
}
