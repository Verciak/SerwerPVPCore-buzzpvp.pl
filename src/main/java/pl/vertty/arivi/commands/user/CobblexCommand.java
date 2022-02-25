package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import cn.nukkit.block.BlockID;
import cn.nukkit.command.CommandSender;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.drop.utils.RandomUtils;
import pl.vertty.arivi.drop.utils.Util;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.ItemBuilder;
import pl.vertty.arivi.utils.ItemUtil;

import java.util.ArrayList;
import java.util.List;

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
                return ChatUtil.sendMessage(p, "&8>> &7Muszisz miec &69x64 &7cobblestone");
            }
            final int r = RandomUtils.getRandInt(1, 3);
            final Item cx = Item.get(52, 0);
            cx.setCount(r);
            cx.setCustomName(ChatUtil.fixColor("&8* &6Cobblex &8*"));
            cx.addEnchantment(Enchantment.get(5).setLevel(10, false));
            final PlayerInventory inv = p.getInventory();
            boolean canAddItem;
                canAddItem = inv.canAddItem(cx);
                if (canAddItem) {
                    p.getInventory().addItem(cx);
                }
                else {
                    p.getLevel().dropItem(new Vector3(p.getX(), p.getFloorY(), p.getZ()), cx);
                }

            ItemUtil.removeItems(p, "4:0-64:cobble", 9);
            return ChatUtil.sendMessage(p, "&8>> &7Stworzyles &9CobbleX &7w ilosci &3x" + r + " &8(&&91 - 3&8)");
        }
        return false;
    }
    
    static {
        CobblexCommand.drops = new ArrayList<>();
        CobblexCommand.drops.add(Item.get(ItemID.IRON_INGOT, 0, 10));
        CobblexCommand.drops.add(Item.get(ItemID.IRON_INGOT, 0, 9));
        CobblexCommand.drops.add(Item.get(ItemID.GOLD_INGOT, 0, 10));
        CobblexCommand.drops.add(Item.get(ItemID.GOLD_INGOT, 0, 9));
        CobblexCommand.drops.add(Item.get(ItemID.DIAMOND, 0, 10));
        CobblexCommand.drops.add(Item.get(ItemID.DIAMOND, 0, 9));
        CobblexCommand.drops.add(Item.get(ItemID.EMERALD, 0, 10));
        CobblexCommand.drops.add(Item.get(ItemID.EMERALD, 0, 9));
        CobblexCommand.drops.add(Item.get(ItemID.COAL, 0, 10));
        CobblexCommand.drops.add(Item.get(ItemID.COAL, 0, 9));
        CobblexCommand.drops.add(Item.get(ItemID.ARROW, 0, 32));
        CobblexCommand.drops.add(Item.get(ItemID.ARROW, 0, 16));
        CobblexCommand.drops.add(Item.get(ItemID.GOLDEN_APPLE, 0, 2));
        CobblexCommand.drops.add(Item.get(ItemID.ENDER_PEARL, 0, 1));
        CobblexCommand.drops.add(Item.get(ItemID.GOLDEN_APPLE_ENCHANTED, 0, 1));
        CobblexCommand.drops.add(Item.get(BlockID.BOOKSHELF, 0, 8));
        CobblexCommand.drops.add(Item.get(BlockID.BOOKSHELF, 0, 4));
        CobblexCommand.drops.add(Item.get(ItemID.SNOWBALL, 0, 8));
        CobblexCommand.drops.add(Item.get(ItemID.SNOWBALL, 0, 4));
        CobblexCommand.drops.add(Item.get(ItemID.STRING, 0, 9));
        CobblexCommand.drops.add(Item.get(ItemID.STRING, 0, 3));
    }
}
