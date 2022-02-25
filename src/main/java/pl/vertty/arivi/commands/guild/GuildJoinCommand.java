
package pl.vertty.arivi.commands.guild;

import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.objects.guild.Guild;
import cn.nukkit.Server;
import pl.vertty.arivi.managers.RoleManager;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.utils.guild.itemstack.ItemStackUtil;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildJoinCommand extends PlayerCommand
{
    public GuildJoinCommand() {
        super("dolacz", "/g dolacz <tag>", GroupType.PLAYER, new String[0]);
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        if (GuildManager.getGuild(player) != null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_IS_GUILD));
            return false;
        }
        if (array.length < 2) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        final Guild guild = GuildManager.getGuild(array[1]);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_JOIN_ERROR));
            return false;
        }
        if (!guild.getInvites().contains(player)) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_JOIN_ERROR1));
            return false;
        }
        if (guild.getMembers().size() >= guild.getLimitMembers()) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_JOIN_ERROR2));
            return false;
        }
        final int size = guild.getMembers().size();
        final String cost_JOIN_NORMAL = Config.COST_JOIN_NORMAL;
        if (!ItemStackUtil.checkItems(player, cost_JOIN_NORMAL, size)) {
            ItemStackUtil.getItem(player, cost_JOIN_NORMAL, size);
            return false;
        }
        ItemStackUtil.removeItems(player, cost_JOIN_NORMAL, size);
        guild.getInvites().remove(player);
        guild.addMember(player);
        final User user = UserManager.getUser(player);
        player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_JOIN_SUCCESS.replace("{TAG}", guild.getTag())));
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_JOIN_MESSAGE.replace("{NICK}", player.getName()).replace("{TAG}", guild.getTag())));
        RoleManager.permsOwnerOff(RoleManager.getUser(player));
        return false;
    }
}
