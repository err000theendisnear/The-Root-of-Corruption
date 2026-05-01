package i.see.you.network;

import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.minecraft.client.Minecraft;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

public record TotemPacket(ItemStack stack) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<TotemPacket> TYPE =
            new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("the_root_of_corruption", "totem_packet"));
    public static final StreamCodec<RegistryFriendlyByteBuf, TotemPacket> STREAM_CODEC =
            StreamCodec.composite(
                    ItemStack.STREAM_CODEC,
                    TotemPacket::stack,
                    TotemPacket::new
            );
    @Override
    public @NotNull CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
    public static void handleClient(final TotemPacket data, final IPayloadContext context) {
        context.enqueueWork(() -> {
            Minecraft.getInstance().gameRenderer.displayItemActivation(data.stack());
        });
    }
}
