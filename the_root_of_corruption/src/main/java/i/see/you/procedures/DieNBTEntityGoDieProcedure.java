package i.see.you.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import i.see.you.init.TheRootOfCorruptionModItems;

@EventBusSubscriber
public class DieNBTEntityGoDieProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("die") && !(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TheRootOfCorruptionModItems.ARTIFACT.get())) : false)) {
			entity.getPersistentData().putBoolean("Invulnerable", false);
			entity.setInvulnerable(false);
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.ADVENTURE);
			if (entity instanceof TamableAnimal _ent) {
				_ent.setTame(false, false);
			}
			entity.invulnerableTime = 1;
			if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity6.getAttribute(Attributes.MAX_HEALTH).setBaseValue(0);
			if (entity instanceof Player _player)
				_player.getInventory().clearContent();
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), 114514);
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), 676767);
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("the_root_of_corruption:null_pointer_damage")))), 1919810);
			for (Object arraylistiterator : InventoryHelperProcedure.execute(world, entity, false)) {
				(arraylistiterator instanceof ItemStack _stack15 ? _stack15 : ItemStack.EMPTY).setCount(0);
			}
			entity.igniteForSeconds(15);
			if (Math.random() < Math.random()) {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (entity instanceof Player _player) {
				_player.getAbilities().mayBuild = false;
				_player.onUpdateAbilities();
			}
			if (entity instanceof Player _player) {
				_player.getAbilities().flying = false;
				_player.onUpdateAbilities();
			}
			if (entity instanceof Player _player)
				_player.getFoodData().setSaturation(0);
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(0);
			if (entity instanceof Player _plr24)
				_plr24.resetAttackStrengthTicker();
			if (entity instanceof Player _plr && _plr.isFallFlying()) {
				_plr.stopFallFlying();
			}
			if (entity instanceof Player _player) {
				_player.getAbilities().invulnerable = true;
				_player.onUpdateAbilities();
			}
			KillentityProcedure.execute(world, entity);
		}
	}
}
