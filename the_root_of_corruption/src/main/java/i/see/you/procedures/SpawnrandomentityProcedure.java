package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.TheRootOfCorruptionMod;

public class SpawnrandomentityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String type = "";
		if (0 == Mth.nextInt(RandomSource.create(), 0, 35) && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).isEmpty()) && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
				&& (entity.level().dimension()) == Level.OVERWORLD) {
			if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				type = "undefined_stare";
			} else if (Minecraft.getInstance().getFps() > 120 && 1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				type = "watchdog";
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 3)) {
				type = "server_owner";
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 3)) {
				type = "missing_one";
			} else if (0 == Mth.nextInt(RandomSource.create(), 0, 4) && TheRootOfCorruptionModVariables.MapVariables.get(world).look_player) {
				type = "custom_death_watch";
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				type = "base_0";
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				type = "invade_crash_report";
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				type = "glitch_code";
			} else if (0 == Mth.nextInt(RandomSource.create(), 0, 3)) {
				type = "soul";
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				type = "watcher";
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				type = "steve";
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				type = "random_cross";
			} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				type = "yourjavaisdie";
			} else if (0 == Mth.nextInt(RandomSource.create(), 0, 1)) {
				type = "invaild_creeper";
			}
			TheRootOfCorruptionMod.LOGGER.info(("Summon random entity : " + EntityToSpawnProcedure.execute(world, x, y, z, MobSpawnType.MOB_SUMMONED, "the_root_of_corruption:" + type)));
		}
		if (!entity.level().isClientSide())
			entity.discard();
	}
}
