
package pl.vertty.arivi.task;

import cn.nukkit.Server;
import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.utils.guild.ChatUtil;

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
