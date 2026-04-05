package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import i.see.you.init.TheRootOfCorruptionModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

@EventBusSubscriber
public class TotemProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}
	public static void execute(LivingDeathEvent event, Entity entity) {
		LevelAccessor world = entity.level();
		if (AllMissnoAromrProcedure.execute(entity)) {
			if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem())
				|| entity instanceof Player _plrCldCheck3 && _plrCldCheck3.getCooldowns().isOnCooldown((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem())
				|| entity instanceof Player _plrCldCheck5 && _plrCldCheck5.getCooldowns().isOnCooldown((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem())
				|| entity instanceof Player _plrCldCheck7 && _plrCldCheck7.getCooldowns().isOnCooldown((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()))) {
				if (entity instanceof Player _player) {
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem(), 1000);
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem(), 1000);
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem(), 1000);
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem(), 1000);
				}
				if (world instanceof ServerLevel _level) {
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).hurtAndBreak(500, _level, null, _stkprov -> {
					});
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).hurtAndBreak(500, _level, null, _stkprov -> {
					});
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).hurtAndBreak(500, _level, null, _stkprov -> {
					});
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).hurtAndBreak(500, _level, null, _stkprov -> {
					});
				}
				UsetotemProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
				event.setCanceled(true);
				if (entity instanceof LivingEntity _ent0) {
					_ent0.setHealth(5.0f);
				}
			}
		} else if (AllNotextureProcedure.execute(entity) && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.BEDROCK.asItem()) {
			UsetotemProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
			event.setCanceled(true);
			if (entity instanceof LivingEntity _entity1) {
				_entity1.setHealth(5.0f);
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(TheRootOfCorruptionModItems.ITEM_IS_MISSING_ID.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
	}
}
