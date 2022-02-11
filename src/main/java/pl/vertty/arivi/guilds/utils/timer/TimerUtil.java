
package pl.vertty.arivi.guilds.utils.timer;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.level.Location;
import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.utils.ChatUtil;

import java.util.ArrayList;
import java.util.List;

public class TimerUtil extends NukkitRunnable implements Listener
{
    public static List<Player> players;
    public int delay;
    public Location location;
    public Player p;
    
    public void run() {
        if (TimerUtil.players.contains(this.p)) {
            if (this.delay == 1) {
                this.p.teleport(this.location);
                ChatUtil.sendTitle(this.p, ChatUtil.fixColor(Config.GUILD_TELEPORT_TITLE));
                ChatUtil.sendSubTitle(this.p, ChatUtil.fixColor(Config.GUILD_TELEPORT_SUBTITLE));
                TimerUtil.players.remove(this.p);
                this.cancel();
            }
            --this.delay;
            ChatUtil.sendTitle(this.p, ChatUtil.fixColor(Config.GUILD_TELEPORT_TITLE));
            ChatUtil.sendSubTitle(this.p, ChatUtil.fixColor(Config.GUILD_TELEPORT_SUBTITLE2.replace("{TIME}", Integer.toString(this.delay))));
        }
    }
    
    @EventHandler
    public void onTeleport(final PlayerMoveEvent playerMoveEvent) {
        final Player player = playerMoveEvent.getPlayer();
        if (TimerUtil.players.contains(player) && (playerMoveEvent.getFrom().getFloorX() != playerMoveEvent.getTo().getFloorX() || playerMoveEvent.getFrom().getFloorY() != playerMoveEvent.getTo().getFloorY() || playerMoveEvent.getFrom().getFloorZ() != playerMoveEvent.getTo().getFloorZ())) {
            TimerUtil.players.remove(player);
            ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_TELEPORT_TITLE));
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_TELEPORT_SUBTITLE3));
            this.cancel();
        }
    }
    
    public TimerUtil(final Player p3, final Location location, final int delay) {
        this.p = p3;
        this.location = location;
        this.delay = delay;
        TimerUtil.players.add(this.p);
    }
    
    static {
        TimerUtil.players = new ArrayList<Player>();
    }
}
