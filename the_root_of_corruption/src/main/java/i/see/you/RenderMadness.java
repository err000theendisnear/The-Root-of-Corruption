package i.see.you;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.server.MinecraftServer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import i.see.you.configuration.ConfigConfiguration;

public class RenderMadness {

	private static boolean canRender = ConfigConfiguration.ALLOW_FLICKERING_SCREEN.get();
	
	private static float getRandom() {
		return (float) Math.random();
	}

	public static void resetScreen() {
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
	}

	public static void GlitchRenderer() {
		if (!canRender) {
			resetScreen();
			return;
		}
		try {
        	RenderSystem.setShaderColor(getRandom(), getRandom(), getRandom(), getRandom());
		} catch (Throwable e) {
			e.printStackTrace();
			resetScreen();
		}
	}
}
