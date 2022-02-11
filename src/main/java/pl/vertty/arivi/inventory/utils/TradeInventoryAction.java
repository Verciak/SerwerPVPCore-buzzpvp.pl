
package pl.vertty.arivi.inventory.utils;

import cn.nukkit.inventory.Inventory;
import cn.nukkit.inventory.transaction.action.SlotChangeAction;
import pl.vertty.arivi.inventory.trade.TradeMenuHandler;
import cn.nukkit.inventory.transaction.action.InventoryAction;
import cn.nukkit.Player;
import cn.nukkit.network.protocol.types.NetworkInventoryAction;

public class TradeInventoryAction extends NetworkInventoryAction
{
    public boolean fake;
    
    public TradeInventoryAction(final boolean fake) {
        this.fake = fake;
    }
    
    public InventoryAction createInventoryAction(final Player p) {
        if (this.oldItem.equalsExact(this.newItem)) {
            return null;
        }
        if (!this.fake && this.sourceType == 0) {
            Inventory window = null;
            int slot = this.inventorySlot;
            if (this.windowId == 124 && (slot == 4 || slot == 5)) {
                window = (Inventory)TradeMenuHandler.getMenuByPlayer(p.getUniqueId()).getInventory(p);
                slot -= 4;
            }
            if (this.windowId == 124 && slot == 51) {
                window = (Inventory)TradeMenuHandler.getMenuByPlayer(p.getUniqueId()).getInventory(p);
                slot -= 49;
            }
            if (window != null) {
                return (InventoryAction)new SlotChangeAction(window, slot, this.oldItem, this.newItem);
            }
        }
        else if (this.fake && this.sourceType == 99999 && (this.windowId == -30 || this.windowId == -31)) {
            return new TradeAction(this.oldItem, this.newItem);
        }
        return null;
    }
}
