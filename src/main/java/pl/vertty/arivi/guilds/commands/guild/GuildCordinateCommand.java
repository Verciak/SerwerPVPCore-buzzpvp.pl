// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.guild;

import java.util.HashMap;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.utils.itemstack.ItemStackUtil;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.data.guild.Guild;
import java.util.Map;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildCordinateCommand extends PlayerCommand
{
    public static Map<Guild, Long> gt;
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        final Long n = GuildCordinateCommand.gt.get(guild);
        if (n != null && System.currentTimeMillis() - n < 36000L) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_CORDINATE_ERROR));
            return false;
        }
        if (array.length < 2) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        final Guild guild2 = GuildManager.getGuild(array[1]);
        if (guild2 == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_INFO_ERROR));
            return false;
        }
        final String cost_CORDINATE_NORMAL = Config.COST_CORDINATE_NORMAL;
        if (!ItemStackUtil.checkItems(player, cost_CORDINATE_NORMAL, 1)) {
            ItemStackUtil.getItem(player, cost_CORDINATE_NORMAL, 1);
            return false;
        }
        ItemStackUtil.removeItems(player, cost_CORDINATE_NORMAL, 1);
        GuildCordinateCommand.gt.put(guild, System.currentTimeMillis());
        player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_CORDINATE_SUCCESS.replace("{TAG}", guild2.getTag()).replace("{X}", Integer.toString(guild2.getRegion().getX())).replace("{Z}", Integer.toString(guild2.getRegion().getZ()))));
        return false;
    }
    
    public GuildCordinateCommand() {
        super("znajdz", "/g znajdz <tag>", GroupType.PLAYER, new String[0]);
    }
    
    static {
        GuildCordinateCommand.gt = new HashMap<Guild, Long>();
    }
}
