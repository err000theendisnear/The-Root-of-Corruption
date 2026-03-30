package i.see.you.procedures;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.Minecraft;

public class SetTitleProcedure {
	public static void execute(String title) {
		if (title == "")
			return;
		String titles = "";
		if (Minecraft.getInstance().getWindow() != null) {
			titles = title;
			GLFW.glfwSetWindowTitle(WindowHandleProcedure.execute(), titles);
		}
	}
}
