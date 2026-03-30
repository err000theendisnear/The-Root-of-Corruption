package i.see.you.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class IpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Your IP:" + (new Object() {
				public String getResponse(java.net.HttpURLConnection connection) {
					try {
						if (connection != null) {
							int responseCode = connection.getResponseCode();
							java.io.InputStream inputStream = (responseCode >= 400) ? connection.getErrorStream() : connection.getInputStream();
							StringBuilder response = new StringBuilder();
							try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, "utf-8"))) {
								String responseLine;
								while ((responseLine = br.readLine()) != null) {
									response.append(responseLine.trim());
								}
							}
							return response.toString();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return "Error getting response";
				}
			}.getResponse((new Object() {
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
			}.createGetRequest("http://ip-api.com/json")))))), false);
	}
}
