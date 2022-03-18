// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.managers.time;

import cn.nukkit.Player;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.utils.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class TimeObjectManager
{
    private static final ConcurrentHashMap<String, TimeObject> users;
    
    public static ConcurrentHashMap<String, TimeObject> getUsers() {
        return TimeObjectManager.users;
    }

    public static void loadUsers() {
        try {
            final ResultSet query = Main.getStore().query("SELECT * FROM `pCGuilds_reward`");
            while (query.next()) {
                final TimeObject value = new TimeObject(query);
                TimeObjectManager.users.put(value.getName(), value);
            }
            query.close();
            Logger.info(String.valueOf(new StringBuilder().append("Loaded ").append(TimeObjectManager.users.size()).append(" players from pCGuilds_reward")));
        }
        catch (SQLException ex) {
            Logger.info("Nie mozna zaladowac tabeli pCGuilds_reward");
            ex.printStackTrace();
        }
    }
    
    public static void createrUser(final Player player) {
        final TimeObject value = new TimeObject(player);
        TimeObjectManager.users.put(player.getName(), value);
    }
    
    public static TimeObject getUser(final Player player) {
        for (final TimeObject user : TimeObjectManager.users.values()) {
            if (user.getName().equalsIgnoreCase(player.getName())) {
                return user;
            }
        }
        return null;
    }
    
    public static TimeObject getUser(final String anotherString) {
        for (final TimeObject user : TimeObjectManager.users.values()) {
            if (user.getName().equalsIgnoreCase(anotherString)) {
                return user;
            }
        }
        return null;
    }
    
    static {
        users = new ConcurrentHashMap<String, TimeObject>();
    }
}
