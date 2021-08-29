package pl.vertty.arivi.listeners.water;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockUpdateEvent;

public class WaterPhisicsListener implements Listener {


    @EventHandler
    public void onWather(final BlockUpdateEvent e){
        final Block b = e.getBlock();
        if (b.getLocation().getY() > 50 && b.getId() == BlockID.WATER){
            e.setCancelled(true);
        }
    }
}
