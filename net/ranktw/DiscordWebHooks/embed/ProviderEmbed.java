package net.ranktw.DiscordWebHooks.embed;

import lombok.*;

@Getter
@Setter
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class ProviderEmbed {
    String name;
    String url;
    public ProviderEmbed(String name, String url) {
        this.name = name;
        this.url = url;
    }

}
