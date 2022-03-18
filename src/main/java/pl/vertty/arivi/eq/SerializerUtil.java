package pl.vertty.arivi.eq;

import cn.nukkit.inventory.Inventory;
import cn.nukkit.item.Item;
import com.google.common.io.ByteStreams;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.util.HashMap;
import java.util.Map;

public class SerializerUtil
{
    public static String serializeItem(final Item item) {
        return item.getId() + ":" + item.getDamage() + ":" + item.getCount() + (item.hasCompoundTag() ? (":" + new String(item.getCompoundTag())) : "");
    }

    public static Item deserializeItem(final String serialized) {
        final String[] data = serialized.split(":");
        final Item item = Item.get(Integer.parseInt(data[0]), Integer.valueOf(Integer.parseInt(data[1])), Integer.parseInt(data[2]));
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

    public static String serialize(Map<Integer, Item> items) {
        final var outputStream = ByteStreams.newDataOutput();

        outputStream.writeInt(items.size());

        items.forEach((slot, item) -> {
            outputStream.writeInt(slot);
            outputStream.writeUTF(SerializerUtil.serializeItem(item));
        });

        return Base64Coder.encodeLines(outputStream.toByteArray());
    }

    public static Map<Integer, Item> deserialize(String serialized) {
        final var inputStream = ByteStreams.newDataInput(Base64Coder.decodeLines(serialized));
        final var items = new HashMap<Integer, Item>();
        final int size = inputStream.readInt();

        for (int i = 0; i < size; i++) {
            final int slot = inputStream.readInt();
            final Item item = SerializerUtil.deserializeItem(inputStream.readUTF());

            items.put(slot, item);
        }

        return items;
    }
}

