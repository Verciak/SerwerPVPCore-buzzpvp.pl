// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.managers;

import java.util.Iterator;
import cn.nukkit.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import pl.vertty.arivi.guilds.utils.Logger;
import pl.vertty.arivi.guilds.rank.RankingManager;
import java.util.Collection;
import java.util.ArrayList;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import cn.nukkit.level.Location;
import java.util.List;
import pl.vertty.arivi.guilds.data.User;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager
{
    private static final ConcurrentHashMap<String, User> users;
    private static final List<User> online;
    
    public static ConcurrentHashMap<String, User> getUsers() {
        return UserManager.users;
    }
    
    public static boolean canPlaceByBorder(final Location loc) {
        final Config c = Main.getPlugin().getConfig();
        return Math.abs(c.getInt("border") - loc.getFloorX()) >= 10 && Math.abs(c.getInt("border") - loc.getFloorZ()) >= 10 && Math.abs(-c.getInt("border") - loc.getFloorX()) >= 10 && Math.abs(-c.getInt("border") - loc.getFloorZ()) >= 10 && Math.abs(-c.getInt("border") - loc.getFloorX()) >= 10 && Math.abs(c.getInt("border") - loc.getFloorZ()) >= 10 && Math.abs(c.getInt("border") - loc.getFloorX()) >= 10 && Math.abs(-c.getInt("border") - loc.getFloorZ()) >= 10;
    }
    
    public static List<User> getOnline() {
        return new ArrayList<User>(UserManager.online);
    }
    
    public static void loadUsers() {
        try {
            final ResultSet query = Main.getStore().query("SELECT * FROM `pCGuilds_users`");
            while (query.next()) {
                final User value = new User(query);
                UserManager.users.put(value.getName(), value);
                RankingManager.addRanking(value);
            }
            query.close();
//            Logger.info(String.valueOf(new StringBuilder().append("Loaded ").append(UserManager.users.size()).append(" players from pCGuilds_users")));
            Logger.info("Loaded " + users.size() + " players from 'pCGuilds_users'");
        }
        catch (SQLException ex) {
            Logger.info("Nie mozna zaladowac tabeli pCGuilds_users");
            ex.printStackTrace();
        }
    }
    
    public static void deleteUser(final User user) {
        UserManager.users.remove(user.getName());
//        Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `pCGuilds_users` WHERE `name` = '").append(user.getName()).append("'")));
        Main.getStore().asyncUpdate("DELETE FROM `pCGuilds_users` WHERE `name` = '" + user.getName() + "'");
        RankingManager.removeRanking(user);
    }
    
    public static void createrUser(final Player player) {
        final User value = new User(player);
        UserManager.users.put(player.getName(), value);
        RankingManager.addRanking(value);
    }
    
    public static User getUser(final Player player) {
        for (final User user : UserManager.users.values()) {
            if (user.getName().equalsIgnoreCase(player.getName())) {
                return user;
            }
        }
        return null;
    }
    
    public static User getUser(final String anotherString) {
        for (final User user : UserManager.users.values()) {
            if (user.getName().equalsIgnoreCase(anotherString)) {
                return user;
            }
        }
        return null;
    }
    
    static {
        online = new ArrayList<User>();
        users = new ConcurrentHashMap<String, User>();
    }
}
