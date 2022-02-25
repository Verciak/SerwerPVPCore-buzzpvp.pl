
package pl.vertty.arivi.commands.guild;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.utils.guild.itemstack.ItemStackUtil;
import pl.vertty.arivi.utils.guild.TimeUtil;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildProlongCommand extends PlayerCommand
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
        if (guild.getProlong() > System.currentTimeMillis() + TimeUtil.DAY.getTime(Config.PROLONG_MAX)) {
            ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_PROLONG_TITLE));
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_PROLONG_SUBTITLE2));
            return false;
        }
        final String cost_PROLONG_NORMAL = Config.COST_PROLONG_NORMAL;
        if (!ItemStackUtil.checkItems(player, cost_PROLONG_NORMAL, 1)) {
            ItemStackUtil.getItem(player, cost_PROLONG_NORMAL, 1);
            return false;
        }
        ItemStackUtil.removeItems(player, cost_PROLONG_NORMAL, 1);
        guild.setProlong(guild.getProlong() + TimeUtil.DAY.getTime(Config.PROLONG_ADD));
        ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_PROLONG_TITLE));
        ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_PROLONG_SUBTITLE.replace("{PROLONG}", Integer.toString(Config.PROLONG_ADD))));
        return false;
    }
    
    public GuildProlongCommand() {
        super("przedluz", "/g przedluz", GroupType.PLAYER, new String[0]);
    }
}
