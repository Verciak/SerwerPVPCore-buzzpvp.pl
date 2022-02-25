
package pl.vertty.arivi.listeners.guild;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.player.PlayerRespawnEvent;
import cn.nukkit.item.Item;
import cn.nukkit.potion.Effect;
import pl.vertty.arivi.drop.utils.Util;
import pl.vertty.arivi.objects.Combat;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.managers.CombatManager;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.managers.BackupManager;
import pl.vertty.arivi.objects.BossBar;
import pl.vertty.arivi.utils.DeathUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerDeathListener implements Listener {


    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        Combat pC = CombatManager.getCombat(p);
        pC.setLastAttactTime(1L);
        pC.setLastAttactTime(0L);
        pC.setLastAttactkPlayer(null);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void onDamagee(EntityDamageEvent e) {
        if (e.getDamage() < 0.0D) {
            return;
        }
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player) e.getEntity();
        final User user = UserManager.getUser(p.getName());
        final Guild g = GuildManager.getGuild(p);
        final Combat combat = CombatManager.getCombat(p);

        if (p.getHealth() - e.getFinalDamage() < 1.0F) {
            Entity k = null;
            Player kill = CombatManager.getCombat(p).getLastAttactkPlayer();
            Combat pK = null;

            switch (e.getCause()) {
                case ENTITY_ATTACK:
                case FALL:
                case FIRE:
                case FIRE_TICK:
                case LAVA:
                case PROJECTILE:
                    if (e instanceof EntityDamageByEntityEvent) {
                        Entity ent = ((EntityDamageByEntityEvent) e).getDamager();
                        if (ent instanceof Player) {
                            k = ent;
                            break;
                        }
                        if (CombatManager.getCombat(p).getLastAttactkPlayer() != null) {
                            Player pp = Server.getInstance().getPlayer(CombatManager.getCombat(p).getLastAttactkPlayer().getName());
                            if (pp != null)
                                kill = pp;
                            pK = CombatManager.getCombat(pp);
                        }
                    }
                    break;
                default:
                    User u = UserManager.getUser(p.getName());
                    if (u != null && CombatManager.getCombat(p).getLastAttactkPlayer() != null) {
                        Player pp = Server.getInstance().getPlayerExact(CombatManager.getCombat(p).getLastAttactkPlayer().getName());
                        if (pp != null)
                            kill = pp;
                    }
                    break;
            }


            p.setHealth(p.getMaxHealth());
            p.getFoodData().setLevel(p.getFoodData().getMaxLevel());
            p.removeAllEffects();
            p.extinguish();
            List<Item> drops = new ArrayList<>();
            if (p.getCursorInventory() != null) {
                Item cursor = p.getCursorInventory().getItem(0);
                if (!cursor.isNull())
                    drops.add(cursor);
            }
            drops.addAll(Arrays.asList(p.getDrops()));

            if (kill != null) {
                for (Item i : drops) {
                    Util.giveItemOnDeath(kill, kill, i);
                }
            } else {
                for (Item item : drops)
                    p.getLevel().dropItem(p, item, null, false, 30);
            }


            if (user != null) {
                if (k == null && (combat == null || !combat.hasFight())) {
                    user.setDeaths(user.getDeaths() + 1);
                    BackupManager.createBackup(p.getName(), "COS", p.getPing(), p.getInventory(), 0);
                    p.getInventory().clearAll();
                    p.getCursorInventory().clearAll();
                    p.setExperience(0, 0);
                    e.getEntity().teleport(Server.getInstance().getDefaultLevel().getSpawnLocation());
                    e.setCancelled(true);
                    for (Player pxd : Server.getInstance().getOnlinePlayers().values()) {
                        pxd.sendMessage(ChatUtil.fixColor("&7Gracz &3" + p.getName() + " &7popelnil samobojstwo!"));
                    }
                } else {
                    if (k == null) {
                        k = CombatManager.getCombat(p).getLastAttactkPlayer();
                    }
                    final User kuser = UserManager.getUser(k.getName());
                    final Guild kg = GuildManager.getGuild(k);
                    if (kuser != null) {
                        int add = (int) (45.0 + (kuser.getPoints() - user.getPoints()) * -0.2);
                        if (add < 3) {
                            add = 3;
                        }
                        if (add > 250) {
                            add = 250;
                        }
                        int remove = add / 6 * 4;
                        if (remove < 1) {
                            remove = 1;
                        }
                        if (remove > 150) {
                            remove = 150;
                        }
                        if (kg != null) {
                            kg.setKills(kg.getKills() + 1);
                        }
                        if (g != null) {
                            g.setDeaths(g.getDeaths() + 1);
                        }
                        user.setDeaths(user.getDeaths() + 1);
                        user.setPoints(user.getPoints() - remove);
                        kuser.setKills(kuser.getKills() + 1);
                        kuser.setPoints(kuser.getPoints() + add);


                        BackupManager.createBackup(p.getName(), k.getName(), p.getPing(), p.getInventory(), remove);
                        p.getInventory().clearAll();
                        p.getCursorInventory().clearAll();
                        p.setExperience(0, 0);
                        e.getEntity().teleport(Server.getInstance().getDefaultLevel().getSpawnLocation());
                        e.setCancelled(true);
                        if (kuser != null) {
                            kuser.getPlayer().addEffect(Effect.getEffect(12).setDuration(200).setAmplifier(0).setVisible(true));
                        }
                        Combat pvp = CombatManager.getCombat(p);
                        if (pvp != null || !pvp.hasFight()) {
                            pvp.setLastAttactTime(0);
                        }

                        for (Player po2 : Server.getInstance().getOnlinePlayers().values()) {
                            ChatUtil.sendMessage(po2, DeathUtil.deathsMessage(add, remove, p, (Player) k));
                        }
                        if (BossBar.playerHasBossBar(p)) {
                            BossBar.removeBossBar(p);
                        }
                    }
                }
            }
        }
    }

}
