// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.player;

import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.utils.EnderchestUtil;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.Listener;

public class PlayerInterractListener implements Listener
{
    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {
        if (event.getBlock() != null && (event.getAction().equals((Object)PlayerInteractEvent.Action.RIGHT_CLICK_AIR) || event.getAction().equals((Object)PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)) && event.getBlock().getId() == 130) {
            event.setCancelled(true);
            EnderchestUtil.open(event.getPlayer());
        }
    }
}
