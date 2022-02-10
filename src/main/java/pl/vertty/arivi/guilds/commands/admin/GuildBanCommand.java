// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.admin;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.utils.DataUtil;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

import java.util.Iterator;

public class GuildBanCommand extends PlayerCommand
{
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
        if (array.length < 3) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        String join = "Dzialanie na szkode serwera!";
        if (array.length > 3) {
            join = StringUtils.join((Object[])array, " ", 3, array.length);
        }
        final Iterator<String> iterator = guild.getMembers().iterator();
        while (iterator.hasNext()) {
            Server.getInstance().dispatchCommand((CommandSender)Server.getInstance().getConsoleSender(), String.valueOf(new StringBuilder().append("ban ").append(iterator.next()).append(" ").append(DataUtil.parseDateDiff(array[2], true)).append(join)));
        }
        return false;
    }
    
    public GuildBanCommand() {
        super("ban", "/ga ban <tag> <czas> <powod>", GroupType.ADMIN, new String[0]);
    }
}
