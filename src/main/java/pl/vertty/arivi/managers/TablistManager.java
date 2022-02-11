
package pl.vertty.arivi.managers;

import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.rank.RankingManager;

public class TablistManager
{
    public static String getReplacementR(final Integer i) {
        if (RankingManager.getRankings().size() < i) {
            return "&7" + i + ". &fBrak informacji.";
        }
        String s;
        if (i == 1) {
            s = "&7" + i + ". ";
        }
        else if (i == 2) {
            s = "&7" + i + ". ";
        }
        else if (i == 3) {
            s = "&7" + i + ". ";
        }
        else {
            s = "&7" + i + ". ";
        }
        return ChatUtil.fixColor(s + "&f" + RankingManager.getRankings().get(i - 1).getName() + " &8- &7" + RankingManager.getRankings().get(i - 1).getPoints() + "pkt");
    }
    
    public static String getReplacementG(final Integer i) {
        if (RankingManager.getGuildRankings().size() < i) {
            return "&7" + i + ". &fBrak informacji.";
        }
        String s;
        if (i == 1) {
            s = "&7" + i + ". ";
        }
        else if (i == 2) {
            s = "&7" + i + ". ";
        }
        else if (i == 3) {
            s = "&7" + i + ". ";
        }
        else {
            s = "&7" + i + ". ";
        }
        if (RankingManager.getGuildRankings().get(i - 1).getOnlineMembers().size() != 0) {
            return ChatUtil.fixColor(s + "&f" + RankingManager.getGuildRankings().get(i - 1).getTag() + " &8- &7" + RankingManager.getGuildRankings().get(i - 1).getPoints() + "pkt");
        }
        return ChatUtil.fixColor(s + "&f" + RankingManager.getGuildRankings().get(i - 1).getTag() + " &8- &7" + RankingManager.getGuildRankings().get(i - 1).getPoints() + "pkt");
    }
}
