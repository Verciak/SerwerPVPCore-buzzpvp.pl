
package pl.vertty.arivi.managers.ranking;

import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.managers.comparator.GuildPointsComparator;

import java.util.LinkedList;
import java.util.List;

public class GuildRankingManager
{
    private static List<Guild> deaths;

    public static List<Guild> getDeaths() {
        return GuildRankingManager.deaths;
    }


    public static void addDeath(final Guild death) {
        GuildRankingManager.deaths.add(death);
        sortDeaths();
    }
    public static void removeDeath(final Guild kill) {
        GuildRankingManager.deaths.remove(kill);
        sortDeaths();
    }



    public static void sortDeaths() {
        GuildRankingManager.deaths.sort(new GuildPointsComparator());
    }

    static {
        GuildRankingManager.deaths = new LinkedList<>();
    }

}
