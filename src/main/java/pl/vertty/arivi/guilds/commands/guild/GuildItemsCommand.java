// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.guild;

import java.util.Iterator;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.utils.itemstack.ItemStackUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.item.ItemData;
import cn.nukkit.item.Item;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildItemsCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        this.openInv(player);
        return false;
    }
    
    public GuildItemsCommand() {
        super("itemy", "/g itemy", GroupType.PLAYER, new String[0]);
    }
    
    public void openInv(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(0, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(1, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(2, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(3, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(4, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(5, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(6, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(7, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(8, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(9, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(10, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(11, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(12, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(13, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(14, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(15, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(16, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(17, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(18, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(19, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(25, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(26, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(27, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(28, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(34, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(35, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(36, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(37, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(38, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(39, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(40, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(41, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(42, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(43, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(44, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(45, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(46, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(47, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(48, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(49, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(50, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(51, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(52, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(53, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        final User ua = UserManager.getUser(player);
        String s = Config.COST_CREATE_NORMAL;
        if (ua.can(GroupType.SVIP)) {
            s = Config.COST_CREATE_SVIP;
        }
        if (ua.can(GroupType.VIP)) {
            s = Config.COST_CREATE_VIP;
        }
        for (final Item itemStack : ItemStackUtil.getItems(s, 1)) {
            for (int ia = 20; ia < ItemStackUtil.getItems(s, 1).size() + 20; ++ia) {
                category.addElement(ia, ItemData.fromItem(itemStack.setCustomName(ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&9").append(itemStack.getName())))).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Posiadasz: &9").append(ItemStackUtil.getItemAmount(itemStack, player, (short)1)).append("&7/&9").append(itemStack.getCount()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Procent posiadania: &9").append(ItemStackUtil.getItemAmount(itemStack, player, (short)1) / itemStack.getCount() * 100.0).append("&7%"))) })));
            }
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("gItemyMenu", category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor("&9Itemy na gildie!"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("gItemyMenu", menu);
    }
}
