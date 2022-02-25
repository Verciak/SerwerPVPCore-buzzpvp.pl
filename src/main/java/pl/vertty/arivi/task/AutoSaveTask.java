
package pl.vertty.arivi.task;

import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.managers.ranking.GuildDeathManager;
import pl.vertty.arivi.managers.ranking.GuildKillsManager;
import pl.vertty.arivi.managers.ranking.GuildRankingManager;
import pl.vertty.arivi.managers.ranking.*;

public class AutoSaveTask extends NukkitRunnable
{
    public void run() {
        RankingManager.sortUserRankings();
        KillManager.sortKills();
        DeathManager.sortDeaths();
        KoxManager.sortKox();
        RefilManager.sortRefil();
        PerlyManager.sortPerly();
        KamienManager.sortKamien();
        GuildRankingManager.sortDeaths();
        GuildKillsManager.sortDeaths();
        GuildDeathManager.sortDeaths();
    }
}
