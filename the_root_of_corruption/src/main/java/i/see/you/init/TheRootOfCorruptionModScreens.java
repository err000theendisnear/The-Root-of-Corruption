
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package i.see.you.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import i.see.you.client.gui.OpcommandScreen;
import i.see.you.client.gui.MeomorydeathScreen;
import i.see.you.client.gui.GlitchGUIScreen;
import i.see.you.client.gui.BehindyouScreen;
import i.see.you.client.gui.AreYouPlayerScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheRootOfCorruptionModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(TheRootOfCorruptionModMenus.BEHINDYOU.get(), BehindyouScreen::new);
		event.register(TheRootOfCorruptionModMenus.MEOMORYDEATH.get(), MeomorydeathScreen::new);
		event.register(TheRootOfCorruptionModMenus.OPCOMMAND.get(), OpcommandScreen::new);
		event.register(TheRootOfCorruptionModMenus.GLITCH_GUI.get(), GlitchGUIScreen::new);
		event.register(TheRootOfCorruptionModMenus.ARE_YOU_PLAYER.get(), AreYouPlayerScreen::new);
	}
}
