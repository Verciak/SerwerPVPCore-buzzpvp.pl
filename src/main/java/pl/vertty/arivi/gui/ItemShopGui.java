// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui;

import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.drop.skrzynka.SkrzynkaManager;
import pl.vertty.arivi.utils.exception.SkinChangeException;
import pl.vertty.arivi.utils.ItemUtil;
import pl.vertty.arivi.drop.pierozek.PierozekManager;
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

public class ItemShopGui
{
    public static void openTopki(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final User user = UserManager.getUser(player);
        final Item pandoreItem = Item.get(122);
        pandoreItem.setCustomName(ChatUtil.fixColor("&5&lPandora"));
        pandoreItem.setLore(new String[] { ChatUtil.fixColor("&8{O} &7Do odebrania: &9" + user.getPandora()) });
        final Item klucz = Item.get(421, Integer.valueOf(0), 1);
        klucz.setCustomName(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("key.name")));
        klucz.setLore(new String[] { ChatUtil.fixColor("&8{O} &7Do odebrania: &9" + user.getMychest()) });
        for (int i = 0; i < 11; ++i) {
            category.addElement(i, new ItemData(160, DyeColor.GRAY.getDyeData(), 1, "&8*"));
        }
        category.addElement(11, ItemData.fromItem(pandoreItem), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (user.getPandora() == 0) {
                    ChatUtil.sendMessage((CommandSender)player, "&4Blad: &cNie masz pandor w itemshopie!");
                    return;
                }
                final Item s = PierozekManager.getPandoreItem();
                s.setCount(user.getPandora());
                ItemUtil.giveItem(player, s);
                ChatUtil.sendMessage((CommandSender)player, "&7Wyplaciles &9" + user.getPandora() + " pandor.");
                user.setPandora(0);
            }
        });
        for (int i = 12; i < 15; ++i) {
            category.addElement(i, new ItemData(160, DyeColor.GRAY.getDyeData(), 1, "&8*"));
        }
        category.addElement(15, ItemData.fromItem(klucz), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (user.getMychest() == 0) {
                    ChatUtil.sendMessage((CommandSender)player, "&4Blad: &cNie masz kluczy w itemshopie!");
                    return;
                }
                final Item s = SkrzynkaManager.key;
                s.setCustomName(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("key.name")));
                s.setCount(user.getMychest());
                ItemUtil.giveItem(player, s);
                ChatUtil.sendMessage((CommandSender)player, "&7Wyplaciles &9" + user.getMychest() + " kluczy.");
                user.setMychest(0);
            }
        });
        for (int i = 16; i < 27; ++i) {
            category.addElement(i, new ItemData(160, DyeColor.GRAY.getDyeData(), 1, "&8*"));
        }
        menu.setMainCategory(category);
        menu.addCategory("ItemShopGUI", category);
        menu.setName(ChatUtil.fixColor("&9ITEMSHOP"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("ItemShopGUI", menu);
    }
}
