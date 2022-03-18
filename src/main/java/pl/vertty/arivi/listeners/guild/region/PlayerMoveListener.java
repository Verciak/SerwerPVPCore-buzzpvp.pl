// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.listeners.region;

import cn.nukkit.potion.Effect;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.utils.LevelUtil;
import pl.vertty.arivi.guilds.managers.CombatManager;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.Player;
import cn.nukkit.event.Listener;

public class PlayerMoveListener implements Listener
{
    
//    @EventHandler
//    public void onPlayerMoveEvent(final PlayerMoveEvent e) {
//        final Player p = e.getPlayer();
//        final Combat combat = CombatManager.getCombat(p);
//        if (combat != null && combat.hasFight() && LevelUtil.isNonPvpArea(e.getTo())) {
//            LevelUtil.knockLinePvP(p);
//            p.sendMessage(ChatUtil.fixColor("&cPodczas pvp nie mozna wejsc na spawn!"));
//        }
//    }
    
    @EventHandler
    public void onMove(final PlayerMoveEvent playerMoveEvent) {
        final Player player = playerMoveEvent.getPlayer();
        player.addEffect(Effect.getEffect(16).setDuration(1200000000).setAmplifier(1).setVisible(false));
    }
}
