
package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.guild.War;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.managers.guild.WarManager;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildWarsCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        openInv(player, guild);
        return false;
    }
    
    private static void lambdaaddSignPoddaj0(final Player player, final Guild guild, final Player player2, final String[] array) {
        final Guild guild2 = GuildManager.getGuild(array[0].substring(1, array[0].length() - 1));
        if (guild2 == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_EXISTS));
            return;
        }
        final War war = WarManager.getWar(guild2.getTag());
        if (war != null) {
            Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_WOJNA_TIME2.replace("{TAG}", war.getTag()).replace("{TAG2}", war.getTag2())));
            WarManager.deleteWar(war);
            return;
        }
        player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_WOJNA_ERROR3));
        openInv(player, guild);
    }
    
    private static void lambdaaddSignWypowiedz1(final Player player, final Guild guild, final Player player2, final String[] array) {
        final Guild guild2 = GuildManager.getGuild(array[0].substring(1, array[0].length() - 1));
        if (guild2 == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_EXISTS));
            return;
        }
        if (guild.getTag().equalsIgnoreCase(guild2.getTag())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_WOJNA_ERROR2));
            return;
        }
        final War war = WarManager.getWar(guild.getTag());
        if (war != null && war.getTag2().equalsIgnoreCase(guild2.getTag())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_WOJNA_ERROR));
            return;
        }
        new War(guild.getTag(), guild2.getTag(), guild2.getName());
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_WOJNA_MESSAGE.replace("{TAG}", guild.getTag()).replace("{TAG2}", guild2.getTag())));
        openInv(player, guild);
    }
    
    public static void openInv(final Player player, final Guild guild) {
    }
    
    public GuildWarsCommand() {
        super("wojny", "/g wojny", GroupType.PLAYER, new String[0]);
    }
}
