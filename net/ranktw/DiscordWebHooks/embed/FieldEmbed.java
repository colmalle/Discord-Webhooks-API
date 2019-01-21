package net.ranktw.DiscordWebHooks.embed;

import lombok.*;

@Getter
@Setter
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class FieldEmbed {
    String name;
    String value;
    boolean inline;

    public FieldEmbed(String name, String value, boolean inline) {
        this.name = name;
        this.value = value;
        this.inline = inline;
    }

}