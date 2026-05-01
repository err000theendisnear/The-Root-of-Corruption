package i.see.you.mixins;

import net.minecraft.ReportType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ReportType.class)
public abstract class ReportTypeMixin {

    @Inject(method = "getErrorComment", at = @At("HEAD"), cancellable = true)
    private static void onGetErrorComment(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue("// You've brought it upon yourself.");
    }
}
