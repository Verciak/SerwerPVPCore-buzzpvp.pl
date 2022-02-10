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
            Item itemStack = ItemStackUtil.getItems(s, 1).get(0);
        Item itemStack1 = ItemStackUtil.getItems(s, 1).get(1);
        Item itemStack2 = ItemStackUtil.getItems(s, 1).get(2);
        Item itemStack3 = ItemStackUtil.getItems(s, 1).get(3);
        Item itemStack4 = ItemStackUtil.getItems(s, 1).get(4);
        Item itemStack5 = ItemStackUtil.getItems(s, 1).get(5);
        category.addElement(20, ItemData.fromItem(itemStack.setCustomName(ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&9").append(itemStack.getName())))).setLore(new String[]{ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Posiadasz: &9").append(ItemStackUtil.getItemAmount(itemStack, player, (short) 1)).append("&7/&9").append(itemStack.getCount()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Procent posiadania: &9").append(ItemStackUtil.getItemAmount(itemStack, player, (short) 1) / itemStack.getCount() * 100.0).append("&7%")))})));
        category.addElement(21, ItemData.fromItem(itemStack1.setCustomName(ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&9").append(itemStack1.getName())))).setLore(new String[]{ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Posiadasz: &9").append(ItemStackUtil.getItemAmount(itemStack1, player, (short) 1)).append("&7/&9").append(itemStack1.getCount()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Procent posiadania: &9").append(ItemStackUtil.getItemAmount(itemStack1, player, (short) 1) / itemStack1.getCount() * 100.0).append("&7%")))})));
        category.addElement(22, ItemData.fromItem(itemStack2.setCustomName(ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&9").append(itemStack2.getName())))).setLore(new String[]{ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Posiadasz: &9").append(ItemStackUtil.getItemAmount(itemStack2, player, (short) 1)).append("&7/&9").append(itemStack2.getCount()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Procent posiadania: &9").append(ItemStackUtil.getItemAmount(itemStack2, player, (short) 1) / itemStack2.getCount() * 100.0).append("&7%")))})));
        category.addElement(23, ItemData.fromItem(itemStack3.setCustomName(ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&9").append(itemStack3.getName())))).setLore(new String[]{ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Posiadasz: &9").append(ItemStackUtil.getItemAmount(itemStack3, player, (short) 1)).append("&7/&9").append(itemStack3.getCount()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Procent posiadania: &9").append(ItemStackUtil.getItemAmount(itemStack3, player, (short) 1) / itemStack3.getCount() * 100.0).append("&7%")))})));
        category.addElement(24, ItemData.fromItem(itemStack4.setCustomName(ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&9").append(itemStack4.getName())))).setLore(new String[]{ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Posiadasz: &9").append(ItemStackUtil.getItemAmount(itemStack4, player, (short) 1)).append("&7/&9").append(itemStack4.getCount()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Procent posiadania: &9").append(ItemStackUtil.getItemAmount(itemStack4, player, (short) 1) / itemStack4.getCount() * 100.0).append("&7%")))})));
        category.addElement(29, ItemData.fromItem(itemStack5.setCustomName(ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&9").append(itemStack5.getName())))).setLore(new String[]{ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Posiadasz: &9").append(ItemStackUtil.getItemAmount(itemStack5, player, (short) 1)).append("&7/&9").append(itemStack5.getCount()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Procent posiadania: &9").append(ItemStackUtil.getItemAmount(itemStack5, player, (short) 1) / itemStack5.getCount() * 100.0).append("&7%")))})));

        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("gItemyMenu", category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor("&9Itemy na gildie!"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("gItemyMenu", menu);
    }
}
