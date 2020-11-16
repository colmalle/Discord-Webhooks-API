import net.ranktw.DiscordWebHooks.*;
import net.ranktw.DiscordWebHooks.embed.*;

import java.awt.*;
import java.util.logging.Logger;

public class WebhookClient {
    private final static Logger log = Logger.getLogger("Webhook");
    public static void main(String[] o) {
        String webhook = "https://discordapp.com/api/webhooks/{webhook.id}/{webhook.token}";
        DiscordWebhook discord = new DiscordWebhook(webhook);

        DiscordMessage dm = new DiscordMessage.Builder()
                .withUsername("Discord")
                .withContent("Java Discord Webhook API ᵇʸ ᴿᴬᴺᴷᵀᵂ \\❤")
                .withAvatarURL("https://i.imgur.com/5xLmduI.jpg")
                .withTTS(true)
                .build();

        DiscordEmbed embed = new DiscordEmbed.Builder()
                .withColor(Color.ORANGE)
                .withAuthor(new AuthorEmbed("Author","https://ranktw.pw","https://i.imgur.com/2deBzZA.png"))
                .withTitle("Title")
                .withTitleUrl("https://twitter.com/xRANKTW")
                .withDescription("Description\n __O__ **0** ~~O~~")
                .withField(new FieldEmbed("Text Formatting","[Link](https://birdie0.github.io/discord-webhooks-guide/other/discord_markdown.html)",true))
                .withField(new FieldEmbed("Field Limits","[Link](https://birdie0.github.io/discord-webhooks-guide/other/field_limits.html)",true))
                .withField(new FieldEmbed("Resource","[Link](https://discordapp.com/developers/docs/resources/webhook#create-webhook)",true))
                .withField(new FieldEmbed("Field Name","Value",true))
                .withFooter(new FooterEmbed("Footer","https://i.imgur.com/2deBzZA.png"))
                .withTimestamp(System.currentTimeMillis())
                .withThumbnail(new ThumbnailEmbed("https://cdn.discordapp.com/emojis/413210566459392010.gif",10,100))
                .withImage(new ImageEmbed("https://i.imgur.com/ta6LrR0.gif",100,100))
                .build();

        dm.addEmbeds(embed);

        String s = dm.toJson(true);
        log.info(s);
        discord.sendMessage(dm);
    }
}
