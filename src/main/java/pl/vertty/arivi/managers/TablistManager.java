// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.managers;

import pl.vertty.arivi.managers.ranking.CoinsManager;
import pl.vertty.arivi.managers.ranking.DeathManager;
import pl.vertty.arivi.managers.ranking.KillManager;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.rank.RankingManager;

public class TablistManager
{
    public static String getReplacementR(final Integer i) {
        if (RankingManager.getRankings().size() < i) {
            return "&r&7" + i + ". &fBrak informacji.";
        }
        String s;
        s = "&r&7" + i + ". ";
        return ChatUtil.fixColor(s + "&r&f" + RankingManager.getRankings().get(i - 1).getName() + " &8- &7" + RankingManager.getRankings().get(i - 1).getPoints() + "pkt");
    }

    public static String getReplacementKills(final Integer i) {
        if (KillManager.getRankings().size() < i) {
            return "&r&7" + i + ". &fBrak informacji.";
        }
        String s;
        s = "&r&7" + i + ". ";
        return ChatUtil.fixColor(s + "&r&f" + KillManager.getRankings().get(i - 1).getName() + " &8- &7" + KillManager.getRankings().get(i - 1).getKills() + " zabojstw");
    }

    public static String getReplacementDeaths(final Integer i) {
        if (DeathManager.getRankings().size() < i) {
            return "&r&7" + i + ". &fBrak informacji.";
        }
        String s;
        s = "&r&7" + i + ". ";
        return ChatUtil.fixColor(s + "&r&f" + DeathManager.getRankings().get(i - 1).getName() + " &8- &7" + DeathManager.getRankings().get(i - 1).getDeaths() + " smierci");
    }
    public static String getReplacementDCoins(final Integer i) {
        if (CoinsManager.getRankings().size() < i) {
            return "&r&7" + i + ". &fBrak informacji.";
        }
        String s;
        s = "&r&7" + i + ". ";
        return ChatUtil.fixColor(s + "&r&f" + CoinsManager.getRankings().get(i - 1).getName() + " &8- &7" + CoinsManager.getRankings().get(i - 1).getCoins() + " monet");
    }

}
