
package pl.vertty.arivi.listeners.connection;

import pl.vertty.arivi.Main;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.objects.Ban;
import cn.nukkit.Player;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.DataUtil;
import pl.vertty.arivi.managers.BanManager;
import cn.nukkit.event.player.PlayerLoginEvent;
import cn.nukkit.utils.Config;
import cn.nukkit.event.Listener;

public class CheckLoginListener implements Listener
{
    public static Config c = Main.getPlugin().getConfig();
    
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

}
