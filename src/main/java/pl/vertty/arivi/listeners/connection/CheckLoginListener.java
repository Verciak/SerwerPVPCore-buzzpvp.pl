// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.connection;

import pl.vertty.arivi.Main;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.data.User;
import java.util.Iterator;
import pl.vertty.arivi.objects.Ban;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.DataUtil;
import pl.vertty.arivi.managers.BanManager;
import cn.nukkit.event.player.PlayerLoginEvent;
import cn.nukkit.utils.Config;
import cn.nukkit.event.Listener;

public class CheckLoginListener implements Listener
{
    public static Config c;
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onLogin(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        final Ban ban = BanManager.getBan(p);
        if (ban != null) {
            if (ban.getTime() != 0L && ban.getTime() <= System.currentTimeMillis()) {
                BanManager.unban(ban);
                return;
            }
            final String reason = "\n&4Zostales zbanowany przez &c" + ban.getAdmin() + "\n&4Powod: &c" + ban.getReason() + "\n&4Wygasa: &c" + ((ban.getTime() == 0L) ? "Nigdy!" : ("&4za &c" + DataUtil.secondsToString(ban.getTime())));
            e.setKickMessage(ChatUtil.fixColor(reason));
            e.setCancelled(true);
        }
    }
    
    static {
        CheckLoginListener.c = Main.getPlugin().getConfig();
    }
}
