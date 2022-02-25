
package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.enums.GroupType;
import java.util.Iterator;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.managers.RoleManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildPvpCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        if (array.length == 1) {
            if (!RoleManager.getUser(player.getName()).isUpr_pvpguild()) {
                player.sendMessage(ChatUtil.fixColor("&cNie posiadasz pozwolen od lidera!"));
                return false;
            }
            guild.setPvp(!guild.isPvp());
            for(Player p : guild.getOnlineMembers()){
                p.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_PVP_SUCCESS1.replace("{NICK}", player.getName()).replace("{STATUS}", guild.isPvp() ? "&awlaczyl" : "&cwylaczyl")));
                return true;
            }
        }
        if (array[1].equalsIgnoreCase("sojusz")) {
            if (!RoleManager.getUser(player.getName()).isUpr_pvpally()) {
                player.sendMessage(ChatUtil.fixColor("&cNie posiadasz pozwolen od lidera!"));
                return false;
            }
            guild.setPvpAlly(!guild.isPvpAlly());
            for(Player p : guild.getOnlineMembers()){
                p.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_PVP_SUCCESS2.replace("{NICK}", player.getName()).replace("{STATUS}", guild.isPvpAlly() ? "&awlaczyl" : "&cwylaczyl")));
                return true;
            }
        }
        return false;
    }
    
    public GuildPvpCommand() {
        super("pvp", "/g pvp", GroupType.PLAYER, new String[] { "g ff" });
    }
}
