
package pl.vertty.arivi.managers.ranking;

import java.util.LinkedList;
import java.util.Comparator;
import pl.vertty.arivi.managers.comparator.GuildComparator;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.User;
import java.util.List;

public class KillManager
{
    private static List<User> kills;
    private static List<Guild> guildKills;
    
    public static List<User> getKills() {
        return KillManager.kills;
    }
    
    public static List<Guild> getGuildKills() {
        return KillManager.guildKills;
    }
    
    public static void addKill(final User kill) {
        KillManager.kills.add(kill);
    }
    
    public static void addKill(final Guild kill) {
        KillManager.guildKills.add(kill);
        sortGuildKills();
    }
    
    public static void removeKill(final User kill) {
        KillManager.kills.remove(kill);
    }
    
    public static void removeKill(final Guild kill) {
        KillManager.guildKills.remove(kill);
        sortGuildKills();
    }
    
    public static void sortGuildKills() {
        KillManager.guildKills.sort(new GuildComparator());
    }
    
    public static int getPlaceUser(final User user) {
        for (int num = 0; num < KillManager.kills.size(); ++num) {
            if (KillManager.kills.get(num).equals(user)) {
                return num + 1;
            }
        }
        return 0;
    }
    
    public static int getPlaceGuild(final Guild guild) {
        for (int num = 0; num < KillManager.kills.size(); ++num) {
            if (KillManager.guildKills.get(num).equals(guild)) {
                return num + 1;
            }
        }
        return 0;
    }
    
    static {
        KillManager.kills = new LinkedList<User>();
        KillManager.guildKills = new LinkedList<Guild>();
    }
}
