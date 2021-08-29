// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands;

import pl.vertty.arivi.guilds.commands.admin.GuildRankingCommand;
import pl.vertty.arivi.guilds.commands.admin.GuildRegenerationCommand;
import pl.vertty.arivi.guilds.commands.admin.GuildJoinCommand;
import pl.vertty.arivi.guilds.commands.admin.GuildUnbanCommand;
import pl.vertty.arivi.guilds.commands.admin.GuildOwnerCommand;
import pl.vertty.arivi.guilds.commands.admin.GuildKaraCommand;
import pl.vertty.arivi.guilds.commands.admin.GuildDeleteCommand;
import pl.vertty.arivi.guilds.commands.admin.GuildTpCommand;
import pl.vertty.arivi.guilds.commands.admin.GuildBanCommand;
import java.util.HashSet;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Player;
import java.util.Iterator;
import pl.vertty.arivi.enums.GroupType;
import java.util.Set;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

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
