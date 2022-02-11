
package pl.vertty.arivi.guilds.commands.admin;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildRankingCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        if (array.length < 3) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        if (array[1].equalsIgnoreCase("kills")) {
            final Guild guild = GuildManager.getGuild(array[2]);
            if (guild == null) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_EXISTS));
                return false;
            }
            guild.setKills(0);
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_RESETRANKING_KILLS_SUCCESS));
            return false;
        }
        else if (array[1].equalsIgnoreCase("deaths")) {
            final Guild guild2 = GuildManager.getGuild(array[2]);
            if (guild2 == null) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_EXISTS));
                return false;
            }
            guild2.setDeaths(0);
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_RESETRANKING_DEATHS_SUCCESS));
            return false;
        }
        else {
            if (!array[1].equalsIgnoreCase("points")) {
                return false;
            }
            final Guild guild3 = GuildManager.getGuild(array[2]);
            if (guild3 == null) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_EXISTS));
                return false;
            }
            guild3.setPoints(1000);
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_RESETRANKING_POINTS_SUCCESS));
            return false;
        }
    }
    
    public GuildRankingCommand() {
        super("ranking", "/ga ranking <kills/deaths/points> <tag>", GroupType.ADMIN, new String[0]);
    }
}
