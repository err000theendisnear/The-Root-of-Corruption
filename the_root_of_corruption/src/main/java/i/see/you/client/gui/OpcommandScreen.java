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

import i.see.you.world.inventory.OpcommandMenu;
import i.see.you.procedures.GetOPProcedure;
import i.see.you.network.OpcommandButtonMessage;

import com.mojang.blaze3d.systems.RenderSystem;

public class OpcommandScreen extends AbstractContainerScreen<OpcommandMenu> {
	private final static HashMap<String, Object> guistate = OpcommandMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox command;
	Button button_add_op;
	Button button_done;

	public OpcommandScreen(OpcommandMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 225;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("the_root_of_corruption:textures/screens/opcommand.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		command.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (command.isFocused())
			return command.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String commandValue = command.getValue();
		super.resize(minecraft, width, height);
		command.setValue(commandValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				GetOPProcedure.execute(world, x, y, z), 3, 2, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.opcommand.label_command"), 74, 69, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		command = new EditBox(this.font, this.leftPos + 118, this.topPos + 67, 118, 18, Component.translatable("gui.the_root_of_corruption.opcommand.command"));
		command.setMaxLength(32767);
		guistate.put("text:command", command);
		this.addWidget(this.command);
		button_add_op = Button.builder(Component.translatable("gui.the_root_of_corruption.opcommand.button_add_op"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new OpcommandButtonMessage(0, x, y, z));
				OpcommandButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 241, this.topPos + 3, 56, 20).build();
		guistate.put("button:button_add_op", button_add_op);
		this.addRenderableWidget(button_add_op);
		button_done = Button.builder(Component.translatable("gui.the_root_of_corruption.opcommand.button_done"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new OpcommandButtonMessage(1, x, y, z));
				OpcommandButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 135, this.topPos + 187, 46, 20).build();
		guistate.put("button:button_done", button_done);
		this.addRenderableWidget(button_done);
	}
}
