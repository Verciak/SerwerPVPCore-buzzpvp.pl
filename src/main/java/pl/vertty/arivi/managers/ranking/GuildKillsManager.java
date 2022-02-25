
package pl.vertty.arivi.managers.ranking;

import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.managers.comparator.GuildKillsComparator;

import java.util.LinkedList;
import java.util.List;

public class GuildKillsManager
{
    private static List<Guild> deaths;

    public static List<Guild> getDeaths() {
        return GuildKillsManager.deaths;
    }
    

    public static void addDeath(final Guild death) {
        GuildKillsManager.deaths.add(death);
        sortDeaths();
    }
    public static void removeDeath(final Guild kill) {
        GuildKillsManager.deaths.remove(kill);
        sortDeaths();
    }
    

    
    public static void sortDeaths() {
        GuildKillsManager.deaths.sort(new GuildKillsComparator());
    }

    static {
        GuildKillsManager.deaths = new LinkedList<>();
    }

}
