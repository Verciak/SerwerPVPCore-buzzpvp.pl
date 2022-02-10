package pl.vertty.arivi.listeners.water;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockUpdateEvent;
import cn.nukkit.event.block.LiquidFlowEvent;

public class WaterPhisicsListener implements Listener {

    @EventHandler
    public void onWoda(LiquidFlowEvent e){
        e.setCancelled(true);
    }
}
