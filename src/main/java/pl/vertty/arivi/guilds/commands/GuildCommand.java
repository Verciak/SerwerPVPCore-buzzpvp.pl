// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands;

import pl.vertty.arivi.guilds.commands.guild.GuildNotificationCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildChestCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildInviteAllCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildWarsCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildPanelCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildFreeSpaceCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildKaraCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildItemsCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildPermissionCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildProlongCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildEnlargeCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildRankingCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildSetHomeCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildHomeCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildPvpCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildOwnerCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildLeaderCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildLeaveCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildKickCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildJoinCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildInviteCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildInfoCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildDeleteCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildCreateCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildCordinateCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildSkrzynkaCommand;
import pl.vertty.arivi.guilds.commands.guild.GuildAllyCommand;
import java.util.HashSet;
import pl.vertty.arivi.enums.GroupType;
import java.util.Iterator;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Player;
import java.util.Set;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildCommand extends PlayerCommand
{
    public static Set<PlayerCommand> cmds;
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        if (array.length == 0) {
            final Iterator<String> iterator = Config.GUILD_COMMAND_HELP_MESSAGE.iterator();
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
    
    public GuildCommand() {
        super("g", "/g", GroupType.PLAYER, new String[] { "gildia" });
    }
    
    public PlayerCommand get(final String anotherString) {
        for (final PlayerCommand playerCommand : GuildCommand.cmds) {
            if (playerCommand.getName().equalsIgnoreCase(anotherString) || playerCommand.getAliases().equals(anotherString)) {
                return playerCommand;
            }
        }
        return null;
    }
    
    static {
        (GuildCommand.cmds = new HashSet<PlayerCommand>()).add(new GuildAllyCommand());
        GuildCommand.cmds.add(new GuildSkrzynkaCommand());
        GuildCommand.cmds.add(new GuildCordinateCommand());
        GuildCommand.cmds.add(new GuildCreateCommand());
        GuildCommand.cmds.add(new GuildDeleteCommand());
        GuildCommand.cmds.add(new GuildInfoCommand());
        GuildCommand.cmds.add(new GuildInviteCommand());
        GuildCommand.cmds.add(new GuildJoinCommand());
        GuildCommand.cmds.add(new GuildKickCommand());
        GuildCommand.cmds.add(new GuildLeaveCommand());
        GuildCommand.cmds.add(new GuildLeaderCommand());
        GuildCommand.cmds.add(new GuildOwnerCommand());
        GuildCommand.cmds.add(new GuildPvpCommand());
        GuildCommand.cmds.add(new GuildHomeCommand());
        GuildCommand.cmds.add(new GuildSetHomeCommand());
        GuildCommand.cmds.add(new GuildRankingCommand());
        GuildCommand.cmds.add(new GuildEnlargeCommand());
        GuildCommand.cmds.add(new GuildProlongCommand());
        GuildCommand.cmds.add(new GuildPermissionCommand());
        GuildCommand.cmds.add(new GuildItemsCommand());
        GuildCommand.cmds.add(new GuildKaraCommand());
        GuildCommand.cmds.add(new GuildFreeSpaceCommand());
        GuildCommand.cmds.add(new GuildPanelCommand());
        GuildCommand.cmds.add(new GuildWarsCommand());
        GuildCommand.cmds.add(new GuildInviteAllCommand());
        GuildCommand.cmds.add(new GuildChestCommand());
        GuildCommand.cmds.add(new GuildNotificationCommand());
    }
}
