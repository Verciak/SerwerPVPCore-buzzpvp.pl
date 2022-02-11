
package pl.vertty.arivi.inventory.utils;

import cn.nukkit.inventory.Inventory;
import java.util.Iterator;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.item.ItemData;
import java.util.Map;
import cn.nukkit.inventory.InventoryHolder;
import cn.nukkit.inventory.InventoryType;
import pl.vertty.arivi.inventory.InventoryMenu;
import cn.nukkit.math.Vector3;
import cn.nukkit.Player;
import cn.nukkit.inventory.ContainerInventory;

public class MenuInventory extends ContainerInventory
{
    protected Player owner;
    
    public MenuInventory(final Player owner, final Vector3 holder, final InventoryMenu menu) {
        this(owner, holder, menu, InventoryType.CHEST);
    }
    
    public MenuInventory(final Player owner, final Vector3 holder, final InventoryMenu menu, final InventoryType type) {
        super((InventoryHolder)new Holder(holder.x, holder.y, holder.z), type);
        this.owner = null;
        this.owner = owner;
        final InventoryCategory category = menu.getMainCategory();
        for (final Map.Entry<Integer, ItemData> entry : category.itemDataMap().entrySet()) {
            final int position = entry.getKey();
            final ItemData data = entry.getValue();
            this.setItem(position, data.build());
        }
    }
    
    public Player getOwner() {
        return this.owner;
    }
    
    public static class Holder extends Vector3 implements InventoryHolder
    {
        public Holder(final double x, final double y, final double z) {
            super(x, y, z);
        }
        
        public Inventory getInventory() {
            return null;
        }
    }
}
