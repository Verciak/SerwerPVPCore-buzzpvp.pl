
package pl.vertty.arivi.guilds.task;

import cn.nukkit.Server;
import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;

public class CheckValidityTask extends NukkitRunnable
{
    public void run() {
        for (final Guild guild : GuildManager.getGuilds().values()) {
            if (guild.getProlong() < System.currentTimeMillis()) {
                GuildManager.deleteGuild(guild);
                Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_PROLONG_TIME.replace("{TAG}", guild.getTag()).replace("{X}", Integer.toString(guild.getRegion().getX())).replace("{Z}", Integer.toString(guild.getRegion().getZ()))));
            }
        }
    }
}
