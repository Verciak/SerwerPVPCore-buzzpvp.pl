// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.admin;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.utils.DataUtil;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildKaraCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        if (array.length < 2) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        final Guild guild = GuildManager.getGuild(array[1]);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_EXISTS));
            return false;
        }
        if (array.length < 3) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        if (guild.getTntKaraTime() > System.currentTimeMillis()) {
            guild.setTntKaraTime(0L);
            Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_KARA_SUCCESS2.replace("{TAG}", guild.getTag()).replace("{ADMIN}", player.getName())));
            return false;
        }
        final long dateDiff = DataUtil.parseDateDiff(array[2], true);
        guild.setTntKaraTime(dateDiff);
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_KARA_SUCCESS.replace("{TAG}", guild.getTag()).replace("{TIME}", DataUtil.secondsToString(dateDiff)).replace("{ADMIN}", player.getName())));
        return false;
    }
    
    public GuildKaraCommand() {
        super("kara", "/ga kara <tag> <czas> ", GroupType.ADMIN, new String[0]);
    }
}
