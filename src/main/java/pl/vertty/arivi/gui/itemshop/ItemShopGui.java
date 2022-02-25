
package pl.vertty.arivi.gui.itemshop;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.DyeColor;
import pl.vertty.arivi.drop.pierozek.PierozekManager;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.objects.ItemShop;
import pl.vertty.arivi.managers.ItemShopManager;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.ItemUtil;
import pl.vertty.arivi.utils.exception.SkinChangeException;

public class ItemShopGui
{
    public static void openTopki(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final User user = UserManager.getUser(player);
        ItemShop is = ItemShopManager.getUser(player);


        category.setDoubleItemShopGui();


        final Item pandoreItem = Item.get(122);
        pandoreItem.setCustomName(ChatUtil.fixColor("&r&9Pandora"));
        pandoreItem.setLore(new String[] { ChatUtil.fixColor("&r&8>> &7Do odebrania: &9" + user.getPandora()) });


        final Item vip = Item.get(ItemID.BOOK);
        vip.setCustomName(ChatUtil.fixColor("&r&9Ranga VIP"));
        vip.setLore(new String[] { ChatUtil.fixColor("&r&8>> &7Do odebrania: &9" + is.getVip()) });

        final Item svip = Item.get(ItemID.BOOK);
        svip.setCustomName(ChatUtil.fixColor("&r&9Ranga SVIP"));
        svip.setLore(new String[] { ChatUtil.fixColor("&r&8>> &7Do odebrania: &9" + is.getSvip()) });

        final Item sponsor = Item.get(ItemID.BOOK);
        sponsor.setCustomName(ChatUtil.fixColor("&r&9Ranga SPONSOR"));
        sponsor.setLore(new String[] { ChatUtil.fixColor("&r&8>> &7Do odebrania: &9" + is.getSponsor()) });


        category.addElement(13, ItemData.fromItem(pandoreItem), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                if (user.getPandora() == 0) {
                    ChatUtil.sendMessage((CommandSender)player, "&4Blad: &cNie masz pandor w itemshopie!");
                    menu.forceDestroy(player);
                    return;
                }
                final Item s = PierozekManager.getPandoreItem();
                s.setCount(user.getPandora());
                ItemUtil.giveItem(player, s);
                ChatUtil.sendMessage((CommandSender)player, "&7Wyplaciles &9" + user.getPandora() + " pandor.");
                user.setPandora(0);
                menu.forceDestroy(player);
            }
        });

        category.addElement(29, ItemData.fromItem(vip), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                ItemShop itemShop = ItemShopManager.getUser(player);
                if (itemShop.getVip() == 0) {
                    ChatUtil.sendMessage((CommandSender)player, "&4Blad: &cNie masz do odebrania rangi VIP!");
                    menu.forceDestroy(player);
                    return;
                }
                user.setGroup(GroupType.VIP);
                itemShop.setVip(0);
                menu.forceDestroy(player);
            }
        });
        category.addElement(31, ItemData.fromItem(svip), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                ItemShop itemShop = ItemShopManager.getUser(player);
                if (itemShop.getSvip() == 0) {
                    ChatUtil.sendMessage((CommandSender)player, "&4Blad: &cNie masz do odebrania rangi SVIP!");
                    return;
                }
                user.setGroup(GroupType.SVIP);
                itemShop.setSvip(0);
            }
        });
        category.addElement(33, ItemData.fromItem(sponsor), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                ItemShop itemShop = ItemShopManager.getUser(player);
                if (itemShop.getSponsor() == 0) {
                    ChatUtil.sendMessage((CommandSender)player, "&4Blad: &cNie masz do odebrania rangi SPONSOR!");
                    return;
                }
                user.setGroup(GroupType.SPONSOR);
                itemShop.setSponsor(0);
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("ItemShopGUI", category);
        menu.setName(ChatUtil.fixColor("&9ITEMSHOP"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("ItemShopGUI", menu);
    }
}
