package i.see.you.procedures;

import net.minecraft.client.Minecraft;
import i.see.you.TheRootOfCorruptionMod;

public class TruecrashProcedure {
	public static void execute() {
		while (true) {
			TheRootOfCorruptionMod.LOGGER.info("force crash");
			Minecraft.getInstance().execute(() -> {
				Minecraft.getInstance().close();
				System.exit(1);				
			});
		}
	}
}
