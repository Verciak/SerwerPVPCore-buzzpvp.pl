
package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.managers.RoleManager;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildLeaveCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        if (guild.isOwner(player)) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_LEAVE_ERROR));
            return false;
        }
        if (guild.isLeader(player.getName())) {
            guild.setLeader("Brak");
        }
        guild.removeMember(player);
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_LEAVE_MESSAGE.replace("{NICK}", player.getName()).replace("{TAG}", guild.getTag())));
        RoleManager.permsOwnerOff(RoleManager.getUser(player));
        return false;
    }
    
    public GuildLeaveCommand() {
        super("opusc", "/g opusc <tag>", GroupType.PLAYER, new String[0]);
    }
}
