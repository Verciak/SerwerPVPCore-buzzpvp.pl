// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.listeners;

import java.util.Iterator;

import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.block.LeavesDecayEvent;
import cn.nukkit.event.Listener;

public class AsyncPlayerChatListener implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void onLeaves(final LeavesDecayEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onCommand(final PlayerCommandPreprocessEvent playerCommandPreprocessEvent) {
        final Player player = playerCommandPreprocessEvent.getPlayer();
        final String message = playerCommandPreprocessEvent.getMessage();
        final Guild guild = GuildManager.getGuild(player.getLocation());
        String pcmd = playerCommandPreprocessEvent.getMessage();
        Combat combat = CombatManager.getCombat(player);
        if (combat != null && combat.hasFight()) {
            for (String cmd : Main.getPlugin().getConfig().getStringList("config.blocked.cmd.incombat")) {
                if (pcmd.toLowerCase().contains("/" + cmd)) {
                    playerCommandPreprocessEvent.setCancelled(true);
                    ChatUtil.sendMessage((CommandSender) player, "&cTa komenda jest zablokowana podczas walki!");
                    return;
                }
            }
        }
        if (guild != null && !guild.isMember(player.getName()) && !player.isOp()) {
            final Iterator<String> iterator = Config.CMD_IN_GUILD.iterator();
            while (iterator.hasNext()) {
                if (message.toLowerCase().contains(String.valueOf(new StringBuilder().append("/").append(iterator.next())))) {
                    playerCommandPreprocessEvent.setCancelled(true);
                    ChatUtil.sendMessage((CommandSender)player, Config.GUILD_COMMAND_USE_GUILD);
                }
            }
        }
    }
}
