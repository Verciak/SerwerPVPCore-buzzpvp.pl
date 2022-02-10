// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.utils;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.item.Item;
import cn.nukkit.level.Location;
import cn.nukkit.utils.TextFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

public final class ChatUtil
{
    public static void giveItems(final Player p, final Item... items) {
        final Inventory ia = (Inventory)p.getInventory();
        ia.addItem(items);
    }
    
    public static Boolean sendActionBar(final Player p, final String m) {
        p.sendActionBar(fixColor(m));
        return false;
    }

    public static void sendTitleRestart(final Player p, final String title, final String subttitle) {
        sendTitle(p, title, subttitle, 1, 20, 1);
    }
    
    public static void sendTitle(final Player p, final String title, final String subttitle) {
        sendTitle(p, title, subttitle, 30, 40, 30);
    }
    
    public static void sendTitle(final Player player, String title, String subtitle, final int fadeIn, final int stay, final int fadeOut) {
        if (title == null) {
            title = "";
        }
        if (subtitle == null) {
            subtitle = "";
        }
        player.sendTitle(fixColor(title), fixColor(subtitle), fadeIn, stay, fadeOut);
    }
    
    public static Location locFromString(final String str) {
        final String[] str2loc = str.split(":");
        final Location loc = new Location(0.0, 0.0, 0.0, 0.0, 0.0);
        loc.setComponents(Double.parseDouble(str2loc[0]), Double.parseDouble(str2loc[1]), Double.parseDouble(str2loc[2]));
        return loc;
    }
    
    public static String locToString(final double x, final double y, final double z) {
        return x + ":" + y + ":" + z + ":" + 0.0f + ":" + 0.0f;
    }
    
    public static String locToString(final Location loc) {
        return loc.getX() + ":" + loc.getY() + ":" + loc.getZ() + ":" + loc.getYaw() + ":" + loc.getPitch();
    }
    
    public static String fixColor(final String s) {
        if (s == null) {
            return "";
        }

        return TextFormat.colorize('&', s).replace(">>", "»").replace("<<", "«").replace("*", "\u25cf").replace("{O}", "\u2022");
    }
    
    public static Collection<String> fixColor(final Collection<String> collection) {
        final Collection<String> local = new ArrayList<String>();
        for (final String s : collection) {
            local.add(fixColor(s));
        }
        return local;
    }
    
    public static List<String> fColor(final List<String> strings) {
        final List<String> colors = new ArrayList<String>();
        for (final String s : strings) {
            colors.add(fixColor(s));
        }
        return colors;
    }
    
    public static int floor(final double value) {
        final int i = (int)value;
        return (value < i) ? (i - 1) : i;
    }
    
    public static double round(final double value, final int decimals) {
        final double p = Math.pow(10.0, decimals);
        return Math.round(value * p) / p;
    }
    
    public static String[] fixColor(final String[] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = fixColor(array[i]);
        }
        return array;
    }
    
    public static boolean sendMessage(final CommandSender sender, final String message, final String permission) {
        if (sender instanceof ConsoleCommandSender) {
            sendMessage(sender, message);
        }
        return permission != null && permission != "" && sender.hasPermission(permission) && sendMessage(sender, message);
    }
    
    public static boolean sendMessage(final CommandSender sender, final String message) {
        if (sender instanceof Player) {
            if (message != null || message != "") {
                sender.sendMessage(fixColor(message));
            }
        }
        else {
            sender.sendMessage(TextFormat.colorize(fixColor(message)));
        }
        return true;
    }
    
    public static boolean sendMessage(final Collection<? extends CommandSender> collection, final String message) {
        for (final CommandSender cs : collection) {
            sendMessage(cs, message);
        }
        return true;
    }
    
    public static boolean sendMessage(final Collection<? extends CommandSender> collection, final String message, final String permission) {
        for (final CommandSender cs : collection) {
            sendMessage(cs, message, permission);
        }
        return true;
    }
    
    public static boolean containsIgnoreCase(final String[] array, final String element) {
        for (final String s : array) {
            if (s.equalsIgnoreCase(element)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isAlphaNumeric(final String s) {
        return s.matches("^[a-zA-Z0-9_]*$");
    }
    
    public static boolean isFloat(final String string) {
        return Pattern.matches("([0-9]*)\\.([0-9]*)", string);
    }
    
    public static boolean isInteger(final String string) {
        return Pattern.matches("-?[0-9]+", string.subSequence(0, string.length()));
    }
}
