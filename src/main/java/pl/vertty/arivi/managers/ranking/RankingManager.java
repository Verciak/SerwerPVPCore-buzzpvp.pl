
package pl.vertty.arivi.managers.ranking;

import java.util.LinkedList;
import java.util.Comparator;
import pl.vertty.arivi.managers.comparator.GuildComparator;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.managers.comparator.UserDeathsComparator;
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
