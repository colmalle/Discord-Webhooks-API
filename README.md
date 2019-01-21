# Discord-Webhooks-API

Webhooks are a low-effort way to post messages to channels in Discord. They do not require a bot user or authentication to use.

# A simple Discord Webhook API for Java

```java
String webhook = "https://discordapp.com/api/webhooks/{webhook.id}/{webhook.token}";
DiscordWebhook discord = new DiscordWebhook(webhook); // Create the webhook client
```
# Embeds
Build an Embed
```java
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
```
# Messages
Build a Messages
```java
DiscordMessage dm = new DiscordMessage.Builder()
   .withUsername("Discord")
   .withContent("Java Discord Webhook API ᵇʸ ᴿᴬᴺᴷᵀᵂ \\❤")
   .withAvatarURL("https://i.imgur.com/5xLmduI.jpg")
   .withTTS(true)
   .build();
```

```java
dm.addEmbeds(embed);     //Add Embeds to the DiscordMessage 

String s = dm.toJson(true);
System.out.println(s);   // Print DiscordMessage to Json
discord.sendMessage(dm); //Finally, send the message:
```
**Output:**

![https://i.imgur.com/8TgrioI.png](https://i.imgur.com/8TgrioI.png)

## Send a Custom Json Messages To Webhooks

```java
DiscordWebhook.sendJsonToWebhook("Url","Json");
```

### Dependencies

[HttpRequest](https://github.com/kevinsawicki/http-request) by @kevinsawicki
