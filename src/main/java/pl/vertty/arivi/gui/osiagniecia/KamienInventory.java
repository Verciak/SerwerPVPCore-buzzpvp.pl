// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui.osiagniecia;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
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

public class KamienInventory
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
        category.addElement(9, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&6Wykopany kamien: &f1")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f1"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fsztabka zelaza &6x&f16"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkamien() + "&6/&f100") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkamien() >= 100) {
                    if (u.getodblokowane_kamien() == 0) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
                    }
                    if (u.getodblokowane_kamien() == 1) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
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
        category.addElement(10, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&6Wykopany kamien: &f2")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f2"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fsztabka zlota &6x&f16"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkamien() + "&6/&f1000") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkamien() >= 1000) {
                    if (u.getodblokowane_kamien() == 1) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
                    }
                    if (u.getodblokowane_kamien() == 2) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
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
        category.addElement(11, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&6Wykopany kamien: &f3")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f3"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fblok zelaza &6x&f4"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkamien() + "&6/&f10000") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkamien() >= 10000) {
                    if (u.getodblokowane_kamien() == 2) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
                    }
                    if (u.getodblokowane_kamien() == 3) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
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
        category.addElement(12, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&6Wykopany kamien: &f4")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f4"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fblok zlota &6x&f4"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkamien() + "&6/&f100000") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkamien() >= 100000) {
                    if (u.getodblokowane_kamien() == 3) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
                    }
                    if (u.getodblokowane_kamien() == 4) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
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
        category.addElement(13, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&6Wykopany kamien: &f5")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f5"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fdiament &6x&f32"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkamien() + "&6/&f1000000") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkamien() >= 1000000) {
                    if (u.getodblokowane_kamien() == 4) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
                    }
                    if (u.getodblokowane_kamien() == 5) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
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
        category.addElement(14, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&6Wykopany kamien: &f6")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f6"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &foko endermana &6x&f2"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkamien() + "&6/&f2000000") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkamien() >= 2000000) {
                    if (u.getodblokowane_kamien() == 5) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
                    }
                    if (u.getodblokowane_kamien() == 6) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
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
        category.addElement(15, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&6Wykopany kamien: &f7")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f7"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &frefil &6x&f32"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkamien() + "&6/&f2500000") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkamien() >= 2500000) {
                    if (u.getodblokowane_kamien() == 6) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
                    }
                    if (u.getodblokowane_kamien() == 7) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
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
        category.addElement(16, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&6Wykopany kamien: &f8")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f8"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fkoxy &6x&f16"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkamien() + "&6/&f3000000") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkamien() >= 3000000) {
                    if (u.getodblokowane_kamien() == 7) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
                    }
                    if (u.getodblokowane_kamien() == 8) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
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
        category.addElement(17, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&6Wykopany kamien: &f9")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&6Poziom: &f9"), ChatUtil.fixColor("&6Nagroda:"), ChatUtil.fixColor(" &6* &fdiamentowy kilof &6x&f1"), ChatUtil.fixColor("  &6- &fwydajnosc &66"), ChatUtil.fixColor("  &6- &fniezniszczalnosc &63"), ChatUtil.fixColor("  &6- &fszczescie &63"), ChatUtil.fixColor(""), ChatUtil.fixColor("&6Posiadasz &f" + u.getkamien() + "&6/&f5000000") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User ua = UserManager.getUser(p);
                if (u.getkamien() >= 5000000) {
                    if (u.getodblokowane_kamien() == 8) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
                    }
                    if (u.getodblokowane_kamien() == 9) {
                        u.setodblokowane_kamien(u.getodblokowane_kamien() + 1);
                        final Item i = new Item(278, Integer.valueOf(0), 1);
                        i.addEnchantment(new Enchantment[] { Enchantment.get(15).setLevel(6, false) });
                        i.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(3, true) });
                        i.addEnchantment(new Enchantment[] { Enchantment.get(18).setLevel(3, true) });
                        ItemUtil.giveItem(player, i);
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
        menu.addCategory("osStoneGui", category);
        menu.setName(ChatUtil.fixColor("&e&lOSIAGNIECIA"));
        menu.setOnlyRead(true);
        menu.show(p);
        InventoryMenuHandler.registerNewMenu("osStoneGui", menu);
    }
}
