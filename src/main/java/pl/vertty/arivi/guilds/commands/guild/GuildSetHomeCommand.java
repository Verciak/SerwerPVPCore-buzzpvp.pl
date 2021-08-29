// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

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
