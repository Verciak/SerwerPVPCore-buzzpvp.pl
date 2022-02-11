
package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.guilds.data.guild.Role;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.managers.guild.RoleManager;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.utils.itemstack.ItemStackUtil;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildJoinCommand extends PlayerCommand
{
    public GuildJoinCommand() {
        super("dolacz", "/g dolacz <tag>", GroupType.PLAYER, new String[0]);
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        if (GuildManager.getGuild(player) != null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_IS_GUILD));
            return false;
        }
        if (array.length < 2) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        final Guild guild = GuildManager.getGuild(array[1]);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_JOIN_ERROR));
            return false;
        }
        if (!guild.getInvites().contains(player)) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_JOIN_ERROR1));
            return false;
        }
        if (guild.getMembers().size() >= guild.getLimitMembers()) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_JOIN_ERROR2));
            return false;
        }
        final int size = guild.getMembers().size();
        final String cost_JOIN_NORMAL = Config.COST_JOIN_NORMAL;
        if (!ItemStackUtil.checkItems(player, cost_JOIN_NORMAL, size)) {
            ItemStackUtil.getItem(player, cost_JOIN_NORMAL, size);
            return false;
        }
        ItemStackUtil.removeItems(player, cost_JOIN_NORMAL, size);
        guild.getInvites().remove(player);
        guild.addMember(player);
        final User user = UserManager.getUser(player);
        final Role role2 = RoleManager.getRole(guild.getTag(), "ROLA 1");
        user.setUpr_Furnace(role2.isUpr_Furnace());
        user.setUpr_Logblock(role2.isUpr_Logblock());
        user.setUpr_Lava(role2.isUpr_Lava());
        user.setUpr_Boyfarmer(role2.isUpr_Boyfarmer());
        user.setUpr_Chest(role2.isUpr_Chest());
        user.setUpr_Tnt(role2.isUpr_Tnt());
        user.setUpr_Place_Obsidian(role2.isUpr_Place_Obsidian());
        user.setUpr_Place_Stone(role2.isUpr_Place_Stone());
        user.setUpr_Break_Obsidian(role2.isUpr_Break_Obsidian());
        user.setUpr_Lapis(role2.isUpr_Lapis());
        user.setUpr_Break_Stone(role2.isUpr_Break_Stone());
        user.setUpr_Water(role2.isUpr_Water());
        user.setRole(role2.getName());
        player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_JOIN_SUCCESS.replace("{TAG}", guild.getTag())));
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_JOIN_MESSAGE.replace("{NICK}", player.getName()).replace("{TAG}", guild.getTag())));
        return false;
    }
}
