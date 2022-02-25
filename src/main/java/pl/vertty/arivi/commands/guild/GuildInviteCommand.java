
package pl.vertty.arivi.commands.guild;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.guild.Guild;
import cn.nukkit.Server;
import pl.vertty.arivi.managers.RoleManager;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildInviteCommand extends PlayerCommand
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
        if (array.length < 2) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        final Player player2 = Server.getInstance().getPlayer(array[1]);
        if (player2 == null) {
            player.sendMessage(ChatUtil.fixColor(Config.USER_NULL));
            return false;
        }
        if (GuildManager.getGuild(player2) != null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_INVITE_ERROR));
            return false;
        }
        if (guild.getInvites().contains(player2)) {
            guild.getInvites().remove(player2);
            player2.getPlayer().sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_INVITE_MESSAGE.replace("{NICK}", player.getName()).replace("{TAG}", guild.getTag())));
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_INVITE_SUCCESS1.replace("{NICK}", player2.getName())));
            return false;
        }
        guild.getInvites().add(player2);
        player2.getPlayer().sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_INVITE_MESSAGE2.replace("{NICK}", player.getName()).replace("{TAG}", guild.getTag())));
        player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_INVITE_SUCCESS2.replace("{NICK}", player2.getName())));
        return false;
    }
    
    public GuildInviteCommand() {
        super("zapros", "/g zapros <gracz>", GroupType.PLAYER, new String[0]);
    }
}
