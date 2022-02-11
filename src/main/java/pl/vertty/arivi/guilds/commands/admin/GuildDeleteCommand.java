
package pl.vertty.arivi.guilds.commands.admin;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildDeleteCommand extends PlayerCommand
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
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_DELETE_MESSAGE.replace("{TAG}", guild.getTag()).replace("{NAZWA}", guild.getName()).replace("{NICK}", player.getName())));
        GuildManager.deleteGuild(guild);
        return false;
    }
    
    public GuildDeleteCommand() {
        super("usun", "/ga usun <tag> ", GroupType.ADMIN, new String[0]);
    }
}
