package pl.vertty.arivi.listeners.action;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.LiquidFlowEvent;

public class LiquidFlowListener implements Listener {
    @EventHandler
    public void onLiquidFlow(LiquidFlowEvent event) {
        event.setCancelled(true);
    }
}