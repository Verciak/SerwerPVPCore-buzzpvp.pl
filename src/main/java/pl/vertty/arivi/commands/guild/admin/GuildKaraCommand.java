
package pl.vertty.arivi.commands.guild.admin;

import cn.nukkit.Player;
import cn.nukkit.Server;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.utils.guild.DataUtil;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildKaraCommand extends PlayerCommand
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
        if (array.length < 3) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        if (guild.getTntKaraTime() > System.currentTimeMillis()) {
            guild.setTntKaraTime(0L);
            Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_KARA_SUCCESS2.replace("{TAG}", guild.getTag()).replace("{ADMIN}", player.getName())));
            return false;
        }
        final long dateDiff = DataUtil.parseDateDiff(array[2], true);
        guild.setTntKaraTime(dateDiff);
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_KARA_SUCCESS.replace("{TAG}", guild.getTag()).replace("{TIME}", DataUtil.secondsToString(dateDiff)).replace("{ADMIN}", player.getName())));
        return false;
    }
    
    public GuildKaraCommand() {
        super("kara", "/ga kara <tag> <czas> ", GroupType.ADMIN, new String[0]);
    }
}
