// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.managers.ranking;

import java.util.LinkedList;
import java.util.Comparator;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.rank.comparators.UserDeathsComparator;
import pl.vertty.arivi.guilds.rank.comparators.UserKillsComparator;

import java.util.List;

public class DeathManager
{
    public static List<User> getRankings() {
        return DeathManager.deaths;
    }

    private static List<User> deaths;

    public static void addDeath(final User death) {
        DeathManager.deaths.add(death);
    }
    
    public static void removeDeath(final User death) {
        DeathManager.deaths.remove(death);
    }

    public static void sortUserRankings() {
        DeathManager.deaths.sort(new UserDeathsComparator());
    }

    
    static {
        DeathManager.deaths = new LinkedList<User>();
    }
}
