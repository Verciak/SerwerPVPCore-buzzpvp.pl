
package pl.vertty.arivi.inventory.utils;

import cn.nukkit.network.protocol.RemoveEntityPacket;
import cn.nukkit.network.protocol.ContainerClosePacket;
import cn.nukkit.item.Item;
import java.io.IOException;
import cn.nukkit.nbt.NBTIO;
import java.nio.ByteOrder;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.network.protocol.UpdateTradePacket;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.entity.data.EntityMetadata;
import cn.nukkit.network.protocol.AddEntityPacket;
import cn.nukkit.Player;
import java.util.Map;
import java.util.HashMap;
import cn.nukkit.inventory.InventoryType;
import cn.nukkit.inventory.InventoryHolder;
import pl.vertty.arivi.inventory.trade.TradeMenu;
import cn.nukkit.inventory.BaseInventory;

public class TradeInventory extends BaseInventory
{
    public TradeMenu menu;
    
    public TradeInventory(final InventoryHolder holder, final TradeMenu menu) {
        super(holder, InventoryType.CHEST, (Map)new HashMap(), Integer.valueOf(3));
        this.menu = menu;
    }
    
    public void onOpen(final Player player) {
        super.onOpen(player);
        final long eid = this.menu.getUid();
        final AddEntityPacket aep = new AddEntityPacket();
        aep.id = "minecraft:npc";
        aep.entityRuntimeId = eid;
        aep.entityUniqueId = eid;
        aep.x = (float)player.getX();
        aep.y = (float)(player.getY() + 2.0);
        aep.z = (float)player.getZ();
        aep.yaw = 0.0f;
        aep.pitch = 0.0f;
        aep.headYaw = 0.0f;
        aep.metadata = new EntityMetadata().putInt(101, this.menu.getTraderTier()).putInt(103, this.menu.getExperience()).putInt(102, this.menu.getMaxTradeTier()).putLong(68, player.getId()).putFloat(38, 0.01f);
        player.dataPacket((DataPacket)aep);
        final UpdateTradePacket pk = new UpdateTradePacket();
        pk.windowId = (byte)player.getWindowId((Inventory)this);
        pk.windowType = 15;
        pk.unknownVarInt1 = 0;
        pk.displayName = this.menu.getTraderName();
        pk.screen2 = true;
        pk.isWilling = true;
        pk.trader = eid;
        pk.tradeTier = this.menu.getTraderTier();
        pk.player = player.getId();
        try {
            pk.offers = NBTIO.write(this.menu.getOffers(), ByteOrder.LITTLE_ENDIAN, true);
        }
        catch (IOException ex) {}
        player.dataPacket((DataPacket)pk);
    }
    
    public void onClose(final Player player) {
        for (int i = 0; i <= 1; ++i) {
            final Item item = this.getItem(i);
            if (player.getInventory().canAddItem(item)) {
                player.getInventory().addItem(new Item[] { item });
            }
            else {
                player.dropItem(item);
            }
            this.clear(i);
        }
        final ContainerClosePacket close = new ContainerClosePacket();
        close.windowId = player.getWindowId((Inventory)this);
        close.wasServerInitiated = true;
        player.dataPacket((DataPacket)close);
        final RemoveEntityPacket pk = new RemoveEntityPacket();
        pk.eid = this.menu.getUid();
        player.dataPacket((DataPacket)pk);
        super.onClose(player);
    }
    
    public String getName() {
        return "Trade Inventory";
    }
    
    public Player getHolder() {
        return (Player)this.holder;
    }
    
    public int getDefaultSize() {
        return 3;
    }
}
