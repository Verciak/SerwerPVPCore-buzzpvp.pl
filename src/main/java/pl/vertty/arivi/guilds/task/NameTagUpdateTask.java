// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.task;

import pl.vertty.arivi.guilds.managers.guild.NameTagManager;
import cn.nukkit.scheduler.NukkitRunnable;

public class NameTagUpdateTask extends NukkitRunnable
{
    public void run() {
        NameTagManager.refresh();
    }
}
