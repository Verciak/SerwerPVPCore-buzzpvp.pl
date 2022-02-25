
package pl.vertty.arivi.commands.guild.admin;

import java.util.Iterator;
import pl.vertty.arivi.objects.guild.Guild;
import cn.nukkit.command.CommandSender;
import cn.nukkit.Server;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildUnbanCommand extends PlayerCommand
{
    public GuildUnbanCommand() {
        super("unban", "/ga unban <tag>", GroupType.ADMIN, new String[0]);
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        if (array.length < 2) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        final Guild guild = GuildManager.getGuild(array[1]);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_EXISTS));
            return false;
        }
        final Iterator<String> iterator = guild.getMembers().iterator();
        while (iterator.hasNext()) {
            Server.getInstance().dispatchCommand((CommandSender)Server.getInstance().getConsoleSender(), String.valueOf(new StringBuilder().append("unban ").append(iterator.next())));
        }
        return false;
    }
}
