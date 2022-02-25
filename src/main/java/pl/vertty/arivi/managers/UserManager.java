
package pl.vertty.arivi.managers;

import cn.nukkit.Player;
import cn.nukkit.level.Location;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.MainConstants;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.utils.guild.Logger;
import pl.vertty.arivi.managers.ranking.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager
{
    private static final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, User> getUsers() {
        return UserManager.users;
    }
    
    public static boolean canPlaceByBorder(final Location loc) {
        return Math.abs(MainConstants.BORDER - loc.getFloorX()) >= 10 && Math.abs(MainConstants.BORDER - loc.getFloorZ()) >= 10 && Math.abs(-MainConstants.BORDER - loc.getFloorX()) >= 10 && Math.abs(-MainConstants.BORDER - loc.getFloorZ()) >= 10 && Math.abs(-MainConstants.BORDER - loc.getFloorX()) >= 10 && Math.abs(MainConstants.BORDER - loc.getFloorZ()) >= 10 && Math.abs(MainConstants.BORDER - loc.getFloorX()) >= 10 && Math.abs(-MainConstants.BORDER - loc.getFloorZ()) >= 10;
    }
    
    public static void loadUsers() {
        try {
            final ResultSet query = Main.getStore().query("SELECT * FROM `pCGuilds_users`");
            while (query.next()) {
                final User value = new User(query);
                UserManager.users.put(value.getName(), value);
                RankingManager.addRanking(value);
                KillManager.addKill(value);
                DeathManager.addDeath(value);
                KoxManager.addKox(value);
                RefilManager.addRefil(value);
                PerlyManager.addPerly(value);
                KamienManager.addKamien(value);
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
        KillManager.removeKill(user);
        DeathManager.removeDeath(user);
        KoxManager.removeKox(user);
        RefilManager.removeRefil(user);
        PerlyManager.removePerly(user);
        KamienManager.removeKamien(user);
    }
    
    public static void createrUser(final Player player) {
        final User value = new User(player);
        UserManager.users.put(player.getName(), value);
        RankingManager.addRanking(value);
        KillManager.addKill(value);
        DeathManager.addDeath(value);
        KoxManager.addKox(value);
        RefilManager.addRefil(value);
        PerlyManager.addPerly(value);
        KamienManager.addKamien(value);
    }
    
    public static User getUser(final Player player) {
        return users.get(player.getName());
    }
    
    public static User getUser(final String anotherString) {
        return  users.get(anotherString);
    }

}
