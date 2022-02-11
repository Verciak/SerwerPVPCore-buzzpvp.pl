
package pl.vertty.arivi.guilds.listeners.region;

import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.utils.TimeUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.potion.Effect;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.utils.DataUtil;
import pl.vertty.arivi.utils.LevelUtil;
import pl.vertty.arivi.guilds.managers.CombatManager;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.Player;
import java.util.HashMap;
import cn.nukkit.event.Listener;

public class PlayerMoveListener implements Listener
{
    public static HashMap<Player, Long> enemysTo;
    public static HashMap<Player, Long> enemysFrom;
    
    @EventHandler
    public void onPlayerMoveEvent(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final Combat combat = CombatManager.getCombat(p);
        if (combat != null && combat.hasFight() && LevelUtil.isNonPvpArea(e.getTo())) {
            LevelUtil.knockLinePvP(p);
            p.sendMessage(ChatUtil.fixColor("&cPodczas pvp nie mozna wejsc na spawn!"));
        }
    }
    
    @EventHandler
    public void onMove(final PlayerMoveEvent playerMoveEvent) {
        final Player player = playerMoveEvent.getPlayer();

        final User userr = UserManager.getUser(player);
        if (userr.getOchrona() != 0L) {
            if (userr.getOchrona() <= System.currentTimeMillis()) {
                userr.setOchrona(0L);
            }
        }

        player.addEffect(Effect.getEffect(16).setDuration(1200000000).setAmplifier(1).setVisible(false));
        final Guild guild = GuildManager.getGuild(playerMoveEvent.getTo());
        final Guild guild2 = GuildManager.getGuild(playerMoveEvent.getFrom());
        if ((playerMoveEvent.getTo().getFloorX() != playerMoveEvent.getFrom().getFloorX() || playerMoveEvent.getTo().getFloorY() != playerMoveEvent.getFrom().getFloorY() || playerMoveEvent.getTo().getFloorZ() != playerMoveEvent.getFrom().getFloorZ()) && guild2 == null && guild != null) {
            if (!guild.isMember(player)) {
                ChatUtil.sendTitle(player, " ");
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.MOVE_GUILD_JOIN_MESSAGE2.replace("{TAG}", guild.getTag()).replace("{NAZWA}", guild.getName())));
                return;
            }
            ChatUtil.sendTitle(player, " ");
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.MOVE_GUILD_JOIN_MESSAGE.replace("{TAG}", guild.getTag()).replace("{NAZWA}", guild.getName())));
            final Long n = PlayerMoveListener.enemysTo.get(player);
            if (!guild.isMember(player) && (n == null || n < System.currentTimeMillis())) {
                for(Player p : guild.getOnlineMembers()){
                    p.sendMessage(ChatUtil.fixColor(Config.MOVE_INTRUZ_MESSAGE.replace("{NICK}", player.getName())));
                }
                PlayerMoveListener.enemysTo.put(player, System.currentTimeMillis() + TimeUtil.SECOND.getTime(3));
            }
        }
        else if ((playerMoveEvent.getTo().getFloorX() != playerMoveEvent.getFrom().getFloorX() || playerMoveEvent.getTo().getFloorY() != playerMoveEvent.getFrom().getFloorY() || playerMoveEvent.getTo().getFloorZ() != playerMoveEvent.getFrom().getFloorZ()) && guild == null && guild2 != null) {
            if (!guild2.isMember(player)) {
                ChatUtil.sendTitle(player, " ");
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.MOVE_GUILD_QUIT_MESSAGE2.replace("{TAG}", guild2.getTag()).replace("{NAZWA}", guild2.getName())));
                return;
            }
            ChatUtil.sendTitle(player, " ");
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.MOVE_GUILD_QUIT_MESSAGE.replace("{TAG}", guild2.getTag()).replace("{NAZWA}", guild2.getName())));
            final Long n2 = PlayerMoveListener.enemysFrom.get(player);
            if (!guild2.isMember(player) && (n2 == null || n2 < System.currentTimeMillis())) {
                for(Player p : guild2.getOnlineMembers()){
                    p.sendMessage(ChatUtil.fixColor(Config.MOVE_INTRUZ_MESSAGE2.replace("{NICK}", player.getName())));
                }

                PlayerMoveListener.enemysFrom.put(player, System.currentTimeMillis() + TimeUtil.SECOND.getTime(3));
            }
        }
    }
    
    static {
        PlayerMoveListener.enemysTo = new HashMap<Player, Long>();
        PlayerMoveListener.enemysFrom = new HashMap<Player, Long>();
    }
}
