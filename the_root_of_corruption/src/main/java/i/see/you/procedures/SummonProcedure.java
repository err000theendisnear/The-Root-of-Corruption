package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class SummonProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		String a = "";
		if (BoolArgumentType.getBool(arguments, "visualonly")) {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(new Object() {
					public double getX() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getX();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getX(), new Object() {
					public double getY() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getY();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getY(), new Object() {
					public double getZ() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getZ();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getZ())));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		} else {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(new Object() {
					public double getX() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getX();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getX(), new Object() {
					public double getY() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getY();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getY(), new Object() {
					public double getZ() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getZ();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getZ())));;
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
