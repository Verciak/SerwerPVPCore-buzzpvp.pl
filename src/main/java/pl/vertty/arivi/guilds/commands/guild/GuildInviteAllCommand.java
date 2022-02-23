
package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.math.Vector3;
import java.util.ArrayList;
import java.util.List;
import cn.nukkit.level.Location;
import java.util.Iterator;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.managers.RoleManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildInviteAllCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        if (!RoleManager.getUser(player.getName()).isUpr_addMember()) {
            player.sendMessage(ChatUtil.fixColor("&cNie posiadasz pozwolen od lidera!"));
            return false;
        }
        for (final Player p : this.getPlayersInRadius(player, player.getLocation(), 5)) {
            if (this.getPlayersInRadius(player, player.getLocation(), 5).size() < 1) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_INVITEALL_ERROR));
                return false;
            }
            if (GuildManager.getGuild(p) != null) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_INVITE_ERROR));
                return false;
            }
            if (guild.getInvites().contains(p)) {
                return true;
            }
            guild.getInvites().add(p);
            p.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_INVITE_MESSAGE2.replace("{NICK}", player.getName()).replace("{TAG}", guild.getTag())));
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_INVITEALL_SUCCESS.replace("{PLAYERS}", p.getName())));
        }
        return false;
    }
    
    public List<Player> getPlayersInRadius(final Player player, final Location location, final int size) {
        final List<Player> players = new ArrayList<Player>();
        for (final Player p : location.getLevel().getPlayers().values()) {
            if (player.distance((Vector3)p.getLocation()) <= size) {
                players.add(p);
                players.remove(player);
            }
        }
        return players;
    }
    
    public GuildInviteAllCommand() {
        super("zaprosall", "/g zaprosall", GroupType.PLAYER, new String[0]);
    }
}
