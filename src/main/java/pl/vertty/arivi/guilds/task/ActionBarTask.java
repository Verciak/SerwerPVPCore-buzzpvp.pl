// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.task;

import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.utils.DataUtil;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.Main;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.scheduler.NukkitRunnable;

public class ActionBarTask extends NukkitRunnable
{
    public void run() {
        for (final Player player : Server.getInstance().getOnlinePlayers().values()) {
            if (!player.isOnline()) {
                return;
            }
            String s = "";
            final cn.nukkit.utils.Config c = Main.getPlugin().getConfig();
            final User userr = UserManager.getUser(player);
            final Combat combat = CombatManager.getCombat(player);
            final User user = UserManager.getUser(player);
            if (combat != null && combat.wasFight() && !combat.hasFight()) {
                player.sendMessage(pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(Config.ANTYLOGAUT_END));
                combat.setLastAttactkPlayer(null);
                combat.setLastAttactTime(0L);
            }
            if (s.equals("")) {
                return;
            }
            pl.vertty.arivi.guilds.utils.ChatUtil.sendActionbar(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(s));
        }
    }
}
