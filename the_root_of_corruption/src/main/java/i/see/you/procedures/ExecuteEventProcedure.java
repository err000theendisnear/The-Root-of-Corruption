package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import i.see.you.init.TheRootOfCorruptionModGameRules;

public class ExecuteEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(TheRootOfCorruptionModGameRules.ENABLE_EVENT)) {//why can't execute event?
			if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {//because recipe event need before give the recipe.
				CutomRecipeProcedure.execute(entity);
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				YouarenotsafeProcedure.execute(world, x, y, z, entity);
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				ToDeathProcedure.execute(world, entity);
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {//rot in hell event need you aren't in hell.
				RotinthehellProcedure.execute(world, x, y, z, entity);
			} else if (Mth.nextInt(RandomSource.create(), 0, 10) == 0) {
				JumpscareProcedure.execute(world, x, y, z);
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				RightbehindyouProcedure.execute(world, x, y, z, entity);
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				MissingProcedure.execute(entity);
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				GiftProcedure.execute(world, x, y, z, entity);
				//gift event need kill ender dragon.
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				StartkeepInventoryProcedure.execute(world, x, y, z);
				//keepinvenory event need gamerule keepinvenory is false.
			} else if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
				DeepcavesoundProcedure.execute(world, x, y, z, entity);
				//bedrock event need y<0.
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				PlaceErrNullProcedure.execute(world, x, y, z);
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				ArrowtheerrorProcedure.execute(world, x, y, z, entity);
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				ToJumpProcedure.execute(world, x, y, z, entity);
			} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				IcanseeyouProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
