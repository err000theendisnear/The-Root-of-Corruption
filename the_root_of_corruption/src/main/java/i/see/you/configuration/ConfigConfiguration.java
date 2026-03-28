package i.see.you.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<Boolean> BAN;
	public static final ModConfigSpec.ConfigValue<Boolean> CRASH;
	public static final ModConfigSpec.ConfigValue<Double> EVENT_INTERVAL;
	public static final ModConfigSpec.ConfigValue<Boolean> RUN_EXE;
	static {
		BUILDER.push("game");
		BAN = BUILDER.comment("是否封禁玩家 Whether to ban the player").define("ban", true);
		CRASH = BUILDER.comment("是否崩溃 Whether it has crashed").define("crash", true);
		EVENT_INTERVAL = BUILDER.comment("事件发生的间隔 The interval at the time of the event").define("event_interval", (double) 100000);
		RUN_EXE = BUILDER.comment("是否允许运行exe文件 Whether to allow running exe files").define("run_exe", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
