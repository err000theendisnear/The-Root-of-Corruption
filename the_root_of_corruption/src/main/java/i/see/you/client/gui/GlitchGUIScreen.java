package i.see.you.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import i.see.you.world.inventory.GlitchGUIMenu;

import com.mojang.blaze3d.systems.RenderSystem;

public class GlitchGUIScreen extends AbstractContainerScreen<GlitchGUIMenu> {
	private final static HashMap<String, Object> guistate = GlitchGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox null2;
	Checkbox null0;
	Checkbox null1;
	Button button_null;
	Button button_null1;
	Button button_null2;
	Button button_null3;
	Button button_null4;
	Button button_null5;
	Button button_null6;
	Button button_null7;
	Button button_null8;
	Button button_null9;
	Button button_null10;
	Button button_null11;
	Button button_null12;
	Button button_null13;
	Button button_null14;
	Button button_null15;
	ImageButton imagebutton_no_texture;
	ImageButton imagebutton_no_texture1;

	public GlitchGUIScreen(GlitchGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("the_root_of_corruption:textures/screens/glitch_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		null2.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 76 && mouseX < leftPos + 100 && mouseY > topPos + 59 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.the_root_of_corruption.glitch_gui.tooltip_null"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("the_root_of_corruption:textures/screens/no_texture.png"), this.leftPos + -125, this.topPos + -40, 0, 0, 128, 128, 128, 128);

		guiGraphics.blit(ResourceLocation.parse("the_root_of_corruption:textures/screens/no_texture.png"), this.leftPos + -126, this.topPos + 87, 0, 0, 128, 128, 128, 128);

		guiGraphics.blit(ResourceLocation.parse("the_root_of_corruption:textures/screens/no_texture.png"), this.leftPos + 2, this.topPos + -34, 0, 0, 128, 128, 128, 128);

		guiGraphics.blit(ResourceLocation.parse("the_root_of_corruption:textures/screens/no_texture.png"), this.leftPos + 105, this.topPos + -36, 0, 0, 128, 128, 128, 128);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (null2.isFocused())
			return null2.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String null2Value = null2.getValue();
		super.resize(minecraft, width, height);
		null2.setValue(null2Value);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.glitch_gui.label_null"), 76, 36, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.glitch_gui.label_null1"), 76, 51, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.glitch_gui.label_null2"), 76, 22, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.glitch_gui.label_null3"), 76, 44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.glitch_gui.label_null4"), 76, 28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.glitch_gui.label_null5"), 76, 33, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.glitch_gui.label_null6"), 76, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.glitch_gui.label_null7"), 76, 47, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.the_root_of_corruption.glitch_gui.label_null8"), 76, 26, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		null2 = new EditBox(this.font, this.leftPos + 32, this.topPos + 85, 118, 18, Component.translatable("gui.the_root_of_corruption.glitch_gui.null2")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.the_root_of_corruption.glitch_gui.null2").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.the_root_of_corruption.glitch_gui.null2").getString());
				else
					setSuggestion(null);
			}
		};
		null2.setMaxLength(32767);
		null2.setSuggestion(Component.translatable("gui.the_root_of_corruption.glitch_gui.null2").getString());
		guistate.put("text:null2", null2);
		this.addWidget(this.null2);
		button_null = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null"), e -> {
		}).bounds(this.leftPos + 5, this.topPos + 63, 46, 20).build();
		guistate.put("button:button_null", button_null);
		this.addRenderableWidget(button_null);
		button_null1 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null1"), e -> {
		}).bounds(this.leftPos + 126, this.topPos + 61, 46, 20).build();
		guistate.put("button:button_null1", button_null1);
		this.addRenderableWidget(button_null1);
		button_null2 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null2"), e -> {
		}).bounds(this.leftPos + 8, this.topPos + 82, 46, 20).build();
		guistate.put("button:button_null2", button_null2);
		this.addRenderableWidget(button_null2);
		button_null3 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null3"), e -> {
		}).bounds(this.leftPos + 125, this.topPos + 84, 46, 20).build();
		guistate.put("button:button_null3", button_null3);
		this.addRenderableWidget(button_null3);
		button_null4 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null4"), e -> {
		}).bounds(this.leftPos + 6, this.topPos + 100, 46, 20).build();
		guistate.put("button:button_null4", button_null4);
		this.addRenderableWidget(button_null4);
		button_null5 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null5"), e -> {
		}).bounds(this.leftPos + 53, this.topPos + 100, 46, 20).build();
		guistate.put("button:button_null5", button_null5);
		this.addRenderableWidget(button_null5);
		button_null6 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null6"), e -> {
		}).bounds(this.leftPos + 100, this.topPos + 102, 46, 20).build();
		guistate.put("button:button_null6", button_null6);
		this.addRenderableWidget(button_null6);
		button_null7 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null7"), e -> {
		}).bounds(this.leftPos + 128, this.topPos + 101, 46, 20).build();
		guistate.put("button:button_null7", button_null7);
		this.addRenderableWidget(button_null7);
		button_null8 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null8"), e -> {
		}).bounds(this.leftPos + 6, this.topPos + 118, 46, 20).build();
		guistate.put("button:button_null8", button_null8);
		this.addRenderableWidget(button_null8);
		button_null9 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null9"), e -> {
		}).bounds(this.leftPos + 6, this.topPos + 139, 46, 20).build();
		guistate.put("button:button_null9", button_null9);
		this.addRenderableWidget(button_null9);
		button_null10 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null10"), e -> {
		}).bounds(this.leftPos + 52, this.topPos + 118, 46, 20).build();
		guistate.put("button:button_null10", button_null10);
		this.addRenderableWidget(button_null10);
		button_null11 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null11"), e -> {
		}).bounds(this.leftPos + 99, this.topPos + 119, 46, 20).build();
		guistate.put("button:button_null11", button_null11);
		this.addRenderableWidget(button_null11);
		button_null12 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null12"), e -> {
		}).bounds(this.leftPos + 129, this.topPos + 119, 46, 20).build();
		guistate.put("button:button_null12", button_null12);
		this.addRenderableWidget(button_null12);
		button_null13 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null13"), e -> {
		}).bounds(this.leftPos + 51, this.topPos + 139, 46, 20).build();
		guistate.put("button:button_null13", button_null13);
		this.addRenderableWidget(button_null13);
		button_null14 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null14"), e -> {
		}).bounds(this.leftPos + 98, this.topPos + 140, 46, 20).build();
		guistate.put("button:button_null14", button_null14);
		this.addRenderableWidget(button_null14);
		button_null15 = Button.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.button_null15"), e -> {
		}).bounds(this.leftPos + 128, this.topPos + 141, 46, 20).build();
		guistate.put("button:button_null15", button_null15);
		this.addRenderableWidget(button_null15);
		imagebutton_no_texture = new ImageButton(this.leftPos + 175, this.topPos + -36, 256, 256,
				new WidgetSprites(ResourceLocation.parse("the_root_of_corruption:textures/screens/no_texture.png"), ResourceLocation.parse("the_root_of_corruption:textures/screens/no_texture.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_no_texture", imagebutton_no_texture);
		this.addRenderableWidget(imagebutton_no_texture);
		imagebutton_no_texture1 = new ImageButton(this.leftPos + -28, this.topPos + 165, 256, 256,
				new WidgetSprites(ResourceLocation.parse("the_root_of_corruption:textures/screens/no_texture.png"), ResourceLocation.parse("the_root_of_corruption:textures/screens/no_texture.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_no_texture1", imagebutton_no_texture1);
		this.addRenderableWidget(imagebutton_no_texture1);
		null0 = Checkbox.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.null0"), this.font).pos(this.leftPos + 4, this.topPos + 5)

				.build();
		guistate.put("checkbox:null0", null0);
		this.addRenderableWidget(null0);
		null1 = Checkbox.builder(Component.translatable("gui.the_root_of_corruption.glitch_gui.null1"), this.font).pos(this.leftPos + 130, this.topPos + 3)

				.build();
		guistate.put("checkbox:null1", null1);
		this.addRenderableWidget(null1);
	}
}
