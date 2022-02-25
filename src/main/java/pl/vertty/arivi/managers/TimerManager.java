
package pl.vertty.arivi.managers;

import cn.nukkit.scheduler.NukkitRunnable;
import java.util.HashMap;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerMoveEvent;
import pl.vertty.arivi.objects.User;
import cn.nukkit.plugin.Plugin;
import pl.vertty.arivi.enums.TimeUtil;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.enums.TimerCallback;
import cn.nukkit.Player;
import java.util.Map;
import cn.nukkit.event.Listener;

public class TimerManager implements Listener
{
    private static final Map<Player, TimerTask> tasks = new HashMap<Player, TimerTask>();
    
    public static void addTask(final Player player, final TimerCallback<Player> call, final int time) {
        final User u = UserManager.getUser(player);
        if (u.can(GroupType.ADMIN)) {
            call.success(player);
            return;
        }
        TimerTask t = TimerManager.tasks.get(player);
        if (t != null) {
            t.cancel(player);
            return;
        }
        t = new TimerTask(player, call);
        TimerManager.tasks.put(player, t);
        t.runTaskLater((Plugin)Main.getPlugin(), TimeUtil.SECOND.getTick(time));
    }
    
    private static void cancel(final TimerTask task, final Player player) {
        task.cancel(player);
        TimerManager.tasks.remove(player);
    }
    
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onMove(final PlayerMoveEvent event) {
        if (event.getFrom().getFloorX() == event.getTo().getFloorX() && event.getFrom().getFloorY() == event.getTo().getFloorY() && event.getFrom().getFloorZ() == event.getTo().getFloorZ()) {
            return;
        }
        final TimerTask t = TimerManager.tasks.get(event.getPlayer());
        if (t != null) {
            cancel(t, event.getPlayer());
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onDamage(final EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            final Player player = (Player)event.getEntity();
            final TimerTask t = TimerManager.tasks.get(player);
            if (t != null) {
                cancel(t, player);
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        final TimerTask t = TimerManager.tasks.get(player);
        if (t != null) {
            cancel(t, player);
        }
    }

    public static class TimerTask extends NukkitRunnable
    {
        private Player player;
        private TimerCallback<Player> call;
        
        public void run() {
            this.call.success(this.player);
            TimerManager.tasks.remove(this.player);
        }
        
        public void cancel(final Player player) {
            super.cancel();
            this.call.error(player);
        }
        
        public TimerTask(final Player player, final TimerCallback<Player> call) {
            this.player = player;
            this.call = call;
        }
        
        public Player getPlayer() {
            return this.player;
        }
    }
}
