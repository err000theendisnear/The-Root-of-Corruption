
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import i.see.you.client.renderer.YourjavaisdieRenderer;
import i.see.you.client.renderer.YourjavaisdieChaseRenderer;
import i.see.you.client.renderer.WatcherRenderer;
import i.see.you.client.renderer.UndefinedleftthegameRenderer;
import i.see.you.client.renderer.UndefinedOnSurfaceRenderer;
import i.see.you.client.renderer.UndefinedBossRenderer;
import i.see.you.client.renderer.UndefindstareRenderer;
import i.see.you.client.renderer.UndefindchaseRenderer;
import i.see.you.client.renderer.TamedBase0Renderer;
import i.see.you.client.renderer.SteveRenderer;
import i.see.you.client.renderer.SoulRenderer;
import i.see.you.client.renderer.RandomCrossRenderer;
import i.see.you.client.renderer.MinecraftRootRenderer;
import i.see.you.client.renderer.LostMemoryRenderer;
import i.see.you.client.renderer.InvalidCreeperRenderer;
import i.see.you.client.renderer.InvadeCrashreportRenderer;
import i.see.you.client.renderer.GlitchCodeRenderer;
import i.see.you.client.renderer.GameCrashRenderer;
import i.see.you.client.renderer.ForgottenPlayerRenderer;
import i.see.you.client.renderer.EntitySpawnerRenderer;
import i.see.you.client.renderer.CustomDeathWatchRenderer;
import i.see.you.client.renderer.CustomDeathRenderer;
import i.see.you.client.renderer.BedrockStalkerRenderer;
import i.see.you.client.renderer.Base0Renderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheRootOfCorruptionModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.UNDEFINDCHASE.get(), UndefindchaseRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.UNDEFINDSTARE.get(), UndefindstareRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.YOURJAVAISDIE.get(), YourjavaisdieRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.YOURJAVAISDIE_CHASE.get(), YourjavaisdieChaseRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.ENTITY_SPAWNER.get(), EntitySpawnerRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.BEDROCK_STALKER.get(), BedrockStalkerRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.UNDEFINED_ON_SURFACE.get(), UndefinedOnSurfaceRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.UNDEFINEDLEFTTHEGAME.get(), UndefinedleftthegameRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.RANDOM_CROSS.get(), RandomCrossRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.ERR.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.FORGOTTEN_PLAYER.get(), ForgottenPlayerRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.GLITCH_CODE.get(), GlitchCodeRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.BROKEN_ERR.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.LOST_MEMORY.get(), LostMemoryRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.BASE_0.get(), Base0Renderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.STEVE.get(), SteveRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.WATCHER.get(), WatcherRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.INVALID_CREEPER.get(), InvalidCreeperRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.INVADE_CRASHREPORT.get(), InvadeCrashreportRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.UNDEFINED_BOSS.get(), UndefinedBossRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.TAMED_BASE_0.get(), TamedBase0Renderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.MINECRAFT_ROOT.get(), MinecraftRootRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.CLEARBOMB.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.CUSTOM_DEATH.get(), CustomDeathRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.CUSTOM_DEATH_WATCH.get(), CustomDeathWatchRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.SOUL.get(), SoulRenderer::new);
		event.registerEntityRenderer(TheRootOfCorruptionModEntities.GAME_CRASH.get(), GameCrashRenderer::new);
	}
}
