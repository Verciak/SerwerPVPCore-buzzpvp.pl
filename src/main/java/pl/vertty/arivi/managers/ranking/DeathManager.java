
package pl.vertty.arivi.managers.ranking;

import java.util.LinkedList;
import java.util.Comparator;
import pl.vertty.arivi.managers.comparator.GuildComparator;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.managers.comparator.UserDeathsComparator;

import java.util.List;

public class DeathManager
{
    private static List<User> deaths;

    public static List<User> getDeaths() {
        return DeathManager.deaths;
    }
    

    public static void addDeath(final User death) {
        DeathManager.deaths.add(death);
        sortDeaths();
    }
    public static void removeDeath(final User kill) {
        DeathManager.deaths.remove(kill);
        sortDeaths();
    }
    

    
    public static void sortDeaths() {
        DeathManager.deaths.sort(new UserDeathsComparator());
    }

    static {
        DeathManager.deaths = new LinkedList<>();
    }

}
