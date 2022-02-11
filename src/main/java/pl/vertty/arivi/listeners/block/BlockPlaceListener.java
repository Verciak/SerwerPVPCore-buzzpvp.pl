
package pl.vertty.arivi.listeners.block;

import cn.nukkit.event.EventHandler;
import cn.nukkit.block.Block;
import cn.nukkit.Player;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.Listener;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        if (block.getId() == 19 || block.getId() == 145) {
            event.setCancelled(true);
        }
    }
}