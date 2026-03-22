
package i.see.you.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import i.see.you.procedures.SummonlightboltProcedure;
import i.see.you.TheRootOfCorruptionMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record SpawnLightboltMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<SpawnLightboltMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TheRootOfCorruptionMod.MODID, "key_spawn_lightbolt"));
	public static final StreamCodec<RegistryFriendlyByteBuf, SpawnLightboltMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SpawnLightboltMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new SpawnLightboltMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<SpawnLightboltMessage> type() {
		return TYPE;
	}

	public static void handleData(final SpawnLightboltMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			SummonlightboltProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TheRootOfCorruptionMod.addNetworkMessage(SpawnLightboltMessage.TYPE, SpawnLightboltMessage.STREAM_CODEC, SpawnLightboltMessage::handleData);
	}
}
