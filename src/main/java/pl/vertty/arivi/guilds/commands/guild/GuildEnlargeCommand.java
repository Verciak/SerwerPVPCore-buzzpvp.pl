// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.utils.itemstack.ItemStackUtil;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildEnlargeCommand extends PlayerCommand
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
        if (guild.getRegion().getSize() >= Config.CUBOID_SIZE_MAX) {
            ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_ENLARGE_TITLE));
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_ENLARGE_SUBTITLE2));
            return false;
        }
        final int n = (guild.getRegion().getSize() - Config.CUBOID_SIZE_START) / 5 + 1;
        final String cost_ENLARGE_NORMAL = Config.COST_ENLARGE_NORMAL;
        if (!ItemStackUtil.checkItems(player, cost_ENLARGE_NORMAL, n)) {
            ItemStackUtil.getItem(player, cost_ENLARGE_NORMAL, n);
            return false;
        }
        ItemStackUtil.removeItems(player, cost_ENLARGE_NORMAL, n);
        guild.addSize(Config.CUBOID_SIZE_ADD);
        final int i = guild.getRegion().getSize() + 1;
        ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_ENLARGE_TITLE));
        ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_ENLARGE_SUBTITLE.replace("{SIZE}", Integer.toString(i))));
        return false;
    }
    
    public GuildEnlargeCommand() {
        super("powieksz", "/g powieksz", GroupType.PLAYER, new String[0]);
    }
}
