// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.block;

import cn.nukkit.event.EventHandler;
import cn.nukkit.block.Block;
import cn.nukkit.Player;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.Listener;

public class BlockPlaceListener implements Listener
{
    @EventHandler
    public void onPlaceSponge(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        final Block b = e.getBlock();
        if (b.getId() == 19) {
            e.setCancelled(true);
        }
        if (b.getId() == 145) {
            e.setCancelled(true);
        }
    }
}
