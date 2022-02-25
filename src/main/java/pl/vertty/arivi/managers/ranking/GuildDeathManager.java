
package pl.vertty.arivi.managers.ranking;

import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.managers.comparator.GuildDeathComparator;

import java.util.LinkedList;
import java.util.List;

public class GuildDeathManager
{
    private static List<Guild> deaths;

    public static List<Guild> getDeaths() {
        return GuildDeathManager.deaths;
    }
    

    public static void addDeath(final Guild death) {
        GuildDeathManager.deaths.add(death);
        sortDeaths();
    }
    public static void removeDeath(final Guild kill) {
        GuildDeathManager.deaths.remove(kill);
        sortDeaths();
    }
    

    
    public static void sortDeaths() {
        GuildDeathManager.deaths.sort(new GuildDeathComparator());
    }

    static {
        GuildDeathManager.deaths = new LinkedList<>();
    }

}
