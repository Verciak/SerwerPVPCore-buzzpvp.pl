
package pl.vertty.arivi.guilds.task;

import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.guilds.rank.GuildDeathManager;
import pl.vertty.arivi.guilds.rank.GuildKillsManager;
import pl.vertty.arivi.guilds.rank.GuildRankingManager;
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
