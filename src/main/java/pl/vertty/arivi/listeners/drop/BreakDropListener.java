// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.drop;

import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import java.util.Iterator;
import pl.vertty.arivi.drop.base.User;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.drop.system.DropSystem;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ItemUtil;
import cn.nukkit.item.Item;
import pl.vertty.arivi.drop.base.utils.DropUtils;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.drop.base.utils.UserUtils;
import pl.vertty.arivi.Main;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.Listener;

public class BreakDropListener implements Listener
{
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onBreak(final BlockBreakEvent e) {
        final Config c = Main.getPlugin().getConfig();
        final Player player = e.getPlayer();
        final User user = UserUtils.get(player.getName());
        if (e.getBlock().getId() == 1) {
            final pl.vertty.arivi.guilds.data.User ua = UserManager.getUser(player);
            ua.setkamien(ua.getkamien() + 1);
            user.addBlocks(1);
            user.removeBlocksToNext(1);
            if (DropUtils.isEq(player.getName())) {
                if (DropUtils.isCobble(player.getName())) {
                    ItemUtil.giveItem(player, new Item(4, Integer.valueOf(0), 1));
                }
                e.setDrops(new Item[] { new Item(0, Integer.valueOf(0), 0) });
            }
            else {
                if (!DropUtils.isCobble(player.getName())) {
                    e.setDrops(new Item[] { new Item(0, Integer.valueOf(0), 0) });
                }
                e.getBlock().getLocation();
            }
            if (user.getBlockstonext() <= 0) {
                user.addLvl(1);
                for (final Player p : Server.getInstance().getOnlinePlayers().values()) {
                    ChatUtil.sendMessage((CommandSender)p, c.getString("bc-level").replace("{NICK}", player.getName()).replace("{LVL}", String.valueOf(user.getLvl())));
                }
                user.setBlockstonext((int)(1.05 * user.getLvl() * 50.0));
            }
            DropSystem.getDropData(e.getBlock()).breakBlock(player, player.getInventory().getItemInHand(), e.getBlock(), user);
        }
    }
}
