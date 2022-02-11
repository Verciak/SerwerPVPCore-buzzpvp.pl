
package pl.vertty.arivi.loader;

import pl.vertty.arivi.managers.VanishManager;
import cn.nukkit.Server;
import pl.vertty.arivi.task.ItemsClearTask;
import pl.vertty.arivi.task.LimitTask;
import pl.vertty.arivi.task.AutoMessageTask;
import pl.vertty.arivi.task.CombatTask;
import pl.vertty.arivi.guilds.task.ActionBarTask;
import pl.vertty.arivi.guilds.utils.TimeUtil;
import pl.vertty.arivi.guilds.task.AutoSaveTask;
import pl.vertty.arivi.guilds.task.CheckValidityTask;
import cn.nukkit.plugin.Plugin;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.task.NameTagUpdateTask;

public class TaskLoader
{
    public static void onTaskLoad() {
        new NameTagUpdateTask().runTaskTimer(Main.getPlugin(), 1000, 1000);
        new CheckValidityTask().runTaskTimer(Main.getPlugin(), 2400, 2400);
        new AutoSaveTask().runTaskTimer(Main.getPlugin(), TimeUtil.MINUTE.getTick(5), TimeUtil.MINUTE.getTick(5));
        new ActionBarTask().runTaskTimerAsynchronously(Main.getPlugin(), 40, 20);
        new CombatTask().runTaskTimer(Main.getPlugin(), 40, 20);
        new AutoMessageTask().runTaskTimer(Main.getPlugin(), 600, 600);
        new LimitTask().runTaskTimer(Main.getPlugin(), 100, 200);
        new ItemsClearTask().runTaskTimer(Main.getPlugin(), 20, 2400);
    }
}
