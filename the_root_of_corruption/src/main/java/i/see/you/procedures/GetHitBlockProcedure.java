package i.see.you.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.ClipContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class GetHitBlockProcedure {
	public static BlockPos execute(Entity entity, double maxDistance) {
		BlockPos empty = new BlockPos(0, 0, 0);
		if (entity == null)
			return empty;
		if (entity instanceof Player player) {
			ClipContext context = new ClipContext(
        		player.getEyePosition(),
        		player.getEyePosition().add(player.getLookAngle().scale(maxDistance)),
        		ClipContext.Block.COLLIDER,
        		ClipContext.Fluid.NONE,
        		player
    		);
    		BlockHitResult hitResult = player.level().clip(context);
    		if (hitResult.getType() == HitResult.Type.BLOCK) {
        		return hitResult.getBlockPos();
			}
		}  
		return empty;
	}
}
