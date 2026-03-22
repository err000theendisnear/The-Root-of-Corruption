package i.see.you.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

import i.see.you.init.TheRootOfCorruptionModBlocks;

@EventBusSubscriber
public class GodtickupdateProcedure {
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
		Entity target = null;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:god")))) {
			if (!((entity.level().dimension()) == Level.OVERWORLD)) {
				DiscardProcedure.execute(entity);
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() instanceof LiquidBlock) {
				world.setBlock(BlockPos.containing(x, y, z), TheRootOfCorruptionModBlocks.GLOWINGOBSIDIAN.get().defaultBlockState(), 3);
				{
					Entity _ent = entity;
					_ent.teleportTo(x, (y + 1), z);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(x, (y + 1), z, _ent.getYRot(), _ent.getXRot());
				}
			}
			if (!((entity.getVehicle()) == null)) {
				if (!(entity.getVehicle()).level().isClientSide())
					(entity.getVehicle()).discard();
			}
			target = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
			if (!(target == null)) {
				if (target instanceof Player _plr16)
					_plr16.resetAttackStrengthTicker();
				if (target instanceof Player _plr && _plr.isFallFlying()) {
					_plr.stopFallFlying();
				}
				if (target.isUnderWater() && target.getY() < y) {
					world.setBlock(BlockPos.containing(target.getX(), target.getY(), target.getZ()), Blocks.SPONGE.defaultBlockState(), 3);
					if (world instanceof Level _level)
						_level.updateNeighborsAt(BlockPos.containing(target.getX(), target.getY(), target.getZ()), _level.getBlockState(BlockPos.containing(target.getX(), target.getY(), target.getZ())).getBlock());
					world.setBlock(BlockPos.containing(target.getX(), target.getY(), target.getZ()), Blocks.AIR.defaultBlockState(), 3);
					if (!world.isEmptyBlock(BlockPos.containing(target.getX(), target.getY() + 2, target.getZ()))) {
						world.setBlock(BlockPos.containing(target.getX(), target.getY() + 2, target.getZ()), Blocks.AIR.defaultBlockState(), 3);
					}
					target.push(0, 1, 0);
				}
				if (target instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Items.TOTEM_OF_UNDYING);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (target instanceof Player _player) {
					_player.getAbilities().flying = false;
					_player.onUpdateAbilities();
				}
				if (target instanceof Player _player)
					_player.getFoodData().setSaturation(0);
				if (target instanceof Player _player)
					_player.getFoodData().setFoodLevel(0);
				if (target instanceof LivingEntity _entity)
					_entity.stopUsingItem();
				target.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
				target.igniteForSeconds(1);
				target.setSprinting(false);
				if (target instanceof LivingEntity _entity)
					_entity.removeAllEffects();
				if (target instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1, 255));
				if (target instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1, 255));
				if (target instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 1, 255));
				if (target instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1, 255));
				if (target instanceof Player _player)
					_player.closeContainer();
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((entityiterator instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == target) {
							entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((target.getX()), (target.getY()), (target.getZ())));
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC_KILL)), 2147483647);
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), 2147483647);
							if (entityiterator instanceof LivingEntity _livingEntity65 && _livingEntity65.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
								_livingEntity65.getAttribute(Attributes.MAX_HEALTH).setBaseValue(0);
							if (entityiterator instanceof LivingEntity _entity)
								_entity.setHealth(0);
							entityiterator.kill();
						} else {
							if (entityiterator instanceof LivingEntity) {
								if (entityiterator instanceof Mob _entity && target instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
							} else {
								if (!entityiterator.level().isClientSide())
									entityiterator.discard();
							}
						}
					}
				}
				if (y < -59) {
					entity.fallDistance = 0;
					{
						Entity _ent = entity;
						_ent.teleportTo((target.getX()), (target.getY()), (target.getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((target.getX()), (target.getY()), (target.getZ()), _ent.getYRot(), _ent.getXRot());
					}
				}
			}
		}
	}
}
