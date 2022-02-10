// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.base;

import pl.vertty.arivi.drop.base.utils.UserUtils;

import java.util.HashMap;
import java.util.Map;

public class User implements Comparable<User>
{
    private String name;
    private long turbo;
    private long turbo_exp;
    private int lvl;
    private int blocks;
    private int blockstonext;
    private Map<String, Integer> drops;
    public static Map<String, Integer> plecak;
    private int cobble;
    private int dirt;
    private boolean changes;
    
    public User(final String name) {
        this.name = name;
        this.turbo = 0L;
        this.turbo_exp = 0L;
        this.lvl = 0;
        this.blocks = 0;
        this.blockstonext = 50;
        this.changes = true;
        this.drops = new HashMap<String, Integer>();
        User.plecak = new HashMap<String, Integer>();
        UserUtils.add(this);
    }
    
    public String getName() {
        return this.name;
    }
    
    public long getTurbo() {
        return this.turbo;
    }
    
    public boolean isTurbo() {
        return this.turbo > System.currentTimeMillis() || this.turbo == -1L;
    }
    
    public long getTurboExp() {
        return this.turbo_exp;
    }
    
    public boolean isTurboExp() {
        return this.turbo_exp > System.currentTimeMillis() || this.turbo_exp == -1L;
    }
    
    public int getLvl() {
        return this.lvl;
    }
    
    public int getBlocks() {
        return this.blocks;
    }
    
    public int getBlockstonext() {
        return this.blockstonext;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setTurbo(final long turbo) {
        this.turbo = turbo;
        this.changes();
    }
    
    public void setTurboExp(final long turbo) {
        this.turbo_exp = turbo;
        this.changes();
    }
    
    public void setLvl(final int lvl) {
        this.lvl = lvl;
        this.changes();
    }
    
    public void setBlocks(final int blocks) {
        this.blocks = blocks;
        this.changes();
    }
    
    public void setBlockstonext(final int blockstonext) {
        this.blockstonext = blockstonext;
        this.changes();
    }
    
    public void addLvl(final int add) {
        this.lvl += add;
        this.changes();
    }
    
    public void removeLvl(final int remove) {
        this.lvl -= remove;
        this.changes();
    }
    
    public void addBlocks(final int add) {
        this.blocks += add;
        this.changes();
    }
    
    public void removeBlocks(final int remove) {
        this.blocks -= remove;
        this.changes();
    }
    
    public void addBlocksToNext(final int add) {
        this.blockstonext += add;
        this.changes();
    }
    
    public void removeBlocksToNext(final int remove) {
        this.blockstonext -= remove;
        this.changes();
    }
    
    public void addDrop(final Drop drop, final int amount) {
        int i = this.getDrop(drop.getName());
        i += amount;
        this.drops.put(drop.getName().toLowerCase(), i);
        this.changes();
    }
    
    public void setDrops(final Map<String, Integer> drops) {
        this.drops = drops;
        this.changes();
    }
    
    public Map<String, Integer> getDrops() {
        return this.drops;
    }
    
    public void addPlecak(final Drop drop, final int amount) {
        int i = this.getDrop(drop.getName());
        i += amount;
        User.plecak.put(drop.getName().toLowerCase(), i);
        this.changes();
    }
    
    public void setPlecak(final Map<String, Integer> plecak) {
        User.plecak = plecak;
        this.changes();
    }
    
    public Map<String, Integer> getPlecak() {
        return User.plecak;
    }
    
    public int getDrop(final String drop) {
        if (!this.drops.containsKey(drop.toLowerCase())) {
            return 0;
        }
        return this.drops.get(drop.toLowerCase());
    }
    
    public int getPlecak(final String drop) {
        if (!User.plecak.containsKey(drop.toLowerCase())) {
            return 0;
        }
        return User.plecak.get(drop.toLowerCase());
    }
    
    public void addCobble() {
        ++this.cobble;
        this.changes();
    }
    
    public void addDirt() {
        ++this.dirt;
        this.changes();
    }
    
    public int getCobble() {
        return this.cobble;
    }
    
    public int getDirt() {
        return this.dirt;
    }
    
    public void setCobble(final int cobble) {
        this.cobble = cobble;
    }
    
    public void setDirt(final int dirt) {
        this.dirt = dirt;
    }
    
    public void changes() {
        this.changes = true;
    }
    
    public boolean changed() {
        return this.changes;
    }
    
    public void setChanges(final boolean changes) {
        this.changes = changes;
    }
    
    @Override
    public int compareTo(final User user) {
        int i = Integer.compare(user.getBlocks(), this.blocks);
        if (i == 0) {
            if (this.name == null) {
                return 0;
            }
            if (user.getName() == null) {
                return 1;
            }
            i = this.name.compareTo(user.getName());
        }
        return i;
    }
}
