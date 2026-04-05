package i.see.you.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<Boolean> BAN;
	public static final ModConfigSpec.ConfigValue<Boolean> CRASH;
	public static final ModConfigSpec.ConfigValue<Boolean> ALWAYS_ONLINE;
	public static final ModConfigSpec.ConfigValue<Double> EVENT_INTERVAL;
	public static final ModConfigSpec.ConfigValue<Double> UNDEFINED_DAMAGECAP;
	public static final ModConfigSpec.ConfigValue<Double> MISSING_DAMAGECAP;
	public static final ModConfigSpec.ConfigValue<Boolean> SPAWN_ENTITY;
	public static final ModConfigSpec.ConfigValue<Boolean> REPLACE_TO_GLOWING_OBSIDIAN;
	public static final ModConfigSpec.ConfigValue<Boolean> BREAKBLOCK;
	public static final ModConfigSpec.ConfigValue<Double> WATCHDOG_CRASHTIME;
	static {
		BUILDER.push("game");
		BAN = BUILDER.comment("是否封禁玩家 Whether to ban the player").define("ban", true);
		CRASH = BUILDER.comment("是否崩溃 Whether it has crashed").define("crash", true);
		ALWAYS_ONLINE = BUILDER.comment("是否将你视为拥有正版账号的玩家，即使你是离线账号玩家 Whether to consider you as an Online player, even if you are an Offline player").define("always_online", false);
		BUILDER.pop();
		BUILDER.push("event");
		EVENT_INTERVAL = BUILDER.comment("事件发生的间隔 The interval at the time of the event").define("event_interval", (double) 10000);
		BUILDER.pop();
		BUILDER.push("entity");
		UNDEFINED_DAMAGECAP = BUILDER.comment("Undefined Boss的限伤 The maximum damage the Undefined Boss can receive").define("undefined_damagecap", (double) 10000);
		MISSING_DAMAGECAP = BUILDER.comment("穿戴Missing盔甲的玩家最大可以受到的伤害 The maximum damage that a player wearing missing armor can receive").define("missing_damagecap", (double) 10000);
		SPAWN_ENTITY = BUILDER.comment("是否允许实体生成 Is entity spawn allowed").define("spawn_entity", true);
		REPLACE_TO_GLOWING_OBSIDIAN = BUILDER.comment("是否允许实体替换水为发光的黑曜石 Is entity replace water to glowing obsidian allowed").define("replace_to_glowing_obsidian", true);
		BREAKBLOCK = BUILDER.comment("是否允许实体破坏方块 Whether entities are allowed to destroy blocks").define("breakblock", true);
		BUILDER.pop();
		BUILDER.push("misc");
		WATCHDOG_CRASHTIME = BUILDER.comment("Watchdog过去多少tick后会崩溃 After how many ticks will the watchdog crash").define("watchdog_crashtime", (double) 1200);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
