
package pl.vertty.arivi.listeners.guild;

import cn.nukkit.event.player.PlayerLoginEvent;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.objects.Combat;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import cn.nukkit.Server;
import pl.vertty.arivi.managers.guild.GuildManager;
import cn.nukkit.event.player.PlayerKickEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.Player;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.CombatManager;
import pl.vertty.arivi.managers.UserManager;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.Listener;
import pl.vertty.arivi.objects.BossBar;

public class PlayerJoinQuitListener implements Listener
{

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        if (BossBar.playerHasBossBar(event.getPlayer())) {
            BossBar.removeBossBar(event.getPlayer());
        }
    }


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
        User.war_create = false;
        User.war_stop = false;
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
        final Guild guild = GuildManager.getGuild(player);
        final User user2 = UserManager.getUser(CombatManager.getCombat(player).getLastAttactkPlayer());
        Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.ANTYLOGAUT_LOGAUT.replace("{NICK}", player.getName()).replace("{TAG}", (guild == null) ? "" : String.valueOf(new StringBuilder().append("&8[&c").append(guild.getTag()).append("&8] "))).replace("{PKT}", "25")));
    }
}
