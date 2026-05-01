
package i.see.you.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.Minecraft;

import i.see.you.procedures.ReturnTrueProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber({Dist.CLIENT})
public class HorrorMainMenuOverlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		if (event.getScreen() instanceof TitleScreen) {
			int w = event.getGuiGraphics().guiWidth();
			int h = event.getGuiGraphics().guiHeight();
			Level world = null;
			double x = 0;
			double y = 0;
			double z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				world = entity.level();
				x = entity.getX();
				y = entity.getY();
				z = entity.getZ();
			}
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);
			if (ReturnTrueProcedure.execute()) {
				event.getGuiGraphics().blit(ResourceLocation.parse("the_root_of_corruption:textures/screens/mainmenu.png"), 0, 0, 0, 0, w, h, w, h);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave"), 12, 14, -13434880, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave1"), w / 2 + -203, h / 2 + -90, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave2"), w / 2 + -203, h / 2 + -75, -16777216, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave3"), w / 2 + -201, h / 2 + -58, -16777165, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave4"), w / 2 + -204, h / 2 + -43, -16764160, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave5"), w / 2 + -203, h / 2 + -26, -13421824, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave6"), w / 2 + -202, h / 2 + -7, -3394816, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave7"), w / 2 + -204, h / 2 + -118, -16724788, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave8"), w / 2 + -80, h / 2 + -115, -10092442, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave9"), w / 2 + -80, h / 2 + -99, -65485, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave10"), w / 2 + -76, h / 2 + -63, -13312, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave11"), w / 2 + -78, h / 2 + -80, -16724890, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave12"), w / 2 + -77, h / 2 + -42, -13108, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave13"), w / 2 + -76, h / 2 + -25, -25967, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_why_can_you_just_leave14"), w / 2 + -76, h / 2 + -7, -6826882, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_leaveleaveleaveleaveleaveleave"), w / 2 + -234, h / 2 + 107, -65536, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_go_away"), w / 2 + 156, h / 2 + -105, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_empty"), w / 2 + -189, h / 2 + 85, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_behind_you"), w / 2 + 117, h / 2 + 44, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_i_see_you"), w / 2 + -19, h / 2 + 20, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_null"), w / 2 + 78, h / 2 + 84, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_undefined"), w / 2 + -156, h / 2 + 42, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_empty1"), w / 2 + 100, h / 2 + -59, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_root_of_corruption.horror_main_menu.label_get_out"), w / 2 + -39, h / 2 + 74, -1, false);
			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
