
package pl.vertty.arivi.inventory;

import java.util.Iterator;
import cn.nukkit.inventory.transaction.InventoryTransaction;
import cn.nukkit.inventory.transaction.action.SlotChangeAction;
import cn.nukkit.inventory.transaction.action.InventoryAction;
import cn.nukkit.event.inventory.InventoryTransactionEvent;
import cn.nukkit.event.inventory.InventoryCloseEvent;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.utils.exception.SkinChangeException;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.Player;
import pl.vertty.arivi.inventory.utils.MenuInventory;
import cn.nukkit.event.inventory.InventoryClickEvent;
import lombok.NonNull;
import java.util.UUID;
import java.util.HashMap;
import cn.nukkit.event.Listener;

public class InventoryMenuHandler implements Listener
{
    public static HashMap<String, InventoryMenu> menus;
    public static HashMap<UUID, InventoryMenu> pmenus;
    
    public static InventoryMenu getMenuById(@NonNull final String id) {
        if (id == null) {
            throw new NullPointerException("id is marked non-null but is null");
        }
        if (InventoryMenuHandler.menus.containsKey(id)) {
            return InventoryMenuHandler.menus.get(id);
        }
        return null;
    }
    
    public static InventoryMenu getMenuByPlayer(@NonNull final UUID uuid) {
        if (uuid == null) {
            throw new NullPointerException("uuid is marked non-null but is null");
        }
        if (InventoryMenuHandler.pmenus.containsKey(uuid)) {
            return InventoryMenuHandler.pmenus.get(uuid);
        }
        return null;
    }
    
    public static void registerNewMenu(final String id, final InventoryMenu menu) {
        if (!InventoryMenuHandler.menus.containsKey(id)) {
            InventoryMenuHandler.menus.put(id, menu);
        }
    }
    
    public static void unregisterMenu(final String id) {
        if (InventoryMenuHandler.menus.containsKey(id)) {
            InventoryMenuHandler.menus.remove(id);
        }
    }
    
    @EventHandler
    public void onClick(final InventoryClickEvent event) throws SkinChangeException {
        final Player player = event.getPlayer();
        final Inventory inv = event.getInventory();
        if (getMenuByPlayer(player.getUniqueId()) != null && inv instanceof MenuInventory) {
            final InventoryMenu menu = getMenuByPlayer(player.getUniqueId());
            final int slot = event.getSlot();
            event.setCancelled();
            if (menu.getCurrentCategory().getItemClick(slot) != null) {
                menu.getCurrentCategory().getItemClick(slot).init(player, menu.getCurrentCategory().getItemData(slot));
                menu.getCurrentCategory().getItemClick(slot).onClick(player, event.getSourceItem());
            }
        }
    }
    
    @EventHandler
    public void onInventoryClose(final InventoryCloseEvent event) {
        final Player player = event.getPlayer();
        final Inventory inv = event.getInventory();
        if (getMenuByPlayer(player.getUniqueId()) != null) {
            final InventoryMenu menu = getMenuByPlayer(player.getUniqueId());
            menu.destroy(player);
        }
    }
    
    @EventHandler
    public void onTransaction(final InventoryTransactionEvent event) {
        final InventoryTransaction trans = event.getTransaction();
        for (final InventoryAction action : trans.getActions()) {
            if (action instanceof SlotChangeAction) {
                final SlotChangeAction act = (SlotChangeAction)action;
                if (!(act.getInventory() instanceof MenuInventory)) {
                    continue;
                }
                final MenuInventory inv = (MenuInventory)act.getInventory();
                if (!(inv.getOwner() instanceof Player)) {
                    continue;
                }
                final Player p = inv.getOwner();
                if (getMenuByPlayer(p.getUniqueId()) == null) {
                    continue;
                }
                final InventoryMenu menu = getMenuByPlayer(p.getUniqueId());
                if (!menu.onlyRead()) {
                    continue;
                }
                event.setCancelled();
            }
        }
    }
    
    static {
        InventoryMenuHandler.menus = new HashMap<String, InventoryMenu>();
        InventoryMenuHandler.pmenus = new HashMap<UUID, InventoryMenu>();
    }
}
