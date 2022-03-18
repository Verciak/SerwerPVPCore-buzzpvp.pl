// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.listeners;

import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.utils.TimeUtil;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.Player;
import cn.nukkit.event.Listener;

public class EntityDamageByEntityListener implements Listener
{


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof Player) {
            final Player i = (Player) e.getDamager();
            if (e.isCancelled()) {
                return;
            }
            if (!(e.getEntity() instanceof Player)) {
                return;
            }
            Player d = (Player) e.getDamager();
            if (d == null) {
                return;
            }
            Player p = (Player) e.getEntity();
            if (p.equals(d)) {
                return;
            }
            Combat u = CombatManager.getCombat(p);
            Combat du = CombatManager.getCombat(d);
            if (u == null) {
                CombatManager.createCombat(p);
                return;
            }
            if (!u.hasFight()) {
                ChatUtil.sendMessage((CommandSender) p, "&8>> &4Zostales zaatakowany nie mozesz wylogowac sie przez 15 sekund!");
            }
            u.setLastAttactTime(System.currentTimeMillis() + TimeUtil.SECOND.getTime(15));
            du.setLastAttactTime(System.currentTimeMillis() + TimeUtil.SECOND.getTime(15));
            u.setLastAttactkPlayer(d);
        }
    }
}
