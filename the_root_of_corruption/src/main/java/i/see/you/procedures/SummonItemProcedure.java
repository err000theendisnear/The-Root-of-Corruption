package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class SummonItemProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		if (BoolArgumentType.getBool(arguments, "limitedlifetime")) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, (new Object() {
					public double getX() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getX();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getX()), (new Object() {
					public double getY() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getY();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getY()), (new Object() {
					public double getZ() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getZ();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getZ()), (ItemArgument.getItem(arguments, "item").getItem().getDefaultInstance()));
				entityToSpawn.setPickUpDelay((int) DoubleArgumentType.getDouble(arguments, "pickupdelay"));
				_level.addFreshEntity(entityToSpawn);
			}
		} else {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, (new Object() {
					public double getX() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getX();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getX()), (new Object() {
					public double getY() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getY();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getY()), (new Object() {
					public double getZ() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getZ();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getZ()), (ItemArgument.getItem(arguments, "item").getItem().getDefaultInstance()));
				entityToSpawn.setPickUpDelay((int) DoubleArgumentType.getDouble(arguments, "pickupdelay"));
				entityToSpawn.setUnlimitedLifetime();
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
