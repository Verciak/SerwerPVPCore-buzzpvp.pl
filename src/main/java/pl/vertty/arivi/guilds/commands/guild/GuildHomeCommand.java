// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.utils.TimerUtil;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildHomeCommand extends PlayerCommand
{
    public GuildHomeCommand() {
        super("baza", "/g baza", GroupType.PLAYER, new String[] { "home" });
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
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
