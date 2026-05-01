package i.see.you;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.fml.common.EventBusSubscriber;
import i.see.you.network.TotemPacket;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TotemPacketHandler {
	@SubscribeEvent
    public static void registerPackets(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playToClient(
                TotemPacket.TYPE,
                TotemPacket.STREAM_CODEC,
                TotemPacket::handleClient
        );
    }
}
