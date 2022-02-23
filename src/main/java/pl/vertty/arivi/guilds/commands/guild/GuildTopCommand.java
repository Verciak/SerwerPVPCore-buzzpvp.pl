
package pl.vertty.arivi.guilds.commands.guild;

import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.gui.guild.TopkiGuildsGui;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

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
