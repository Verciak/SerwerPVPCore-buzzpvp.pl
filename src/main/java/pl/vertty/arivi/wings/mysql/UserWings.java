
package pl.vertty.arivi.wings.mysql;

import cn.nukkit.Player;
import pl.vertty.arivi.Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class UserWings
{
    public static final ConcurrentHashMap<String, UserWingsManager> users = new ConcurrentHashMap<>();
    
    public static UserWingsManager getUser(final Player p) {
        return users.get(p.getName());
    }
    
    public static UserWingsManager getUser(final String name) {
        return users.get(name);
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

}
