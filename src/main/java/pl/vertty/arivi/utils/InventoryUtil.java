
package pl.vertty.arivi.utils;

import cn.nukkit.inventory.Inventory;
import cn.nukkit.item.Item;
import pl.vertty.arivi.MainConstants;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.item.ItemData;

import java.util.HashMap;
import java.util.Map;

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
