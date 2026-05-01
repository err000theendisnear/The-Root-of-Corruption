package i.see.you.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import i.see.you.network.TheRootOfCorruptionModVariables;
import i.see.you.TheRootOfCorruptionMod;

public class BehindYouOverlayProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		TheRootOfCorruptionModVariables.MapVariables.get(world).screen_phase = 0;
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = true;
		TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
		TheRootOfCorruptionMod.queueServerWork(20, () -> {
			TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = false;
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
			TheRootOfCorruptionModVariables.MapVariables.get(world).screen_phase = TheRootOfCorruptionModVariables.MapVariables.get(world).screen_phase + 1;
			TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
			TheRootOfCorruptionMod.queueServerWork(20, () -> {
				TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = true;
				TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
				TheRootOfCorruptionMod.queueServerWork(20, () -> {
					TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = false;
					TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
					TheRootOfCorruptionModVariables.MapVariables.get(world).screen_phase = TheRootOfCorruptionModVariables.MapVariables.get(world).screen_phase + 1;
					TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
					TheRootOfCorruptionMod.queueServerWork(20, () -> {
						TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = true;
						TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
						TheRootOfCorruptionMod.queueServerWork(20, () -> {
							TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = false;
							TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
							TheRootOfCorruptionModVariables.MapVariables.get(world).screen_phase = TheRootOfCorruptionModVariables.MapVariables.get(world).screen_phase + 1;
							TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
							TheRootOfCorruptionMod.queueServerWork(20, () -> {
								TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = true;
								TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
								TheRootOfCorruptionMod.queueServerWork(20, () -> {
									TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = false;
									TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
									TheRootOfCorruptionMod.queueServerWork(20, () -> {
										TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = true;
										TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
										TheRootOfCorruptionMod.queueServerWork(20, () -> {
											TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = false;
											TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
											TheRootOfCorruptionModVariables.MapVariables.get(world).screen_phase = TheRootOfCorruptionModVariables.MapVariables.get(world).screen_phase + 1;
											TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
											TheRootOfCorruptionMod.queueServerWork(20, () -> {
												TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = true;
												TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
												TheRootOfCorruptionMod.queueServerWork(20, () -> {
													TheRootOfCorruptionModVariables.MapVariables.get(world).tovoid = false;
													TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
													TheRootOfCorruptionModVariables.MapVariables.get(world).screen_phase = 1;
													TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
													TheRootOfCorruptionMod.queueServerWork(20, () -> {
														TheRootOfCorruptionModVariables.MapVariables.get(world).screen_phase = 0;
														TheRootOfCorruptionModVariables.MapVariables.get(world).syncData(world);
														if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 1));
														if (world instanceof ServerLevel _level) {
															LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
															entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
															_level.addFreshEntity(entityToSpawn);
														}
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			});
		});
	}
}
