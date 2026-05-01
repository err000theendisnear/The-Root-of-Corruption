package i.see.you.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import i.see.you.init.TheRootOfCorruptionModItems;
import i.see.you.init.TheRootOfCorruptionModEntities;
import i.see.you.entity.ErrEntity;

public class ArrowtheerrorProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(TheRootOfCorruptionModItems.ITEM_IS_MISSING_ID.get()).copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
					AbstractArrow entityToSpawn = new ErrEntity(TheRootOfCorruptionModEntities.ERR.get(), level) {
						@Override
						public byte getPierceLevel() {
							return piercing;
						}

						@Override
						protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
							if (knockback > 0) {
								double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
								Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
								if (vec3.lengthSqr() > 0.0) {
									livingEntity.push(vec3.x, 0.1, vec3.z);
								}
							}
						}
					};
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setSilent(true);
					entityToSpawn.igniteForSeconds(100);
					entityToSpawn.setCritArrow(true);
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, 666, 10, (byte) 10);
			_entityToSpawn.setPos(x, (y + 2), z);
			_entityToSpawn.shoot(0, (-1), 0, 2, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("throw new Error();"), false);
	}
}
