package pl.vertty.arivi.listeners.inventory;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.inventory.InventoryClickEvent;
import cn.nukkit.event.inventory.InventoryTransactionEvent;
import cn.nukkit.event.player.PlayerDropItemEvent;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.inventory.InventoryType;
import cn.nukkit.inventory.transaction.InventoryTransaction;
import cn.nukkit.item.Item;
import pl.vertty.arivi.eq.SerializerUtil;
import pl.vertty.arivi.gui.EQGui;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.utils.ChatUtil;

import java.util.HashMap;
import java.util.Map;

public class InventoryClickListener implements Listener {


    @EventHandler
    public void onDrop(final PlayerDropItemEvent event) {
        final Player player = event.getPlayer();
        if(UserManager.getUser(player).isStatus() == true){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onTransaction(final InventoryTransactionEvent event) {
        final InventoryTransaction transaction = event.getTransaction();

        if (UserManager.getUser(event.getTransaction().getSource()).isStatus() == true) {
            transaction.getInventories().forEach(inventory -> {
                if (inventory.getType() == InventoryType.PLAYER)
                    event.setCancelled(true);
            });
        }
    }

    @EventHandler
    public void handleEQGuiClickSaveItem(final InventoryClickEvent event) {
        final Inventory inventory = event.getInventory();
        if (UserManager.getUser(event.getPlayer()).isStatus() == true) {

            if (inventory.getType() == InventoryType.PLAYER) {
                event.setCancelled(true);
            }
        }
        if (inventory.getTitle().equals(ChatUtil.fixColor(EQGui.GUI_TITLE))) {



            final Item item = event.getSourceItem();

            if (EQGui.isGlassItem(item)) {
                event.setCancelled();
            }

            if (EQGui.isSaveItem(item)) {
                event.setCancelled();

                final Map<Integer, Item> items = new HashMap();

                inventory.getContents().forEach((slot, invItem) -> {
                    if (EQGui.isSaveItem(invItem)) {
                        return;
                    }

                    if (slot < 18) return;

                    if (slot >= 45 && slot <= 53) {
                        slot -= 45;
                    } else {
                        slot -= 9;
                    }

                    items.put(slot, invItem);
                });

                final User user = UserManager.getUser(event.getPlayer());
                final String serialized = SerializerUtil.serialize(items);

                user.setEq_1(serialized);
                event.getInventory().close(event.getPlayer());
                UserManager.getUser(event.getPlayer()).setStatus(false);
                ChatUtil.sendTitle(event.getPlayer(), "", "&7Ekwipunek zostal &azapisany&7!");
            }
        }
    }
}
