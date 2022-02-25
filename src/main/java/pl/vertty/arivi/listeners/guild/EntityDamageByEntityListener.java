
package pl.vertty.arivi.listeners.guild;

import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import pl.vertty.arivi.objects.Combat;
import pl.vertty.arivi.utils.guild.TimeUtil;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.managers.CombatManager;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.managers.guild.GuildManager;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.Player;
import cn.nukkit.event.Listener;

public class EntityDamageByEntityListener implements Listener
{
    private boolean is(final Player player, final Player player2, final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        final Guild guild = GuildManager.getGuild(player);
        final Guild guild2 = GuildManager.getGuild(player2);
        if (guild == null || guild2 == null) {
            return false;
        }
        if (guild.equals(guild2)) {
            if (guild.isPvp()) {
                entityDamageByEntityEvent.setDamage(0.0f);
            }
            else {
                entityDamageByEntityEvent.setCancelled(true);
            }
            return true;
        }
        if (!guild.getAlly().contains(guild2.getTag())) {
            return false;
        }
        if (guild.isPvpAlly() && guild2.isPvpAlly()) {
            entityDamageByEntityEvent.setDamage(0.0f);
        }
        else {
            entityDamageByEntityEvent.setCancelled(true);
        }
        return true;
    }


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
            Player d = ChatUtil.getDamager(e);
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
            if (UserManager.getUser(p).getOchrona() != 0L) {
                return;
            }
            if (UserManager.getUser(d).getOchrona() != 0L) {
                return;
            }
            if (is(p, d, e)) {
                return;
            }
            if (!u.hasFight()) {
                ChatUtil.sendMessage((CommandSender) p, "&8>> &4Zostales zaatakowany nie mozesz wylogowac sie przez 30 sekund!");
            }
            u.setLastAttactTime(System.currentTimeMillis() + TimeUtil.SECOND.getTime(31));
            du.setLastAttactTime(System.currentTimeMillis() + TimeUtil.SECOND.getTime(31));
            u.setLastAttactkPlayer(d);
        }
    }
}
