package i.see.you.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class HaveJSONBodyPostProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("response : " + (new Object() {
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
				public java.net.HttpURLConnection createPostRequest(String url, String bodyJson) {
					try {
						java.net.URL requestUrl = new java.net.URL(url);
						java.net.HttpURLConnection connection = (java.net.HttpURLConnection) requestUrl.openConnection();
						connection.setRequestMethod("POST");
						connection.setRequestProperty("Content-Type", "application/json");
						connection.setDoOutput(true);
						connection.setConnectTimeout(5000);
						connection.setReadTimeout(5000);
						// Write the JSON body
						try (java.io.OutputStream os = connection.getOutputStream()) {
							byte[] input = bodyJson.getBytes("utf-8");
							os.write(input, 0, input.length);
						}
						return connection;
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			}.createPostRequest((StringArgumentType.getString(arguments, "url")), (StringArgumentType.getString(arguments, "json")))))))), false);
	}
}
