// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.utils;

import java.awt.*;
import java.io.IOException;

public class WebhookUtil
{
    public static void sendMessage(final String s, final String s2, final String s3) throws IOException {
        final Webhook webhook = new Webhook("https://discord.com/api/webhooks/865543467286790194/r3eUweG6Ukfg4nCwDdsnBBPtqvaPyMqsJYywX5hYZzrtBTyv98yZVLZfuZi3yElP_82X");
        webhook.setAvatarUrl(String.valueOf(new StringBuilder().append("https://minotar.net/avatar/").append(s).append("/500.png")));
        webhook.setUsername("BlazePE.pl | Zglaszanie kary");
        webhook.addEmbed(new Webhook.EmbedObject().setColor(Color.RED).addField("Zgloszenie od: ", s, false).addField("Zgloszona gildia: ", s2, false).addField("Powod zgloszenia: ", s3, false).setThumbnail(String.valueOf(new StringBuilder().append("https://minotar.net/avatar/").append(s).append("/500.png"))).setFooter(String.valueOf(new StringBuilder().append("Guilds - Notification | ").append(DataUtil.getDate(System.currentTimeMillis()))), ""));
        webhook.execute();
    }
}
