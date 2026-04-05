package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import com.mojang.brigadier.context.CommandContext;
import java.lang.Exception;
import net.minecraft.nbt.CompoundTag;
import i.see.you.TheRootOfCorruptionMod;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

public class CloneEntityProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		try {
			TheRootOfCorruptionMod.LOGGER.info("clone entity : " + cloneEntity(world, arguments));
		} catch (Exception e) {
			Exception _err = null;
			Entity _ent = null;
			try {
				_ent = EntityArgument.getEntity(arguments, "entity");
			} catch (Exception err) {
				_err = err;
			}
			if (_ent == null && _err != null) {
				TheRootOfCorruptionMod.LOGGER.info("failed to clone entity. " + _err + " raw exception : " + e);
			} else {
				TheRootOfCorruptionMod.LOGGER.info("failed to clone entity. " + e + " raw entity : " + _ent);
			}
		}
	}

	private static Entity cloneEntity(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = null;
			Entity ent = null;
			BlockPos _bp = BlockPos.containing(0, 0, 0);
			try {
				ent = EntityArgument.getEntity(arguments, "entity");
				_bp = BlockPosArgument.getLoadedBlockPos(arguments, "pos");
			} catch (CommandSyntaxException e) {
				e.printStackTrace();
				return null;
			}
			entityToSpawn = ent.getType().spawn(_level, _bp, MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				CompoundTag nbtdata = ent.saveWithoutId(new CompoundTag());
				entityToSpawn.load(nbtdata);
				entityToSpawn.setPos(_bp.getX(), _bp.getY(), _bp.getZ());
			}
			return entityToSpawn;
		}
		return null;
	}
}
