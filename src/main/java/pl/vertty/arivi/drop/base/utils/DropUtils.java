package pl.vertty.arivi.drop.base.utils;

import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.drop.base.Drop;
import pl.vertty.arivi.drop.utils.Colors;

import java.util.ArrayList;
import java.util.List;

public class DropUtils
{
    private static final List<Drop> drops = new ArrayList<>();
    private static final List<String> cobble = new ArrayList<>();
    private static final List<String> eq = new ArrayList<>();
    private static final List<String> msg = new ArrayList<>();
    
    public static void load() {
        final Config c = Main.getPlugin().getConfig();
        DropUtils.drops.clear();
        for (final String s : c.getSection("drops").getKeys(false)) {
            final String name = c.getString("drops." + s + ".name");
            final List<String> lore = c.getStringList("drops." + s + ".lore");
            final Item item = new Item(c.getInt("drops." + s + ".item"), 0, 1);
            if (name != null) {
                item.setCustomName(Colors.translate(name));
            }
            if (lore != null) {
                item.setLore(Colors.translate(String.valueOf(lore)));
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
        return new ArrayList<>(DropUtils.drops);
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
        DropUtils.cobble.remove(player.toLowerCase());
    }
    
    public static boolean isEq(final String player) {
        return !DropUtils.eq.contains(player.toLowerCase());
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
        DropUtils.msg.remove(player.toLowerCase());
    }

}
