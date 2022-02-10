// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.utils;

import cn.nukkit.inventory.Inventory;
import cn.nukkit.item.Item;

public class SeralizerUtil {
    public static String serializeItem(final Item item) {
        return item.getId() + ":" + item.getDamage() + ":" + item.getCount() + (item.hasCompoundTag() ? (":" + new String(item.getCompoundTag())) : "");
    }

    public static Item deserializeItem(final String serialized) {
        final String[] data = serialized.split(":");
        final Item item = Item.get(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        final String compoundTag = (data.length - 1 >= 3) ? data[3] : "";
        if (!compoundTag.isEmpty()) {
            item.setCompoundTag(compoundTag.getBytes());
        }
        return item;
    }

    public static String serializeItemArray(final Item[] items) {
        final StringBuilder sb = new StringBuilder();
        sb.append(items.length).append(";");
        for (final Item item : items) {
            sb.append(serializeItem(item)).append(";");
        }
        sb.substring(0, sb.length() - 1);
        return sb.toString();
    }

    public static Item[] deserializeItemArray(final String serialized) {
        final String[] data = serialized.split(";");
        final Item[] items = new Item[Integer.parseInt(data[0])];
        for (int i = 0; i < items.length; ++i) {
            items[i] = deserializeItem(data[i + 1]);
        }
        return items;
    }

    public static String serializeInventory(final Inventory inventory) {
        return serializeItemArray(InventoryUtil.inventoryContentsToItemArray(InventoryUtil.getIncludeEmptyInventoryContents(inventory)));
    }
}