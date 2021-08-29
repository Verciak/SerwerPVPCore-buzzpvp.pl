// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.global;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildTntCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        if (array.length < 2) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        if (array[1].equalsIgnoreCase("on")) {
            if (Config.ENABLE_TNT) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_TNT_ERROR));
                return false;
            }
            Config.ENABLE_TNT = true;
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_TNT_SUCCESS));
            return false;
        }
        else {
            if (!array[1].equalsIgnoreCase("off")) {
                return false;
            }
            if (!Config.ENABLE_TNT) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_TNT_ERROR2));
                return false;
            }
            Config.ENABLE_TNT = false;
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_TNT_SUCCESS2));
            return false;
        }
    }
    
    public GuildTntCommand() {
        super("tnt", "/ga tnt <on/off>", GroupType.ADMIN, new String[0]);
    }
}
