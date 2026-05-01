package i.see.you.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import i.see.you.world.inventory.MeomorydeathMenu;
import i.see.you.network.MeomorydeathButtonMessage;

import com.mojang.blaze3d.systems.RenderSystem;

public class MeomorydeathScreen extends AbstractContainerScreen<MeomorydeathMenu> {
	private final static HashMap<String, Object> guistate = MeomorydeathMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_null;

	public MeomorydeathScreen(MeomorydeathMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("the_root_of_corruption:textures/screens/memoryiswatch.png"), this.leftPos + -125, this.topPos + -37, 0, 0, 640, 640, 640, 640);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.meomorydeath.label_erroutofmemory"), 50, 29, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.meomorydeath.label_erroutofmemory1"), 54, 41, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.meomorydeath.label_erroutofmemory2"), 54, 55, -65536, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.meomorydeath.label_erroutofmemory3"), 55, 70, -16711936, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.meomorydeath.label_erroutofmemory4"), 56, 81, -16776961, false);
	}

	@Override
	public void init() {
		super.init();
		button_null = Button.builder(Component.translatable("gui.the_root_of_corruption.meomorydeath.button_null"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MeomorydeathButtonMessage(0, x, y, z));
				MeomorydeathButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 70, this.topPos + 149, 46, 20).build();
		guistate.put("button:button_null", button_null);
		this.addRenderableWidget(button_null);
	}
}
