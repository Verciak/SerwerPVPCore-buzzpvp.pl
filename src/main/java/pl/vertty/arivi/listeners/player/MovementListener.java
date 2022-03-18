
package pl.vertty.arivi.listeners.player;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.player.*;
import cn.nukkit.event.Listener;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.managers.UserManager;

public class MovementListener implements Listener {
    @EventHandler
    public void onMove(final PlayerLoginEvent e) {
        e.getPlayer().setCheckMovement(false);
    }


    @EventHandler
    public void onFood(PlayerEatFoodEvent e) {
        e.setCancelled(true);

    }

    @EventHandler
    public void onFood(PlayerFoodLevelChangeEvent e) {
        e.setCancelled(true);

    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onLogin(PlayerPreLoginEvent event) {
        event.getPlayer().setCheckMovement(false);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if(!UserManager.getUser(player).can(GroupType.HELPER)) {
            if (!"tp".contains(event.getPlayer().getLevel().getName()) && player.getLocation().getFloorX() <= 200 && player.getLocation().getFloorX() >= -200 && player.getLocation().getFloorZ() <= 200 && player.getLocation().getFloorZ() >= -200) {

                if (UserManager.getUser(player).isFlying() == true) {
                    player.setAllowFlight(true);
                } else {
                    player.setAllowFlight(false);
                }
            }
        }

        if (event.getFrom().equals(event.getTo())) {
            return;
        }
        if (event.getTo().getFloorY() < 0) {
            player.teleport(Server.getInstance().getDefaultLevel().getSpawnLocation().getLocation());
        }
    }

}
