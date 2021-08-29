// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.border;

import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.EventPriority;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.utils.Config;
import cn.nukkit.level.Location;
import cn.nukkit.Player;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.Main;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.event.Listener;

public class BorderListener implements Listener
{
    @EventHandler
    public static void onMove(final PlayerMoveEvent event) {
        final Player player = event.getPlayer();
        final Location to = event.getTo();
        final Config c = Main.getPlugin().getConfig();
        if (event.getTo().getFloorX() > c.getInt("border") || event.getTo().getFloorX() < -c.getInt("border") || event.getTo().getFloorZ() > c.getInt("border") || event.getTo().getFloorZ() < -c.getInt("border")) {
            event.setTo(event.getFrom());
            player.sendMessage(ChatUtil.fixColor("&4Dotarles do granicy swiata! &8(&e%BORDER% kratek&8)").replace("%BORDER%", String.valueOf(c.getInt("border"))));
        }
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(final BlockPlaceEvent event) {
        if (!UserManager.canPlaceByBorder(event.getBlock().getLocation())) {
            event.setCancelled(true);
            ChatUtil.sendMessage((CommandSender)event.getPlayer(), "&4Nie mozesz stawiac przy borderze!");
        }
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreak(final BlockBreakEvent event) {
        if (!UserManager.canPlaceByBorder(event.getBlock().getLocation())) {
            event.setCancelled(true);
            ChatUtil.sendMessage((CommandSender)event.getPlayer(), "&4Nie mozesz niszczyc przy borderze!");
        }
    }
}
