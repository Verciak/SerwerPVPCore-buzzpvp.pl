
package pl.vertty.arivi.commands.guild;

import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.objects.guild.Guild;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.guild.itemstack.ItemStackUtil;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildOwnerCommand extends PlayerCommand
{
    public GuildOwnerCommand() {
        super("lider", "/g lider <gracz>", GroupType.PLAYER, new String[0]);
    }
    
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
        final String substring = array[1];
        final User user = UserManager.getUser(substring);
        if (user == null) {
            player.sendMessage(ChatUtil.fixColor(Config.USER_NULL));
            return false;
        }
        if (!guild.isMember(user.getName())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_MYGUILD));
            return false;
        }
        if (guild.isOwner(substring)) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_LIDER_ERROR));
            return false;
        }
        final String cost_OWNER_NORMAL = Config.COST_OWNER_NORMAL;
        if (!ItemStackUtil.checkItems(player, cost_OWNER_NORMAL, 1)) {
            ItemStackUtil.getItem(player, cost_OWNER_NORMAL, 1);
            return false;
        }
        ItemStackUtil.removeItems(player, cost_OWNER_NORMAL, 1);
        guild.setOwner(user.getName());
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_LIDER_MESSAGE.replace("{NICK}", user.getName()).replace("{TAG}", guild.getTag())));
        return false;
    }
}
