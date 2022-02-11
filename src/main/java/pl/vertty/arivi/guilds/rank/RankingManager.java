
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
            final int n = 4;
            final int n2 = -1;
        }
        return 0;
    }
    
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
    
    public static String getReplacementGuilds(final int n) {
        if (getGuildRankings().size() >= n) {
            String str = String.valueOf(new StringBuilder().append("&7").append(n).append(". &f"));
            if (n > 9) {
                str = String.valueOf(new StringBuilder().append("&7").append(n).append(". &f"));
            }
            return String.valueOf(new StringBuilder().append(str).append(getGuildRankings().get(n - 1).getTag()).append(" &8[&9").append(getGuildRankings().get(n - 1).getPoints()).append("&8]"));
        }
        return "";
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
        RankingManager.rankings = new LinkedList<User>();
        RankingManager.guildRankings = new LinkedList<Guild>();
    }
}
