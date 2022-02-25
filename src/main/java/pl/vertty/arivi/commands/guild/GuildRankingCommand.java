
package pl.vertty.arivi.commands.guild;

import java.util.HashMap;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.guild.Guild;
import java.util.Map;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildRankingCommand extends PlayerCommand
{
    public static Map<Guild, Long> gt;
    
    public GuildRankingCommand() {
        super("resetujranking", "/g resetujranking", GroupType.PLAYER, new String[] { "rr" });
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        if (!guild.getOwner().equalsIgnoreCase(player.getName())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_OWNER));
            return false;
        }
        final Long n = GuildRankingCommand.gt.get(guild);
        if (n != null && System.currentTimeMillis() - n < 36000L) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_RANKING_ERROR2));
            return false;
        }
        if (!guild.isPreResetStats()) {
            guild.setPreResetStats(true);
            guild.setPoints(1000);
            guild.setKills(0);
            guild.setDeaths(0);
            GuildRankingCommand.gt.put(guild, System.currentTimeMillis());
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_RANKING_SUCCESS));
            return true;
        }
        return false;
    }
    
    static {
        GuildRankingCommand.gt = new HashMap<Guild, Long>();
    }
}
