package i.see.you.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public class ConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<Boolean> KICK;
	public static final ModConfigSpec.ConfigValue<Boolean> BAN;
	public static final ModConfigSpec.ConfigValue<Boolean> CRASH;
	public static final ModConfigSpec.ConfigValue<Boolean> ALWAYS_ONLINE;
	public static final ModConfigSpec.ConfigValue<Boolean> UNDEFINED_CHAT;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_FLICKERING_SCREEN;
	public static final ModConfigSpec.ConfigValue<Double> EVENT_INTERVAL;
	public static final ModConfigSpec.ConfigValue<Double> MAX_EVENT_SPEED;
	public static final ModConfigSpec.ConfigValue<Double> MIN_EVENT_SPEED;
	public static final ModConfigSpec.ConfigValue<Double> UNDEFINED_DAMAGECAP;
	public static final ModConfigSpec.ConfigValue<Double> MISSING_DAMAGECAP;
	public static final ModConfigSpec.ConfigValue<Boolean> SPAWN_ENTITY;
	public static final ModConfigSpec.ConfigValue<Boolean> REPLACE_TO_GLOWING_OBSIDIAN;
	public static final ModConfigSpec.ConfigValue<Boolean> BREAKBLOCK;
	public static final ModConfigSpec.ConfigValue<List<? extends String>> REMOVE_TECHNICAL_ENTITY_BLACKLIST;
	public static final ModConfigSpec.ConfigValue<Double> WATCHDOG_CRASHTIME;
	public static final ModConfigSpec.ConfigValue<Boolean> TRASH_LOG;
	static {
		BUILDER.push("game");
		KICK = BUILDER.comment("是否允许踢出玩家 Whether  are allowed to kick the player").define("kick", true);
		BAN = BUILDER.comment("是否允许封禁玩家 Whether allowed to ban players").define("ban", true);
		CRASH = BUILDER.comment("是否允许崩溃 Whether allowed to crashed").define("crash", true);
		ALWAYS_ONLINE = BUILDER.comment("是否将你视为拥有正版账号的玩家，即使你是离线账号玩家 Whether to consider you as an Online player, even if you are an Offline player").define("always_online", false);
		UNDEFINED_CHAT = BUILDER.comment("是否允许玩家与Undefined聊天 Whether players are allowed to chat with Undefined").define("undefined_chat", true);
		ALLOW_FLICKERING_SCREEN = BUILDER.comment("是否允许屏幕闪烁（癫痫患者不要开启） Whether screen flickering is allowed (do not turn on in people with epilepsy)").define("allow_flickering_screen", true);
		BUILDER.pop();
		BUILDER.push("event");
		EVENT_INTERVAL = BUILDER.comment("事件发生的间隔 The interval at the time of the event").define("event_interval", (double) 35000);
		MAX_EVENT_SPEED = BUILDER.comment("事件发生的最大速度 The maximum speed at which the event occurs").define("max_event_speed", (double) 2);
		MIN_EVENT_SPEED = BUILDER.comment("事件发生的最小速度 The minimum speed at which the event occurs").define("min_event_speed", (double) 0.5);
		BUILDER.pop();
		BUILDER.push("entity");
		UNDEFINED_DAMAGECAP = BUILDER.comment("Undefined Boss的限伤 The maximum damage the Undefined Boss can receive").define("undefined_damagecap", (double) 20);
		MISSING_DAMAGECAP = BUILDER.comment("穿戴Missing盔甲的玩家最大可以受到的伤害 The maximum damage that a player wearing missing armor can receive").define("missing_damagecap", (double) 50);
		SPAWN_ENTITY = BUILDER.comment("是否允许实体生成 Is entity spawn allowed").define("spawn_entity", true);
		REPLACE_TO_GLOWING_OBSIDIAN = BUILDER.comment("是否允许实体替换水为发光的黑曜石 Is entity replace water to glowing obsidian allowed").define("replace_to_glowing_obsidian", true);
		BREAKBLOCK = BUILDER.comment("是否允许实体破坏方块 Whether entities are allowed to destroy blocks").define("breakblock", true);
		BUILDER.pop();
		BUILDER.push("misc");
		REMOVE_TECHNICAL_ENTITY_BLACKLIST = BUILDER.comment("模组实体移除技术性实体的黑名单 Blacklist of technical entities removed by mods").defineList("remove_technical_entity_blacklist", List.of("touhou_little_maid:tombstone"), entry -> true);
		WATCHDOG_CRASHTIME = BUILDER.comment("Watchdog过去多少tick后会崩溃 After how many ticks will the watchdog crash").define("watchdog_crashtime", (double) 1200);
		TRASH_LOG = BUILDER.comment("是否在模组加载时记录日志 Whether to log an entry when the mod is loaded").define("trash_log", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
