package pl.vertty.arivi.listeners.block;

import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBlockPlace(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getId() == 19) {
            event.setCancelled(true);
        }
    }
}