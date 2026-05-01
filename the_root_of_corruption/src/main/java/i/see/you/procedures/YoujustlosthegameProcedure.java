package i.see.you.procedures;

import i.see.you.configuration.ConfigConfiguration;

public class YoujustlosthegameProcedure {
	public static void execute() {
		if (ConfigConfiguration.CRASH.get()) {
			com.mojang.blaze3d.Blaze3D.youJustLostTheGame();
		}
	}
}
