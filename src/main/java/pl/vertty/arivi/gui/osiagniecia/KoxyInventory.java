// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui.osiagniecia;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.ItemUtil;

public class KoxyInventory
{
    public static void guiStone(final Player p) {
        final User u = UserManager.getUser(p);
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        for (int i = 0; i <= 26; ++i) {
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 18 || i == 19 || i == 20 || i == 21 || i == 23 || i == 24 || i == 25 || i == 26) {
                category.addElement(i, ItemData.fromItem(new Item(160, Integer.valueOf(15), 1).setCustomName(ChatUtil.fixColor("&a"))));
            }
        }
        category.addElement(9, ItemData.fromItem(new Item(466).setCustomName(ChatUtil.fixColor("&6Zjedzone koxy: &f1")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f1"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fsztabka zelaza &6x&f16"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkox() + "&6/&f5") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkox() >= 5) {
                    if (u.getodblokowane_kox() == 0) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                    }
                    if (u.getodblokowane_kox() == 1) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                        ItemUtil.giveItem(player, new Item(265, Integer.valueOf(0), 16));
                    }
                    else {
                        ChatUtil.sendTitle(p, ChatUtil.fixColor("&cOsiagniecie wykonane!"), ChatUtil.fixColor(""));
                    }
                }
                else {
                    p.sendMessage(ChatUtil.fixColor("&cBrak wymagan do wykonania osiagniecia!"));
                }
            }
        });
        category.addElement(10, ItemData.fromItem(new Item(466).setCustomName(ChatUtil.fixColor("&6Zjedzone koxy: &f2")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f2"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fsztabka zlota &6x&f16"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkox() + "&6/&f20") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkox() >= 10) {
                    if (u.getodblokowane_kox() == 1) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                    }
                    if (u.getodblokowane_kox() == 2) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                        ItemUtil.giveItem(player, new Item(266, Integer.valueOf(0), 16));
                    }
                    else {
                        ChatUtil.sendTitle(p, ChatUtil.fixColor("&cOsiagniecie wykonane!"), ChatUtil.fixColor(""));
                    }
                }
                else {
                    p.sendMessage(ChatUtil.fixColor("&cBrak wymagan do wykonania osiagniecia!"));
                }
            }
        });
        category.addElement(11, ItemData.fromItem(new Item(466).setCustomName(ChatUtil.fixColor("&6Zjedzone koxy: &f3")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f3"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fblok zelaza &6x&f4"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkox() + "&6/&f50") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkox() >= 20) {
                    if (u.getodblokowane_kox() == 2) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                    }
                    if (u.getodblokowane_kox() == 3) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                        ItemUtil.giveItem(player, new Item(42, Integer.valueOf(0), 4));
                    }
                    else {
                        ChatUtil.sendTitle(p, ChatUtil.fixColor("&cOsiagniecie wykonane!"), ChatUtil.fixColor(""));
                    }
                }
                else {
                    p.sendMessage(ChatUtil.fixColor("&cBrak wymagan do wykonania osiagniecia!"));
                }
            }
        });
        category.addElement(12, ItemData.fromItem(new Item(466).setCustomName(ChatUtil.fixColor("&6Zjedzone koxy: &f4")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f4"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fblok zlota &6x&f4"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkox() + "&6/&f100") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkox() >= 30) {
                    if (u.getodblokowane_kox() == 3) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                    }
                    if (u.getodblokowane_kox() == 4) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                        ItemUtil.giveItem(player, new Item(41, Integer.valueOf(0), 4));
                    }
                    else {
                        ChatUtil.sendTitle(p, ChatUtil.fixColor("&cOsiagniecie wykonane!"), ChatUtil.fixColor(""));
                    }
                }
                else {
                    p.sendMessage(ChatUtil.fixColor("&cBrak wymagan do wykonania osiagniecia!"));
                }
            }
        });
        category.addElement(13, ItemData.fromItem(new Item(466).setCustomName(ChatUtil.fixColor("&6Zjedzone koxy: &f5")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f5"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fdiament &6x&f32"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkox() + "&6/&f150") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkox() >= 60) {
                    if (u.getodblokowane_kox() == 4) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                    }
                    if (u.getodblokowane_kox() == 5) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                        ItemUtil.giveItem(player, new Item(264, Integer.valueOf(0), 32));
                    }
                    else {
                        ChatUtil.sendTitle(p, ChatUtil.fixColor("&cOsiagniecie wykonane!"), ChatUtil.fixColor(""));
                    }
                }
                else {
                    p.sendMessage(ChatUtil.fixColor("&cBrak wymagan do wykonania osiagniecia!"));
                }
            }
        });
        category.addElement(14, ItemData.fromItem(new Item(466).setCustomName(ChatUtil.fixColor("&6Zjedzone koxy: &f6")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f6"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &foko endermana &6x&f2"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkox() + "&6/&f200") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkox() >= 90) {
                    if (u.getodblokowane_kox() == 5) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                    }
                    if (u.getodblokowane_kox() == 6) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                        ItemUtil.giveItem(player, new Item(368, Integer.valueOf(0), 2));
                    }
                    else {
                        ChatUtil.sendTitle(p, ChatUtil.fixColor("&cOsiagniecie wykonane!"), ChatUtil.fixColor(""));
                    }
                }
                else {
                    p.sendMessage(ChatUtil.fixColor("&cBrak wymagan do wykonania osiagniecia!"));
                }
            }
        });
        category.addElement(15, ItemData.fromItem(new Item(466).setCustomName(ChatUtil.fixColor("&6Zjedzone koxy: &f7")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f7"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &frefil &6x&f32"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkox() + "&6/&f500") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkox() >= 120) {
                    if (u.getodblokowane_kox() == 6) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                    }
                    if (u.getodblokowane_kox() == 7) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                        ItemUtil.giveItem(player, new Item(322, Integer.valueOf(0), 32));
                    }
                    else {
                        ChatUtil.sendTitle(p, ChatUtil.fixColor("&cOsiagniecie wykonane!"), ChatUtil.fixColor(""));
                    }
                }
                else {
                    p.sendMessage(ChatUtil.fixColor("&cBrak wymagan do wykonania osiagniecia!"));
                }
            }
        });
        category.addElement(16, ItemData.fromItem(new Item(466).setCustomName(ChatUtil.fixColor("&6Zjedzone koxy: &f8")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f8"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fkoxy &6x&f16"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkox() + "&6/&f1000") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkox() >= 200) {
                    if (u.getodblokowane_kox() == 7) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                    }
                    if (u.getodblokowane_kox() == 8) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                        ItemUtil.giveItem(player, new Item(466, Integer.valueOf(0), 16));
                    }
                    else {
                        ChatUtil.sendTitle(p, ChatUtil.fixColor("&cOsiagniecie wykonane!"), ChatUtil.fixColor(""));
                    }
                }
                else {
                    p.sendMessage(ChatUtil.fixColor("&cBrak wymagan do wykonania osiagniecia!"));
                }
            }
        });
        category.addElement(17, ItemData.fromItem(new Item(466).setCustomName(ChatUtil.fixColor("&6Zjedzone koxy: &f9")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f9"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fkox &6x&f32"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkox() + "&6/&f2000") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkox() >= 250) {
                    if (u.getodblokowane_kox() == 8) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                    }
                    if (u.getodblokowane_kox() == 9) {
                        u.setodblokowane_kox(u.getodblokowane_kox() + 1);
                        ItemUtil.giveItem(player, new Item(466, Integer.valueOf(0), 32));
                    }
                    else {
                        ChatUtil.sendTitle(p, ChatUtil.fixColor("&cOsiagniecie wykonane!"), ChatUtil.fixColor(""));
                    }
                }
                else {
                    p.sendMessage(ChatUtil.fixColor("&cBrak wymagan do wykonania osiagniecia!"));
                }
            }
        });
        category.addElement(22, ItemData.fromItem(new Item(107, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&c&lWROC"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                OsiagnieciaInventory.guiStone(player);
            }
        });
        menu.setMainCategory(category);
        menu.addCategory("osKoxGui", category);
        menu.setName(ChatUtil.fixColor("&e&lOSIAGNIECIA"));
        menu.setOnlyRead(true);
        menu.show(p);
        InventoryMenuHandler.registerNewMenu("osKoxGui", menu);
    }
}
