// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.inventory.trade;

import java.util.Iterator;
import cn.nukkit.nbt.tag.Tag;
import cn.nukkit.nbt.tag.ListTag;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.network.protocol.RemoveEntityPacket;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.ContainerClosePacket;
import cn.nukkit.inventory.InventoryHolder;
import pl.vertty.arivi.inventory.utils.TradeInventory;
import cn.nukkit.entity.Entity;
import lombok.NonNull;
import cn.nukkit.Player;
import java.util.function.Consumer;
import cn.nukkit.inventory.Inventory;
import java.util.UUID;
import java.util.HashMap;
import java.util.ArrayList;

public class TradeMenu
{
    private ArrayList<TradeRecipe> recipes;
    private HashMap<UUID, Inventory> inventories;
    public int maxTradeTier;
    public String traderName;
    public int traderTier;
    public int experience;
    public long uid;
    public Consumer<Player> closeHandler;
    
    public TradeMenu() {
        this.recipes = new ArrayList<TradeRecipe>();
        this.inventories = new HashMap<UUID, Inventory>();
        this.maxTradeTier = 4;
        this.traderTier = 4;
        this.experience = 30;
    }
    
    public void show(@NonNull final Player player) {
        if (player == null) {
            throw new NullPointerException("player is marked non-null but is null");
        }
        this.uid = Entity.entityCount++;
        final TradeInventory inv = new TradeInventory((InventoryHolder)player, this);
        final Inventory value = inv;
        player.getServer().getScheduler().scheduleDelayedTask(() -> {
            player.addWindow(value);
            this.inventories.put(player.getUniqueId(), value);
            TradeMenuHandler.pmenus.put(player.getUniqueId(), this);
        }, 10);
    }
    
    public void forceClose(@NonNull final Player player) {
        if (player == null) {
            throw new NullPointerException("player is marked non-null but is null");
        }
        player.getServer().getScheduler().scheduleDelayedTask(() -> {
            ContainerClosePacket close = new ContainerClosePacket();
            close.windowId = player.getWindowId((Inventory)this.inventories.get(player.getUniqueId()));
            close.wasServerInitiated = true;
            player.dataPacket((DataPacket)close);
            RemoveEntityPacket pk = new RemoveEntityPacket();
            pk.eid = this.getUid();
            player.dataPacket((DataPacket)pk);
            this.inventories.remove(player.getUniqueId());
            TradeMenuHandler.pmenus.remove(player.getUniqueId());
        }, 1);
    }
    
    public TradeInventory getInventory(final Player p) {
        return (TradeInventory)this.inventories.get(p.getUniqueId());
    }
    
    public void addRecipe(final TradeRecipe recipe) {
        this.recipes.add(recipe);
    }
    
    public CompoundTag getOffers() {
        final CompoundTag nbt = new CompoundTag("Offers");
        nbt.putList((ListTag)this.recipesToNbt());
        nbt.putList((ListTag)this.getTierExpRequirements());
        return nbt;
    }
    
    private ListTag<CompoundTag> recipesToNbt() {
        final ListTag<CompoundTag> tag = (ListTag<CompoundTag>)new ListTag("Recipes");
        for (final TradeRecipe recipe : this.recipes) {
            tag.add(recipe.toNBT());
        }
        return tag;
    }
    
    private ListTag<CompoundTag> getTierExpRequirements() {
        final ListTag<CompoundTag> tag = (ListTag<CompoundTag>)new ListTag("TierExpRequirements");
        tag.add(new CompoundTag().putInt("0", 0));
        tag.add(new CompoundTag().putInt("1", 10));
        tag.add(new CompoundTag().putInt("2", 70));
        tag.add(new CompoundTag().putInt("3", 150));
        tag.add(new CompoundTag().putInt("4", 250));
        return tag;
    }
    
    public int getMaxTradeTier() {
        return this.maxTradeTier;
    }
    
    public void setMaxTradeTier(final int maxTradeTier) {
        this.maxTradeTier = maxTradeTier;
    }
    
    public String getTraderName() {
        return this.traderName;
    }
    
    public void setTraderName(final String traderName) {
        this.traderName = traderName;
    }
    
    public int getTraderTier() {
        return this.traderTier;
    }
    
    public void setTraderTier(final int traderTier) {
        this.traderTier = traderTier;
    }
    
    public int getExperience() {
        return this.experience;
    }
    
    public void setExperience(final int experience) {
        this.experience = experience;
    }
    
    public long getUid() {
        return this.uid;
    }
    
    public void setUid(final long uid) {
        this.uid = uid;
    }
    
    public Consumer<Player> getCloseHandler() {
        return this.closeHandler;
    }
    
    public void setCloseHandler(final Consumer<Player> closeHandler) {
        this.closeHandler = closeHandler;
    }
}
