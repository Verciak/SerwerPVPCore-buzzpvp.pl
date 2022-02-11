
package pl.vertty.arivi.listeners.crafting;

import cn.nukkit.event.EventHandler;
import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.event.inventory.CraftItemEvent;
import cn.nukkit.event.Listener;

public class CraftingBlockAndCreateListener implements Listener
{
    @EventHandler
    public void onCraftItem(final CraftItemEvent e) {
        final Item item = e.getRecipe().getResult();
        if (item.getId() == 310 || item.getId() == 311 || item.getId() == 312 || item.getId() == 313 || item.getId() == 276 || item.getId() == 293 || item.getId() == 292 || item.getId() == 291 || item.getId() == 290) {
            e.setCancelled(true);
        }
    }
}
