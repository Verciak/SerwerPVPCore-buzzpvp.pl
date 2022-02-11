
package pl.vertty.arivi.guilds.commands;

import pl.vertty.arivi.guilds.commands.global.GuildFarmerCommand;
import pl.vertty.arivi.guilds.commands.global.GuildStoneCommand;
import pl.vertty.arivi.guilds.commands.global.GuildTntCommand;
import java.util.HashSet;
import pl.vertty.arivi.enums.GroupType;
import java.util.Iterator;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Player;
import java.util.Set;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildGlobalCommand extends PlayerCommand
{
    public static Set<PlayerCommand> cmds;
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        if (array.length == 0) {
            final Iterator<String> iterator = Config.GUILD_COMMAND_HELP_GLOBAL_MESSAGE.iterator();
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
    
    public GuildGlobalCommand() {
        super("gg", "/ga", GroupType.PLAYER, new String[0]);
    }
    
    public PlayerCommand get(final String anotherString) {
        for (final PlayerCommand playerCommand : GuildGlobalCommand.cmds) {
            if (playerCommand.getName().equalsIgnoreCase(anotherString) || playerCommand.getAliases().equals(anotherString)) {
                return playerCommand;
            }
        }
        return null;
    }
    
    static {
        (GuildGlobalCommand.cmds = new HashSet<PlayerCommand>()).add(new GuildTntCommand());
        GuildGlobalCommand.cmds.add(new GuildStoneCommand());
        GuildGlobalCommand.cmds.add(new GuildFarmerCommand());
    }
}
