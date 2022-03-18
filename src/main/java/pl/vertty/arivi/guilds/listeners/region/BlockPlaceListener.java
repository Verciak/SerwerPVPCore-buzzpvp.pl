// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.listeners.region;

import cn.nukkit.block.Block;
import cn.nukkit.Player;
import cn.nukkit.math.Vector3;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.Listener;

public class BlockPlaceListener implements Listener
{
    
    @EventHandler
    public void slimeblock(final BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        final Block block = event.getBlock();
        if (block.getId() == 165 && player.getFloorX() == block.getFloorX() && player.getFloorY() - 1 == block.getFloorY() && player.getFloorZ() == block.getFloorZ()) {
            player.setMotion(new Vector3(0.0, 2.0, 0.0));
        }
    }
}
