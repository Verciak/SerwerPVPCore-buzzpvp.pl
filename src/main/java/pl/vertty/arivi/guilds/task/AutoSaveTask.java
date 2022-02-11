
package pl.vertty.arivi.guilds.task;

import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.guilds.rank.RankingManager;

public class AutoSaveTask extends NukkitRunnable
{
    public void run() {
        RankingManager.sortUserRankings();
        RankingManager.sortGuildRankings();

    }
}
