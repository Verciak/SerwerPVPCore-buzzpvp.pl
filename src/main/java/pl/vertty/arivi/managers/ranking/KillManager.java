
package pl.vertty.arivi.managers.ranking;

import java.util.LinkedList;
import java.util.Comparator;
import pl.vertty.arivi.managers.comparator.GuildComparator;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.managers.comparator.UserKillsComparator;

import java.util.List;

public class KillManager
{
    private static List<User> kills;

    public static List<User> getKills() {
        return KillManager.kills;
    }
    

    public static void addKill(final User kill) {
        KillManager.kills.add(kill);
        sortKills();
    }

    
    public static void removeKill(final User kill) {
        KillManager.kills.remove(kill);
        sortKills();
    }

    
    public static void sortKills() {
        KillManager.kills.sort(new UserKillsComparator());
    }

    
    static {
        KillManager.kills = new LinkedList<>();
    }
}
