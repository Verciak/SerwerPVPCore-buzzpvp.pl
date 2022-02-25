
package pl.vertty.arivi.listeners.drop;

import cn.nukkit.block.BlockID;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;

import cn.nukkit.item.ItemID;
import pl.vertty.arivi.drop.base.User;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.drop.system.DropSystem;
import pl.vertty.arivi.utils.guild.RandomUtil;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ItemUtil;
import cn.nukkit.item.Item;
import pl.vertty.arivi.drop.base.utils.DropUtils;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.drop.base.utils.UserUtils;
import pl.vertty.arivi.Main;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.Listener;

public class BreakDropListener implements Listener {
    private static final Item[] ITEM_NULL = new Item[] {new Item(0, 0, 0)};

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onBreak(final BlockBreakEvent e) {
        if(e.getBlock().getId() == BlockID.OBSIDIAN){
            e.getPlayer().addExperience(4);
            ItemUtil.giveItem(e.getPlayer(), new Item(Item.OBSIDIAN, 0, RandomUtil.getRandInt(1,3)));
        }
        if(e.getBlock().getId() == BlockID.LEAVES){
            if(RandomUtil.getChance(50)){
                e.getPlayer().addExperience(2);
                ItemUtil.giveItem(e.getPlayer(), new Item(ItemID.APPLE, 0, RandomUtil.getRandInt(1,4)));
            }
        }
        if (e.getBlock().getId() == 1) {
            final Player player = e.getPlayer();
            final User user = UserUtils.get(player.getName());
            final Config c = Main.getPlugin().getConfig();
            final pl.vertty.arivi.objects.User ua = UserManager.getUser(player);
            ua.setkamien(ua.getkamien() + 1);
            user.addBlocks(1);
            user.removeBlocksToNext(1);
            if (DropUtils.isEq(player.getName())) {
                if (DropUtils.isCobble(player.getName())) {
                    ItemUtil.giveItem(player, new Item(4, 0, 1));
                }
                e.setDrops(ITEM_NULL);
            }
            else {
                if (!DropUtils.isCobble(player.getName())) {
                    e.setDrops(ITEM_NULL);
                }
                e.getBlock().getLocation();
            }
            if (user.getBlockstonext() <= 0) {
                user.addLvl(1);
                if (user.getLvl() % 5 == 0) {
                    for (final Player p : Server.getInstance().getOnlinePlayers().values()) {
                        ChatUtil.sendMessage(p, c.getString("bc-level").replace("{NICK}", player.getName()).replace("{LVL}", String.valueOf(user.getLvl())));
                    }
                }
                user.setBlockstonext((int)(1.05 * user.getLvl() * 50.0));
            }
            DropSystem.getDropData(e.getBlock()).breakBlock(player, player.getInventory().getItemInHand(), e.getBlock(), user);
        }
    }
}
