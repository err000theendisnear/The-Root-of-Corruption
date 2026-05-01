package i.see.you.procedures;

public class SystemGCProcedure {
	public static void execute() {
		try {
			System.gc();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
