// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.admin;

import java.util.Iterator;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.command.CommandSender;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

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
