// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.task;

import pl.vertty.arivi.guilds.data.Combat;
import java.util.Iterator;
import cn.nukkit.level.Level;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.DataUtil;
import pl.vertty.arivi.guilds.managers.CombatManager;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.scheduler.NukkitRunnable;

public class CombatTask extends NukkitRunnable
{
    public void run() {
        final Level l = Server.getInstance().getDefaultLevel();
        l.setTime(100);
        for (final Player p2 : Server.getInstance().getOnlinePlayers().values()) {
            final Combat u = CombatManager.getCombat(p2);
            final int seconds = (int)((u.getLastAttactTime() - System.currentTimeMillis()) / 1000L);
            if (u == null) {
                continue;
            }
            if (u.hasFight()) {
                ChatUtil.sendActionBar(p2, "&cJestes podczas walki jeszcze przez &6" + (DataUtil.secondsToString(u.getLastAttactTime()).isEmpty() ? "0 &csekund" : (DataUtil.secondsToString(u.getLastAttactTime()) + " &csekund")));
            }
            else {
                if (!u.wasFight()) {
                    continue;
                }
                if (u.hasFight()) {
                    continue;
                }
                ChatUtil.sendActionBar(p2, "&aMozesz sie wylogowac!");
                u.setLastAttactkPlayer(null);
                u.setLastAsystPlayer(null);
            }
        }
    }
}
