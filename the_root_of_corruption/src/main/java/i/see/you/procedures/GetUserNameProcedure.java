package i.see.you.procedures;

public class GetUserNameProcedure {
	public static String execute() {
		return System.getProperty("user.name");
	}
}
