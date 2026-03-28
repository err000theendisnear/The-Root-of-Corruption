package i.see.you.procedures;

import net.neoforged.fml.loading.FMLPaths;
import net.minecraft.client.Minecraft;
import java.nio.file.Paths;
import java.io.File;
import i.see.you.configuration.ConfigConfiguration;
import java.nio.file.Files;
import java.nio.file.Path;
import java.lang.Exception;
import java.lang.RuntimeException;
import java.nio.file.StandardOpenOption;
import java.util.List;
import i.see.you.TheRootOfCorruptionMod;
import net.minecraft.world.level.LevelAccessor;

public class HserrpidlogProcedure {
	public static void execute(double x, double y, double z, LevelAccessor world) {
    	
		String home = "";
		home = Minecraft.getInstance().gameDirectory.getAbsolutePath();
		if (Files.isWritable(Paths.get(home))){
			TheRootOfCorruptionMod.LOGGER.info("can create hs_err_pid*.log");
		} else {
			TheRootOfCorruptionMod.LOGGER.warn("hs_err_pid*.log can't to create at:" + home);
			home = System.getProperty("java.io.tmpdir");
		}
		Path file = Paths.get(home).resolve("hs_err_pid" + ProcessHandle.current().pid() + ".log");
		if (!Files.exists(file)) {
			 List<String> lines = List.of(
                "A fatal error has detected by Java Runtime Environment:",
                "I watching you."
            );
            try {
            	Files.write(file, lines, StandardOpenOption.CREATE);
            	TheRootOfCorruptionMod.LOGGER.info("create hs_err_pid*.log at:" + home);
            } catch (Exception e) {
            	TheRootOfCorruptionMod.LOGGER.error("Failed to create hs_err_pid*.log", e);
            }
            if (ConfigConfiguration.CRASH.get()) {
				GameToCrashProcedure.execute(world, x, y, z);
			}
		} else {
			TheRootOfCorruptionMod.LOGGER.warn("hs_err_pid*.log File exists");
		}
	}
}