
package pl.vertty.arivi.inventory;

import java.util.Iterator;

import pl.vertty.arivi.MainConstants;
import pl.vertty.arivi.inventory.item.ItemData;
import java.util.Map;
import cn.nukkit.network.protocol.ContainerClosePacket;
import cn.nukkit.level.GlobalBlockPalette;
import cn.nukkit.network.protocol.UpdateBlockPacket;
import cn.nukkit.network.protocol.DataPacket;
import java.io.IOException;
import cn.nukkit.nbt.NBTIO;
import java.nio.ByteOrder;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.network.protocol.BlockEntityDataPacket;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.inventory.utils.MenuInventory;
import pl.vertty.arivi.inventory.utils.MenuDoubleInventory;
import lombok.NonNull;
import cn.nukkit.Player;
import cn.nukkit.inventory.Inventory;
import java.util.UUID;
import java.util.HashMap;

public class InventoryMenu
{
    private InventoryCategory category;
    private HashMap<String, InventoryCategory> categories;
    private InventoryCategory currentCategory;
    private HashMap<UUID, Inventory> inventories;
    protected String name;
    protected boolean isDouble;
    private boolean read;
    
    public InventoryMenu() {
        this.category = null;
        this.categories = new HashMap<String, InventoryCategory>();
        this.currentCategory = null;
        this.inventories = new HashMap<UUID, Inventory>();
        this.name = "Menu";
        this.isDouble = false;
        this.read = true;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Inventory getInventory(final UUID uuid) {
        if (this.inventories.containsKey(uuid)) {
            return this.inventories.get(uuid);
        }
        return null;
    }
    
    public void show(@NonNull final Player player) {
        if (player == null) {
            throw new NullPointerException("player is marked non-null but is null");
        }
        final Vector3 vec = this.createInventory(player);
        final MenuInventory inv = this.isDoubleChest() ? new MenuDoubleInventory(player, vec, this) : new MenuInventory(player, vec, this);
        final Inventory value = inv;
        player.getServer().getScheduler().scheduleDelayedTask(() -> {
            player.addWindow(value);
            this.inventories.put(player.getUniqueId(), value);
            InventoryMenuHandler.pmenus.put(player.getUniqueId(), this);
            this.openMainCategory(player);
        }, 10);
    }
    
    protected Vector3 createInventory(final Player player) {
        final Vector3 pos = new Vector3((double)(int)player.getX(), (double)((int)player.getY() + 2), (double)(int)player.getZ());
        this.spawnChest(player, pos);
        if (this.isDoubleChest()) {
            final Vector3 pos2 = pos.clone().add(1.0, 0.0, 0.0);
            this.spawnChest(player, pos2);
            this.pairChests(player, pos, pos2);
            this.pairChests(player, pos2, pos);
        }
        return new Vector3(player.x, player.y + 2.0, player.z);
    }
    
    private void pairChests(final Player player, final Vector3 pos1, final Vector3 pos2) {
        final BlockEntityDataPacket pk = new BlockEntityDataPacket();
        pk.x = (int)pos1.x;
        pk.y = (int)pos1.y;
        pk.z = (int)pos1.z;
        final CompoundTag nbt = new CompoundTag();
        nbt.putString("CustomName", this.getName());
        nbt.putInt("x", (int)pos1.x);
        nbt.putInt("y", (int)pos1.y);
        nbt.putInt("z", (int)pos1.z);
        nbt.putInt("pairx", (int)pos2.x);
        nbt.putInt("pairz", (int)pos2.z);
        nbt.putString("id", "Chest");
        try {
            pk.namedTag = NBTIO.write(nbt, ByteOrder.LITTLE_ENDIAN, true);
        }
        catch (IOException ex) {}
        player.dataPacket((DataPacket)pk);
    }
    
    private void spawnChest(final Player player, final Vector3 pos) {
        final UpdateBlockPacket pk1 = new UpdateBlockPacket();
        pk1.x = (int)pos.x;
        pk1.y = (int)pos.y;
        pk1.z = (int)pos.z;
        pk1.blockRuntimeId = GlobalBlockPalette.getOrCreateRuntimeId(54, 0);
        pk1.dataLayer = 0;
        pk1.flags = 0;
        player.dataPacket((DataPacket)pk1);
        final BlockEntityDataPacket pk2 = new BlockEntityDataPacket();
        pk2.x = (int)pos.x;
        pk2.y = (int)pos.y;
        pk2.z = (int)pos.z;
        final CompoundTag nbt = new CompoundTag();
        nbt.putString("CustomName", this.getName());
        nbt.putInt("x", (int)pos.x);
        nbt.putInt("y", (int)pos.y);
        nbt.putInt("z", (int)pos.z);
        nbt.putString("id", "Chest");
        try {
            pk2.namedTag = NBTIO.write(nbt, ByteOrder.LITTLE_ENDIAN, true);
        }
        catch (IOException ex) {}
        player.dataPacket((DataPacket)pk2);
    }
    
    public void destroy(@NonNull final Player player) {
        if (player == null) {
            throw new NullPointerException("player is marked non-null but is null");
        }
        this.inventories.remove(player.getUniqueId());
        InventoryMenuHandler.pmenus.remove(player.getUniqueId());
        final Vector3 vec = new Vector3(player.x, player.y + 2.0, player.z);
        if (this.isDoubleChest()) {
            final Vector3 vec2 = vec.add(1.0, 0.0, 0.0);
            player.level.sendBlocks(new Player[] { player }, new Vector3[] { vec, vec2 });
            return;
        }
        player.level.sendBlocks(new Player[] { player }, new Vector3[] { vec });
    }
    
    public void forceDestroy(@NonNull final Player player) {
        if (player == null) {
            throw new NullPointerException("player is marked non-null but is null");
        }
        player.getServer().getScheduler().scheduleDelayedTask((Runnable)new Runnable() {
            @Override
            public void run() {
                final ContainerClosePacket pk = new ContainerClosePacket();
                pk.windowId = player.getWindowId((Inventory)InventoryMenu.this.inventories.get(player.getUniqueId()));
                pk.wasServerInitiated = true;
                InventoryMenu.this.destroy(player);
            }
        }, 1);
    }
    
    public void setDoubleChest() {
        this.isDouble = true;
    }
    
    public boolean isDoubleChest() {
        return this.isDouble;
    }
    
    public void setMainCategory(@NonNull final InventoryCategory category) {
        if (category == null) {
            throw new NullPointerException("category is marked non-null but is null");
        }
        category.menu = this;
        this.category = category;
    }
    
    public InventoryCategory getMainCategory() {
        return this.category;
    }
    
    public void addCategory(@NonNull final String id, @NonNull final InventoryCategory category) {
        if (id == null) {
            throw new NullPointerException("id is marked non-null but is null");
        }
        if (category == null) {
            throw new NullPointerException("category is marked non-null but is null");
        }
        if (this.categories.containsKey(id)) {
            return;
        }
        category.menu = this;
        this.categories.put(id, category);
    }
    
    public void removeCategory(@NonNull final String id) {
        if (id == null) {
            throw new NullPointerException("id is marked non-null but is null");
        }
        if (!this.categories.containsKey(id)) {
            return;
        }
        this.categories.remove(id);
    }
    
    public InventoryCategory getCategory(@NonNull final String id) {
        if (id == null) {
            throw new NullPointerException("id is marked non-null but is null");
        }
        if (this.categories.containsKey(id)) {
            return this.categories.get(id);
        }
        return null;
    }
    
    public InventoryCategory getCurrentCategory() {
        return this.currentCategory;
    }
    
    public void openMainCategory(final Player player) {
        final InventoryCategory category = this.category;
        final Inventory inventory = this.inventories.get(player.getUniqueId());
        inventory.clearAll();
        for (final Map.Entry<Integer, ItemData> entry : category.itemDataMap().entrySet()) {
            final int position = entry.getKey();
            final ItemData data = entry.getValue();
            inventory.setItem(position, data.build());
        }
        this.currentCategory = category;
    }
    
    public void openCategory(@NonNull final String id, final Player player) {
        if (id == null) {
            throw new NullPointerException("id is marked non-null but is null");
        }
        if (this.categories.containsKey(id)) {
            final InventoryCategory category = this.categories.get(id);
            final Inventory inventory = this.inventories.get(player.getUniqueId());
            inventory.clearAll();
            for (final Map.Entry<Integer, ItemData> entry : category.itemDataMap().entrySet()) {
                final int position = entry.getKey();
                final ItemData data = entry.getValue();
                inventory.setItem(position, data.build());
            }
            this.currentCategory = category;
        }
    }
    
    public boolean onlyRead() {
        return this.read;
    }
    
    public void setOnlyRead(final boolean value) {
        this.read = value;
    }
}
