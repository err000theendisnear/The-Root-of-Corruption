package i.see.you.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;

@EventBusSubscriber
public class NotextureAromrProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() == null) {
			return;
		}
		Entity entity = event.getEntity();
		LevelAccessor world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		DamageSource damagesource = event.getSource();
		Entity immediatesourceentity = event.getSource().getDirectEntity();
		Entity sourceentity = event.getSource().getEntity();
		if (sourceentity == entity || immediatesourceentity == entity) {
			return;
		}
		double amount = event.getAmount();
		if ((AllNotextureProcedure.execute(entity) || AllMissnoAromrProcedure.execute(entity)) && entity instanceof Player) {
			if (!(immediatesourceentity instanceof LivingEntity) && immediatesourceentity != null) {
				if (!immediatesourceentity.level().isClientSide())
					immediatesourceentity.discard();
			}
			if (sourceentity != null && !sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:god")))) {
				sourceentity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("the_root_of_corruption:null_pointer_damage"))), null, null), (float) (amount / 2));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.MUSIC, 1000, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.MUSIC, 1000, 1, false);
					}
				}
			}
			if (AllMissnoAromrProcedure.execute(entity)) {
				if (!(damagesource.is(DamageTypes.GENERIC_KILL) || damagesource.is(DamageTypes.PLAYER_ATTACK) || damagesource.is(DamageTypes.GENERIC) || damagesource.is(DamageTypes.MOB_ATTACK) || damagesource.is(DamageTypes.MOB_ATTACK_NO_AGGRO)
					|| damagesource.is(DamageTypes.FELL_OUT_OF_WORLD) || damagesource.is(DamageTypes.FALLING_BLOCK) || damagesource.is(DamageTypes.IN_WALL)
					|| damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("the_root_of_corruption:null_pointer_damage"))))) {
					event.setCanceled(true);
				}				
			} else {
				if (damagesource.is(DamageTypes.WITHER) || damagesource.is(DamageTypes.LAVA) || damagesource.is(DamageTypes.IN_FIRE) || damagesource.is(DamageTypes.LIGHTNING_BOLT) || damagesource.is(DamageTypes.MOB_PROJECTILE)
					|| damagesource.is(DamageTypes.FALL) || damagesource.is(DamageTypes.EXPLOSION) || damagesource.is(DamageTypes.ARROW)) {
					event.setCanceled(true);
				}
			}
		}
	}
}
