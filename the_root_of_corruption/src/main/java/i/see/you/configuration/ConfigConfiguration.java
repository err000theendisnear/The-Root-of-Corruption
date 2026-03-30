package i.see.you.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<Boolean> BAN;
	public static final ModConfigSpec.ConfigValue<Boolean> CRASH;
	public static final ModConfigSpec.ConfigValue<Double> EVENT_INTERVAL;
	public static final ModConfigSpec.ConfigValue<Double> UNDEFINED_DAMAGECAP;
	public static final ModConfigSpec.ConfigValue<Double> MISSING_DAMAGECAP;
	public static final ModConfigSpec.ConfigValue<Boolean> SPAWN_ENTITY;
	public static final ModConfigSpec.ConfigValue<Boolean> REPLACE_TO_GLOWING_OBSIDIAN;
	static {
		BUILDER.push("game");
		BAN = BUILDER.comment("是否封禁玩家 Whether to ban the player").define("ban", true);
		CRASH = BUILDER.comment("是否崩溃 Whether it has crashed").define("crash", true);
		BUILDER.pop();
		BUILDER.push("event");
		EVENT_INTERVAL = BUILDER.comment("事件发生的间隔 The interval at the time of the event").define("event_interval", (double) 10000);
		BUILDER.pop();
		BUILDER.push("entity");
		UNDEFINED_DAMAGECAP = BUILDER.comment("Undefined Boss的限伤 The maximum damage the Undefined Boss can receive").define("undefined_damagecap", (double) 10000);
		MISSING_DAMAGECAP = BUILDER.comment("穿戴Missing盔甲的玩家最大可以受到的伤害 The maximum damage that a player wearing missing armor can receive").define("missing_damagecap", (double) 10000);
		SPAWN_ENTITY = BUILDER.comment("是否允许实体生成 Is entity spawn allowed").define("spawn_entity", true);
		REPLACE_TO_GLOWING_OBSIDIAN = BUILDER.comment("是否允许实体替换水为发光的黑曜石 Is entity replace water to glowing obsidian allowed").define("replace_to_glowing_obsidian", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
