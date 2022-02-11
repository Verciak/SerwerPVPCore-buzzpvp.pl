
package pl.vertty.arivi.guilds.utils;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.level.Location;
import cn.nukkit.utils.TextFormat;

import java.util.Iterator;
import java.util.regex.Pattern;

public final class ChatUtil
{
    public static String locToString2(final Location location) {
        return String.valueOf(new StringBuilder().append(String.valueOf(location.getX())).append(":").append(location.getY()).append(":").append(location.getZ()));
    }
    
    public static void sendTitle(final Player player, final String str) {
        player.sendTitle(fixColor(str), "", 5, 60, 5);
    }
    
    public static boolean isInteger(final String s) {
        return Pattern.matches("-?[0-9]+", s.subSequence(0, s.length()));
    }
    
    public static void sendActionbar(final Player player, final String s) {
        player.sendTip(fixColor(s));
    }
    
    public static void sendbareq(final Player player, final String s) {
        player.sendActionBar(fixColor(s));
    }
    
    public static String replace(final String s) {
        return TextFormat.colorize('&', s.replace(">>", "»").replace("<<", "«").replace("{O}", "\u2022").replace("<3", "&c&l\u2764&r"));
    }
    
    public static double round(final double n, final int n2) {
        final double pow = Math.pow(10.0, n2);
        return Math.round(n * pow) / pow;
    }
    
    public static Player getDamager(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        final Entity damager = entityDamageByEntityEvent.getDamager();
        if (damager instanceof Player) {
            return (Player)damager;
        }
        return null;
    }
    
    public static Location locFromString2(final String s) {
        final String[] split = s.split(":");
        final Location location = new Location(0.0, 0.0, 0.0);
        location.setComponents(Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]));
        return location;
    }
    
    public static String fixColor(final String s) {
        return (s == null) ? "" : TextFormat.colorize('&', s).replace(">>", "»");
    }
    
    public static void sendSubTitle(final Player player, final String str) {
        player.sendTitle("", fixColor(str), 5, 60, 5);
    }
    
    public static void sendFullTitle(final Player player, final String title, final String subtitle) {
        player.sendTitle(fixColor(title), fixColor(subtitle), 5, 60, 5);
    }
    
    public static void sendActionbar(final String s) {
        final Iterator<Player> iterator = Server.getInstance().getOnlinePlayers().values().iterator();
        while (iterator.hasNext()) {
            iterator.next().sendActionBar(fixColor(s));
        }
    }
    
    public static boolean sendMessage(final CommandSender commandSender, final String s) {
        if (commandSender instanceof Player) {
            commandSender.sendMessage(fixColor(s));
        }
        else {
            commandSender.sendMessage(TextFormat.colorize(fixColor(s)));
        }
        return true;
    }
}
