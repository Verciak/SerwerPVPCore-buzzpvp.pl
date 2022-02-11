
package pl.vertty.arivi.listeners.logs;

import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.block.Block;
import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.Player;
import pl.vertty.arivi.logs.LogsWrite;
import java.time.temporal.TemporalAccessor;
import pl.vertty.arivi.enums.GroupType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.Listener;

public class LogsListener implements Listener
{
    @EventHandler
    public void onBreak(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        final User u = UserManager.getUser(p);
        if (u.can(GroupType.HELPER)) {
            final String ranga = u.getGroup().getFullName();
            final Block b = e.getBlock();
            final int x = b.getFloorX();
            final int y = b.getFloorY();
            final int z = b.getFloorZ();
            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            final LocalDateTime time = LocalDateTime.now();
            LogsWrite.logToFileBreak("[Ranga: " + ranga + "] | Gracz " + p.getName() + " zniszczyl " + b.getName() + " | Data: " + dtf.format(time) + "| Kordy: [x: " + x + "] [y: " + y + "] [z: " + z + "]");
        }
    }
    
    @EventHandler
    public void onPlace(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        final User u = UserManager.getUser(p);
        final Block b = e.getBlock();
        final String nick = p.getName();
        final int x = b.getFloorX();
        final int y = b.getFloorY();
        final int z = b.getFloorZ();
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        final LocalDateTime time = LocalDateTime.now();
        final String ranga = u.getGroup().getFullName();
        if (u.can(GroupType.HELPER)) {
            LogsWrite.logToFilePlace("[Ranga: " + ranga + "] | Gracz " + nick + " postawil " + b.getName() + " | Data: " + dtf.format(time) + "| Kordy: [x: " + x + "] [y: " + y + "] [z: " + z + "]");
        }
    }
    
    @EventHandler
    public void onChat(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        final User u = UserManager.getUser(p);
        final String message = e.getMessage();
        final String nick = p.getName();
        final int x = p.getFloorX();
        final int y = p.getFloorY();
        final int z = p.getFloorZ();
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        final LocalDateTime time = LocalDateTime.now();
        final String ranga = u.getGroup().getFullName();
        if (u.can(GroupType.HELPER)) {
            LogsWrite.logToFilePlace("[Ranga: " + ranga + "] | Gracz " + nick + " uzyl: [" + message + "] | Data: " + dtf.format(time) + "| Kordy: [x: " + x + "] [y: " + y + "] [z: " + z + "]");
        }
    }
}
