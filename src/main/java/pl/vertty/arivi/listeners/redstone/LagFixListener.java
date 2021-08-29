// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.redstone;

import cn.nukkit.event.EventHandler;
import cn.nukkit.block.Block;
import java.util.concurrent.TimeUnit;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.Cooldown;
import cn.nukkit.event.Listener;

public class LagFixListener implements Listener
{
    private static final Cooldown<Player> COOLDOWN;
    
    @EventHandler
    public void lagFix(final PlayerInteractEvent e) {
        final Block clicked = e.getBlock();
        final Player p = e.getPlayer();
        if (e.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK && clicked.getId() == 69) {
            if (LagFixListener.COOLDOWN.isOnCooldown(p)) {
                e.setCancelled(true);
            }
            else {
                LagFixListener.COOLDOWN.putOnCooldown(p, TimeUnit.SECONDS, 1L);
            }
        }
    }
    
    static {
        COOLDOWN = new Cooldown<Player>();
    }
}
