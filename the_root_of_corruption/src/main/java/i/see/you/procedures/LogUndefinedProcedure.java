package i.see.you.procedures;

import i.see.you.TheRootOfCorruptionMod;

public class LogUndefinedProcedure {
	public static void execute() {
		TheRootOfCorruptionMod.LOGGER.info(org.openjdk.nashorn.internal.runtime.Undefined.getUndefined());
	}
}
