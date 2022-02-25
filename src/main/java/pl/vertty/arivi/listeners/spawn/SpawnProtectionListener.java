
package pl.vertty.arivi.listeners.spawn;

import cn.nukkit.Server;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.player.*;
import cn.nukkit.event.block.BlockSpreadEvent;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.item.Item;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.managers.FakeWater;
import pl.vertty.arivi.managers.WaterManager;
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
    public void onWiadro(PlayerBucketFillEvent e) {
        Player p = e.getPlayer();
        Block i = e.getBlockClicked().getSide(e.getBlockFace().getOpposite());
        Location l = i.getLocation();
        if (i.getLocation().getFloorX() <= 200 && i.getLocation().getFloorX() >= -200 && i.getLocation().getFloorZ() <= 200 && i.getLocation().getFloorZ() >= -200) {
            if (i.getLocation().getFloorX() <= 101 && i.getLocation().getFloorX() >= -101 && i.getLocation().getFloorZ() <= 101 && i.getLocation().getFloorZ() >= -101) {
                e.setCancelled(true);
            }else{
                FakeWater water = WaterManager.getWater(l);
                if(water == null) {
                    e.setCancelled(true);
                    pl.vertty.arivi.utils.guild.ChatUtil.sendMessage(p, "&cNie mozesz zbierac na terenie spawna!");
                } else {
                    WaterManager.removeWater(l);
                }
            }
        }
        final Guild g = GuildManager.getGuildByLoc(i.getLocation());
        if (g != null) {
            FakeWater water = WaterManager.getWater(l);
            if(water == null) {
                e.setCancelled(true);
                pl.vertty.arivi.utils.guild.ChatUtil.sendMessage(p, "&cNie mozesz wylewac na terenie gildii!");
            } else {
                WaterManager.removeWater(l);
            }
        }
    }



    @EventHandler
    public void onWiadro(PlayerBucketEmptyEvent e) {
        Player p = e.getPlayer();
        Location l = e.getBlockClicked().getLocation();
        Block i = e.getBlockClicked();
        if (i.getLocation().getFloorX() <= 200 && i.getLocation().getFloorX() >= -200 && i.getLocation().getFloorZ() <= 200 && i.getLocation().getFloorZ() >= -200) {
            if (i.getLocation().getFloorX() <= 101 && i.getLocation().getFloorX() >= -101 && i.getLocation().getFloorZ() <= 101 && i.getLocation().getFloorZ() >= -101) {
                e.setCancelled(true);
            }else{
                if(e.getBucket().getName().toString().toUpperCase().contains("WATER")) {
                    WaterManager.createWater(l);
                } else {
                    e.setCancelled(true);
                    pl.vertty.arivi.utils.guild.ChatUtil.sendMessage(p, "&cNie mozesz wylewac na terenie spawna!");
                }
            }
        }
        final Guild g = GuildManager.getGuildByLoc(i.getLocation());
        if (g != null) {
            if(e.getBucket().getName().toString().toUpperCase().contains("WATER")) {
                WaterManager.createWater(l);
            } else {
                e.setCancelled(true);
                pl.vertty.arivi.utils.guild.ChatUtil.sendMessage(p, "&cNie mozesz wylewac na terenie gildii!");
            }
        }
    }
    
    
    @EventHandler
    public void xdddd(final ItemFrameDropItemEvent e) {
        final Player p = e.getPlayer();
        final Block i = e.getBlock();
        User u = UserManager.getUser(p);

        if (!u.can(GroupType.ADMIN)  && i.getLocation().getFloorX() <= 200 && i.getLocation().getFloorX() >= -200 && i.getLocation().getFloorZ() <= 200 && i.getLocation().getFloorZ() >= -200) {
            e.setCancelled(true);
        }
    }


    
    @EventHandler
    public void onSss(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final Block i = e.getBlock();
        User u = UserManager.getUser(p);

        if (((!u.can(GroupType.ADMIN)  && e.getBlock().getId() == Block.SNOW_BLOCK || e.getBlock().getId() == 200) || e.getBlock().getId() == 389 || p.getInventory().getItemInHand().getId() == 259 || p.getInventory().getItemInHand().getId() == Item.FLINT_AND_STEEL || p.getInventory().getItemInHand().getId() == 259) && i.getLocation().getFloorX() <= 101 && i.getLocation().getFloorX() >= -101 && i.getLocation().getFloorZ() <= 101 && i.getLocation().getFloorZ() >= -101) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    private void onBlockSpreadEvent(final PlayerInteractEvent e) {
        final Block i = e.getBlock();
        final Player p = e.getPlayer();
        User u = UserManager.getUser(p);

        if (!u.can(GroupType.ADMIN)  && i.getLocation().getFloorX() <= 200 && i.getLocation().getFloorX() >= -200 && i.getLocation().getFloorZ() <= 200 && i.getLocation().getFloorZ() >= -200 && (i.getId() == 17 || i.getId() == 3 || i.getId() == 2) && (e.getPlayer().getInventory().getItemInHand().getId() == 279 || e.getPlayer().getInventory().getItemInHand().getId() == 271 || e.getPlayer().getInventory().getItemInHand().getId() == 286 || e.getPlayer().getInventory().getItemInHand().getId() == 286 || e.getPlayer().getInventory().getItemInHand().getId() == 258 || e.getPlayer().getInventory().getItemInHand().getId() == 275 || e.getPlayer().getInventory().getItemInHand().getId() == 277 || e.getPlayer().getInventory().getItemInHand().getId() == 269 || e.getPlayer().getInventory().getItemInHand().getId() == 284 || e.getPlayer().getInventory().getItemInHand().getId() == 284 || e.getPlayer().getInventory().getItemInHand().getId() == 256 || e.getPlayer().getInventory().getItemInHand().getId() == 273)) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            final Player i = (Player)event.getEntity();
            if (i.getLocation().getFloorX() <= 101 && i.getLocation().getFloorX() >= -101 && i.getLocation().getFloorZ() <= 101 && i.getLocation().getFloorZ() >= -101) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityDamage(final PlayerDropItemEvent event) {
            final Player i = event.getPlayer();
            if (i.getLocation().getFloorX() <= 101 && i.getLocation().getFloorX() >= -101 && i.getLocation().getFloorZ() <= 101 && i.getLocation().getFloorZ() >= -101) {
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
        if (e.getCause().equals((Object)PlayerTeleportEvent.TeleportCause.ENDER_PEARL) && e.getTo().getFloorX() <= 101 && e.getTo().getFloorX() >= -101 && e.getTo().getFloorZ() <= 101 && e.getTo().getFloorZ() >= -101) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            final Player i = (Player)event.getEntity();
            final Player damage = (Player)event.getDamager();
            if (i.getLocation().getFloorX() <= 101 && i.getLocation().getFloorX() >= -101 && i.getLocation().getFloorZ() <= 101 && i.getLocation().getFloorZ() >= -101) {
                event.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    private void onBlockSpreadEvent(final BlockSpreadEvent e) {
        final Block i = e.getBlock();
        if (i.getLocation().getFloorX() <= 200 && i.getLocation().getFloorX() >= -200 && i.getLocation().getFloorZ() <= 200 && i.getLocation().getFloorZ() >= -200) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void breaks(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        final Block i = e.getBlock();
        User u = UserManager.getUser(p);

        if (!u.can(GroupType.ADMIN)  && i.getLocation().getFloorX() <= 200 && i.getLocation().getFloorX() >= -200 && i.getLocation().getFloorZ() <= 200 && i.getLocation().getFloorZ() >= -200) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void breaks(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        final Block i = e.getBlock();
        User u = UserManager.getUser(p);

        if (!u.can(GroupType.ADMIN)  && i.getLocation().getFloorX() <= 200 && i.getLocation().getFloorX() >= -200 && i.getLocation().getFloorZ() <= 200 && i.getLocation().getFloorZ() >= -200) {
            e.setCancelled(true);
        }else if (i.getId() == 130) {
                e.setDrops(new Item[0]);
                Server.getInstance().getDefaultLevel().dropItem(new Vector3(i.x, i.y, i.z), Item.get(130, Integer.valueOf(0), 1));
            }
    }
}
