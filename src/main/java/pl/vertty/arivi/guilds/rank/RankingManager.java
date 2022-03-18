// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.rank;

import java.util.LinkedList;
import pl.vertty.arivi.guilds.rank.comparators.UserPointsComparator;

import pl.vertty.arivi.guilds.data.User;
import java.util.List;

public class RankingManager
{
    private static List<User> rankings;
    
    public static String getReplacementUsers(final int n) {
        if (getRankings().size() >= n) {
            String str = String.valueOf(new StringBuilder().append("&7").append(n).append(". &c&l\u2718 &f"));
            final User user = getRankings().get(n - 1);
            if (user.getPlayer() != null && user.getPlayer().isOnline()) {
                str = String.valueOf(new StringBuilder().append("&7").append(n).append(". &a&l\u2714 &f"));
            }
            return String.valueOf(new StringBuilder().append(str).append(getRankings().get(n - 1).getName()).append(" &8[&9").append(getRankings().get(n - 1).getPoints()).append("&8]"));
        }
        return "";
    }
    
    public static int getPlaceUser(final User obj) {
        for (int i = 0; i < RankingManager.rankings.size(); ++i) {
            if (RankingManager.rankings.get(i).equals(obj)) {
                return i + 1;
            }
            final int n = 0;
        }
        return 0;
    }
    
    public static void removeRanking(final User user) {
        RankingManager.rankings.remove(user);
        sortUserRankings();
    }
    
    public static void addRanking(final User user) {
        RankingManager.rankings.add(user);
        sortUserRankings();
    }
    
    public static void sortUserRankings() {
        RankingManager.rankings.sort(new UserPointsComparator());
    }
    
    public static List<User> getRankings() {
        return RankingManager.rankings;
    }
    

    static {
        RankingManager.rankings = new LinkedList<User>();
    }
}
