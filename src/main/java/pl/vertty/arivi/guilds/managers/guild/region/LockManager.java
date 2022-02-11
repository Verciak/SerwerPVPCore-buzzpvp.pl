
package pl.vertty.arivi.guilds.managers.guild.region;

import java.util.ArrayList;
import cn.nukkit.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import pl.vertty.arivi.guilds.utils.Logger;
import java.util.Iterator;
import cn.nukkit.level.Location;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.guild.cuboid.Lock;
import java.util.List;

public class LockManager
{
    private static List<Lock> locks;
    
    public static void deleteLock(final String s) {
        final Lock lockByTag = getLockByTag(s);
        LockManager.locks.remove(lockByTag);
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `pCGuilds_lock` WHERE `tag` = '").append(lockByTag.getTag()).append("'")));
    }
    
    public static Lock getLockByLocation(final Location location) {
        for (final Lock lock : LockManager.locks) {
            if (lock.getLocation().equals((Object)location)) {
                return lock;
            }
        }
        return null;
    }
    
    public static void loadLocks() {
        try {
            final ResultSet query = Main.getStore().query("SELECT * FROM `pCGuilds_lock`");
            while (query.next()) {
                LockManager.locks.add(new Lock(query));
            }
            query.close();
            Logger.info(String.valueOf(new StringBuilder().append("Loaded ").append(LockManager.locks.size()).append(" locks from pCGuilds_lock")));
        }
        catch (SQLException ex) {
            Logger.info("Nie mozna zaladowac tabeli pCGuilds_lock");
            ex.printStackTrace();
        }
    }
    
    public static void addLock(final String s, final String s2, final Location location) {
        LockManager.locks.add(new Lock(s, s2, location));
    }
    
    public static Lock getLockByPlayer(final Location location, final Player player) {
        for (final Lock lock : LockManager.locks) {
            if (lock.getLocation().equals((Object)location) && lock.getNick().equalsIgnoreCase(player.getName())) {
                return lock;
            }
        }
        return null;
    }
    
    public static Lock getLockByTag(final String anotherString) {
        for (final Lock lock : LockManager.locks) {
            if (lock.getTag().equalsIgnoreCase(anotherString)) {
                return lock;
            }
        }
        return null;
    }
    
    static {
        LockManager.locks = new ArrayList<Lock>();
    }
}
