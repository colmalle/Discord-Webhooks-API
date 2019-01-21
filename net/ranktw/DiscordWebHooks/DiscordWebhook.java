package net.ranktw.DiscordWebHooks;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import net.ranktw.DiscordWebHooks.connection.Response;
import net.ranktw.DiscordWebHooks.connection.WebhookException;

import java.net.MalformedURLException;
import java.net.URL;

public class DiscordWebhook {
    public static final Gson gson = new Gson();
    public String webhook;

    public DiscordWebhook(String webhook) {
        this.webhook = webhook;
    }

    public void sendMessage(Payload dm) {
        new Thread(() -> {
            String strResponse = HttpRequest.post(webhook)
                    .acceptJson()
                    .contentType("application/json")
                    .header("User-Agent", "Mozilla/5.0 (X11; U; Linux i686) Gecko/20071127 Firefox/2.0.0.11") // Why? Because discordapp.com blocks the default User Agent
                    .send(gson.toJson(dm))
                    .body();

            if (!strResponse.isEmpty()) {
                Response response = gson.fromJson(strResponse, Response.class);
                try {
                    if (response.getMessage().equals("You are being rate limited.")) {
                        throw new WebhookException(response.getMessage());
                    }
                } catch (Exception e) {
                    throw new WebhookException(strResponse);
                }
            }
        }).start();
    }
    public void sendMessageWithSlackFormatting(Payload dm) {
        new Thread(() -> {
            String strResponse = HttpRequest.post(webhook+"/slack")
                    .acceptJson()
                    .contentType("application/json")
                    .header("User-Agent", "Mozilla/5.0 (X11; U; Linux i686) Gecko/20071127 Firefox/2.0.0.11") // Why? Because discordapp.com blocks the default User Agent
                    .send(gson.toJson(dm))
                    .body();

            if (!strResponse.isEmpty()) {
                Response response = gson.fromJson(strResponse, Response.class);
                try {
                    if (response.getMessage().equals("You are being rate limited.")) {
                        throw new WebhookException(response.getMessage());
                    }
                } catch (Exception e) {
                    throw new WebhookException(strResponse);
                }
            }
        }).start();
    }
    public String sendGet() {
        return (HttpRequest.get(webhook)
                .acceptJson()
                .contentType("application/json")
                .header("User-Agent", "Mozilla/5.0 (X11; U; Linux i686) Gecko/20071127 Firefox/2.0.0.11") // Why? Because discordapp.com blocks the default User Agent
                .body());
    }
    public void sendDelete(){
        new Thread(() -> {
            String strResponse = HttpRequest.delete(webhook)
                    .acceptJson()
                    .contentType("application/json")
                    .header("User-Agent", "Mozilla/5.0 (X11; U; Linux i686) Gecko/20071127 Firefox/2.0.0.11") // Why? Because discordapp.com blocks the default User Agent
                    .body();
            if (!strResponse.isEmpty()) {
                throw new WebhookException(strResponse);
            }
        }).start();
    }
    public static String sendJsonToWebhook(String url, String json) throws MalformedURLException {
        return HttpRequest.post(new URL(url))
                .acceptJson()
                .contentType("application/json")
                .header(HttpRequest.HEADER_USER_AGENT, "Mozilla/5.0 (X11; U; Linux i686) Gecko/20071127 Firefox/2.0.0.11") // Why? Because discordapp.com blocks the default User Agent
                .send(json)
                .body();
    }

}
