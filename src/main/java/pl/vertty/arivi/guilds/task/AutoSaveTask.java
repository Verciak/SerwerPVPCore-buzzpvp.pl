// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.task;

import pl.vertty.arivi.guilds.rank.RankingManager;
import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.managers.ranking.CoinsManager;
import pl.vertty.arivi.managers.ranking.DeathManager;
import pl.vertty.arivi.managers.ranking.KillManager;

public class AutoSaveTask extends NukkitRunnable
{
    public void run() {
        RankingManager.sortUserRankings();
        KillManager.sortUserRankings();
        DeathManager.sortUserRankings();
        CoinsManager.sortUserRankings();
    }
}
