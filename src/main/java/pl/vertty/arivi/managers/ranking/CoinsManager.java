// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.managers.ranking;

import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.rank.comparators.UserCoinsComparator;
import pl.vertty.arivi.guilds.rank.comparators.UserKillsComparator;

import java.util.LinkedList;
import java.util.List;

public class CoinsManager
{
    public static List<User> getRankings() {
        return CoinsManager.coins;
    }

    private static List<User> coins;

    public static void addKill(final User kill) {
        CoinsManager.coins.add(kill);
    }
    
    public static void removeKill(final User kill) {
        CoinsManager.coins.remove(kill);
    }


    public static void sortUserRankings() {
        CoinsManager.coins.sort(new UserCoinsComparator());
    }



    static {
        CoinsManager.coins = new LinkedList<User>();
    }
}
