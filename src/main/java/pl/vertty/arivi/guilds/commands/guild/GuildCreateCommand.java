
package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.guilds.data.Role;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.managers.RoleManager;
import pl.vertty.arivi.guilds.managers.guild.NameTagManager;
import cn.nukkit.level.Location;
import pl.vertty.arivi.guilds.utils.itemstack.ItemStackUtil;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildCreateCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        if (GuildManager.getGuild(player) != null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_IS_GUILD));
            return false;
        }
        if (array.length != 3) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        final String upperCase = array[1].toUpperCase();
        final String s = array[2];
        if (upperCase.length() > 4 || upperCase.length() < 2 || s.length() > 32 || s.length() < 4) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_CREATE_ERROR4));
            return false;
        }
        if (GuildManager.getGuild(upperCase) != null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_CREATE_ERROR));
            return false;
        }
        if (GuildManager.getGuild(s) != null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_CREATE_ERROR1));
            return false;
        }
        if (!GuildManager.canCreateGuildBySpawn(player.getLocation())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_CREATE_ERROR2));
            return false;
        }
        if (!GuildManager.canCreateGuildByGuild(player.getLocation())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_CREATE_ERROR3));
            return false;
        }
        final User ua = UserManager.getUser(player);
        String s2 = Config.COST_CREATE_NORMAL;
        if (ua.can(GroupType.SVIP)) {
            s2 = Config.COST_CREATE_SVIP;
        }
        if (ua.can(GroupType.VIP)) {
            s2 = Config.COST_CREATE_VIP;
        }
        if(!ua.can(GroupType.ROOT)) {
            if (!ItemStackUtil.checkItems(player, s2, 1)) {
                ItemStackUtil.getItem(player, s2, 1);
                return false;
            }
        }
        ItemStackUtil.removeItems(player, s2, 1);
        final Guild guild = GuildManager.createGuild(upperCase.toUpperCase(), s, player, new Location(player.getLocation().getX(), player.getLevel().getHighestBlockAt(player.getLocation().getFloorX(), player.getLocation().getFloorZ()) + 1.5, player.getLocation().getZ()));
        guild.setHome(new Location(player.getLocation().getX(), 43.0, player.getLocation().getZ()));
        NameTagManager.refresh();
        RoleManager.permsOwner(RoleManager.getUser(player));
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_CREATE_MESSAGE.replace("{TAG}", guild.getTag()).replace("{NAZWA}", guild.getName()).replace("{NICK}", player.getName())));
        ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_CREATE_TITLE));
        ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_CREATE_SUBTITLE.replace("{TAG}", guild.getTag())));
        return false;
    }
    
    public GuildCreateCommand() {
        super("zaloz", "/g zaloz <tag> <pelna nazwa>", GroupType.PLAYER, new String[0]);
    }
}
