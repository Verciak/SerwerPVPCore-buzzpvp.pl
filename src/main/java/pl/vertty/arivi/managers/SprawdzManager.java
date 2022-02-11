
package pl.vertty.arivi.managers;

import java.util.Iterator;
import cn.nukkit.Player;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.objects.Sprawdz;
import java.util.ArrayList;
import java.util.HashMap;

public class SprawdzManager
{
    public static String title;
    public static String chat;
    public static HashMap<String, String> messages;
    public static ArrayList<String> allowed_commands;
    public static String wyslij_admin;
    public static String wyslij_user;
    public static String admin_mess;
    public static String user_mess;
    private static HashMap<String, Sprawdz> sprawdz;
    
    public SprawdzManager() {
        SprawdzManager.chat = "&bJestes  sprawdzany! Nie logaj!";
        SprawdzManager.wyslij_admin = "&8[&b&lSPRWADZANY&8] &7{USER} &8>> &7{MESSAGE}";
        SprawdzManager.wyslij_user = "&8[&b&lADMINISTRATOR&8] &7{USER} &8>> &7{MESSAGE}";
        SprawdzManager.allowed_commands = (ArrayList<String>)Main.getPlugin().getConfig().getStringList("check_allowed_commands");
    }
    
    public static Sprawdz getByPlayer(final Player p) {
        for (final Sprawdz s : SprawdzManager.sprawdz.values()) {
            if (s.getPlayer() == p) {
                return s;
            }
        }
        return null;
    }
    
    public static Sprawdz getByAdmin(final Player p) {
        for (final Sprawdz s : SprawdzManager.sprawdz.values()) {
            if (s.getAdmin() == p) {
                return s;
            }
        }
        return null;
    }
    
    public static Sprawdz delete(final Player p) {
        p.removeEffect(9);
        p.removeEffect(15);
        SprawdzManager.sprawdz.remove(p.getName());
        return null;
    }
    
    public static Sprawdz create(final Player p, final Player admin, final String reason) {
        final Sprawdz s = new Sprawdz(p, admin, Long.valueOf(System.currentTimeMillis()), reason, p.getLocation(), true, "");
        SprawdzManager.sprawdz.put(p.getName(), s);
        return s;
    }
    
    public static HashMap<String, Sprawdz> getList() {
        return SprawdzManager.sprawdz;
    }
    
    static {
        SprawdzManager.messages = new HashMap<String, String>();
        SprawdzManager.allowed_commands = new ArrayList<String>();
        SprawdzManager.sprawdz = new HashMap<String, Sprawdz>();
    }
}
