package i.see.you.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class PlayerExistProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof Player || entity instanceof ServerPlayer) {
			if (new Object() {
				public int getStatusCode(java.net.HttpURLConnection connection) {
					try {
						if (connection != null) {
							return connection.getResponseCode();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return -1;
				}
			}.getStatusCode((new Object() {
				public java.net.HttpURLConnection createGetRequest(String url) {
					try {
						java.net.URL requestUrl = new java.net.URL(url);
						java.net.HttpURLConnection connection = (java.net.HttpURLConnection) requestUrl.openConnection();
						connection.setRequestMethod("GET");
						connection.setConnectTimeout(5000);
						connection.setReadTimeout(5000);
						return connection;
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			}.createGetRequest(("https://api.mojang.com/users/profiles/minecraft/" + entity.getDisplayName().getString())))) > 400) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}
}
