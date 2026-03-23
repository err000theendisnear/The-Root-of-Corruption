package i.see.you.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.ArrayList;

import i.see.you.init.TheRootOfCorruptionModParticleTypes;
import i.see.you.init.TheRootOfCorruptionModBlocks;
import i.see.you.TheRootOfCorruptionMod;

public class UndefinedEndgameProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:the_end_is_undefined")), SoundSource.PLAYERS, 1000, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:the_end_is_undefined")), SoundSource.PLAYERS, 1000, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:glitch")), SoundSource.PLAYERS, 1000, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:glitch")), SoundSource.PLAYERS, 1000, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:goaway")), SoundSource.PLAYERS, 1000, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:goaway")), SoundSource.PLAYERS, 1000, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:void")), SoundSource.PLAYERS, 1000, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:void")), SoundSource.PLAYERS, 1000, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:chase")), SoundSource.PLAYERS, 1000, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:chase")), SoundSource.PLAYERS, 1000, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:jumpscare")), SoundSource.PLAYERS, 1000, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("the_root_of_corruption:jumpscare")), SoundSource.PLAYERS, 1000, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.PLAYERS, 1000, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.PLAYERS, 1000, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.resonate")), SoundSource.PLAYERS, 1000, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.resonate")), SoundSource.PLAYERS, 1000, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheRootOfCorruptionModParticleTypes.ERROR.get()), x, y, z, 2, 1, 1, 1, 1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SOUL, x, y, z, 2, 1, 1, 1, 1);
		if (world instanceof ServerLevel _level) {
			LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
			entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
			entityToSpawn.setVisualOnly(true);
			_level.addFreshEntity(entityToSpawn);
		}
		world.getLevelData().setRaining(true);
		world.setBlock(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -16, 16), y + Mth.nextInt(RandomSource.create(), -16, 16), z + Mth.nextInt(RandomSource.create(), -16, 16)),
				TheRootOfCorruptionModBlocks.TEXTURELESS.get().defaultBlockState(), 3);
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A7e" + (Component.translatable("multiplayer.player.left").getString()).replace("%s", entityiterator.getDisplayName().getString()))), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(((Component.translatable("multiplayer.player.left").getString()).replace("%s", "\u00A7e\u00A7kundefined\u00A7r\u00A7e"))), false);
			if (entityiterator instanceof LivingEntity _entity)
				_entity.stopUsingItem();
			if (entityiterator.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx);
					itemstackiterator.set(DataComponents.CUSTOM_NAME, Component.literal("undefined"));
					EnchantmentHelper.updateEnchantments(itemstackiterator,
							mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING))));
					EnchantmentHelper.updateEnchantments(itemstackiterator,
							mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING))));
					if (world instanceof ServerLevel _level) {
						itemstackiterator.hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
					itemstackiterator.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), 1);
					itemstackiterator.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), 1);
					if (entityiterator instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstackiterator.getItem(), 2147483647);
				}
			}
			if (entityiterator instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 255));
			if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 255));
			if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 255));
			if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 255));
			entityiterator.stopRiding();
			entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
			entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			if (entityiterator instanceof Player _player)
				_player.closeContainer();
			if (entityiterator instanceof Player _player) {
				_player.getAbilities().mayBuild = false;
				_player.onUpdateAbilities();
			}
			if (entityiterator instanceof Player _player)
				_player.getFoodData().setFoodLevel(0);
			if (entityiterator instanceof Player _player)
				_player.getFoodData().setSaturation(0);
			entityiterator.setAirSupply(0);
			entityiterator.setTicksFrozen(1000);
			entityiterator.igniteForSeconds(15);
			entityiterator.setCustomName(Component.literal("err"));
			entityiterator.push((Mth.nextDouble(RandomSource.create(), 1, -1)), (Mth.nextDouble(RandomSource.create(), 1, -1)), (Mth.nextDouble(RandomSource.create(), 1, -1)));
			if (entityiterator instanceof Player _plr59)
				_plr59.resetAttackStrengthTicker();
			if (entityiterator instanceof Player _player) {
				_player.getAbilities().flying = false;
				_player.onUpdateAbilities();
			}
			if (entityiterator instanceof Player _plr)
				_plr.jumpFromGround();
			if (entityiterator instanceof Player _plr && _plr.isFallFlying()) {
				_plr.stopFallFlying();
			}
			if (entityiterator instanceof Player _player)
				_player.giveExperiencePoints(-(10000));
			if (entityiterator instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7e" + (Component.translatable("multiplayer.player.left").getString()).replace("%s", "null"))), false);
			if (entityiterator instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("null"), true);
			TheRootOfCorruptionMod.LOGGER.fatal("undefined");
			TheRootOfCorruptionMod.LOGGER.error("null");
			TheRootOfCorruptionMod.LOGGER.info("hello");
			TheRootOfCorruptionMod.LOGGER.warn("this is all you fault");
			TheRootOfCorruptionMod.LOGGER.debug((entityiterator.getDisplayName().getString()));
			TheRootOfCorruptionMod.queueServerWork(85, () -> {
				entityiterator.kill();
				TheRootOfCorruptionMod.queueServerWork(15, () -> {
				});
			});
		}
	}
}
