// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.listeners;

import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.player.PlayerTeleportEvent;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.Combat;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;

import java.math.BigDecimal;

public class AsyncPlayerChatListener implements Listener
{

    @EventHandler
    public void onPlayerTeleport(final PlayerTeleportEvent event) {
        if (event.getCause().equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL)) {
            event.setCancelled(true);
            event.getPlayer().teleport(event.getTo());
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onCommand(final PlayerCommandPreprocessEvent playerCommandPreprocessEvent) {
        final Player player = playerCommandPreprocessEvent.getPlayer();
        final String message = playerCommandPreprocessEvent.getMessage();
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
    }
}
