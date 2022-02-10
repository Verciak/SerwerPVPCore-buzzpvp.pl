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

public class SmierciInventory
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
        category.addElement(9, ItemData.fromItem(new Item(283).setCustomName(ChatUtil.fixColor("&6Poniesione smierci: &f1")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f1"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fsztabka zelaza &6x&f16"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + UserManager.getUser(p).getDeaths() + "&6/&f5") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (ua.getDeaths() >= 5) {
                    if (u.getodblokowane_zgonow() == 0) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
                    }
                    if (u.getodblokowane_zgonow() == 1) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
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
        category.addElement(10, ItemData.fromItem(new Item(283).setCustomName(ChatUtil.fixColor("&6Poniesione smierci: &f2")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f2"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fsztabka zlota &6x&f16"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + UserManager.getUser(p).getDeaths() + "&6/&f10") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (ua.getDeaths() >= 10) {
                    if (u.getodblokowane_zgonow() == 1) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
                    }
                    if (u.getodblokowane_zgonow() == 2) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
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
        category.addElement(11, ItemData.fromItem(new Item(283).setCustomName(ChatUtil.fixColor("&6Poniesione smierci: &f3")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f3"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fblok zelaza &6x&f4"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + UserManager.getUser(p).getDeaths() + "&6/&f20") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (ua.getDeaths() >= 20) {
                    if (u.getodblokowane_zgonow() == 2) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
                    }
                    if (u.getodblokowane_zgonow() == 3) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
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
        category.addElement(12, ItemData.fromItem(new Item(283).setCustomName(ChatUtil.fixColor("&6Poniesione smierci: &f4")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f4"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fblok zlota &6x&f4"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + UserManager.getUser(p).getDeaths() + "&6/&f30") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (ua.getDeaths() >= 30) {
                    if (u.getodblokowane_zgonow() == 3) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
                    }
                    if (u.getodblokowane_zgonow() == 4) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
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
        category.addElement(13, ItemData.fromItem(new Item(283).setCustomName(ChatUtil.fixColor("&6Poniesione smierci: &f5")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f5"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fdiament &6x&f32"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + UserManager.getUser(p).getDeaths() + "&6/&f60") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (ua.getDeaths() >= 60) {
                    if (u.getodblokowane_zgonow() == 4) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
                    }
                    if (u.getodblokowane_zgonow() == 5) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
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
        category.addElement(14, ItemData.fromItem(new Item(283).setCustomName(ChatUtil.fixColor("&6Poniesione smierci: &f6")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f6"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &foko endermana &6x&f2"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + UserManager.getUser(p).getDeaths() + "&6/&f90") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (ua.getDeaths() >= 90) {
                    if (u.getodblokowane_zgonow() == 5) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
                    }
                    if (u.getodblokowane_zgonow() == 6) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
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
        category.addElement(15, ItemData.fromItem(new Item(283).setCustomName(ChatUtil.fixColor("&6Poniesione smierci: &f7")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f7"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &frefil &6x&f32"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + UserManager.getUser(p).getDeaths() + "&6/&f120") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (ua.getDeaths() >= 120) {
                    if (u.getodblokowane_zgonow() == 6) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
                    }
                    if (u.getodblokowane_zgonow() == 7) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
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
        category.addElement(16, ItemData.fromItem(new Item(283).setCustomName(ChatUtil.fixColor("&6Poniesione smierci: &f8")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f8"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fkoxy &6x&f16"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + UserManager.getUser(p).getDeaths() + "&6/&f200") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (ua.getDeaths() >= 200) {
                    if (u.getodblokowane_zgonow() == 7) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
                    }
                    if (u.getodblokowane_zgonow() == 8) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
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
        category.addElement(17, ItemData.fromItem(new Item(283).setCustomName(ChatUtil.fixColor("&6Poniesione smierci: &f9")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f9"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fzlote jablko &6x&f32"), ChatUtil.fixColor(" &6* &fkoxy &6x&f16"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + UserManager.getUser(p).getDeaths() + "&6/&f250") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (ua.getDeaths() >= 250) {
                    if (u.getodblokowane_zgonow() == 8) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
                    }
                    if (u.getodblokowane_zgonow() == 9) {
                        u.setodblokowane_zgonow(u.getodblokowane_zgonow() + 1);
                        ItemUtil.giveItem(player, new Item(322, Integer.valueOf(0), 32));
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
        category.addElement(22, ItemData.fromItem(new Item(107, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&c&lWROC"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                OsiagnieciaInventory.guiStone(player);
            }
        });
        menu.setMainCategory(category);
        menu.addCategory("OsDeathsGUI", category);
        menu.setName(ChatUtil.fixColor("&e&lOSIAGNIECIA"));
        menu.setOnlyRead(true);
        menu.show(p);
        InventoryMenuHandler.registerNewMenu("OsDeathsGUI", menu);
    }
}
