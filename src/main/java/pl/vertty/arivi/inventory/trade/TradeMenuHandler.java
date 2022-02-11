
package pl.vertty.arivi.inventory.trade;

import java.util.List;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.network.protocol.ContainerClosePacket;
import pl.vertty.arivi.inventory.utils.TradeInventoryAction;
import cn.nukkit.network.protocol.types.NetworkInventoryAction;
import java.util.ArrayList;
import cn.nukkit.network.protocol.InventoryTransactionPacket;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerQuitEvent;
import lombok.NonNull;
import java.util.UUID;
import java.util.HashMap;
import cn.nukkit.event.Listener;

public class TradeMenuHandler implements Listener
{
    public static HashMap<String, TradeMenu> menus;
    public static HashMap<UUID, TradeMenu> pmenus;
    
    public static TradeMenu getMenuById(@NonNull final String id) {
        if (id == null) {
            throw new NullPointerException("id is marked non-null but is null");
        }
        if (TradeMenuHandler.menus.containsKey(id)) {
            return TradeMenuHandler.menus.get(id);
        }
        return null;
    }
    
    public static TradeMenu getMenuByPlayer(@NonNull final UUID uuid) {
        if (uuid == null) {
            throw new NullPointerException("uuid is marked non-null but is null");
        }
        if (TradeMenuHandler.pmenus.containsKey(uuid)) {
            return TradeMenuHandler.pmenus.get(uuid);
        }
        return null;
    }
    
    public static void registerNewMenu(final String id, final TradeMenu menu) {
        if (!TradeMenuHandler.menus.containsKey(id)) {
            TradeMenuHandler.menus.put(id, menu);
        }
    }
    
    public static void unregisterMenu(final String id) {
        if (TradeMenuHandler.menus.containsKey(id)) {
            TradeMenuHandler.menus.remove(id);
        }
    }
    
    @EventHandler
    public void quit(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (getMenuByPlayer(p.getUniqueId()) != null) {
            getMenuByPlayer(p.getUniqueId()).forceClose(p);
        }
    }
    
    @EventHandler
    public void handleTransaction(final DataPacketReceiveEvent e) {
        final Player p = e.getPlayer();
        if (e.getPacket() instanceof InventoryTransactionPacket) {
            final InventoryTransactionPacket pk = (InventoryTransactionPacket)e.getPacket();
            final List<NetworkInventoryAction> actions = new ArrayList<NetworkInventoryAction>();
            boolean edited = false;
            for (NetworkInventoryAction newAction : pk.actions) {
                final NetworkInventoryAction action = newAction;
                Label_0334: {
                    if (action.windowId == 124 && (action.inventorySlot == 4 || action.inventorySlot == 5 || action.inventorySlot == 50)) {
                        if (action.inventorySlot == 50) {
                            if (getMenuByPlayer(p.getUniqueId()) == null) {
                                actions.add(newAction);
                                break Label_0334;
                            }
                            action.inventorySlot = 51;
                        }
                        newAction = new TradeInventoryAction(false);
                        newAction.inventorySlot = action.inventorySlot;
                        newAction.windowId = action.windowId;
                        newAction.oldItem = action.oldItem;
                        newAction.newItem = action.newItem;
                        newAction.sourceType = action.sourceType;
                        newAction.unknown = action.unknown;
                        edited = true;
                    }
                    if (action.sourceType == 99999 && (action.windowId == -30 || action.windowId == -31)) {
                        newAction = new TradeInventoryAction(true);
                        newAction.inventorySlot = action.inventorySlot;
                        newAction.windowId = action.windowId;
                        newAction.oldItem = action.oldItem;
                        newAction.newItem = action.newItem;
                        newAction.sourceType = action.sourceType;
                        newAction.unknown = action.unknown;
                        edited = true;
                    }
                    actions.add(newAction);
                }
            }
            if (edited) {
                final NetworkInventoryAction[] networkActions = new NetworkInventoryAction[actions.size()];
                for (int i = 0; i < actions.size(); ++i) {
                    networkActions[i] = actions.get(i);
                }
                pk.actions = networkActions;
            }
        }
        else if (e.getPacket() instanceof ContainerClosePacket) {
            final ContainerClosePacket pk2 = (ContainerClosePacket)e.getPacket();
            if (getMenuByPlayer(p.getUniqueId()) != null && pk2.windowId == p.getWindowId((Inventory)getMenuByPlayer(p.getUniqueId()).getInventory(p))) {
                getMenuByPlayer(p.getUniqueId()).getCloseHandler().accept(p);
            }
        }
    }
    
    static {
        TradeMenuHandler.menus = new HashMap<String, TradeMenu>();
        TradeMenuHandler.pmenus = new HashMap<UUID, TradeMenu>();
    }
}
