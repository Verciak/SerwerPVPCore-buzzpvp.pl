package pl.vertty.arivi.listeners.reach;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.entity.item.EntityFishingHook;
import cn.nukkit.entity.projectile.EntityArrow;
import cn.nukkit.entity.projectile.EntitySnowball;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.level.Location;
import pl.vertty.arivi.Cooldown;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.utils.guild.ChatUtil;

public class ReachListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            if(e.getDamager() instanceof EntitySnowball){
                return;
            }
            if(e.getDamager() instanceof EntityFishingHook){
                return;
            }
            if(e.getDamager() instanceof EntityArrow){
                return;
            }
            if(e.getEntity() instanceof EntitySnowball){
                return;
            }
            if(e.getEntity() instanceof EntityFishingHook){
                return;
            }
            if(e.getEntity() instanceof EntityArrow){
                return;
            }
            Location l1 = e.getEntity().getLocation();
            Location l2 = e.getDamager().getLocation();
            if (l1.distance(l2) > 4.5D) {
                for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                    User u = UserManager.getUser(po);
                    if (u.can(GroupType.HELPER)) {
                        if (!Cooldown.getInstance().has(po, "REACH2")) {
                            ChatUtil.sendMessage(po, "&9AC &8> &7Gracz &3" + e.getDamager().getName() + " &7posiada &3REACH! &8(&f20%&8) | &8(&f"+((Player) e.getDamager()).getPing()+"ms&8)!");
                            Cooldown.getInstance().add(po, "REACH2", 5f);
                        }
                    }
                }
            }
            if (l1.distance(l2) > 5.0D) {
                for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                    User u = UserManager.getUser(po);
                    if (u.can(GroupType.HELPER)) {
                        if (!Cooldown.getInstance().has(po, "REACH3")) {
                            ChatUtil.sendMessage(po, "&9AC &8> &7Gracz &3" + e.getDamager().getName() + " &7posiada &3REACH! &8(&f40%&8) | &8(&f"+((Player) e.getDamager()).getPing()+"ms&8)!");
                            Cooldown.getInstance().add(po, "REACH3", 5f);
                        }
                    }
                }
            }
            if (l1.distance(l2) > 6.0D) {
                for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                    User u = UserManager.getUser(po);
                    if (u.can(GroupType.HELPER)) {
                        if (!Cooldown.getInstance().has(po, "REACH4")) {
                            ChatUtil.sendMessage(po, "&9AC &8> &7Gracz &3" + e.getDamager().getName() + " &7posiada &3REACH! &8(&f60%&8) | &8(&f"+((Player) e.getDamager()).getPing()+"ms&8)!");
                            Cooldown.getInstance().add(po, "REACH4", 5f);
                        }
                    }
                }
            }
            if (l1.distance(l2) > 7.0D) {
                for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                    User u = UserManager.getUser(po);
                    if (u.can(GroupType.HELPER)) {
                        if (!Cooldown.getInstance().has(po, "REACH5")) {
                            ChatUtil.sendMessage(po, "&9AC &8> &7Gracz &3" + e.getDamager().getName() + " &7posiada &3REACH! &8(&f80%&8) | &8(&f"+((Player) e.getDamager()).getPing()+"ms&8)!");
                            Cooldown.getInstance().add(po, "REACH5", 5f);
                        }
                    }
                }
            }
            if (l1.distance(l2) > 7.5D) {
                for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                    User u = UserManager.getUser(po);
                    if (u.can(GroupType.HELPER)) {
                        if (!Cooldown.getInstance().has(po, "REACH6")) {
                            ChatUtil.sendMessage(po, "&9AC &8> &7Gracz &3" + e.getDamager().getName() + " &7posiada &3REACH! &8(&f100%&8) | &8(&f"+((Player) e.getDamager()).getPing()+"ms&8)!");
                            Cooldown.getInstance().add(po, "REACH6", 5f);
                        }
                    }
                }
            }
        }
    }

}
