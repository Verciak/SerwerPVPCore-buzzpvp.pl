// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.inventory.utils;

import java.util.Iterator;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.item.ItemData;
import java.util.Map;
import cn.nukkit.inventory.InventoryType;
import pl.vertty.arivi.inventory.InventoryMenu;
import cn.nukkit.math.Vector3;
import cn.nukkit.Player;

public class MenuDoubleInventory extends MenuInventory
{
    public MenuDoubleInventory(final Player owner, final Vector3 holder, final InventoryMenu menu) {
        super(owner, holder, menu, InventoryType.DOUBLE_CHEST);
        final InventoryCategory category = menu.getMainCategory();
        for (final Map.Entry<Integer, ItemData> entry : category.itemDataMap().entrySet()) {
            final int position = entry.getKey();
            final ItemData data = entry.getValue();
            this.setItem(position, data.build());
        }
    }
}
