
package pl.vertty.arivi.commands.guild.construct;

import pl.vertty.arivi.commands.guild.admin.GuildRankingCommand;
import pl.vertty.arivi.commands.guild.admin.GuildRegenerationCommand;
import pl.vertty.arivi.commands.guild.admin.GuildJoinCommand;
import pl.vertty.arivi.commands.guild.admin.GuildUnbanCommand;
import pl.vertty.arivi.commands.guild.admin.GuildOwnerCommand;
import pl.vertty.arivi.commands.guild.admin.GuildKaraCommand;
import pl.vertty.arivi.commands.guild.admin.GuildDeleteCommand;
import pl.vertty.arivi.commands.guild.admin.GuildTpCommand;
import pl.vertty.arivi.commands.guild.admin.GuildBanCommand;
import java.util.HashSet;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import cn.nukkit.Player;
import java.util.Iterator;
import pl.vertty.arivi.enums.GroupType;
import java.util.Set;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildAdminCommand extends PlayerCommand
{
    public static Set<PlayerCommand> cmds;
    
    public GuildAdminCommand() {
        super("ga", "/ga", GroupType.ADMIN, new String[0]);
    }
    
    public PlayerCommand get(final String anotherString) {
        for (final PlayerCommand playerCommand : GuildAdminCommand.cmds) {
            if (playerCommand.getName().equalsIgnoreCase(anotherString) || playerCommand.getAliases().equals(anotherString)) {
                return playerCommand;
            }
        }
        return null;
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        if (array.length == 0) {
            final Iterator<String> iterator = Config.GUILD_COMMAND_HELP_ADMIN_MESSAGE.iterator();
            while (iterator.hasNext()) {
                player.sendMessage(ChatUtil.fixColor(iterator.next()));
            }
            return false;
        }
        final PlayerCommand value = this.get(array[0]);
        if (value == null) {
            player.sendMessage(ChatUtil.fixColor("&cWpisales zly argumeny"));
            return false;
        }
        return value.onExecute((CommandSender)player, array);
    }
    
    static {
        (GuildAdminCommand.cmds = new HashSet<PlayerCommand>()).add(new GuildBanCommand());
        GuildAdminCommand.cmds.add(new GuildTpCommand());
        GuildAdminCommand.cmds.add(new GuildDeleteCommand());
        GuildAdminCommand.cmds.add(new GuildKaraCommand());
        GuildAdminCommand.cmds.add(new GuildOwnerCommand());
        GuildAdminCommand.cmds.add(new GuildUnbanCommand());
        GuildAdminCommand.cmds.add(new GuildJoinCommand());
        GuildAdminCommand.cmds.add(new GuildRegenerationCommand());
        GuildAdminCommand.cmds.add(new GuildRankingCommand());
    }
}
