// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.base;

import pl.vertty.arivi.utils.ChatUtil;
import java.util.Iterator;
import pl.vertty.arivi.drop.base.utils.DropUtils;
import pl.vertty.arivi.drop.utils.StringUtils;
import java.util.ArrayList;
import pl.vertty.arivi.Main;
import cn.nukkit.utils.Config;
import java.util.List;
import cn.nukkit.item.Item;

public class Drop
{
    private String name;
    private Item item;
    private double chance;
    private boolean fortune;
    private int height;
    private int slot;
    private List<String> disabled;
    private String invname;
    private String message;
    private int lvl;
    Config config;
    
    public Drop(final String name, final Item item, final int height, final int slot, final double chance, final boolean fortune, final String message, final int lvl) {
        this.config = Main.getPlugin().getConfig();
        this.disabled = new ArrayList<String>();
        this.name = name;
        this.item = item;
        this.chance = chance;
        this.height = height;
        this.slot = slot;
        this.fortune = fortune;
        this.message = message;
        this.lvl = lvl;
        this.invname = StringUtils.replace(this.config.getString("drop.name"), "{NAME}", name);
    }
    
    public String getName() {
        return this.name;
    }
    
    public Item getItem() {
        return this.item;
    }
    
    public double getChance() {
        return this.chance;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getSlot() {
        return this.slot;
    }
    
    public boolean isFortune() {
        return this.fortune;
    }
    
    public List<String> getDisabled() {
        return this.disabled;
    }
    
    public int getLvl() {
        return this.lvl;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setItem(final Item item) {
        this.item = item;
    }
    
    public void setChance(final double chance) {
        this.chance = chance;
    }
    
    public void setFortune(final boolean fortune) {
        this.fortune = fortune;
    }
    
    public void setDisabled(final List<String> disabled) {
        this.disabled = disabled;
    }
    
    public void disable(final String player) {
        if (!this.disabled.contains(player)) {
            this.disabled.add(player);
        }
    }
    
    public void enable(final String player) {
        if (this.disabled.contains(player)) {
            this.disabled.remove(player);
        }
    }
    
    public boolean isDisabled(final String player) {
        return this.disabled.contains(player);
    }
    
    public String getInvName() {
        return this.invname;
    }
    
    public static Drop get(final String name) {
        for (final Drop drop : DropUtils.getDrops()) {
            if (drop.getName().equalsIgnoreCase(name)) {
                return drop;
            }
        }
        return null;
    }
    
    public static Drop getInv(final String name) {
        for (final Drop drop : DropUtils.getDrops()) {
            if (ChatUtil.fixColor(drop.getInvName()).equalsIgnoreCase(name)) {
                return drop;
            }
        }
        return null;
    }
}
