package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.player.LocalPlayer;

import java.util.ArrayList;

public class ExecuteEventProcedure {
	public static String execute(LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return "";
		String name = "";
		ArrayList<Object> event = new ArrayList<>();
		ArrayList<Object> place = new ArrayList<>();
		ArrayList<Object> give = new ArrayList<>();
		give.add("null");
		give.add("server");
		give.add("bucket");
		give.add("deepslate");
		for (Object arraylistiterator : give) {
			event.add(("give" + (arraylistiterator instanceof String _str5 ? _str5 : "")));
		} //give
		place.add("copper");
		place.add("light");
		place.add("fire");
		for (Object arraylistiterator : place) {
			event.add(("place" + (arraylistiterator instanceof String _str12 ? _str12 : "")));
		} //place
		event.add("pause");
		event.add("overlay");
		event.add("die");
		event.add("lava");
		event.add("gui");
		event.add("message");
		event.add("message");
		event.add("chat");
		event.add("gc");
		event.add("totem");
		event.add("stuck");
		event.add("under");
		event.add("particle");
		event.add("goaway");
		event.add("rename");
		event.add("attack");
		event.add("undefined");
		event.add("break");
		event.add("void");
		event.add("windcharge");
		event.add("fly");
		event.add("title");
		event.add("broken");
		event.add("memory");
		event.add("safe");
		event.add("damage");
		event.add("behind");
		event.add("errnull");
		event.add("throw");
		event.add("jump");
		event.add("see");
		event.add("enchant");
		//why can't execute event?
		if (Mth.nextInt(RandomSource.create(), 0, 6) == 0) {
			event.add("ip");
		} else if (Mth.nextInt(RandomSource.create(), 0, 3) == 0) {
			event.add("left");
		} else if (Mth.nextInt(RandomSource.create(), 0, 2) == 0) {
			event.add("build");
		} else if (Mth.nextInt(RandomSource.create(), 0, 1) == 0) {
			event.add("corruption");
		} else if (Mth.nextInt(RandomSource.create(), 0, 2) == 0) {
			event.add("log");
		} else if (Math.random() < 0.45) {
			event.add("cantsee");
		}
		if (!(new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, ResourceLocation.parse("the_root_of_corruption:errr")))) {//because recipe event need before give the recipe.
			event.add("recipe");
		} else if (Mth.nextInt(RandomSource.create(), 0, 1) == 1) {
			event.add("doom");
		} else if (entity instanceof ServerPlayer _plr62 && _plr62.level() instanceof ServerLevel && _plr62.getAdvancements().getOrStartProgress(_plr62.server.getAdvancements().get(ResourceLocation.parse("minecraft:end/kill_dragon"))).isDone()) {//gift event need kill ender dragon.
			event.add("gift");
		} else if ((entity.level().dimension()) == Level.OVERWORLD) {//rot in hell event need you are in overworld.
			event.add("hell");
		} else if (Mth.nextInt(RandomSource.create(), 0, 2) == 1) {
			event.add("jumpscare");
		} else if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
			event.add("keep");
			//keepinvenory event need gamerule keepinvenory is false.
		} else if (y < 0) {//bedrock event need y<0.
			event.add("bedrock");
		}
		try {
			name = event.get(Mth.nextInt(RandomSource.create(), 0, (int) (event.size() - 1))) instanceof String _str75 ? _str75 : "";
		} catch (Throwable e) {//沟槽的IndexOutOfBoundsException
			e.printStackTrace();
			return "";
		}
		return name;
	}
}
