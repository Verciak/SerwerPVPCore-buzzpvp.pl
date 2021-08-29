// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildDeleteCommand extends PlayerCommand
{
    public GuildDeleteCommand() {
        super("usun", "/g usun", GroupType.PLAYER, new String[0]);
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        if (!guild.isOwner(player)) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_OWNER));
            return false;
        }
        if (!guild.isPreDeleted()) {
            guild.setPreDeleted(true);
            Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_DELETE_MESSAGE.replace("{TAG}", guild.getTag()).replace("{NAZWA}", guild.getName()).replace("{NICK}", player.getName())));
            ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_DELETE_TITLE));
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_DELETE_SUBTITLE.replace("{TAG}", guild.getTag())));
            GuildManager.deleteGuild(guild);
            return true;
        }
        return false;
    }
}
