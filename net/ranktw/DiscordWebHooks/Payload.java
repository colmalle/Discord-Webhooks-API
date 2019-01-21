package net.ranktw.DiscordWebHooks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.reflxction.simplejson.utils.Gsons;

public class Payload {
    private static final Gson gson = new Gson();
    private static final Gson PRETTY_PRINTING = (new GsonBuilder()).setPrettyPrinting().create();

    public String toJson() {
        return gson.toJson(this);
    }
    public String toJson(boolean prettyPrinting) {
        return PRETTY_PRINTING.toJson(this);
    }
}
