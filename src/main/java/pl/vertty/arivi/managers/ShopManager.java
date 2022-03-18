// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.managers;

import cn.nukkit.Player;
import cn.nukkit.level.Location;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.utils.Logger;
import pl.vertty.arivi.objects.Shop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ShopManager
{
    private static final ConcurrentHashMap<String, Shop> users;
    private static final List<Shop> online;
    
    public static ConcurrentHashMap<String, Shop> getUsers() {
        return ShopManager.users;
    }
    
    public static List<Shop> getOnline() {
        return new ArrayList<Shop>(ShopManager.online);
    }
    
    public static void loadUsers() {
        try {
            final ResultSet query = Main.getStore().query("SELECT * FROM `pCGuilds_shop`");
            while (query.next()) {
                final Shop value = new Shop(query);
                ShopManager.users.put(value.getName(), value);
            }
            query.close();
            Logger.info(String.valueOf(new StringBuilder().append("Loaded ").append(ShopManager.users.size()).append(" players from pCGuilds_shop")));
        }
        catch (SQLException ex) {
            Logger.info("Nie mozna zaladowac tabeli pCGuilds_shop");
            ex.printStackTrace();
        }
    }
    
    public static void deleteUser(final Shop user) {
        ShopManager.users.remove(user.getName());
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `pCGuilds_shop` WHERE `name` = '").append(user.getName()).append("'")));
    }
    
    public static void createrUser(final Player player) {
        final Shop value = new Shop(player);
        ShopManager.users.put(player.getName(), value);
    }
    
    public static Shop getUser(final Player player) {
        for (final Shop user : ShopManager.users.values()) {
            if (user.getName().equalsIgnoreCase(player.getName())) {
                return user;
            }
        }

        return null;
    }
    
    public static Shop getUser(final String anotherString) {
        for (final Shop user : ShopManager.users.values()) {
            if (user.getName().equalsIgnoreCase(anotherString)) {
                return user;
            }
        }
        return null;
    }
    
    static {
        online = new ArrayList<Shop>();
        users = new ConcurrentHashMap<String, Shop>();
    }
}
