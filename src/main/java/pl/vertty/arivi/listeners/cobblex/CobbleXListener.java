// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.cobblex;

import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import cn.nukkit.block.Block;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.block.BlockBreakEvent;
import pl.vertty.arivi.utils.PolishItemNames;
import pl.vertty.arivi.drop.utils.RandomUtils;
import pl.vertty.arivi.commands.user.CobblexCommand;
import cn.nukkit.item.enchantment.Enchantment;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.ItemBuilder;
import cn.nukkit.item.Item;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.Listener;

public class CobbleXListener implements Listener
{

    @EventHandler(priority = EventPriority.MONITOR)
    public void s(final BlockBreakEvent e) {
        final Block b = e.getBlock();
        if (b.getId() == 52) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void s(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        final Block b = e.getBlock();
        final Item cx = new ItemBuilder(Item.get(52)).setTitle(ChatUtil.fixColor("&8* &6Cobblex &8*")).addEnchantment(Enchantment.get(5), 10).build();
        if (b.getId() == 52) {
            final Item drop = Item.get(CobblexCommand.drops.get(RandomUtils.getRandInt(0, CobblexCommand.drops.size() - 1)).getId(), Integer.valueOf(CobblexCommand.drops.get(RandomUtils.getRandInt(0, CobblexCommand.drops.size() - 1)).getDamage()), CobblexCommand.drops.get(RandomUtils.getRandInt(0, CobblexCommand.drops.size() - 1)).getCount());
            ChatUtil.giveItems(p, drop);
            e.setCancelled(true);
            final Item itemInHand = e.getPlayer().getInventory().getItemInHand();
            if (itemInHand.getCount() <= 1) {
                e.getPlayer().getInventory().setItemInHand(new Item(0, Integer.valueOf(0), 0));
            }
            else {
                itemInHand.setCount(itemInHand.getCount() - 1);
                e.getPlayer().getInventory().setItemInHand(itemInHand);
            }
            ChatUtil.sendMessage((CommandSender)p, "&8>> &cOtworzyles &6Cobblex &ci wylosowales &6" + PolishItemNames.getPolishName(drop) + " &8| &cx" + drop.getCount());
        }
    }
}
