// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.spawn;

import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.player.*;
import cn.nukkit.event.block.BlockSpreadEvent;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.block.Block;
import cn.nukkit.Player;
import cn.nukkit.event.block.ItemFrameDropItemEvent;
import cn.nukkit.event.Listener;

public class SpawnProtectionListener implements Listener
{
    @EventHandler
    public void xdddd(final ItemFrameDropItemEvent e) {
        final Player p = e.getPlayer();
        final Block i = e.getBlock();
        if (!p.hasPermission("protect") && i.getLocation().getFloorX() <= 150 && i.getLocation().getFloorX() >= -150 && i.getLocation().getFloorZ() <= 150 && i.getLocation().getFloorZ() >= -150) {
            e.setCancelled(true);
        }
    }


    
    @EventHandler
    public void onSss(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final Block i = e.getBlock();
        if (((!p.hasPermission("protect") && e.getBlock().getId() == 150) || e.getBlock().getId() == 389 || p.getInventory().getItemInHand().getId() == 259 || p.getInventory().getItemInHand().getId() == 318 || p.getInventory().getItemInHand().getId() == 259) && i.getLocation().getFloorX() <= 65 && i.getLocation().getFloorX() >= -65 && i.getLocation().getFloorZ() <= 65 && i.getLocation().getFloorZ() >= -65) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    private void onBlockSpreadEvent(final PlayerInteractEvent e) {
        final Block i = e.getBlock();
        final Player p = e.getPlayer();
        if (!p.hasPermission("protect") && i.getLocation().getFloorX() <= 150 && i.getLocation().getFloorX() >= -150 && i.getLocation().getFloorZ() <= 150 && i.getLocation().getFloorZ() >= -150 && (i.getId() == 17 || i.getId() == 3 || i.getId() == 2) && (e.getPlayer().getInventory().getItemInHand().getId() == 279 || e.getPlayer().getInventory().getItemInHand().getId() == 271 || e.getPlayer().getInventory().getItemInHand().getId() == 286 || e.getPlayer().getInventory().getItemInHand().getId() == 286 || e.getPlayer().getInventory().getItemInHand().getId() == 258 || e.getPlayer().getInventory().getItemInHand().getId() == 275 || e.getPlayer().getInventory().getItemInHand().getId() == 277 || e.getPlayer().getInventory().getItemInHand().getId() == 269 || e.getPlayer().getInventory().getItemInHand().getId() == 284 || e.getPlayer().getInventory().getItemInHand().getId() == 284 || e.getPlayer().getInventory().getItemInHand().getId() == 256 || e.getPlayer().getInventory().getItemInHand().getId() == 273)) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            final Player i = (Player)event.getEntity();
            if (i.getLocation().getFloorX() <= 65 && i.getLocation().getFloorX() >= -65 && i.getLocation().getFloorZ() <= 65 && i.getLocation().getFloorZ() >= -65) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityDamage(final PlayerDropItemEvent event) {
            final Player i = event.getPlayer();
            if (i.getLocation().getFloorX() <= 65 && i.getLocation().getFloorX() >= -65 && i.getLocation().getFloorZ() <= 65 && i.getLocation().getFloorZ() >= -65) {
                event.setCancelled(true);
            }
    }
    
    @EventHandler
    public void onPlayerTeleport(final PlayerTeleportEvent e) {
        final Player p = e.getPlayer();
        if (e.getCause().equals((Object)PlayerTeleportEvent.TeleportCause.ENDER_PEARL) && (e.getTo().getX() > 800.0 || e.getTo().getX() < -800.0 || e.getTo().getZ() > 800.0 || e.getTo().getZ() < -800.0)) {
            e.setCancelled(true);
            p.sendMessage(ChatUtil.fixColor("&4Dotarles do granicy swiata! &8(&e%BORDER% kratek&8)").replace("%BORDER%", String.valueOf(800)));
            return;
        }
        if (e.getCause().equals((Object)PlayerTeleportEvent.TeleportCause.ENDER_PEARL) && e.getTo().getFloorX() <= 65 && e.getTo().getFloorX() >= -65 && e.getTo().getFloorZ() <= 65 && e.getTo().getFloorZ() >= -65) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            final Player i = (Player)event.getEntity();
            final Player damage = (Player)event.getDamager();
            if (i.getLocation().getFloorX() <= 65 && i.getLocation().getFloorX() >= -65 && i.getLocation().getFloorZ() <= 65 && i.getLocation().getFloorZ() >= -65) {
                event.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    private void onBlockSpreadEvent(final BlockSpreadEvent e) {
        final Block i = e.getBlock();
        if (i.getLocation().getFloorX() <= 150 && i.getLocation().getFloorX() >= -150 && i.getLocation().getFloorZ() <= 150 && i.getLocation().getFloorZ() >= -150) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onPlayerBucketEmpty(final PlayerBucketEmptyEvent event) {
        final Player p = event.getPlayer();
        final Player i = event.getPlayer();
        if (!p.hasPermission("protect") && i.getLocation().getFloorX() <= 150 && i.getLocation().getFloorX() >= -150 && i.getLocation().getFloorZ() <= 150 && i.getLocation().getFloorZ() >= -150) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onPlayerBucketEmptye(final PlayerBucketFillEvent event) {
        final Player p = event.getPlayer();
        final Player i = event.getPlayer();
        if (!p.hasPermission("protect") && i.getLocation().getFloorX() <= 150 && i.getLocation().getFloorX() >= -150 && i.getLocation().getFloorZ() <= 150 && i.getLocation().getFloorZ() >= -150) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void breaks(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        final Block i = e.getBlock();
        if (!p.hasPermission("protect") && i.getLocation().getFloorX() <= 150 && i.getLocation().getFloorX() >= -150 && i.getLocation().getFloorZ() <= 150 && i.getLocation().getFloorZ() >= -150) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void breaks(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        final Block i = e.getBlock();
        if (!p.hasPermission("protect") && i.getLocation().getFloorX() <= 150 && i.getLocation().getFloorX() >= -150 && i.getLocation().getFloorZ() <= 150 && i.getLocation().getFloorZ() >= -150) {
            e.setCancelled(true);
        }
    }
}
