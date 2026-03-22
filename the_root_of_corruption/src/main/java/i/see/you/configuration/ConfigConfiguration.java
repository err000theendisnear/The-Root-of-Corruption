package i.see.you.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<Boolean> BAN;
	public static final ModConfigSpec.ConfigValue<Boolean> CRASH;
	static {
		BUILDER.push("game");
		BAN = BUILDER.comment("是否封禁玩家").define("ban", true);
		CRASH = BUILDER.comment("是否崩溃").define("crash", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
