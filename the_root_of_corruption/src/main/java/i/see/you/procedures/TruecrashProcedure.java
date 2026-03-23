package i.see.you.procedures;

public class TruecrashProcedure {
	public static void execute() {
		while (true) {
			throw new NullPointerException("It was all your fault.");
		}
	}
}
