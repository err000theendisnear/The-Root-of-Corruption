package i.see.you.procedures;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class LookentityProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return false;
		double x2 = 0;
		double y2 = 0;
		double z2 = 0;
		double y1 = 0;
		double dx = 0;
		double dy = 0;
		double dz = 0;
		double step = 0;
		double steps = 0;
		double distance = 0;
		double cx = 0;
		double cy = 0;
		double cz = 0;
		x2 = sourceentity.getX();
		y2 = sourceentity.getY();
		z2 = sourceentity.getZ();
		y1 = y + entity.getEyeHeight();
		dx = x2 - x;
		dy = y2 - y1;
		dz = z2 - z;
		distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));
		step = 0.1;
		steps = Math.round(distance / step);
		cx = x;
		cy = y1;
		cz = z;
		for (int index0 = 0; index0 < (int) steps; index0++) {
			if (!((world.getBlockState(BlockPos.containing(cx, cy, cz))).getBlock() instanceof LiquidBlock || world.isEmptyBlock(BlockPos.containing(cx, cy, cz)))) {
				return false;
			}
			cx = cx + entity.getLookAngle().x * step;
			cy = cy + entity.getLookAngle().y * step;
			cz = cz + entity.getLookAngle().z * step;
			if (Math.floor(cx) == Math.floor(x2) && Math.floor(cy) == Math.floor(y2) && Math.floor(cz) == Math.floor(z2)) {
				return true;
			}
		}
		return false;
	}
}
