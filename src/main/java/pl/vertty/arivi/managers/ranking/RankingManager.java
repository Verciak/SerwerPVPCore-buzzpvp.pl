
package pl.vertty.arivi.managers.ranking;

import java.util.LinkedList;

import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.comparator.UserPointsComparator;

import java.util.List;

public class RankingManager
{
    private static List<User> deaths;

    public static List<User> getDeaths() {
        return RankingManager.deaths;
    }


    public static void addRanking(final User death) {
        RankingManager.deaths.add(death);
        sortUserRankings();
    }
    public static void removeRanking(final User kill) {
        RankingManager.deaths.remove(kill);
        sortUserRankings();
    }



    public static void sortUserRankings() {
        RankingManager.deaths.sort(new UserPointsComparator());
    }

    static {
        RankingManager.deaths = new LinkedList<>();
    }

}
