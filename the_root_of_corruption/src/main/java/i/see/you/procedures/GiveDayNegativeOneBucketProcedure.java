package i.see.you.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import i.see.you.init.TheRootOfCorruptionModItems;

public class GiveDayNegativeOneBucketProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _player)
			_player.setGameMode(GameType.SURVIVAL);
		if (entity instanceof Player _player)
			_player.getFoodData().setFoodLevel(0);
		if (entity instanceof Player _player)
			_player.getFoodData().setSaturation(0);
		if (entity instanceof Player _plr3)
			_plr3.resetAttackStrengthTicker();
		if (entity instanceof Player _plr && _plr.isFallFlying()) {
			_plr.stopFallFlying();
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (entity instanceof Player _player) {
			ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("This is all your fault."), true);
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack = new ItemStack(TheRootOfCorruptionModItems.DAY_NEGATIVE_ONE_BUCKET.get()).copy();
			_setstack.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
	}
}
