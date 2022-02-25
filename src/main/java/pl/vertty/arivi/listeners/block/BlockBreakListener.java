package pl.vertty.arivi.listeners.block;

import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import pl.vertty.arivi.utils.guild.ChatUtil;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBlockPlace(BlockBreakEvent event) {
        Block block = event.getBlock();
        if(block.getLocation().getFloorY() <= 1){
            ChatUtil.sendMessage(event.getPlayer(), "&9Zabezpieczenie &8>> &7Nie możesz kopac nizej");
            event.setCancelled(true);
        }
        if (block.getId() == 19) {
            event.setCancelled(true);
        }
    }
}