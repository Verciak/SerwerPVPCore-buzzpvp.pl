// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.task;

import java.util.Iterator;
import pl.vertty.arivi.guilds.data.guild.War;
import pl.vertty.arivi.guilds.managers.guild.WarManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.scheduler.NukkitRunnable;

public class CheckValidityTask extends NukkitRunnable
{
    public void run() {
        for (final Guild guild : GuildManager.getGuilds().values()) {
            if (guild.getProlong() < System.currentTimeMillis()) {
                GuildManager.deleteGuild(guild);
                Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_PROLONG_TIME.replace("{TAG}", guild.getTag()).replace("{X}", Integer.toString(guild.getRegion().getX())).replace("{Z}", Integer.toString(guild.getRegion().getZ()))));
            }
            for (final War war : WarManager.getWars().values()) {
                if (war.getTime() < System.currentTimeMillis()) {
                    if (war.getKills() > war.getDeaths()) {
                        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_WOJNA_TIME.replace("{TAG}", war.getTag()).replace("{TAG2}", war.getTag2()).replace("{KILLS}", Integer.toString(war.getKills())).replace("{DEATHS}", Integer.toString(war.getDeaths()))));
                    }
                    else if (war.getKills() < war.getDeaths()) {
                        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_WOJNA_TIME.replace("{TAG}", war.getTag2()).replace("{TAG2}", war.getTag()).replace("{KILLS}", Integer.toString(war.getDeaths())).replace("{DEATHS}", Integer.toString(war.getKills()))));
                    }
                    else if (war.getKills() == war.getDeaths()) {
                        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_WOJNA_TIME.replace("{TAG}", war.getTag()).replace("{TAG2}", war.getTag2()).replace("{KILLS}", Integer.toString(war.getKills())).replace("{DEATHS}", Integer.toString(war.getDeaths()))));
                    }
                    WarManager.deleteWar(war);
                }
            }
        }
    }
}
