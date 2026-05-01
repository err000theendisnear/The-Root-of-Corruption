package i.see.you.mixins;

import net.minecraft.CrashReport;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.lang.reflect.Field;

@Mixin(CrashReport.class)
public abstract class CrashReportMixin {

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onCrashReportConstructed(String title, Throwable exception, CallbackInfo ci) {
        try {
            Field titleField = CrashReport.class.getDeclaredField("title");
            titleField.setAccessible(true);
            System.out.println("Crash report title has been modified, raw title : " + title);
            titleField.set(this, "Here I am.");
        } catch (Throwable e) {
            System.err.println("failed to modified Crash report title");
            e.printStackTrace();
        }
    }
}
