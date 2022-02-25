
package pl.vertty.arivi.commands.guild;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildSetHomeCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        if (!guild.isOwner(player.getName())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_OWNER));
            return false;
        }
        if (!guild.equals(GuildManager.getGuild(player.getLocation()))) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SETHOME_ERROR));
            return false;
        }
        guild.setHome(player.getLocation());
        player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SETHOME_SUCCESS));
        return false;
    }
    
    public GuildSetHomeCommand() {
        super("ustawbaza", "/g ustawbaza", GroupType.PLAYER, new String[0]);
    }
}
