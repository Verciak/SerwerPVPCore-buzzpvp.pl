// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.player;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.EnderchestUtil;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.Listener;

public class PlayerInterractListener implements Listener
{
    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Combat c = CombatManager.getCombat(p);
        if (event.getBlock() != null && (event.getAction().equals((Object)PlayerInteractEvent.Action.RIGHT_CLICK_AIR) || event.getAction().equals((Object)PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)) && event.getBlock().getId() == 130) {
            if(c.hasFight()){
                event.setCancelled(true);
                ChatUtil.sendMessage(p, "&cJestes podczas walki!");
                return;
            }else{
                event.setCancelled(true);
                EnderchestUtil.open(event.getPlayer());
            }
        }
    }
}
