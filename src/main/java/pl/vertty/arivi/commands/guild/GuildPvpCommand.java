
package pl.vertty.arivi.commands.guild;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.managers.RoleManager;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

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
