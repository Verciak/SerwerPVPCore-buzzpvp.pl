
package pl.vertty.arivi.commands.guild;

import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.managers.RoleManager;
import pl.vertty.arivi.utils.TimerUtil;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildHomeCommand extends PlayerCommand
{
    public GuildHomeCommand() {
        super("baza", "/g baza", GroupType.PLAYER, new String[] { "home", "dom" });
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        if(!RoleManager.getUser(player).isUpr_base_teleport()){
            ChatUtil.sendMessage(player, "&cNie posiadasz pozwolen od lidera!");
            return false;
        }
        final Guild guild2 = GuildManager.getGuild(player.getLocation());
        if (guild2 != null && !guild2.isMember(player)) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_HOME_ERROR));
            return false;
        }
        TimerUtil.teleportSpawn(player, guild.getHome(), 10);
        return true;
    }
}
