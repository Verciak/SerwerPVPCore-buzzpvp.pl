// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;
import cn.nukkit.potion.Potion;
import cn.nukkit.item.enchantment.Enchantment;
import java.util.HashMap;
import java.util.List;
import cn.nukkit.item.Item;

public class ItemBuilder
{
    private Item mat;
    private int amount;
    private int data;
    private String title;
    private final List<String> lore;
    private final HashMap<Enchantment, Integer> enchants;
    private Potion potion;
    
    public ItemBuilder(final Item mat) {
        this(mat, 1);
    }
    
    public ItemBuilder(final Item mat, final int amount) {
        this(mat, amount, 0);
    }
    
    public ItemBuilder(final Item mat, final short data) {
        this(mat, 1, data);
    }
    
    public ItemBuilder(final Item mat, final int amount, final int data) {
        this.title = null;
        this.lore = new ArrayList<String>();
        this.enchants = new HashMap<Enchantment, Integer>();
        this.mat = mat;
        this.amount = amount;
        this.data = data;
    }
    
    public ItemBuilder setType(final Item mat) {
        this.mat = mat;
        return this;
    }
    
    public ItemBuilder setTitle(final String title) {
        this.title = ChatUtil.fixColor(title);
        return this;
    }
    
    public ItemBuilder addLores(final List<String> lores) {
        this.lore.addAll(ChatUtil.fixColor(lores));
        return this;
    }
    
    public ItemBuilder addLores(final String... lore) {
        this.lore.addAll(Arrays.asList(ChatUtil.fixColor(lore)));
        return this;
    }
    
    public ItemBuilder addLore(final String lore) {
        this.lore.add(ChatUtil.fixColor(lore));
        return this;
    }
    
    public ItemBuilder addEnchantment(final Enchantment enchant, final int level) {
        this.enchants.remove(enchant);
        this.enchants.put(enchant, level);
        return this;
    }
    
    public ItemBuilder setAmount(final int amount) {
        this.amount = amount;
        return this;
    }
    
    public Item build() {
        Item mat = this.mat;
        if (mat == null) {
            mat = Item.get(0);
        }
        final Item item = new Item(this.mat.getId(), Integer.valueOf(this.amount), this.data);
        if (this.title != null) {
            item.setCustomName(ChatUtil.fixColor(this.title));
        }
        if (!this.lore.isEmpty()) {
            item.setLore(ChatUtil.fixColor(new String[] { String.valueOf(this.lore) }));
        }
        return item;
    }
    
    public ItemBuilder clone() {
        final ItemBuilder newBuilder = new ItemBuilder(this.mat);
        newBuilder.setTitle(this.title);
        for (final String lore : this.lore) {
            newBuilder.addLore(lore);
        }
        for (final Map.Entry<Enchantment, Integer> entry : this.enchants.entrySet()) {
            newBuilder.addEnchantment(entry.getKey(), entry.getValue());
        }
        newBuilder.potion = this.potion;
        return newBuilder;
    }
    
    public Item getType() {
        return this.mat;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public List<String> getLore() {
        return this.lore;
    }
    
    public boolean hasEnchantment(final Enchantment enchant) {
        return this.enchants.containsKey(enchant);
    }
    
    public int getEnchantmentLevel(final Enchantment enchant) {
        return this.enchants.get(enchant);
    }
    
    public HashMap<Enchantment, Integer> getAllEnchantments() {
        return this.enchants;
    }
    
    public boolean isItem(final Item item) {
        return this.isItem(item, false);
    }
    
    public boolean isItem(final Item item, final boolean strictDataMatch) {
        if (item.getId() != this.getType().getId()) {
            return false;
        }
        if (!item.hasCustomName() && this.getTitle() != null) {
            return false;
        }
        if (!item.getCustomName().equals(this.getTitle())) {
            return false;
        }
        if (item.getLore() != null) {
            for (final String lore : item.getLore()) {
                if (!this.getLore().contains(lore)) {
                    return false;
                }
            }
        }
        return true;
    }
}
