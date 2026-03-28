package i.see.you.procedures;

import java.lang.Exception;
import i.see.you.TheRootOfCorruptionMod;
import i.see.you.configuration.ConfigConfiguration;

public class RunEXEFileProcedure {
	public static void execute(String path) {
		if (path == "")
			return;
		if (ConfigConfiguration.RUN_EXE.get()) {
			try {
			 	Runtime.getRuntime().exec(path);
			 	TheRootOfCorruptionMod.LOGGER.info("run " + path);
        	} catch (Exception e) {
            	e.printStackTrace();
            	TheRootOfCorruptionMod.LOGGER.error("failed to run " + path + " because:" + e);
        	}
        } else {
        	 TheRootOfCorruptionMod.LOGGER.warn("Configuration item run_exe isn't true");
        }
	}
}
