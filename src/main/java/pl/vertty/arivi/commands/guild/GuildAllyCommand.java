
package pl.vertty.arivi.commands.guild;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.guild.Guild;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildAllyCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        if (!guild.isOwner(player)) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_OWNER));
            return false;
        }
        if (array.length < 2) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        if (array[1].equalsIgnoreCase("zerwij")) {
            if (array.length < 3) {
                player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
                return false;
            }
            final Guild guild2 = GuildManager.getGuild(array[2]);
            if (guild2 == null) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_ERROR));
                return false;
            }
            if (guild.equals(guild2)) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_ERROR1));
                return false;
            }
            if (!guild.getAlly().contains(guild2.getTag())) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_ERROR2));
                return false;
            }
            guild.removeAlly(guild2.getTag());
            guild2.removeAlly(guild.getTag());
            Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_MESSAGE.replace("{TAG}", guild.getTag()).replace("{TAG2}", guild2.getTag())));
            return false;
        }
        else {
            if (!array[1].equalsIgnoreCase("zawrzyj")) {
                return false;
            }
            if (array.length < 3) {
                player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
                return false;
            }
            final Guild guild2 = GuildManager.getGuild(array[2]);
            if (guild2 == null) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_ERROR));
                return false;
            }
            if (guild.equals(guild2)) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_ERROR1));
                return false;
            }
            if (guild.getAlly().contains(guild2.getTag())) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_ERROR3));
                return false;
            }
            if (guild.getAllyinvites().contains(guild2)) {
                guild.getAllyinvites().remove(guild2);
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_SUCCESS.replace("{TAG}", guild2.getTag())));
                final Player player2 = Server.getInstance().getPlayer(guild2.getOwner());
                if (player2 != null) {
                    player2.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_SUCCESS1.replace("{TAG}", guild.getTag())));
                }
            }
            else {
                if (guild.getAlly().size() >= 4) {
                    player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_ERROR4));
                    return false;
                }
                if (guild2.getAlly().size() >= 4) {
                    player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_ERROR5));
                    return false;
                }
                final Player player3 = Server.getInstance().getPlayer(guild2.getOwner());
                if (player3 == null) {
                    player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_ERROR6));
                    return false;
                }
                if (!guild2.getAllyinvites().contains(guild)) {
                    guild.getAllyinvites().add(guild2);
                    player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_SUCCESS2.replace("{TAG}", guild2.getTag())));
                    player3.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_SUCCESS3.replace("{TAG}", guild.getTag())));
                    return false;
                }
                guild.addAlly(guild2.getTag());
                guild2.addAlly(guild.getTag());
                guild.getAllyinvites().remove(guild2);
                guild2.getAllyinvites().remove(guild);
                Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_SOJUSZ_MESSAGE2.replace("{TAG}", guild.getTag()).replace("{TAG2}", guild2.getTag())));
            }
            return false;
        }
    }
    
    public GuildAllyCommand() {
        super("sojusz", "/g sojusz <zawrzyj/zerwij> <tag>", GroupType.PLAYER, new String[0]);
    }
}
