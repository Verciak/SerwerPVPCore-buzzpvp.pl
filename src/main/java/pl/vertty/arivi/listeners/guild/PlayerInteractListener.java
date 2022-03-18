// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.listeners;

import cn.nukkit.block.BlockID;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.event.player.PlayerInteractEntityEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.Listener;
import pl.vertty.arivi.guilds.utils.RandomUtil;

public class PlayerInteractListener implements Listener
{

    @EventHandler
    public void kowadlo(PlayerInteractEvent e){
        if(e.getBlock().getId() == BlockID.ANVIL){
            e.setCancelled(true);
        }
    }

    @EventHandler
    private void ranking(final PlayerInteractEntityEvent playerInteractEntityEvent) {
        if (playerInteractEntityEvent.getEntity() instanceof Player) {
            final Player player = playerInteractEntityEvent.getPlayer();
            final Player player2 = (Player)playerInteractEntityEvent.getEntity();
            if (player2 != null) {
                final User user1 = UserManager.getUser(player2);
                final User user2 = UserManager.getUser(player);
                final User user3 = UserManager.getUser(player);
                if (user3 == null) {
                    return;
                }
                int add = (int) (45.0 + (user3.getPoints() - user1.getPoints()) * -0.2);
                if (add < 3) {
                    add = 3;
                }
                if (add > 250) {
                    add = 250;
                }
                int remove = add / 6 * 4;
                if (remove < 1) {
                    remove = 1;
                }
                if (remove > 150) {
                    remove = 150;
                }

                if (user1.isIncognitoNick()) {
                    player.sendMessage(ChatUtil.fixColor(Config.PLAYER_CLICK_SUCCESS.replace("{NICK}", "&cUKRYTO").replace("{POINTS}", Integer.toString(user1.getPoints())).replace("{MINUS}", String.valueOf(remove)).replace("{PLUS}", String.valueOf(add))));
                    return;
                }
                player.sendMessage(ChatUtil.fixColor(Config.PLAYER_CLICK_SUCCESS.replace("{NICK}", player2.getName()).replace("{POINTS}", Integer.toString(user1.getPoints())).replace("{MINUS}", String.valueOf(remove)).replace("{PLUS}", String.valueOf(add))));
            }
        }
    }
}
