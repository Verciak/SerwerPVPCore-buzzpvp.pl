// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.utils;

import java.util.Iterator;
import java.util.HashMap;
import cn.nukkit.item.Item;
import java.util.Map;
import cn.nukkit.inventory.Inventory;

public final class InventoryUtil
{
    public static Map<Integer, Item> getIncludeEmptyInventoryContents(final Inventory inventory) {
        final Map<Integer, Item> contents = new HashMap<Integer, Item>();
        for (int i = 0; i < inventory.getSize(); ++i) {
            contents.put(i, inventory.getItem(i));
        }
        return contents;
    }
    
    public static Item[] inventoryContentsToItemArray(final Map<Integer, Item> contents) {
        final Item[] items = new Item[contents.size()];
        for (final Map.Entry<Integer, Item> entry : contents.entrySet()) {
            items[entry.getKey()] = entry.getValue();
        }
        return items;
    }
    
    public static Map<Integer, Item> itemArrayToInventoryContents(final Item[] items) {
        final Map<Integer, Item> contents = new HashMap<Integer, Item>();
        for (int i = 0; i < items.length; ++i) {
            contents.put(i, items[i]);
        }
        return contents;
    }
    
    private InventoryUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
