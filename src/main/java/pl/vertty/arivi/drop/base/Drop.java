package pl.vertty.arivi.drop.base;

import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.drop.base.utils.DropUtils;
import pl.vertty.arivi.drop.utils.StringUtils;
import pl.vertty.arivi.utils.ChatUtil;

import java.util.ArrayList;
import java.util.List;

public class Drop
{
    private String name;
    private Item item;
    private final double chance;
    private final boolean fortune;
    private final int height;
    private final int slot;
    private final List<String> disabled;
    private final String invname;
    private final String message;
    private final int lvl;
    Config config;
    
    public Drop(final String name, final Item item, final int height, final int slot, final double chance, final boolean fortune, final String message, final int lvl) {
        this.config = Main.getPlugin().getConfig();
        this.disabled = new ArrayList<>();
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
