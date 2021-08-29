// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildKickCommand extends PlayerCommand
{
    public GuildKickCommand() {
        super("wyrzuc", "/g wyrzuc <gracz>", GroupType.PLAYER, new String[0]);
    }
    
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
        if (array.length < 2) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        final String substring = array[1];
        if (!guild.isMember(substring)) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_KICK_ERROR));
            return false;
        }
        if (guild.isOwner(substring)) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_KICK_ERROR1));
            return false;
        }
        if (player.getName().equals(substring)) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_KICK_ERROR2));
            return false;
        }
        if (guild.isLeader(substring)) {
            guild.setLeader("Brak");
        }
        guild.removeMember(substring);
        final User user = UserManager.getUser(substring);
        user.setUpr_Boyfarmer(true);
        user.setUpr_Break_Obsidian(true);
        user.setUpr_Chest(true);
        user.setUpr_Break_Stone(true);
        user.setUpr_Lava(true);
        user.setUpr_Place_Obsidian(true);
        user.setUpr_Place_Stone(true);
        user.setUpr_Tnt(true);
        user.setUpr_Water(true);
        user.setUpr_Lapis(true);
        user.setUpr_Logblock(true);
        user.setUpr_Furnace(true);
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_KICK_MESSAGE.replace("{NICK}", substring).replace("{TAG}", guild.getTag()).replace("{NICK2}", player.getName())));
        return false;
    }
}
