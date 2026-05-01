package i.see.you.procedures;

import i.see.you.AlertWindow;
import java.lang.Exception;
import i.see.you.TheRootOfCorruptionMod;

public class AlertWindowsProcedure {
	public static void execute(String message, String title) {
		if (message == "" || title == "")
			return;
		String a = "";
		String b = "";
		a = title;
		b = message;
		try {
			new AlertWindow(a, b).show();
			MinimizeWindowProcedure.execute();
		} catch(Throwable e) {
			TheRootOfCorruptionMod.LOGGER.error("Failed to start alert window", e);
		}
	}
}
