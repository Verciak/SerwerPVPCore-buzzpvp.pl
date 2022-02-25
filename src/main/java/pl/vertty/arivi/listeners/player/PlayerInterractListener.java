package pl.vertty.arivi.listeners.player;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.objects.Combat;
import pl.vertty.arivi.managers.CombatManager;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.Listener;

public class PlayerInterractListener implements Listener
{
    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Combat c = CombatManager.getCombat(p);
        if (event.getBlock() != null && (event.getAction().equals(PlayerInteractEvent.Action.RIGHT_CLICK_AIR) || event.getAction().equals(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)) && event.getBlock().getId() == 130) {
            if(c.hasFight()){
                event.setCancelled(true);
                ChatUtil.sendMessage(p, "&cJestes podczas walki!");
            }
        }
    }
}
