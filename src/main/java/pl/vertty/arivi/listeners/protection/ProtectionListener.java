// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.protection;

import cn.nukkit.entity.Entity;
import cn.nukkit.utils.Config;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.DataUtil;
import pl.vertty.arivi.Main;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.Listener;

public class ProtectionListener implements Listener
{
    @EventHandler
    public void onDamageFall(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final User u = UserManager.getUser(p);
            if (u.getOchrona() > System.currentTimeMillis() && e.getCause().equals((Object)EntityDamageEvent.DamageCause.FALL)) {
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(final EntityDamageByEntityEvent e) {
        if (e.isCancelled()) {
            return;
        }
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player d = getDamager(e);
        if (d == null) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (p.equals((Object)d)) {
            return;
        }
        if (this.ochronaD(d, e)) {
            return;
        }
        if (this.ochrona(p, d, e)) {
            return;
        }
    }
    
    private boolean ochronaD(final Player d, final EntityDamageByEntityEvent e) {
        final User u = UserManager.getUser(d);
        if (u.getOchrona() > System.currentTimeMillis()) {
            e.setCancelled(true);
            return true;
        }
        return false;
    }
    
    private boolean ochrona(final Player p, final Player d, final EntityDamageByEntityEvent e) {
        final User u = UserManager.getUser(p);
        final Config c = Main.getPlugin().getConfig();
        if (u.getOchrona() > System.currentTimeMillis()) {
            e.setCancelled(true);
            ChatUtil.sendMessage((CommandSender)d, c.getString("protection.have-player").replace("{NAME}", p.getName()).replace("{TIME}", DataUtil.secondsToString(u.getOchrona()).isEmpty() ? "1s" : DataUtil.secondsToString(u.getOchrona())));
            return true;
        }
        return false;
    }
    
    public static Player getDamager(final EntityDamageByEntityEvent e) {
        final Entity damager = e.getDamager();
        if (damager instanceof Player) {
            return (Player)damager;
        }
        return null;
    }
}
