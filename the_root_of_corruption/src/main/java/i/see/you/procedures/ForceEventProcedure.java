package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import i.see.you.TheRootOfCorruptionMod;

public class ForceEventProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, String eventname) {
		if (entity == null || eventname == null)
			return false;
		String event = "";
		boolean execute_event = false;
		execute_event = true;
		event = eventname;
		if (event.contains("jumpscare")) {
			JumpscareProcedure.execute(world, x, y, z);
		} else if (event.contains("gc")) {
			SystemGCProcedure.execute();
		} else if (event.contains("pause")) {
			PauseGameProcedure.execute(world);
		} else if (event.contains("overlay")) {
			BehindYouOverlayProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("under")) {
			UnderFeetBlockProcedure.execute(world, x, y, z);
		} else if (event.contains("gui")) {
			OpenGlitchGUIProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("die")) {
			ClientDieProcedure.execute(world, entity);
		} else if (event.contains("chat")) {
			OpenChatScreenProcedure.execute(entity);
		} else if (event.contains("totem")) {
			TexturelessAnimationProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("see") && (event.contains("can") && event.contains("not") || event.contains("can't") || event.contains("cant"))) {
			CantYouSeeProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("message")) {
			RandomMessageProcedure.execute(world);
		} else if (event.contains("stuck")) {
			StuckProcedure.execute(entity);
		} else if (event.contains("particle")) {
			ISeeYouParticleProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("give")) {
			if (event.contains("deepslate")) {
				GiveReinforcedDeepslateProcedure.execute(entity);
			} else if (event.contains("server")) {
				GiveServerProcedure.execute(entity);
			} else if (event.contains("null")) {
				GiveNullNullNullProcedure.execute(entity);
			} else if (event.contains("bucket")) {
				GiveDayNegativeOneBucketProcedure.execute(entity);
			}
		} else if (event.contains("place")) {
			if (event.contains("copper")) {
				PlaceRawCopperBlockProcedure.execute(world, x, y, z);
			} else if (event.contains("light")) {
				PlaceLight15Procedure.execute(world, x, y, z);
			} else if (event.contains("fire")) {
				PlaceSoulFireProcedure.execute(world, x, y, z);
			}
		} else if (event.contains("doom")) {
			BreakworldProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("enchant")) {
			EnchantmentProcedure.execute(world, entity);
		} else if (event.contains("away") && event.contains("go")) {
			GoawaygoawayProcedure.execute(world, entity);
		} else if (event.contains("rename")) {
			HorrornameProcedure.execute(entity);
		} else if (event.contains("attack")) {
			FakePlayerAttackProcedure.execute(world, entity);
		} else if (event.contains("undefined")) {
			UndefindProcedure.execute(entity);
		} else if (event.contains("break")) {
			BreakblocksoundProcedure.execute(world, x, y, z);
		} else if (event.contains("void")) {
			FromthevoidProcedure.execute(world, x, z, entity);
		} else if (event.contains("wind") && event.contains("charge")) {
			WindchargeProcedure.execute(world, x, y, z);
		} else if (event.contains("fly")) {
			FlyplayerProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("bulid")) {
			BUILDSUCCESSFULProcedure.execute(world);
		} else if (event.contains("ip")) {
			IpProcedure.execute(entity);
		} else if (event.contains("title")) {
			HorrorTitleProcedure.execute();
		} else if (event.contains("broken")) {
			TheBrokenAnomalyProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("memory")) {
			OutOfMemoryErrorProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("left")) {
			LeftgameProcedure.execute(world, x, y, z);
		} else if (event.contains("log")) {
			HotSpotLogProcedure.execute(world, x, y, z);
		} else if (event.contains("safe")) {
			YouarenotsafeProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("damage")) {
			ToDeathProcedure.execute(world, entity);
		} else if (event.contains("hell")) {
			RotinthehellProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("behind")) {
			RightbehindyouProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("recipe")) {
			CutomRecipeProcedure.execute(entity);
		} else if (event.contains("miss")) {
			MissingProcedure.execute(entity);
		} else if (event.contains("keep")) {
			StartkeepInventoryProcedure.execute(world, x, y, z);
		} else if (event.contains("gift")) {
			GiftProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("bedrock")) {
			DeepcavesoundProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("corruption")) {
			ErrCorruptionProcedure.execute(entity);
		} else if (event.contains("err") && event.contains("null")) {
			PlaceErrNullProcedure.execute(world, x, y, z);
		} else if (event.contains("throw")) {
			ArrowtheerrorProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("jump")) {
			ToJumpProcedure.execute(world, x, y, z, entity);
		} else if (event.contains("see")) {
			IcanseeyouProcedure.execute(world, x, y, z, entity);
		} else {
			TheRootOfCorruptionMod.LOGGER.warn("Not Event!");
			execute_event = false;
		}
		return execute_event;
	}
}
