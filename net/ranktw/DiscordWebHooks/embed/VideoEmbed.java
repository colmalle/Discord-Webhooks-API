package net.ranktw.DiscordWebHooks.embed;

import lombok.*;

@Getter
@Setter
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class VideoEmbed {
    String url;
    int height;
    int width;

    public VideoEmbed(String url, int height, int width) {
        this.url = url;
        this.height = height;
        this.width = width;
    }
}