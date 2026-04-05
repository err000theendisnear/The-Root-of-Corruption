package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.player.LocalPlayer;

public class ExecuteEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		//why can't execute event?
		if (!(new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, ResourceLocation.parse("the_root_of_corruption:errr"))) && Mth.nextInt(RandomSource.create(), 1, 2) == 1) {//because recipe event need before give the recipe.
			CutomRecipeProcedure.execute(entity);
		} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			HorrornameProcedure.execute(entity);
		} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			FakePlayerAttackProcedure.execute(world, entity);
		} else if (Mth.nextInt(RandomSource.create(), 0, 2) == 1) {
			BreakblocksoundProcedure.execute(world, x, y, z);
		} else if (Mth.nextInt(RandomSource.create(), 0, 1) == 1) {
			WindchargeProcedure.execute(world, x, y, z);
		} else if (Mth.nextInt(RandomSource.create(), 0, 4) == 1) {
			FromthevoidProcedure.execute(world, x, z, entity);
		} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			FlyplayerProcedure.execute(world, x, y, z, entity);
		} else if (Mth.nextInt(RandomSource.create(), 0, 2) == 1) {
			BUILDSUCCESSFULProcedure.execute(world);
		} else if (Mth.nextInt(RandomSource.create(), 0, 2) == 1) {
			IpProcedure.execute(entity);
		} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			HorrorTitleProcedure.execute();
		} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			TheBrokenAnomalyProcedure.execute(world, x, y, z, entity);
		} else if (Mth.nextInt(RandomSource.create(), 0, 3) == 0) {
			LeftgameProcedure.execute(world, x, y, z);
		} else if (Mth.nextInt(RandomSource.create(), 0, 5) == 0) {
			OutOfMemoryErrorProcedure.execute(world, x, y, z, entity);
		} else if (Mth.nextInt(RandomSource.create(), 0, 6) == 0) {
			HotSpotLogProcedure.execute(world, x, y, z);
		} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			YouarenotsafeProcedure.execute(world, x, y, z, entity);
		} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			ToDeathProcedure.execute(world, entity);
		} else if ((entity.level().dimension()) == Level.OVERWORLD && Mth.nextInt(RandomSource.create(), 1, 2) == 1) {//rot in hell event need you are in overworld.
			RotinthehellProcedure.execute(world, x, y, z, entity);
		} else if (Mth.nextInt(RandomSource.create(), 0, 5) == 0) {
			JumpscareProcedure.execute(world, x, y, z);
		} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			RightbehindyouProcedure.execute(world, x, y, z, entity);
		} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			MissingProcedure.execute(entity);
		} else if (entity instanceof ServerPlayer _plr24 && _plr24.level() instanceof ServerLevel && _plr24.getAdvancements().getOrStartProgress(_plr24.server.getAdvancements().get(ResourceLocation.parse("minecraft:end/kill_dragon"))).isDone()
				&& Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			GiftProcedure.execute(world, x, y, z, entity);
			//gift event need kill ender dragon.
		} else if (!world.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY) && Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			StartkeepInventoryProcedure.execute(world, x, y, z);
			//keepinvenory event need gamerule keepinvenory is false.
		} else if (y < 0 && Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
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
		} else {
			UndefindProcedure.execute(entity);
		}
	}
}
