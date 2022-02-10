// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.listeners;

import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerRespawnEvent;
import cn.nukkit.inventory.PlayerInventory;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.enums.TimeUtil;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.rank.RankingManager;
import pl.vertty.arivi.guilds.data.Combat;
import cn.nukkit.potion.Effect;
import pl.vertty.arivi.guilds.utils.RandomUtil;
import pl.vertty.arivi.utils.DeathUtil;
import pl.vertty.arivi.utils.ItemUtil;
import cn.nukkit.Player;
import pl.vertty.arivi.managers.BackupManager;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.math.Vector3;
import cn.nukkit.item.Item;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import cn.nukkit.event.entity.EntityDamageEvent;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.event.player.PlayerDeathEvent;
import java.util.HashMap;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.utils.Coooldown;
import cn.nukkit.entity.data.Skin;
import java.util.Map;
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

    @EventHandler
    public void onDeaths(PlayerDeathEvent e) {
        e.setDeathMessage("");
        Player p = e.getEntity();
        Combat pC = CombatManager.getCombat(p);
        User user = UserManager.getUser(p);
        final PlayerInventory playerInventory = p.getInventory();
        switch (p.getLastDamageCause().getCause()) {
            case LAVA:
                user.setDeaths(user.getDeaths() + 1);
                e.getEntity().getInventory().clearAll();
                e.setDeathMessage(ChatUtil.fixColor("&7Gracz &c" + p.getName() + " &7probowal plywac w lawie!"));
                BackupManager.createBackup(p.getName(), "LAVA", p.getPing(), playerInventory, 0);
            case DROWNING:
                user.setDeaths(user.getDeaths() + 1);
                e.getEntity().getInventory().clearAll();
                e.setDeathMessage(ChatUtil.fixColor("&7Gracz &c" + p.getName() + " &7utopil sie!"));
                BackupManager.createBackup(p.getName(), "UTOPIL SIE", p.getPing(), playerInventory, 0);
            case SUICIDE:
                user.setDeaths(user.getDeaths() + 1);
                e.getEntity().getInventory().clearAll();
                e.setDeathMessage(ChatUtil.fixColor("&7Gracz &c" + p.getName() + " &7postanowil popelnic samobojstwo!"));
                BackupManager.createBackup(p.getName(), "STRZELIL SOBIE W KOLANO", p.getPing(), playerInventory, 0);
            case FALL:
                user.setDeaths(user.getDeaths() + 1);
                e.getEntity().getInventory().clearAll();
                e.setDeathMessage(ChatUtil.fixColor("&7Gracz &c" + p.getName() + " &7nie potrafi latac!"));
                BackupManager.createBackup(p.getName(), "NIE MIAL SKRZYDEL", p.getPing(), playerInventory, 0);
                break;
        }
        if(p.getKiller() instanceof Player) {
            Player k = (Player) p.getKiller();
            if (k == null && pC != null && pC.wasFight())
                k = pC.getLastAttactkPlayer();
            if (k != null) {
                User kUser = UserManager.getUser(k);
                if (kUser == null)
                    return;
                if (p.equals(k))
                    return;
                if (DeathUtil.isLastKill(kUser, p)) {
                    ChatUtil.sendMessage((CommandSender) k, "&cZabiles tego samego gracza w ciagu 10m");
                    if (DeathUtil.isAsyst(pC)) {
                        assyst(pC, user);
                    }
                    for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                        User u = UserManager.getUser(po);
                        ChatUtil.sendMessage((CommandSender) po, DeathUtil.deathsMessage(0, 0, p, k));
                    }
                } else {
                    int add = (int) (94.0D + (kUser.getPoints() - ((user != null) ? user.getPoints() : 0)) * -0.25D);
                    if (add <= 0) {
                        add = RandomUtil.getRandInt(8, 15);
                    }
                    int remove = add / 4 * 3;
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
                    BackupManager.createBackup(p.getName(), k.getName(), p.getPing(), playerInventory, remove);

                    for (Player po2 : Server.getInstance().getOnlinePlayers().values()) {
                        User u2 = UserManager.getUser(po2);
                        ChatUtil.sendMessage((CommandSender) po2, DeathUtil.deathsMessage(add, remove, p, k));
                    }
                    if (DeathUtil.isAsyst(pC))
                        assyst(pC, user);
                    Guild g = GuildManager.getGuild(k);
                    if (g != null) {
                        g.addPoints(GuildManager.addPoints(k, p));
                        g.addKills(1);
                    }
                    Guild o = GuildManager.getGuild(p);
                    if (o != null) {
                        o.removePoints(GuildManager.removePoints(p, k));
                        o.addDeaths(1);
                    }
                    RankingManager.sortGuildRankings();
                }
            } else if (user != null) {
                user.setPoints(user.getPoints() - 5);
            }
            if (user != null) {
                user.setDeaths(user.getDeaths() + 1);
            }
            if (k instanceof Player) {
                ItemUtil.giveItems(k, e.getDrops());
            }
            e.setDrops(new Item[]{});

            DeathUtil.remove(pC);
            e.setDeathMessage("");
            RankingManager.sortGuildRankings();
            RankingManager.sortUserRankings();

            Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), new Runnable() {
                public void run() {
                    if (e.getEntity() instanceof Player) {
                        e.getEntity().getInventory().clearAll();
                        e.getEntity().teleport(new Vector3(0, 80, 0));
                    }
                }
            }, 15);
        }
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
