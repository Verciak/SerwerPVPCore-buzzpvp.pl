// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.admin;

import java.util.Iterator;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.plugin.Plugin;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.task.RegenerationTaskAdmin;
import pl.vertty.arivi.guilds.data.block.BlockRegeneration;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildRegenerationCommand extends PlayerCommand
{
    public GuildRegenerationCommand() {
        super("regeneracja", "/ga regeneracja <fast/slow> <tag> ", GroupType.ADMIN, new String[0]);
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        if (array.length < 3) {
            player.sendMessage(ChatUtil.fixColor(Config.COMMAND_USAGE.replace("{USAGE}", this.getUsage())));
            return false;
        }
        if (array[1].equalsIgnoreCase("fast")) {
            final Guild guild = GuildManager.getGuild(array[2]);
            if (guild == null) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_EXISTS));
                return false;
            }
            if (guild.getBlocks().isEmpty()) {
                ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_TITLE));
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_SUBTITLE7));
                return false;
            }
            if (guild.isRegeneration()) {
                ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_TITLE));
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_SUBTITLE8));
                return false;
            }
            for (final Player player2 : guild.getOnlineMembers()) {
                ChatUtil.sendTitle(player2, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_TITLE));
                ChatUtil.sendSubTitle(player2, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_SUBTITLE6.replace("{NAME}", player.getName())));
            }
            for (final BlockRegeneration blockState : guild.getBlocks()) {
                new RegenerationTaskAdmin(guild, guild.getBlocks()).runTaskTimer((Plugin)Main.getPlugin(), 0, 2);
            }
            guild.getBlocks().clear();
            return false;
        }
        else {
            if (!array[1].equalsIgnoreCase("slow")) {
                return false;
            }
            final Guild guild2 = GuildManager.getGuild(array[2]);
            if (guild2 == null) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_EXISTS));
                return false;
            }
            if (guild2.getBlocks().isEmpty()) {
                ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_TITLE));
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_SUBTITLE7));
                return false;
            }
            if (guild2.isRegeneration()) {
                ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_TITLE));
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_SUBTITLE8));
                return false;
            }
            for (final Player player3 : guild2.getOnlineMembers()) {
                ChatUtil.sendTitle(player3, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_TITLE));
                ChatUtil.sendSubTitle(player3, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_SUBTITLE6.replace("{NAME}", player.getName())));
            }
            new RegenerationTaskAdmin(guild2, guild2.getBlocks()).runTaskTimer((Plugin)Main.getPlugin(), 0, 2);
            return false;
        }
    }
}
