// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.osiagniecia;

import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.event.player.PlayerItemConsumeEvent;
import cn.nukkit.event.Listener;

public class OsiagnieciaListener implements Listener
{
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onPlayerItemConsume(final PlayerItemConsumeEvent e) {
        final Player p = e.getPlayer();
        final User u = UserManager.getUser(p);
        if (e.getItem().getId() == 322) {
            u.setrefil(u.getrefil() + 1);
        }
        if (e.getItem().getId() == 466) {
            u.setkox(u.getkox() + 1);
        }
    }
}
