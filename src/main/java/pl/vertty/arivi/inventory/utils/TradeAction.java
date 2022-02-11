
package pl.vertty.arivi.inventory.utils;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.inventory.transaction.action.InventoryAction;

public class TradeAction extends InventoryAction
{
    public TradeAction(final Item sourceItem, final Item targetItem) {
        super(sourceItem, targetItem);
    }
    
    public boolean isValid(final Player source) {
        return true;
    }
    
    public boolean execute(final Player source) {
        return source.getInventory().contains(this.sourceItem);
    }
    
    public void onExecuteSuccess(final Player source) {
    }
    
    public void onExecuteFail(final Player source) {
    }
}
