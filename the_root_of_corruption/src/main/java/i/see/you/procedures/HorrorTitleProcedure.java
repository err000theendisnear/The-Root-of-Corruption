package i.see.you.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class HorrorTitleProcedure {
	public static void execute() {
		String title = "";
		if (Mth.nextInt(RandomSource.create(), 0, 1) == 0) {
			title = Mth.nextInt(RandomSource.create(), 0, 1) == 0 ? "go away" : "null";
		} else if (Mth.nextInt(RandomSource.create(), 0, 1) == 0) {
			title = Mth.nextInt(RandomSource.create(), 0, 1) == 0 ? "behind you" : "0";
		} else if (Mth.nextInt(RandomSource.create(), 0, 1) == 0) {
			title = Mth.nextInt(RandomSource.create(), 0, 1) == 0 ? "=)" : "glitch";
		} else {
			title = Mth.nextInt(RandomSource.create(), 0, 1) == 0 ? "err" : "undefined";
		}
		SetTitleProcedure.execute(title);
	}
}
