
package pl.vertty.arivi.listeners.premium;

import cn.nukkit.event.EventHandler;
import cn.nukkit.utils.Config;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.drop.pierozek.PierozekManager;
import pl.vertty.arivi.Main;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.Listener;

public class PandoraListener implements Listener
{
    @EventHandler
    public void onPlace(final BlockPlaceEvent e) {
        final Player player = e.getPlayer();
        final Config c = Main.getPlugin().getConfig();
        if (player.getInventory().getItemInHand().getId() == PierozekManager.getPandoreItem().getId()) {
            if (!c.getBoolean("enable.pandora.status")) {
                e.setCancelled(true);
                ChatUtil.sendMessage((CommandSender)player, "&cPandory sa tymczasowo wylaczone!");
                return;
            }
            PierozekManager.giveItem(e);
        }
    }
}
