
package pl.vertty.arivi.commands.guild;

import java.util.Set;
import java.util.Iterator;
import pl.vertty.arivi.objects.guild.Guild;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.utils.guild.DataUtil;
import pl.vertty.arivi.objects.yml.Config;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildInfoCommand extends PlayerCommand
{
    public GuildInfoCommand() {
        super("info", "/g info <tag>", GroupType.PLAYER, new String[0]);
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        Guild g = null;
        if (array.length == 1) {
            g = GuildManager.getGuild(player);
        }
        else {
            g = GuildManager.getGuild(array[1]);
        }
        if (g == null && array.length == 1) {
            return ChatUtil.sendMessage((CommandSender)player, "&4Blad: &cNie posiadasz gildii!");
        }
        if (g == null) {
            return ChatUtil.sendMessage((CommandSender)player, Config.GUILD_COMMAND_INFO_ERROR);
        }
        final Iterator<String> iterator = Config.GUILD_COMMAND_INFO_SUCCESS.iterator();
        while (iterator.hasNext()) {
            player.sendMessage(ChatUtil.fixColor(iterator.next().replace("{TAG}", g.getTag()).replace("{NAZWA}", g.getName()).replace("{OWNER}", g.getOwner()).replace("{POINTS}", Integer.toString(g.getPoints())).replace("{KILLS}", Integer.toString(g.getKills())).replace("{DEATHS}", Integer.toString(g.getDeaths())).replace("{STARTTIME}", DataUtil.getDate(g.getCreateTime())).replace("{LIFE}", Integer.toString(g.getLife())).replace("{MEMBERS}", StringUtils.join((Object[])getMemberList(g.getMembers()), "&8, ")).replace("{ZASTEPCA}", g.getLeader()).replace("{PROLONG}", DataUtil.secondsToString(g.getProlong()))));
        }
        return false;
    }
    
    public static String[] getMemberList(final Set<String> members) {
        final String[] s = new String[members.size()];
        int i = 0;
        for (final String u : members) {
            s[i] = "&f" + u;
            ++i;
        }
        return s;
    }
}
