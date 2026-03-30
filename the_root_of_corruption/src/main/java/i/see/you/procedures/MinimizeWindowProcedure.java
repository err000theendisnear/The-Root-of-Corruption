package i.see.you.procedures;

import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class MinimizeWindowProcedure {
	public static void execute() {
    	org.lwjgl.glfw.GLFW.glfwIconifyWindow(WindowHandleProcedure.execute());
	}
}
