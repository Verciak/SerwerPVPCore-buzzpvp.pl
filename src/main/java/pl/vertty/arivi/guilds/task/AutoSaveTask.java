// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.task;

import pl.vertty.arivi.guilds.managers.guild.RoleManager;
import pl.vertty.arivi.guilds.managers.guild.NameTagManager;
import pl.vertty.arivi.guilds.rank.RankingManager;
import cn.nukkit.scheduler.NukkitRunnable;

public class AutoSaveTask extends NukkitRunnable
{
    public void run() {
        RankingManager.sortUserRankings();
        RankingManager.sortGuildRankings();

    }
}
