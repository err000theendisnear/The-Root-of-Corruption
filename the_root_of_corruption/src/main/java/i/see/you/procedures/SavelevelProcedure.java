package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;

public class SavelevelProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		SaveworldProcedure.execute(world, x, y, z, entity, 16);
		if (world instanceof ServerLevel _level) {
			itemstack.hurtAndBreak(Mth.nextInt(RandomSource.create(), 3, 10), _level, null, _stkprov -> {
			});
		}
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("the_root_of_corruption:ajgaqgjsgh")));
	}
}
