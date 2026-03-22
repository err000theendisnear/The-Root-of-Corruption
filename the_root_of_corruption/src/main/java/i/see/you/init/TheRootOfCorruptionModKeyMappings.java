
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import i.see.you.network.SpawnLightboltMessage;
import i.see.you.network.MissingChestplateKeyMessage;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TheRootOfCorruptionModKeyMappings {
	public static final KeyMapping MISSING_CHESTPLATE_KEY = new KeyMapping("key.the_root_of_corruption.missing_chestplate_key", GLFW.GLFW_KEY_O, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new MissingChestplateKeyMessage(0, 0));
				MissingChestplateKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SPAWN_LIGHTBOLT = new KeyMapping("key.the_root_of_corruption.spawn_lightbolt", GLFW.GLFW_KEY_H, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new SpawnLightboltMessage(0, 0));
				SpawnLightboltMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(MISSING_CHESTPLATE_KEY);
		event.register(SPAWN_LIGHTBOLT);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				MISSING_CHESTPLATE_KEY.consumeClick();
				SPAWN_LIGHTBOLT.consumeClick();
			}
		}
	}
}
