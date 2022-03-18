// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.listeners;

import cn.nukkit.command.CommandSender;
import cn.nukkit.event.player.PlayerLoginEvent;
import cn.nukkit.potion.Effect;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.enums.TimeUtil;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.rank.RankingManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Server;
import cn.nukkit.event.player.PlayerKickEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.Listener;
import pl.vertty.arivi.guilds.utils.RandomUtil;
import pl.vertty.arivi.utils.DeathUtil;

public class PlayerJoinQuitListener implements Listener
{

    @EventHandler
    public void onCreate(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        User u = UserManager.getUser(p);
        if (u == null)
            UserManager.createrUser(p);
        Combat combat = CombatManager.getCombat(p);
        if (combat == null)
            CombatManager.createCombat(p);
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent playerJoinEvent) {
        playerJoinEvent.setJoinMessage("");
        final Player player = playerJoinEvent.getPlayer();
        if (UserManager.getUser(player) == null) {
            UserManager.createrUser(player);
        }
        if (CombatManager.getCombat(player) == null) {
            CombatManager.createCombat(player);
        }
        Combat combat = CombatManager.getCombat(player);
        if (combat == null)
            CombatManager.createCombat(player);
    }

    @EventHandler
    public void onQuit(final PlayerQuitEvent playerQuitEvent) {
        playerQuitEvent.setQuitMessage("");
        final Player player = playerQuitEvent.getPlayer();
        quitGame(player);
    }

    
    @EventHandler
    public void onKick(final PlayerKickEvent playerKickEvent) {
        playerKickEvent.setQuitMessage("");
        quitGame(playerKickEvent.getPlayer());
    }
    
    public static void quitGame(final Player player) {
        if (!player.getServer().isRunning()) {
            return;
        }
        final User user = UserManager.getUser(player);
        if (user == null) {
            return;
        }
        final Combat combat = CombatManager.getCombat(player);
        if (combat == null) {
            return;
        }
        if (!CombatManager.getCombat(player).hasFight()) {
            return;
        }
        player.setHealth(0.0f);
        final User kUser = UserManager.getUser(CombatManager.getCombat(player).getLastAttactkPlayer());

        if (DeathUtil.isLastKill(kUser, player) == false){
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

        if (DeathUtil.isLastKill(kUser, player)) {
            ChatUtil.sendMessage((CommandSender) kUser.getPlayer(), "&cZabiles tego samego gracza w ciagu 10m");
            for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendMessage((CommandSender) po, DeathUtil.deathsMessage(0, 0, player, kUser.getPlayer()));
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
            kUser.setLastKill(player.getName());
            kUser.setPoints(kUser.getPoints() + add);
            kUser.setKills(kUser.getKills() + 1);
            user.setDeaths(user.getDeaths() + 1);
            if (kUser != null) {
                kUser.getPlayer().addEffect(Effect.getEffect(12).setDuration(200).setAmplifier(0).setVisible(true));
            }
            for (Player po2 : Server.getInstance().getOnlinePlayers().values()) {
                User u2 = UserManager.getUser(po2);
                ChatUtil.sendMessage((CommandSender) po2, DeathUtil.deathsMessage(add, remove, player, kUser.getPlayer()));
            }
        }
        CombatManager.getCombat(kUser.getPlayer()).setLastAttactTime(0);
        RankingManager.sortUserRankings();

        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.ANTYLOGAUT_LOGAUT.replace("{NICK}", player.getName()).replace("{PKT}", "25")));
    }
}
