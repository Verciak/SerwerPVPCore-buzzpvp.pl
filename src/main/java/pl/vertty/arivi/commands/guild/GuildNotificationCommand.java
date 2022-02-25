
package pl.vertty.arivi.commands.guild;

import java.io.IOException;
import pl.vertty.arivi.utils.WebhookUtil;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildNotificationCommand extends PlayerCommand
{
    public GuildNotificationCommand() {
        super("zglos", "/g zglos <tag> <powod>", GroupType.PLAYER, new String[0]);
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        if (array.length < 3) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        if (GuildManager.getGuild(array[1]) == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_EXISTS));
            return false;
        }
        final String join = StringUtils.join((Object[])array, " ", 2, array.length);
        try {
            WebhookUtil.sendMessage(player.getName(), array[1], join);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_ZGLOS_SUCCESS));
        return false;
    }
}
