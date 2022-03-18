// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.managers.ranking;

import java.util.LinkedList;
import java.util.Comparator;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.rank.RankingManager;
import pl.vertty.arivi.guilds.rank.comparators.UserKillsComparator;
import pl.vertty.arivi.guilds.rank.comparators.UserPointsComparator;

import java.util.List;

public class KillManager
{
    public static List<User> getRankings() {
        return KillManager.kills;
    }

    private static List<User> kills;

    public static void addKill(final User kill) {
        KillManager.kills.add(kill);
    }
    
    public static void removeKill(final User kill) {
        KillManager.kills.remove(kill);
    }


    public static void sortUserRankings() {
        KillManager.kills.sort(new UserKillsComparator());
    }



    static {
        KillManager.kills = new LinkedList<User>();
    }
}
