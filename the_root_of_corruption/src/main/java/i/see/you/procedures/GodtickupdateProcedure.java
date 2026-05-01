package i.see.you.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

import i.see.you.init.TheRootOfCorruptionModBlocks;
import i.see.you.configuration.ConfigConfiguration;

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
		boolean remove = false;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:god")))) {
			if (ConfigConfiguration.BREAKBLOCK.get()) {
				if (!world.isEmptyBlock(BlockPos.containing(x, y, z))) {
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId((world.getBlockState(BlockPos.containing(x, y, z)))));
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (!world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
					world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId((world.getBlockState(BlockPos.containing(x, y + 1, z)))));
					{
						BlockPos _pos = BlockPos.containing(x, y + 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 1, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			entity.setInvulnerable(true);
			if (entity instanceof LivingEntity _entity) {
				AttributeInstance _attrInst = _entity.getAttribute(Attributes.STEP_HEIGHT);
				if (_attrInst != null)
					_attrInst.setBaseValue(256);
			}
			RemoveHarmfulEffectProcedure.execute(entity);
			if (!((entity.level().dimension()) == Level.OVERWORLD || ConfigConfiguration.SPAWN_ENTITY.get())) {
				DiscardProcedure.execute(entity);
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
			if (ConfigConfiguration.REPLACE_TO_GLOWING_OBSIDIAN.get() && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() instanceof LiquidBlock) {
				for (int index0 = 0; index0 < 5; index0++) {
					for (int index1 = 0; index1 < 5; index1++) {
						world.setBlock(BlockPos.containing(x - 2 + index0, y - 1, z - 2 + index1), TheRootOfCorruptionModBlocks.GLOWINGOBSIDIAN.get().defaultBlockState(), 3);
					}
				}
			}
			if (entity.isPassenger()) {
				DiscardProcedure.execute(entity.getVehicle());
			}
			target = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
			if (!(target == null)) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((target.getX()), (target.getY()), (target.getZ()), 1);
				if (target instanceof ServerPlayer _player)
					_player.setGameMode(GameType.SURVIVAL);
				if (target instanceof Player _plr30)
					_plr30.resetAttackStrengthTicker();
				if (target instanceof Player _plr && _plr.isFallFlying()) {
					_plr.stopFallFlying();
				}
				if ((world.getBlockState(BlockPos.containing(target.getX(), target.getY(), target.getZ()))).getBlock() instanceof LiquidBlock && target.getY() < y) {
					world.setBlock(BlockPos.containing(target.getX(), target.getY(), target.getZ()), Blocks.SPONGE.defaultBlockState(), 3);
					if (world instanceof Level _level)
						_level.updateNeighborsAt(BlockPos.containing(target.getX(), target.getY(), target.getZ()), _level.getBlockState(BlockPos.containing(target.getX(), target.getY(), target.getZ())).getBlock());
					world.setBlock(BlockPos.containing(target.getX(), target.getY(), target.getZ()), Blocks.AIR.defaultBlockState(), 3);
					if (!world.isEmptyBlock(BlockPos.containing(target.getX(), target.getY() + 2, target.getZ())) && ConfigConfiguration.BREAKBLOCK.get()) {
						world.setBlock(BlockPos.containing(target.getX(), target.getY() + 2, target.getZ()), Blocks.AIR.defaultBlockState(), 3);
					}
					target.push(0, 10, 0);
				}
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(target.getX(), target.getY(), target.getZ())));
					entityToSpawn.setVisualOnly(true);
					_level.addFreshEntity(entityToSpawn);
				}
				if (target instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Items.TOTEM_OF_UNDYING);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1000, _player.inventoryMenu.getCraftSlots());
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
				target.igniteForSeconds(100);
				target.setSprinting(false);
				if (target instanceof LivingEntity _entity)
					_entity.removeAllEffects();
				if (target instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 10000, 255));
				if (target instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 10000, 255));
				if (target instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 10000, 255));
				if (target instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10000, 255));
				if (target instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 255));
				if (target instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 10000, 255));
				if (target instanceof Player _player)
					_player.closeContainer();
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((entityiterator instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == target) {
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeAllEffects();
							entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((target.getX()), (target.getY()), (target.getZ())));
							KillentityProcedure.execute(world, entityiterator);
							/*孩子们看我肘飞梦云水晶锚定核心魂之书混沌之书女仆，还顺便把墓碑也肘飞了*/
						} else {
							if (entityiterator instanceof LivingEntity) {
								if (entityiterator instanceof Mob _entity && target instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
							} else {
								remove = true;
								for (String stringiterator : ConfigConfiguration.REMOVE_TECHNICAL_ENTITY_BLACKLIST.get()) {
									if ((BuiltInRegistries.ENTITY_TYPE.getKey(entityiterator.getType()).toString()).equals(stringiterator)) {
										remove = false;
										break;
									}
								}
								if (remove) {
									DiscardProcedure.execute(entityiterator);
								}
							}
						}
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.VOID_AIR) {
					entity.fallDistance = 0;
					{
						Entity _ent = entity;
						_ent.teleportTo((target.getX()), (target.getY()), (target.getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((target.getX()), (target.getY()), (target.getZ()), _ent.getYRot(), _ent.getXRot());
					}
					entity.push(0, 5, 0);
				}
			}
		}
	}
}
