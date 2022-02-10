// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import java.util.ArrayList;
import cn.nukkit.inventory.PlayerInventory;
import pl.vertty.arivi.drop.utils.Util;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.drop.utils.RandomUtils;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ItemUtil;
import cn.nukkit.Player;
import cn.nukkit.item.enchantment.Enchantment;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.ItemBuilder;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.item.Item;
import java.util.List;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class CobblexCommand extends PlayerCommand
{
    public static List<Item> drops;
    
    public CobblexCommand() {
        super("cobblex", "Tworzenie oraz drop z CobbleX", "cobblex", GroupType.PLAYER, new String[] { "cx" });
    }
    
    public static Item getItem() {
        final Item cx = new ItemBuilder(Item.get(48), 1).setTitle(ChatUtil.fixColor("&8* &6Cobblex &8*")).addEnchantment(Enchantment.get(5), 10).build();
        return cx;
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        if (args.length == 0) {
            if (!ItemUtil.checkItems(p, "4:0-64:cobble", 9)) {
                return ChatUtil.sendMessage((CommandSender)p, "&8>> &7Muszisz miec &69x64 &7cobblestone");
            }
            final int r = RandomUtils.getRandInt(1, 3);
            final Item cx = Item.get(52, Integer.valueOf(0));
            cx.setCount(r);
            cx.setCustomName(ChatUtil.fixColor("&8* &6Cobblex &8*"));
            cx.addEnchantment(new Enchantment[] { Enchantment.get(5).setLevel(10, false) });
            final PlayerInventory inv = p.getInventory();
            boolean canAddItem = false;
                canAddItem = inv.canAddItem(cx);
                if (canAddItem) {
                    p.getInventory().addItem(new Item[] { cx });
                }
                else {
                    p.getLevel().dropItem(new Vector3(p.getX(), (double)p.getFloorY(), p.getZ()), cx);
                }

            ItemUtil.removeItems(p, "4:0-64:cobble", 9);
            return ChatUtil.sendMessage((CommandSender)p, "&8>> &7Wycraftowales &6Cobblex &7x" + r);
        }
        else {
            if (args[0].equalsIgnoreCase("drop")) {
                Util.openCobbleX(p);
                return true;
            }
            return ChatUtil.sendMessage((CommandSender)p, this.getUsage());
        }
    }
    
    static {
        (CobblexCommand.drops = new ArrayList<Item>()).add(Item.get(47, Integer.valueOf(0), 12));
        CobblexCommand.drops.add(Item.get(Item.SNOWBALL, Integer.valueOf(0), 8));
        CobblexCommand.drops.add(Item.get(266, Integer.valueOf(0), 7));
        CobblexCommand.drops.add(Item.get(368, Integer.valueOf(0), 1));
        CobblexCommand.drops.add(Item.get(265, Integer.valueOf(0), 9));
        CobblexCommand.drops.add(Item.get(341, Integer.valueOf(0), 3));
        CobblexCommand.drops.add(Item.get(260, Integer.valueOf(0), 3));
        CobblexCommand.drops.add(Item.get(322, Integer.valueOf(0), 1));
        CobblexCommand.drops.add(Item.get(121, Integer.valueOf(0), 5));
        CobblexCommand.drops.add(Item.get(353, Integer.valueOf(0), 5));
        CobblexCommand.drops.add(Item.get(264, Integer.valueOf(0), 10));
        CobblexCommand.drops.add(Item.get(388, Integer.valueOf(0), 10));
        CobblexCommand.drops.add(Item.get(266, Integer.valueOf(0), 10));
        CobblexCommand.drops.add(Item.get(265, Integer.valueOf(0), 10));
        CobblexCommand.drops.add(Item.get(331, Integer.valueOf(0), 10));
        CobblexCommand.drops.add(Item.get(263, Integer.valueOf(0), 10));
        CobblexCommand.drops.add(Item.get(287, Integer.valueOf(0), 3));
        CobblexCommand.drops.add(Item.get(262, Integer.valueOf(0), 8));
        CobblexCommand.drops.add(Item.get(262, Integer.valueOf(0), 16));
    }
}
