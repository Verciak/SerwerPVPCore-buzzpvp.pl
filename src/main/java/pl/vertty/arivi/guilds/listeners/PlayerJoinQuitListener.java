// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.listeners;

import cn.nukkit.event.player.PlayerLoginEvent;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.event.player.PlayerKickEvent;
import pl.vertty.arivi.guilds.managers.guild.NameTagManager;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.Listener;

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
        final User usa = UserManager.getUser(player);
        User.skarbiec_eme = false;
        User.skarbiec_head = false;
        User.update_name = false;
        User.war_create = false;
        User.war_stop = false;
        Combat combat = CombatManager.getCombat(player);
        if (combat == null)
            CombatManager.createCombat(player);
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void PlayerJoinTag(final PlayerJoinEvent playerJoinEvent) {
        lambdaPlayerJoinTag0(playerJoinEvent.getPlayer());
    }
    
    @EventHandler
    public void onQuit(final PlayerQuitEvent playerQuitEvent) {
        playerQuitEvent.setQuitMessage("");
        final Player player = playerQuitEvent.getPlayer();
        quitGame(player);
    }
    
    public static void lambdaPlayerJoinTag0(final Player player) {
        NameTagManager.refreshAllNameTag();
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
        final Guild guild = GuildManager.getGuild(player);
        final User user2 = UserManager.getUser(CombatManager.getCombat(player).getLastAttactkPlayer());
        if (user2.getPoints() >= 1700) {
            user2.setPoints(1000);
            final User prestiz = UserManager.getUser(user2.getPlayer());
            prestiz.setPresiz(prestiz.getPresiz() + 1);
        }
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.ANTYLOGAUT_LOGAUT.replace("{NICK}", player.getName()).replace("{TAG}", (guild == null) ? "" : String.valueOf(new StringBuilder().append("&8[&c").append(guild.getTag()).append("&8] "))).replace("{PKT}", "25")));
    }
}