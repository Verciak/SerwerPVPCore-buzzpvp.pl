
package pl.vertty.arivi.managers;

import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.managers.ranking.*;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.rank.RankingManager;

public class TablistManager
{

    public static String getKamien(Integer i) {
        if (KamienManager.getKamien().size() >= i) {
            String s = "&7" + i + ". &3";
            if (i > 9)
                s = "&7" + i + ". &3";
            return s + "&e"+KamienManager.getKamien().get(i - 1).getName() + " &8(&f" + KamienManager.getKamien().get(i - 1).getkamien() + " &7wykopanego kamienia&8)";
        }
        return "&7" + i + ". &7Brak";
    }

    public static String getPerly(Integer i) {
        if (PerlyManager.getPerly().size() >= i) {
            String s = "&7" + i + ". &3";
            if (i > 9)
                s = "&7" + i + ". &3";
            return s + "&e"+PerlyManager.getPerly().get(i - 1).getName() + " &8(&f" + PerlyManager.getPerly().get(i - 1).getperla() + " &7rzuconych perel&8)";
        }
        return "&7" + i + ". &7Brak";
    }

    public static String getRefil(Integer i) {
        if (RefilManager.getRefil().size() >= i) {
            String s = "&7" + i + ". &3";
            if (i > 9)
                s = "&7" + i + ". &3";
            return s + "&e" + RefilManager.getRefil().get(i - 1).getName() + " &8(&f" + RefilManager.getRefil().get(i - 1).getrefil() + " &7zjedzonych refili&8)";
        }
        return "&7" + i + ". &7Brak";
    }

    public static String getKox(Integer i) {
        if (KoxManager.getKox().size() >= i) {
            String s = "&7" + i + ". &e";
            if (i > 9)
                s = "&7" + i + ". &e";
            return s + "&e"+KoxManager.getKox().get(i - 1).getName() + " &8(&f" + KoxManager.getKox().get(i - 1).getkox() + " &7zjedzonych koxow&8)";
        }
        return "&7" + i + ". &fBrak";
    }

    public static String getKills(Integer i) {
        if (KillManager.getKills().size() >= i) {
            String s = "&7" + i + ". &e";
            if (i > 10)
                s = "&7" + i + ". &e";
            return "" + s + "&e" + KillManager.getKills().get(i - 1).getName() + " &8(&f" + KillManager.getKills().get(i - 1).getKills() + " &7zabitych graczy&8)";
        }
        return "&7" + i + ". &fBrak";
    }

    public static String getDeaths(Integer i) {
        if (DeathManager.getDeaths().size() >= i) {
            String s = "&7" + i + ". &e";
            if (i > 9)
                s = "&7" + i + ". &e";
            return s + "&e"+DeathManager.getDeaths().get(i - 1).getName() + " &8(&f" + DeathManager.getDeaths().get(i - 1).getDeaths() + " &7smierci&8)";
        }
        return "&7" + i + ". &7Brak";
    }

    public static String getReplacementR(final Integer i) {
        if (RankingManager.getRankings().size() < i) {
            return "&7" + i + ". &7Brak";
        }
        String s = "&7" + i + ". ";
        return ChatUtil.fixColor(s + "&e" + RankingManager.getRankings().get(i - 1).getName() + " &8(&f" + RankingManager.getRankings().get(i - 1).getPoints() + " &7punktow&8)");
    }
    
    public static String getReplacementG(final Integer i) {
        if (RankingManager.getGuildRankings().size() < i) {
            return "&7" + i + ". &7Brak";
        }
        String s = "&7" + i + ". ";
        RankingManager.getGuildRankings().get(i - 1).getOnlineMembers();
        return ChatUtil.fixColor(s + "&fe" + RankingManager.getGuildRankings().get(i - 1).getTag() + " &8- &7" + RankingManager.getGuildRankings().get(i - 1).getPoints() + "pkt");
    }
}
