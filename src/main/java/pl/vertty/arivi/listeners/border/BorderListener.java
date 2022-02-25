
package pl.vertty.arivi.listeners.border;

import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.EventPriority;
import pl.vertty.arivi.MainConstants;
import pl.vertty.arivi.managers.UserManager;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.Player;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.event.Listener;

public class BorderListener implements Listener {
    @EventHandler
    public static void onMove(final PlayerMoveEvent event) {
        final Player player = event.getPlayer();
        if (event.getTo().getFloorX() > MainConstants.BORDER || event.getTo().getFloorX() < -MainConstants.BORDER || event.getTo().getFloorZ() > MainConstants.BORDER || event.getTo().getFloorZ() < -MainConstants.BORDER) {
            event.setTo(event.getFrom());
            player.sendMessage(ChatUtil.fixColor("&4Dotarles do granicy swiata! &8(&e%BORDER% kratek&8)").replace("%BORDER%", String.valueOf(MainConstants.BORDER)));
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(final BlockPlaceEvent event) {
        if (!UserManager.canPlaceByBorder(event.getBlock().getLocation())) {
            event.setCancelled(true);
            ChatUtil.sendMessage(event.getPlayer(), "&4Nie mozesz stawiac przy borderze!");
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreak(final BlockBreakEvent event) {
        if (!UserManager.canPlaceByBorder(event.getBlock().getLocation())) {
            event.setCancelled(true);
            ChatUtil.sendMessage(event.getPlayer(), "&4Nie mozesz niszczyc przy borderze!");
        }
    }
}