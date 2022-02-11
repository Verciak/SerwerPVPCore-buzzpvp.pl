
package pl.vertty.arivi.listeners.player;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.player.PlayerLoginEvent;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.event.player.PlayerPreLoginEvent;

public class MovementListener implements Listener
{
    @EventHandler
    public void onMove(final PlayerLoginEvent e) {
        e.getPlayer().setCheckMovement(false);
    }


    @EventHandler(priority = EventPriority.MONITOR)
    public void onLogin(PlayerPreLoginEvent event) {
        event.getPlayer().setCheckMovement(false);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (event.getFrom().equals(event.getTo())) {
            return;
        }
        if (event.getTo().getFloorY() < 0) {
            player.teleport(Server.getInstance().getDefaultLevel().getSpawnLocation().getLocation());
        }
    }

}
