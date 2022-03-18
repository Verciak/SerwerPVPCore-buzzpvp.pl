// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.listeners;

import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.player.PlayerRespawnEvent;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.level.Location;
import cn.nukkit.scheduler.Task;
import pl.vertty.arivi.Cooldown;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.enums.TimeUtil;
import pl.vertty.arivi.guilds.rank.RankingManager;
import pl.vertty.arivi.guilds.data.Combat;
import cn.nukkit.potion.Effect;
import pl.vertty.arivi.guilds.utils.RandomUtil;
import pl.vertty.arivi.utils.DeathUtil;
import pl.vertty.arivi.utils.ItemUtil;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.math.Vector3;
import cn.nukkit.item.Item;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.event.player.PlayerDeathEvent;

import java.util.*;

import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.utils.Coooldown;
import cn.nukkit.entity.data.Skin;

import cn.nukkit.event.Listener;

public class PlayerDeathListener implements Listener
{
    private Map<String, Skin> skins;
    private static final Coooldown<User> COOLDOWN;
    
    public PlayerDeathListener() {
        this.skins = new HashMap<String, Skin>();
    }
    
    public Map<String, Skin> getSkins() {
        return this.skins;
    }


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
        if (p.getHealth() - e.getFinalDamage() < 1.0F) {
            Combat pC = CombatManager.getCombat(p);
            pC.setLastAttactTime(0L);
            Entity killer;
            Player kill = CombatManager.getCombat(p).getLastAttactkPlayer();
            Combat pK ;

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
                            killer = ent;
                            break;
                        }
                        User user = UserManager.getUser(p.getName());
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
            e.getEntity().teleport(new Location(0, 107, 0, Server.getInstance().getDefaultLevel()));
            p.setHealth(p.getMaxHealth());
            p.getFoodData().setLevel(p.getFoodData().getMaxLevel());
            p.removeAllEffects();
            p.extinguish();
            p.getInventory().clearAll();
            p.getCursorInventory().clearAll();
            p.setExperience(0, 0);
            e.setCancelled(true);
            User kUser = UserManager.getUser(kill);
            User user = UserManager.getUser(p);
            user.setDeaths(user.getDeaths() + 1);
            CombatManager.getCombat(kill).setLastAttactTime(0L);

            if (DeathUtil.isLastKill(kUser, p) == false){
                user.removeCoins(3);
                ChatUtil.sendMessage(user.getPlayer(), "&cStraciles &43 monety&c!");
                if(kUser.can(GroupType.SPONSOR)){
                    kUser.addCoins(20);
                    ChatUtil.sendMessage(kUser.getPlayer(), "&7Otrzymales &320 monet &7za zabojstwo gracza!");
                }else if(kUser.can(GroupType.YOUTUBER)){
                    kUser.addCoins(10);
                    ChatUtil.sendMessage(kUser.getPlayer(), "&7Otrzymales &310 monet &7za zabojstwo gracza!");
                } else if(kUser.can(GroupType.SVIP)){
                    kUser.addCoins(15);
                    ChatUtil.sendMessage(kUser.getPlayer(), "&7Otrzymales &315 monet &7za zabojstwo gracza!");
                } else if(kUser.can(GroupType.VIP)){
                    kUser.addCoins(10);
                    ChatUtil.sendMessage(kUser.getPlayer(), "&7Otrzymales &310 monet &7za zabojstwo gracza!");
                } else if(kUser.can(GroupType.PLAYER)){
                    kUser.addCoins(5);
                    ChatUtil.sendMessage(kUser.getPlayer(), "&7Otrzymales &35 monet &7za zabojstwo gracza!");
                }
            }


            if (DeathUtil.isLastKill(kUser, p)) {
                ChatUtil.sendMessage((CommandSender) kill, "&cZabiles tego samego gracza w ciagu 10m");
                if (DeathUtil.isAsyst(pC)) {
                    assyst(pC, user);
                }
                for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                    ChatUtil.sendMessage((CommandSender) po, DeathUtil.deathsMessage(0, 0, p, kill));
                }
            } else {
                int add = (int) (45.0 + (kUser.getPoints() - user.getPoints()) * -0.2);
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
                if (user != null) {
                    user.setPoints(user.getPoints() - remove);
                }
                kUser.setLastKillTime(System.currentTimeMillis() + TimeUtil.MINUTE.getTime(10));
                kUser.setLastKill(p.getName());
                kUser.setPoints(kUser.getPoints() + add);
                kUser.setKills(kUser.getKills() + 1);
                if (kUser != null) {
                    kUser.getPlayer().addEffect(Effect.getEffect(12).setDuration(200).setAmplifier(0).setVisible(true));
                }
                for (Player po2 : Server.getInstance().getOnlinePlayers().values()) {
                    User u2 = UserManager.getUser(po2);
                    ChatUtil.sendMessage((CommandSender) po2, DeathUtil.deathsMessage(add, remove, p, kill));
                }
                if (DeathUtil.isAsyst(pC))
                    assyst(pC, user);
            }
            DeathUtil.remove(pC);
            RankingManager.sortUserRankings();
        }
    }






    @EventHandler
    public void onDeaths(PlayerDeathEvent e) {
        e.setDeathMessage("");
    }

    private void assyst(Combat pC, User pU) {
        User asysta = UserManager.getUser(pC.getLastAsystPlayer());
        int asyst = (int)((94.0D + (((asysta != null) ? asysta.getPoints() : 0) - pU.getPoints()) * -0.25D) / 3.0D);
        if (asysta == asysta)
            return;
        if (asyst <= -1)
            asyst = -1;
        if (asysta != null) {
            asysta.setPoints(asysta.getPoints() + asyst);
        }
        for (Player p : Server.getInstance().getOnlinePlayers().values()) {
            User u = UserManager.getUser(p);
            ChatUtil.sendMessage((CommandSender) p, DeathUtil.asystaMessage(asyst, pC.getLastAsystPlayer()));
        }
    }
    
    static {
        COOLDOWN = new Coooldown<User>();
    }

    //killer.addEffect(Effect.getEffect(12).setDuration(200).setAmplifier(0).setVisible(true));
    //final PlayerInventory playerInventory = entity.getInventory();
    //BackupManager.createBackup(entity.getName(), killer.getName(), entity.getPing(), playerInventory, i)
}
