// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.inventory;

import cn.nukkit.item.Item;
import cn.nukkit.level.GlobalBlockPalette;
import cn.nukkit.network.protocol.UpdateBlockPacket;
import cn.nukkit.network.protocol.DataPacket;
import java.io.IOException;
import cn.nukkit.nbt.NBTIO;
import java.nio.ByteOrder;
import java.util.HashMap;

import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.network.protocol.BlockEntityDataPacket;
import cn.nukkit.inventory.Inventory;
import lombok.NonNull;
import cn.nukkit.math.Vector3;
import cn.nukkit.Player;
import cn.nukkit.inventory.InventoryHolder;
import cn.nukkit.inventory.InventoryType;
import pl.vertty.arivi.gui.EQGui;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.utils.MenuInventory;
import cn.nukkit.inventory.ContainerInventory;

public class SimpleInventoryMenu extends ContainerInventory
{
    private final boolean isDouble;
    
    public SimpleInventoryMenu(final boolean isDouble, final String title) {
        super(new MenuInventory.Holder(0.0, 0.0, 0.0), isDouble ? InventoryType.DOUBLE_CHEST : InventoryType.CHEST, new HashMap<Integer, Item>(), null, title);
        this.isDouble = isDouble;
    }
    
    public void onClose(final Player who) {
        super.onClose(who);
        UserManager.getUser(who).setStatus(false);
        final Vector3 vec = new Vector3(who.x, who.y - 2.0, who.z);
        if (this.isDouble) {
            final Vector3 vec2 = vec.add(1.0, 0.0, 0.0);
            who.level.sendBlocks(new Player[] { who }, new Vector3[] { vec, vec2 });
            return;
        }
        who.level.sendBlocks(new Player[] { who }, new Vector3[] { vec });
    }
    
    public void show(@NonNull final Player player) {
        if (player == null) {
            throw new NullPointerException("player is marked non-null but is null");
        }
        final Vector3 pos = this.createInventory(player);
        this.holder = (InventoryHolder)new MenuInventory.Holder(pos.x, pos.y, pos.z);
        player.getServer().getScheduler().scheduleDelayedTask(() -> player.addWindow((Inventory)this), 10);
    }
    
    protected Vector3 createInventory(final Player player) {
        final Vector3 pos = new Vector3((double)(int)player.getX(), (double)((int)player.getY() - 2), (double)(int)player.getZ());
        this.spawnChest(player, pos);
        if (this.isDouble) {
            final Vector3 pos2 = pos.clone().add(1.0, 0.0, 0.0);
            this.spawnChest(player, pos2);
            this.pairChests(player, pos, pos2);
            this.pairChests(player, pos2, pos);
        }
        return new Vector3(player.x, player.y - 2.0, player.z);
    }
    
    private void pairChests(final Player player, final Vector3 pos1, final Vector3 pos2) {
        final BlockEntityDataPacket pk = new BlockEntityDataPacket();
        pk.x = (int)pos1.x;
        pk.y = (int)pos1.y;
        pk.z = (int)pos1.z;
        final CompoundTag nbt = new CompoundTag();
        nbt.putString("CustomName", this.title);
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
        nbt.putString("CustomName", this.title);
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
}
