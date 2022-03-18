package pl.vertty.arivi.listeners.reach;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.item.EntityFishingHook;
import cn.nukkit.entity.projectile.EntityArrow;
import cn.nukkit.entity.projectile.EntitySnowball;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByChildEntityEvent;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.inventory.transaction.data.UseItemOnEntityData;
import cn.nukkit.item.ItemID;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;
import cn.nukkit.network.protocol.InventoryTransactionPacket;
import pl.vertty.arivi.Cooldown;
import pl.vertty.arivi.commands.helper.ACCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;

public class ReachListener implements Listener {


    @EventHandler
    public void onEntityDamageByChildEntity(EntityDamageByChildEntityEvent e) {
        if (e.isCancelled()) {
            return;
        }
        Entity projectile = e.getChild();
        if (projectile instanceof cn.nukkit.entity.projectile.EntityArrow || projectile instanceof cn.nukkit.entity.projectile.EntitySnowball) {
            Entity damager = e.getDamager();
            Entity player = e.getEntity();
            if (damager instanceof Player && player instanceof Player && !damager.equals(player) &&
                    !Cooldown.getInstance().has(player.getName(), "arrowhp")) {
                float health = (player.getHealth() + player.getAbsorption()) / 2.0F;
                ChatUtil.sendMessage((CommandSender)damager, "&7Gracz &3{P} &7posiada &3{HP}!".replace("{HP}", String.valueOf(health)).replace("{P}", player.getName()));
                Cooldown.getInstance().add(player.getName(), "arrowhp", Float.valueOf(1.0F));
            }
        }
    }


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            if(e.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)){
                return;
            }
            Location l1 = e.getEntity().getLocation();
            Location l2 = e.getDamager().getLocation();
            if(!ACCommand.status) {
                if (l1.distance((Vector3) l2) > 4.5D) {

                    for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                        User u = UserManager.getUser(po);
                        if (u.can(GroupType.HELPER)) {
                            if (!Cooldown.getInstance().has(po, "REACH2")) {
                                ChatUtil.sendMessage((CommandSender) po, "&9AC &8> &7Gracz &3" + ((Player) e.getDamager()).getName() + " &7posiada &3REACH! &8(&f20%&8) | &8(&f" + ((Player) e.getDamager()).getPing() + "ms&8)!");
                                Cooldown.getInstance().add(po, "REACH2", 5f);
                            }
                        }
                    }
                }
            }
            if(!ACCommand.status) {
                if (l1.distance((Vector3) l2) > 5.0D) {
                    for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                        User u = UserManager.getUser(po);
                        if (u.can(GroupType.HELPER)) {
                            if (!Cooldown.getInstance().has(po, "REACH3")) {
                                ChatUtil.sendMessage((CommandSender) po, "&9AC &8> &7Gracz &3" + ((Player) e.getDamager()).getName() + " &7posiada &3REACH! &8(&f40%&8) | &8(&f" + ((Player) e.getDamager()).getPing() + "ms&8)!");
                                Cooldown.getInstance().add(po, "REACH3", 5f);
                            }
                        }
                    }
                }
            }
            if(!ACCommand.status) {
                if (l1.distance((Vector3) l2) > 6.0D) {
                    for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                        User u = UserManager.getUser(po);
                        if (u.can(GroupType.HELPER)) {
                            if (!Cooldown.getInstance().has(po, "REACH4")) {
                                ChatUtil.sendMessage((CommandSender) po, "&9AC &8> &7Gracz &3" + ((Player) e.getDamager()).getName() + " &7posiada &3REACH! &8(&f60%&8) | &8(&f" + ((Player) e.getDamager()).getPing() + "ms&8)!");
                                Cooldown.getInstance().add(po, "REACH4", 5f);
                            }
                        }
                    }
                }
            }
            if(!ACCommand.status) {
                if (l1.distance((Vector3) l2) > 7.0D) {
                    for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                        User u = UserManager.getUser(po);
                        if (u.can(GroupType.HELPER)) {
                            if (!Cooldown.getInstance().has(po, "REACH5")) {
                                ChatUtil.sendMessage((CommandSender) po, "&9AC &8> &7Gracz &3" + ((Player) e.getDamager()).getName() + " &7posiada &3REACH! &8(&f80%&8) | &8(&f" + ((Player) e.getDamager()).getPing() + "ms&8)!");
                                Cooldown.getInstance().add(po, "REACH5", 5f);
                            }
                        }
                    }
                }
            }
            if(!ACCommand.status) {
                if (l1.distance((Vector3) l2) > 7.5D) {
                    for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                        User u = UserManager.getUser(po);
                        if (u.can(GroupType.HELPER)) {
                            if (!Cooldown.getInstance().has(po, "REACH6")) {
                                ChatUtil.sendMessage((CommandSender) po, "&9AC &8> &7Gracz &3" + ((Player) e.getDamager()).getName() + " &7posiada &3REACH! &8(&f100%&8) | &8(&f" + ((Player) e.getDamager()).getPing() + "ms&8)!");
                                Cooldown.getInstance().add(po, "REACH6", 5f);
                            }
                        }
                    }
                }
            }
        }
    }

}
