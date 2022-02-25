
package pl.vertty.arivi.commands.guild;

import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.gui.guild.TopkiGuildsGui;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildTopCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        TopkiGuildsGui.openTopki(player);
        return false;
    }

    public GuildTopCommand() {
        super("top", "/g top", GroupType.PLAYER, new String[]{"topki, topka"});
    }
}
