// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.wings.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import pl.vertty.arivi.Main;
import java.util.Iterator;
import cn.nukkit.Player;
import java.util.concurrent.ConcurrentHashMap;

public class UserWings
{
    public static final ConcurrentHashMap<String, UserWingsManager> users;
    
    public static UserWingsManager getUser(final Player p) {
        for (final UserWingsManager u : UserWings.users.values()) {
            if (u.getName().equalsIgnoreCase(p.getName())) {
                return u;
            }
        }
        return null;
    }
    
    public static UserWingsManager getUser(final String name) {
        for (final UserWingsManager u : UserWings.users.values()) {
            if (u.getName().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }
    
    public static void createrUser(final Player p) {
        final UserWingsManager u = new UserWingsManager(p);
        UserWings.users.put(p.getName(), u);
    }
    
    public static void deleteUser(final Player p) {
        final UserWingsManager u = new UserWingsManager(p);
        UserWings.users.remove(u.getName());
        Main.getStore().update(false, "DELETE FROM `pCGuilds_wings` WHERE `name` = '" + p.getName() + "'");
    }
    
    public static void deleteUser(final String p) {
        final UserWingsManager u = new UserWingsManager(p);
        UserWings.users.remove(u.getName());
        Main.getStore().update(false, "DELETE FROM `pCGuilds_wings` WHERE `name` = '" + p + "'");
    }
    
    public static void loadUsers() {
        try {
            final ResultSet rs = Main.getStore().query("SELECT * FROM `pCGuilds_wings`");
            while (rs.next()) {
                final UserWingsManager u = new UserWingsManager(rs);
                UserWings.users.put(u.getName(), u);
            }
            rs.close();
        }
        catch (SQLException e) {}
    }
    
    public static ConcurrentHashMap<String, UserWingsManager> getUsers() {
        return UserWings.users;
    }
    
    static {
        users = new ConcurrentHashMap<String, UserWingsManager>();
    }
}
