package i.see.you.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.server.network.ServerCommonPacketListenerImpl;
import i.see.you.configuration.ConfigConfiguration;
import net.minecraft.network.chat.Component;
import net.minecraft.network.DisconnectionDetails;

@Mixin(ServerCommonPacketListenerImpl.class)
public abstract class ServerCommonPacketListenerImplMixin {
	@Inject(method = {"disconnect"}, at = {@At("HEAD")}, cancellable = true)
	private void YouCannotDisconnectPlayer1(Component component, CallbackInfo ci) {
  		try {
    		if (!ConfigConfiguration.KICK.get())
    			System.out.println("Cancel kick player");
    			ci.cancel(); 
  		} catch (Throwable e) {
  			e.printStackTrace();
  		}
	}
}
