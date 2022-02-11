
package pl.vertty.arivi.guilds.listeners;

import pl.vertty.arivi.guilds.data.Combat;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.managers.CombatManager;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.level.LevelLoadEvent;
import cn.nukkit.event.block.BlockFallEvent;
import cn.nukkit.event.block.BlockFadeEvent;
import cn.nukkit.event.block.BlockBurnEvent;
import cn.nukkit.event.block.LeavesDecayEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.level.WeatherChangeEvent;
import cn.nukkit.event.Listener;

public class BlockOpenInventoriesListener implements Listener
{
    @EventHandler
    public void changeWeather(final WeatherChangeEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void weatherChange(final WeatherChangeEvent event) {
        event.setCancelled(true);
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void loadworld(final LevelLoadEvent e) {
        e.getLevel().setRaining(false);
        e.getLevel().setThundering(false);
    }
    
    @EventHandler
    public void onOpen(final PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        final Combat combat = CombatManager.getCombat(player);
        if (combat == null) {
            return;
        }
        if (!CombatManager.getCombat(player).hasFight()) {
            return;
        }
        if (e.getBlock().getId() == 54 || e.getBlock().getId() == 61 || e.getBlock().getId() == 130 || e.getBlock().getId() == 58 || e.getBlock().getId() == 116 || e.getBlock().getId() == 145) {
            e.setCancelled(true);
            ChatUtil.sendMessage((CommandSender)player, "&cJestes podczas walki!");
        }
    }
}
