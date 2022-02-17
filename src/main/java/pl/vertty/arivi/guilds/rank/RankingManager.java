
package pl.vertty.arivi.guilds.rank;

import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.rank.comparators.GuildComparator;
import pl.vertty.arivi.guilds.rank.comparators.UserPointsComparator;

import java.util.LinkedList;
import java.util.List;

public class RankingManager
{
    private static List<User> rankings;
    private static List<Guild> guildRankings;


    public static void addRanking(final Guild guild) {
        RankingManager.guildRankings.add(guild);
        sortGuildRankings();
    }
    
    public static void removeRanking(final Guild guild) {
        RankingManager.guildRankings.remove(guild);
        sortGuildRankings();
    }
    
    public static void sortGuildRankings() {
        RankingManager.guildRankings.sort(new GuildComparator());
    }
    
    public static int getPlaceGuild(final Guild obj) {
        for (int i = 0; i < RankingManager.rankings.size(); ++i) {
            if (RankingManager.guildRankings.get(i).equals(obj)) {
                return i + 1;
            }
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
    
    public static List<Guild> getGuildRankings() {
        return RankingManager.guildRankings;
    }
    
    static {
        RankingManager.rankings = new LinkedList<>();
        RankingManager.guildRankings = new LinkedList<>();
    }
}
