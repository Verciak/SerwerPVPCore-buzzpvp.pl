
package pl.vertty.arivi.inventory.item;

import cn.nukkit.item.Item;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.item.enchantment.Enchantment;

public class ItemData
{
    public String customName;
    public int count;
    public int id;
    public int damage;
    public String[] lores;
    public Enchantment[] enchantment;
    
    public ItemData(final int i1, final int i, final int id, final String s, final String[] strings, final ItemClick itemClick) {
        this.customName = "Item";
        this.count = 0;
        this.id = 0;
        this.damage = 0;
        this.lores = new String[0];
        this.enchantment = new Enchantment[0];
        this.id = i1;
        this.damage = i;
        this.count = id;
        this.customName = ChatUtil.fixColor(s);
        this.lores = strings;
    }
    
    public ItemData(final int id, final int damage) {
        this(id, damage, 1);
    }
    
    public ItemData(final int id, final int damage, final int count) {
        this(id, damage, count, "Name");
    }
    
    public ItemData(final int id, final int damage, final int count, final String customName) {
        this(id, damage, count, customName, new String[0]);
    }
    
    public ItemData(final int id, final int damage, final int count, final String customName, final String[] lores) {
        this.customName = "Item";
        this.count = 0;
        this.id = 0;
        this.damage = 0;
        this.lores = new String[0];
        this.enchantment = new Enchantment[0];
        this.id = id;
        this.damage = damage;
        this.count = count;
        this.customName = ChatUtil.fixColor(customName);
        this.lores = ChatUtil.fixColor(lores);
    }
    
    public ItemData(final int id, final int damage, final int count, final String customName, final String[] lores, final Enchantment[] enchantment1) {
        this.customName = "Item";
        this.count = 0;
        this.id = 0;
        this.damage = 0;
        this.lores = new String[0];
        this.enchantment = new Enchantment[0];
        this.id = id;
        this.damage = damage;
        this.count = count;
        this.customName = ChatUtil.fixColor(customName);
        this.lores = ChatUtil.fixColor(lores);
        this.enchantment = enchantment1;
    }
    
    public Item build() {
        final Item item = Item.get(this.id, Integer.valueOf(this.damage), this.count);
        if (!this.customName.equals("Name")) {
            item.setCustomName(ChatUtil.fixColor(this.customName));
        }
        if (this.lores.length > 0) {
            item.setLore(ChatUtil.fixColor(this.lores));
        }
        if (this.enchantment.length > 0) {
            item.addEnchantment(this.enchantment);
        }
        return item;
    }
    
    public static ItemData fromItem(final Item item) {
        return new ItemData(item.getId(), item.getDamage(), item.getCount(), ChatUtil.fixColor(item.getCustomName()), item.getLore(), item.getEnchantments());
    }
}
