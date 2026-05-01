package i.see.you.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import i.see.you.world.inventory.AreYouPlayerMenu;
import i.see.you.network.AreYouPlayerButtonMessage;

import com.mojang.blaze3d.systems.RenderSystem;

public class AreYouPlayerScreen extends AbstractContainerScreen<AreYouPlayerMenu> {
	private final static HashMap<String, Object> guistate = AreYouPlayerMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox player;
	Button button_done;

	public AreYouPlayerScreen(AreYouPlayerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("the_root_of_corruption:textures/screens/are_you_player.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		player.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (player.isFocused())
			return player.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String playerValue = player.getValue();
		super.resize(minecraft, width, height);
		player.setValue(playerValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.are_you_player.label_enter_your_player_name"), 26, 27, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		player = new EditBox(this.font, this.leftPos + 26, this.topPos + 71, 118, 18, Component.translatable("gui.the_root_of_corruption.are_you_player.player"));
		player.setMaxLength(32767);
		guistate.put("text:player", player);
		this.addWidget(this.player);
		button_done = Button.builder(Component.translatable("gui.the_root_of_corruption.are_you_player.button_done"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AreYouPlayerButtonMessage(0, x, y, z));
				AreYouPlayerButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 57, this.topPos + 120, 46, 20).build();
		guistate.put("button:button_done", button_done);
		this.addRenderableWidget(button_done);
	}
}
