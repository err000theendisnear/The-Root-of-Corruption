package i.see.you.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class EntitySpawnerCanSpawnProcedure {
	public static boolean execute() {
		/*
		*我为什么现在才搞这个代码
		*/
		return ((Mth.nextDouble(RandomSource.create(), 1, 10))) > ((Math.random() * Mth.nextDouble(RandomSource.create(), 1, 4))) && ((Mth.nextDouble(RandomSource.create(), 1, 10))) < ((Mth.nextInt(RandomSource.create(), 1, 10)))
				&& Math.random() < Math.random() && 1 == Mth.nextInt(RandomSource.create(), 1, 50);
	}
}
