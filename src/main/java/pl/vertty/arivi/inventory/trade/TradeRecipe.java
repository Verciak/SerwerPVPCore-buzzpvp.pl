
package pl.vertty.arivi.inventory.trade;

import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.item.Item;

public class TradeRecipe
{
    private Item sellItem;
    private Item buyItem;
    private Item secondBuyItem;
    private int tier;
    private int maxUses;
    private int buyCountA;
    private int buyCountB;
    private int uses;
    private int demand;
    private byte rewardsExp;
    private int traderExp;
    private float priceMultiplierA;
    private float priceMultiplierB;
    
    public TradeRecipe(final Item sellItem, final Item buyItem) {
        this(sellItem, buyItem, Item.get(0));
    }
    
    public TradeRecipe(final Item sellItem, final Item buyItem, final Item secondBuyItem) {
        this.tier = 0;
        this.maxUses = 999;
        this.buyCountA = 0;
        this.buyCountB = 0;
        this.uses = 0;
        this.demand = 0;
        this.rewardsExp = 0;
        this.traderExp = 0;
        this.priceMultiplierA = 0.0f;
        this.priceMultiplierB = 0.0f;
        this.sellItem = sellItem;
        this.buyItem = buyItem;
        this.secondBuyItem = secondBuyItem;
    }
    
    public TradeRecipe setTier(final int tier) {
        this.tier = tier;
        return this;
    }
    
    public TradeRecipe setMaxUses(final int maxUses) {
        this.maxUses = maxUses;
        return this;
    }
    
    public TradeRecipe setBuysA(final int count) {
        this.buyCountA = count;
        return this;
    }
    
    public TradeRecipe setBuysB(final int count) {
        this.buyCountB = count;
        return this;
    }
    
    public CompoundTag toNBT() {
        final CompoundTag nbt = new CompoundTag();
        nbt.putCompound("buyA", NBTIO.putItemHelper(this.buyItem, Integer.valueOf(-1)));
        if (this.secondBuyItem != null) {
            nbt.putCompound("buyB", NBTIO.putItemHelper(this.secondBuyItem, Integer.valueOf(-1)));
        }
        nbt.putCompound("sell", NBTIO.putItemHelper(this.sellItem, Integer.valueOf(-1)));
        nbt.putInt("tier", this.tier);
        nbt.putInt("buyCountA", this.buyCountA);
        nbt.putInt("buyCountB", this.buyCountB);
        nbt.putInt("uses", this.uses);
        nbt.putInt("maxUses", this.maxUses);
        nbt.putByte("rewardExp", (int)this.rewardsExp);
        nbt.putInt("demand", this.demand);
        nbt.putInt("traderExp", this.traderExp);
        nbt.putFloat("priceMultiplierA", this.priceMultiplierA);
        nbt.putFloat("priceMultiplierB", this.priceMultiplierB);
        return nbt;
    }
    
    private static CompoundTag putItemHelper(final Item item, final Integer slot, final String tagName) {
        final CompoundTag tag = new CompoundTag(tagName).putShort("id", item.getId()).putByte("Count", item.getCount()).putShort("Damage", item.getDamage());
        if (slot != null) {
            tag.putByte("Slot", (int)slot);
        }
        if (item.hasCompoundTag()) {
            tag.putCompound("tag", item.getNamedTag());
        }
        return tag;
    }
    
    public Item getSellItem() {
        return this.sellItem;
    }
    
    public Item getBuyItem() {
        return this.buyItem;
    }
    
    public Item getSecondBuyItem() {
        return this.secondBuyItem;
    }
}
