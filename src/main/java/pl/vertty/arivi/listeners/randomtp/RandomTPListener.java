
package pl.vertty.arivi.listeners.randomtp;

import cn.nukkit.Server;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

import cn.nukkit.block.Block;
import cn.nukkit.event.player.PlayerTeleportEvent;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.utils.guild.RandomUtil;
import cn.nukkit.Player;
import cn.nukkit.event.Listener;

public class RandomTPListener implements Listener
{

    @EventHandler
    public void onEntityDamage(final EntityDamageEvent event) {
        if(event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();
            User u = UserManager.getUser(p);
            if (u.isTeleport()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityDamagee(final EntityDamageByEntityEvent event) {
        Player p = (Player) event.getEntity();
        User u = UserManager.getUser(p);
        if(u.isTeleport()){
            event.setCancelled(true);
        }
    }


    public static boolean randomTp(final Player player) {


        final int x = RandomUtil.getRandInt(-570, 570);
        final int z = RandomUtil.getRandInt(-570, 570);
        final Location location = player.getLocation();
        final Block tele = player.getLocation().getLevel().getBlock(new Vector3(location.getX(), location.getY(), location.getZ()));
        final Location telep = tele.getLocation();
        final Location loc = new Location(x, telep.getLevel().getHighestBlockAt(x, z), z);
        User u2 = UserManager.getUser(player);
        u2.setTeleport(true);
        Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> u2.setTeleport(false), 4 * 20);

        player.teleport(loc, PlayerTeleportEvent.TeleportCause.PLUGIN);
        if (player.getEffects() != null) {
            player.removeAllEffects();
        }
        return true;
    }
    
    public List<Player> getPlayersInRadius(final Block b, final Location location, final int size) {
        final List<Player> players = new ArrayList<Player>();
        for (final Player p : location.getLevel().getPlayers().values()) {
            if (b.distance(p.getLocation()) <= size) {
                players.add(p);
            }
        }
        return players;
    }
    
    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Block block = e.getBlock();
        final Block i = e.getBlock();
        User u = UserManager.getUser(e.getPlayer());
        if (e.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK && block.getId() == 25 && i.getLocation().getFloorX() <= 65 && i.getLocation().getFloorX() >= -65 && i.getLocation().getFloorZ() <= 65 && i.getLocation().getFloorZ() >= -65) {
            if (this.getPlayersInRadius(block, e.getBlock().getLocation(), 3).size() < 2) {
                ChatUtil.sendTitle(e.getPlayer(), "", "&cPoczekaj na innych graczy aby sie teleportowac");
                return;
            }
            final Player p = e.getPlayer();
            randomTp(p);
            u.setTeleport(true);
            Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> u.setTeleport(false), 4 * 20);

            for (final Player players : this.getPlayersInRadius(block, block.getLocation(), 3)) {
                User ua = UserManager.getUser(players);
                ua.setTeleport(true);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> ua.setTeleport(false), 4 * 20);
                if (players.getEffects() != null) {
                    players.removeAllEffects();
                }
                players.teleport(p.getLocation());
            }
        }
        if (e.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK && block.getId() == 84 && i.getLocation().getFloorX() <= 65 && i.getLocation().getFloorX() >= -65 && i.getLocation().getFloorZ() <= 65 && i.getLocation().getFloorZ() >= -65) {
            if (this.getPlayersInRadius(block, e.getBlock().getLocation(), 3).size() < 2) {
                ChatUtil.sendTitle(e.getPlayer(), "", "&cPoczekaj na innych graczy aby sie teleportowac");
                return;
            }
            final Player p2 = this.getPlayersInRadius(block, e.getBlock().getLocation(), 3).get(0).getPlayer();
            final Player p3 = this.getPlayersInRadius(block, e.getBlock().getLocation(), 3).get(1).getPlayer();
            randomTp(p2);
            User u1 = UserManager.getUser(p2);
            User u2 = UserManager.getUser(p3);

            u1.setTeleport(true);
            Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> u1.setTeleport(false), 4 * 20);

            if (p3.getEffects() != null) {
                p3.removeAllEffects();
            }
            u2.setTeleport(true);
            Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> u2.setTeleport(false), 4 * 20);

            p3.teleport(p2.getLocation());
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onRandomTp(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        final Block clicked = event.getBlock();
        final Block i = event.getBlock();
        if (i.getLocation().getFloorX() <= 65 && i.getLocation().getFloorX() >= -65 && i.getLocation().getFloorZ() <= 65 && i.getLocation().getFloorZ() >= -65) {
            if (clicked.getId() != 19) {
                return;
            }
            randomTp(event.getPlayer());
        }
    }
}
