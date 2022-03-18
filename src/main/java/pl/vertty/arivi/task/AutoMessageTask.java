// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.task;

import cn.nukkit.level.Level;
import cn.nukkit.scheduler.Task;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.data.User;
import java.util.Iterator;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.utils.Config;
import cn.nukkit.scheduler.NukkitRunnable;

public class AutoMessageTask extends NukkitRunnable
{
    int index;
    public static Config c;
    
    public AutoMessageTask() {
        this.index = 0;
    }
    
    public void run() {
        for (Level level : Server.getInstance().getLevels().values()) {
            level.setRaining(false);
            level.setThundering(false);
            level.setRainTime(240000);
            level.setThunderTime(240000);
            Server.getInstance().getScheduler().scheduleDelayedTask(new Task() {
                public void onRun(int arg0) {
                    level.sendWeather(Server.getInstance().getOnlinePlayers().values());
                }
            },  40);
        }


        if (AutoMessageTask.c.getStringList("automsg").size() == 0) {
            return;
        }
        for (final Player p : Server.getInstance().getOnlinePlayers().values()) {
            final User u = UserManager.getUser(p);
            final Combat combat = CombatManager.getCombat(p);
            ChatUtil.sendMessage((CommandSender)p, AutoMessageTask.c.getStringList("automsg").get(this.index).toString());
            ++this.index;
            if (this.index >= AutoMessageTask.c.getStringList("automsg").size()) {
                this.index = 0;
            }
        }
    }
    
    static {
        AutoMessageTask.c = Main.getPlugin().getConfig();
    }
}
