
package pl.vertty.arivi.commands.guild.admin;

import cn.nukkit.Player;
import cn.nukkit.level.Location;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildTpCommand extends PlayerCommand
{
    public GuildTpCommand() {
        super("tp", "/ga tp <tag> <y>", GroupType.MODERATOR, new String[0]);
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        if (array.length < 3) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        final Guild guild = GuildManager.getGuild(array[1]);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_EXISTS));
            return false;
        }
        player.teleport(new Location(guild.getRegion().getLocation().getX(), (double)Integer.parseInt(array[2]), guild.getRegion().getLocation().getZ()));
        player.sendMessage(ChatUtil.fixColor(Config.GUILD_TELEPORT_SUCCESS));
        return false;
    }
}
