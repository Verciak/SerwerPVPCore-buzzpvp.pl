
package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.utils.itemstack.ItemStackUtil;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildLeaderCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        if (!guild.isOwner(player)) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_OWNER));
            return false;
        }
        if (array.length < 2) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        final User user = UserManager.getUser(array[1]);
        if (user == null) {
            player.sendMessage(ChatUtil.fixColor(Config.USER_NULL));
            return false;
        }
        if (!guild.isMember(user.getName())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_LEADER_ERROR));
            return false;
        }
        if (guild.isOwner(user.getName())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_LEADER_ERROR2));
            return false;
        }
        if (guild.isLeader(user.getName())) {
            guild.setLeader(null);
            Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_LEADER_MESSAGE.replace("{NICK}", user.getName()).replace("{TAG}", guild.getTag())));
            return false;
        }
        final String cost_LEADER_NORMAL = Config.COST_LEADER_NORMAL;
        if (!ItemStackUtil.checkItems(player, cost_LEADER_NORMAL, 1)) {
            ItemStackUtil.getItem(player, cost_LEADER_NORMAL, 1);
            return false;
        }
        ItemStackUtil.removeItems(player, cost_LEADER_NORMAL, 1);
        guild.setLeader(user.getName());
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_LEADER_MESSAGE2.replace("{NICK}", user.getName()).replace("{TAG}", guild.getTag())));
        return false;
    }
    
    public GuildLeaderCommand() {
        super("zastepca", "/g zastepca <gracz>", GroupType.PLAYER, new String[0]);
    }
}
