
package pl.vertty.arivi.listeners.guild.region;

import cn.nukkit.event.player.PlayerBucketFillEvent;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.utils.guild.region.CuboidUtil;
import cn.nukkit.event.player.PlayerBucketEmptyEvent;
import cn.nukkit.event.Listener;

public class PlayerBucketListener implements Listener
{
    @EventHandler
    public void onPlayerBucketEmpty(final PlayerBucketEmptyEvent playerBucketEmptyEvent) {
        playerBucketEmptyEvent.setCancelled(CuboidUtil.cancelAction(playerBucketEmptyEvent.getPlayer(), playerBucketEmptyEvent.getBlockClicked().getLocation().add(0.0, 1.0, 0.0), "&cNa terenie wrogiej gildi nie mozesz budowac", playerBucketEmptyEvent.getPlayer().getInventory().getItemInHand().getId(), "WYLANIE"));
    }
    
    @EventHandler
    public void onPlayerBucketFill(final PlayerBucketFillEvent playerBucketFillEvent) {
        playerBucketFillEvent.setCancelled(CuboidUtil.cancelAction(playerBucketFillEvent.getPlayer(), playerBucketFillEvent.getBlockClicked().getLocation(), "&cNa terenie wrogiej gildi nie mozesz budowac", playerBucketFillEvent.getPlayer().getInventory().getItemInHand().getId(), "NAPELNIENIE"));
    }
}
