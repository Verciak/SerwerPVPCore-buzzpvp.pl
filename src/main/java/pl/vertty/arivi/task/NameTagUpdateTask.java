
package pl.vertty.arivi.task;

import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.managers.guild.NameTagManager;

public class NameTagUpdateTask extends NukkitRunnable
{
    public void run() {
        NameTagManager.refresh();
    }
}
