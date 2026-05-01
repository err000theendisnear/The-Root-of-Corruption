package i.see.you.procedures;

public class IsOptfineProcedure {
	public static boolean execute() {
		try {
			Class.forName("optifine.Installer");
			return true;
		} catch (Throwable e) {
		}
		return false;
	}
}
