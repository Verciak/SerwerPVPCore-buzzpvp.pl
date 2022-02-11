
package pl.vertty.arivi.guilds.task;

import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.guilds.managers.guild.NameTagManager;

public class NameTagUpdateTask extends NukkitRunnable
{
    public void run() {
        NameTagManager.refresh();
    }
}
