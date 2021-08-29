// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.block;

import cn.nukkit.event.EventHandler;
import cn.nukkit.block.Block;
import cn.nukkit.math.Vector3;
import cn.nukkit.Server;
import cn.nukkit.item.Item;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.Listener;

public class BlockBreakListener implements Listener
{
    @EventHandler
    public void onGabka(final BlockBreakEvent e) {
        final Block b = e.getBlock();
        if (b.getId() == 19) {
            e.setCancelled(true);
        }
        if (b.getId() == 130) {
            e.setDrops(new Item[0]);
            Server.getInstance().getDefaultLevel().dropItem(new Vector3(b.x, b.y, b.z), Item.get(130, Integer.valueOf(0), 1));
        }
    }
}
