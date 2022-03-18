// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui;

import cn.nukkit.item.ItemID;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.managers.ItemShop;
import pl.vertty.arivi.managers.ItemShopManager;
import pl.vertty.arivi.utils.exception.SkinChangeException;
import pl.vertty.arivi.utils.ItemUtil;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import cn.nukkit.utils.DyeColor;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.item.Item;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import cn.nukkit.Player;
import pl.vertty.arivi.wings.WingsManager;

public class ItemShopGui
{
    public static void openTopki(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final User user = UserManager.getUser(player);
        ItemShop is = ItemShopManager.getUser(player);

//        final Item pandoreItem = Item.get(122);
//        pandoreItem.setCustomName(ChatUtil.fixColor("&5&lPandora"));
//        pandoreItem.setLore(new String[] { ChatUtil.fixColor("&8{O} &7Do odebrania: &9" ) });


        final Item vip = Item.get(ItemID.BOOK);
        vip.setCustomName(ChatUtil.fixColor("&r&3Ranga VIP"));
        vip.setLore(ChatUtil.fixColor("&r&8>> &7Do odebrania: &9" + is.getVip()));

        final Item svip = Item.get(ItemID.BOOK);
        svip.setCustomName(ChatUtil.fixColor("&r&3Ranga SVIP"));
        svip.setLore(ChatUtil.fixColor("&r&8>> &7Do odebrania: &9" + is.getSvip()));

        final Item sponsor = Item.get(ItemID.BOOK);
        sponsor.setCustomName(ChatUtil.fixColor("&r&3Ranga SPONSOR"));
        sponsor.setLore(ChatUtil.fixColor("&r&8>> &7Do odebrania: &9" + is.getSponsor()));

        final Item skrzydla = Item.get(ItemID.BOOK);
        skrzydla.setCustomName(ChatUtil.fixColor("&r&3Skrzydla"));
        skrzydla.setLore(ChatUtil.fixColor("&r&8>> &7Do odebrania: &9" + is.getSkrzydla()));


        for (int i = 0; i < 13; ++i) {
            category.addElement(i, new ItemData(160, DyeColor.GRAY.getDyeData(), 1, "&8*"));
        }
        category.addElement(13, ItemData.fromItem(skrzydla), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                ItemShop itemShop = ItemShopManager.getUser(player);
                if (itemShop.getSkrzydla() == 0) {
                    ChatUtil.sendMessage((CommandSender)player, "&4Blad: &cNie masz skrzydel w itemshopie!");
                    menu.forceDestroy(player);
                    return;
                }
                itemShop.setSkrzydla(0);
                WingsManager.setRatWings(player, WingsManager.getWings("ladnexd"));
                menu.forceDestroy(player);
            }
        });
        for (int i = 14; i < 21; ++i) {
            category.addElement(i, new ItemData(160, DyeColor.GRAY.getDyeData(), 1, "&r&8*"));
        }

        category.addElement(21, ItemData.fromItem(vip), new ItemClick() {
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
        category.addElement(22, ItemData.fromItem(svip), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                ItemShop itemShop = ItemShopManager.getUser(player);
                if (itemShop.getSvip() == 0) {
                    ChatUtil.sendMessage((CommandSender)player, "&4Blad: &cNie masz do odebrania rangi SVIP!");
                    menu.forceDestroy(player);
                    return;
                }
                user.setGroup(GroupType.SVIP);
                itemShop.setSvip(0);
                menu.forceDestroy(player);
            }
        });
        category.addElement(23, ItemData.fromItem(sponsor), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                ItemShop itemShop = ItemShopManager.getUser(player);
                if (itemShop.getSponsor() == 0) {
                    ChatUtil.sendMessage((CommandSender)player, "&4Blad: &cNie masz do odebrania rangi SPONSOR!");
                    menu.forceDestroy(player);
                    return;
                }
                user.setGroup(GroupType.SPONSOR);
                itemShop.setSponsor(0);
                menu.forceDestroy(player);
            }
        });
        for (int i = 24; i < 27; ++i) {
            category.addElement(i, new ItemData(160, DyeColor.GRAY.getDyeData(), 1, "&r&8*"));
        }
        menu.setMainCategory(category);
        menu.addCategory("ItemShopGUI", category);
        menu.setName(ChatUtil.fixColor("&9ITEMSHOP"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("ItemShopGUI", menu);
    }
}
