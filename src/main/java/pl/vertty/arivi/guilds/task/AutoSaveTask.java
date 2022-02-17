
package pl.vertty.arivi.guilds.task;

import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.guilds.rank.RankingManager;
import pl.vertty.arivi.managers.ranking.*;

public class AutoSaveTask extends NukkitRunnable
{
    public void run() {
        RankingManager.sortUserRankings();
        RankingManager.sortGuildRankings();
        KillManager.sortKills();
        DeathManager.sortDeaths();
        KoxManager.sortKox();
        RefilManager.sortRefil();
        PerlyManager.sortPerly();
        KamienManager.sortKamien();
    }
}
