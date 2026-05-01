package i.see.you.mixins;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import i.see.you.network.TheRootOfCorruptionModVariables;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import javax.annotation.Nullable;
import java.io.File;
import net.minecraft.CrashReport;
import java.nio.file.Path;
import net.minecraft.server.Bootstrap;
import javax.swing.filechooser.FileSystemView;
import net.minecraft.ReportType;
import net.minecraft.Util;

@Mixin({Minecraft.class})
public class MinecraftMixin {
	@Inject(method = {"pauseGame"}, at = {@At("HEAD")}, cancellable = true)
	private static void YouCannotPauseGame(boolean pauseOnly, CallbackInfo ci) {
  		Minecraft mc = Minecraft.getInstance();
  		boolean a = mc.player != null;
  		boolean b = TheRootOfCorruptionModVariables.MapVariables.get(mc.level).unpauseable;
    	if (a && b)
    		ci.cancel(); 
	}
	@Inject(method = {"createTitle"}, at = {@At("RETURN")}, cancellable = true)
	private static void TheRootOfCorruptionTitle(CallbackInfoReturnable<String> cir) {
  		cir.setReturnValue("The Root of Corruption");
	}
	@Inject(method = {"crash"}, at = {@At("HEAD")}, cancellable = true)
	private static void OnGameCrash(@Nullable Minecraft mc, File f, CrashReport cr, CallbackInfo ci) {
		try {
  			Path path = FileSystemView.getFileSystemView().getHomeDirectory().toPath();
        	Path path1 = path.resolve("crash-" + Util.getFilenameFormattedDateTime() + "-client.txt");
       	 	Bootstrap.realStdoutPrintln(cr.getFriendlyReport(ReportType.CRASH));
       		if (mc != null) 
            	mc.getSoundManager().emergencyShutdown();
        	if (cr.getSaveFile() != null) {
            	Bootstrap.realStdoutPrintln("#@!@# Game crashed! Crash report saved to: #@!@# " + cr.getSaveFile().toAbsolutePath());
            	net.neoforged.neoforge.server.ServerLifecycleHooks.handleExit(-1);
        	} else if (cr.saveToFile(path1, ReportType.CRASH)) {
            	Bootstrap.realStdoutPrintln("#@!@# Game crashed! Crash report saved to: #@!@# " + path1.toAbsolutePath());
            	net.neoforged.neoforge.server.ServerLifecycleHooks.handleExit(-1);
        	} else {
            	Bootstrap.realStdoutPrintln("#@?@# Game crashed! Crash report could not be saved. #@?@#");
            	net.neoforged.neoforge.server.ServerLifecycleHooks.handleExit(-2);
       	 	}
       	 	ci.cancel();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
