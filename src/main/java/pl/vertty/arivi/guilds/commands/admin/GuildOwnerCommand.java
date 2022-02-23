
package pl.vertty.arivi.guilds.commands.admin;

import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildOwnerCommand extends PlayerCommand
{
    public GuildOwnerCommand() {
        super("zalozyciel", "/ga zalozyciel <tag> <nick> ", GroupType.ADMIN, new String[0]);
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
        final String s = array[2];
        if (s == null) {
            player.sendMessage(ChatUtil.fixColor(Config.USER_NULL));
            return false;
        }
        final Player player2 = Server.getInstance().getPlayer(s);
        if (player2 == null) {
            player.sendMessage(ChatUtil.fixColor(Config.USER_NULL));
            return false;
        }
        if (GuildManager.getGuild(player2) == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        if (!guild.isMember(player2.getName())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD2));
            return false;
        }
        guild.setOwner(player2.getName());
        final User user = UserManager.getUser(player2);
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_LIDER_MESSAGE.replace("{NICK}", player2.getName()).replace("{TAG}", guild.getTag())));
        return false;
    }
}
