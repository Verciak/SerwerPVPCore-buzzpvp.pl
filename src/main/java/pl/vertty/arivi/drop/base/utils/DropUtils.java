// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.base.utils;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.drop.utils.Colors;
import cn.nukkit.item.Item;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.drop.base.Drop;
import java.util.List;

public class DropUtils
{
    private static List<Drop> drops;
    private static List<String> cobble;
    private static List<String> eq;
    private static List<String> msg;
    
    public static void load() {
        final Config c = Main.getPlugin().getConfig();
        DropUtils.drops.clear();
        for (final String s : c.getSection("drops").getKeys(false)) {
            final String name = c.getString("drops." + s + ".name");
            final List<String> lore = (List<String>)c.getStringList("drops." + s + ".lore");
            final Item item = new Item(c.getInt("drops." + s + ".item"), Integer.valueOf(0), 1);
            if (name != null) {
                item.setCustomName(Colors.translate(name));
            }
            if (lore != null) {
                item.setLore(new String[] { Colors.translate(String.valueOf(lore)) });
            }
            final double chance = c.getDouble("drops." + s + ".chance");
            final boolean fortune = c.getBoolean("drops." + s + ".fortune");
            final int height = c.getInt("drops." + s + ".height");
            final int slot = c.getInt("drops." + s + ".slot");
            final String msg = Colors.translate(c.getString("drops." + s + ".message"));
            final int lvl = c.getInt("drops." + s + ".lvl");
            final Drop drop = new Drop(s, item, height, slot, chance, fortune, msg, lvl);
            DropUtils.drops.add(drop);
        }
    }
    
    public static List<Drop> getDrops() {
        return new ArrayList<Drop>(DropUtils.drops);
    }
    
    public static boolean isCobble(final String player) {
        return !DropUtils.cobble.contains(player.toLowerCase());
    }
    
    public static void disableCobble(final String player) {
        if (!DropUtils.cobble.contains(player.toLowerCase())) {
            DropUtils.cobble.add(player.toLowerCase());
        }
    }
    
    public static void enableCobble(final String player) {
        if (DropUtils.cobble.contains(player.toLowerCase())) {
            DropUtils.cobble.remove(player.toLowerCase());
        }
    }
    
    public static boolean isEq(final String player) {
        return !DropUtils.eq.contains(player.toLowerCase());
    }
    
    public static void disableEq(final String player) {
        if (!DropUtils.eq.contains(player.toLowerCase())) {
            DropUtils.eq.add(player.toLowerCase());
        }
    }
    
    public static void enableEq(final String player) {
        if (DropUtils.eq.contains(player.toLowerCase())) {
            DropUtils.eq.remove(player.toLowerCase());
        }
    }
    
    public static boolean isMsg(final String player) {
        return !DropUtils.msg.contains(player.toLowerCase());
    }
    
    public static void disableMsg(final String player) {
        if (!DropUtils.msg.contains(player.toLowerCase())) {
            DropUtils.msg.add(player.toLowerCase());
        }
    }
    
    public static void enableMsg(final String player) {
        if (DropUtils.msg.contains(player.toLowerCase())) {
            DropUtils.msg.remove(player.toLowerCase());
        }
    }
    
    static {
        DropUtils.drops = new ArrayList<Drop>();
        DropUtils.cobble = new ArrayList<String>();
        DropUtils.eq = new ArrayList<String>();
        DropUtils.msg = new ArrayList<String>();
    }
}
