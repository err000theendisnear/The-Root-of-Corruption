package i.see.you.mixins;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.world.entity.Entity;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {
	@Inject(method = {"addEntity"}, at = {@At("HEAD")}, cancellable = true)
	private void onAddRemovedEntity(Entity entity, CallbackInfoReturnable<Boolean> cir) {
  		if (entity.isRemoved()) {
  			cir.setReturnValue(false);
  			cir.cancel();
        }
	}
}
