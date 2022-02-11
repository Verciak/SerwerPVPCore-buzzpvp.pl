package pl.vertty.arivi.gui;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import pl.vertty.arivi.MainConstants;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.ItemUtil;

public class CraftingiGui
{
    public static void openEnderchest(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(10, ItemData.fromItem(MainConstants.OBSYDIAN));
        category.addElement(11, ItemData.fromItem(MainConstants.OBSYDIAN));
        category.addElement(12, ItemData.fromItem(MainConstants.OBSYDIAN));
        category.addElement(19, ItemData.fromItem(MainConstants.OBSYDIAN));
        category.addElement(21, ItemData.fromItem(MainConstants.OBSYDIAN));
        category.addElement(28, ItemData.fromItem(MainConstants.OBSYDIAN));
        category.addElement(29, ItemData.fromItem(MainConstants.OBSYDIAN));
        category.addElement(30, ItemData.fromItem(MainConstants.OBSYDIAN));
        category.addElement(20, ItemData.fromItem(MainConstants.PERLA));
        category.addElement(24, ItemData.fromItem(MainConstants.ENDERCHEST));
        category.addElement(46, ItemData.fromItem(MainConstants.ANTI_LEGS_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openAntyNogi(player);
            }
        });
        category.addElement(48, ItemData.fromItem(MainConstants.RZUCAK_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openRzucak(player);
            }
        });
        category.addElement(49, ItemData.fromItem(MainConstants.STONIARKA_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openStoniarka(player);
            }
        });
        category.addElement(50, ItemData.fromItem(MainConstants.ENDERCHEST_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openEnderchest(player);
            }
        });
        category.addElement(53, ItemData.fromItem(MainConstants.ENDERCHEST_GUI_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final Item boy2 = new Item(130, 0, 1);
                final String items = "49:0-8:Obsydian;368:0-1:Perla;";
                if (!ItemUtil.checkItems(player, items, 1)) {
                    ItemUtil.getItem(player, items, 1);
                    return;
                }
                ItemUtil.removeItems(player, items, 1);
                ItemUtil.giveItemsLore(player, boy2);
                ChatUtil.sendMessage(player, "&aPomyslnie wycraftowano!");
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("EnderchestGUI", category);
        menu.setName(ChatUtil.fixColor("&9CRAFTINGI"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("EnderchestGUI", menu);
    }
    
    public static void openStoniarka(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(10, ItemData.fromItem(MainConstants.COBBLESTONE));
        category.addElement(11, ItemData.fromItem(MainConstants.COBBLESTONE));
        category.addElement(12, ItemData.fromItem(MainConstants.COBBLESTONE));
        category.addElement(19, ItemData.fromItem(MainConstants.COBBLESTONE));
        category.addElement(21, ItemData.fromItem(MainConstants.COBBLESTONE));
        category.addElement(28, ItemData.fromItem(MainConstants.COBBLESTONE));
        category.addElement(29, ItemData.fromItem(MainConstants.COBBLESTONE));
        category.addElement(30, ItemData.fromItem(MainConstants.COBBLESTONE));
        category.addElement(20, ItemData.fromItem(MainConstants.DIAMENT));
        category.addElement(24, ItemData.fromItem(MainConstants.STONIARKA));
        category.addElement(46, ItemData.fromItem(MainConstants.ANTI_LEGS_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openAntyNogi(player);
            }
        });
        category.addElement(48, ItemData.fromItem(MainConstants.RZUCAK_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openRzucak(player);
            }
        });
        category.addElement(49, ItemData.fromItem(MainConstants.STONIARKA_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openStoniarka(player);
            }
        });
        category.addElement(50, ItemData.fromItem(MainConstants.ENDERCHEST_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openEnderchest(player);
            }
        });
        category.addElement(53, ItemData.fromItem(MainConstants.STONIARKA_GUI_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final Item boy2 = new Item(121, 0, 1);
                boy2.setCustomName(ChatUtil.fixColor("&9STONIARKA"));
                boy2.setLore(ChatUtil.fixColor(new String[] { "", "&7Kliknij, PPM aby postawic STONIARKA" }));
                final String items = "4:0-8:Cobblestone;264:0-1:Diament;";
                if (!ItemUtil.checkItems(player, items, 1)) {
                    ItemUtil.getItem(player, items, 1);
                    return;
                }
                ItemUtil.removeItems(player, items, 1);
                ItemUtil.giveItemsLore(player, boy2);
                ChatUtil.sendMessage(player, "&aPomyslnie wycraftowano!");
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("StoniarkaGUI", category);
        menu.setName(ChatUtil.fixColor("&9CRAFTINGI"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("StoniarkaGUI", menu);
    }
    
    public static void openRzucak(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(10, ItemData.fromItem(MainConstants.TNT));
        category.addElement(11, ItemData.fromItem(MainConstants.TNT));
        category.addElement(12, ItemData.fromItem(MainConstants.TNT));
        category.addElement(19, ItemData.fromItem(MainConstants.TNT));
        category.addElement(21, ItemData.fromItem(MainConstants.TNT));
        category.addElement(28, ItemData.fromItem(MainConstants.TNT));
        category.addElement(29, ItemData.fromItem(MainConstants.TNT));
        category.addElement(30, ItemData.fromItem(MainConstants.TNT));
        category.addElement(20, ItemData.fromItem(MainConstants.TNT));
        category.addElement(24, ItemData.fromItem(MainConstants.RZUCAK));
        category.addElement(46, ItemData.fromItem(MainConstants.ANTI_LEGS_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openAntyNogi(player);
            }
        });
        category.addElement(48, ItemData.fromItem(MainConstants.RZUCAK_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openRzucak(player);
            }
        });
        category.addElement(49, ItemData.fromItem(MainConstants.STONIARKA_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openStoniarka(player);
            }
        });
        category.addElement(50, ItemData.fromItem(MainConstants.ENDERCHEST_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openEnderchest(player);
            }
        });
        category.addElement(53, ItemData.fromItem(MainConstants.RZUCAK_GUI_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final Item boy2 = new Item(46, 0, 1);
                boy2.setCustomName(ChatUtil.fixColor("&9RZUCANETNT"));
                boy2.setLore(ChatUtil.fixColor(new String[] { "", "&7Kliknij, PPM aby postawic RZUCANETNT" }));
                final String items = "46:0-576:TNT;";
                if (!ItemUtil.checkItems(player, items, 1)) {
                    ItemUtil.getItem(player, items, 1);
                    return;
                }
                ItemUtil.removeItems(player, items, 1);
                ItemUtil.giveItemsLore(player, boy2);
                ChatUtil.sendMessage(player, "&aPomyslnie wycraftowano!");
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("RZucakGUI", category);
        menu.setName(ChatUtil.fixColor("&9CRAFTINGI"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("RZucakGUI", menu);
    }
    
    public static void openAntyNogi(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(10, ItemData.fromItem(MainConstants.GOLD_BLOCK));
        category.addElement(11, ItemData.fromItem(MainConstants.GOLD_BLOCK));
        category.addElement(12, ItemData.fromItem(MainConstants.GOLD_BLOCK));
        category.addElement(19, ItemData.fromItem(MainConstants.GOLD_BLOCK));
        category.addElement(21, ItemData.fromItem(MainConstants.GOLD_BLOCK));
        category.addElement(28, ItemData.fromItem(MainConstants.GOLD_BLOCK));
        category.addElement(29, ItemData.fromItem(MainConstants.GOLD_BLOCK));
        category.addElement(30, ItemData.fromItem(MainConstants.GOLD_BLOCK));
        category.addElement(20, ItemData.fromItem(MainConstants.GOLD_BOOTS));
        category.addElement(24, ItemData.fromItem(MainConstants.ANTI_LEGS));
        category.addElement(46, ItemData.fromItem(MainConstants.ANTI_LEGS_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openAntyNogi(player);
            }
        });
        category.addElement(48, ItemData.fromItem(MainConstants.RZUCAK_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openRzucak(player);
            }
        });
        category.addElement(49, ItemData.fromItem(MainConstants.STONIARKA_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openStoniarka(player);
            }
        });
        category.addElement(50, ItemData.fromItem(MainConstants.ENDERCHEST_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openEnderchest(player);
            }
        });
        category.addElement(53, ItemData.fromItem(MainConstants.ANTI_LEGS_GUI_ITEM), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final Item boy2 = new Item(317, 0, 1);
                boy2.setCustomName(ChatUtil.fixColor("&9ANTY-NOGI"));
                boy2.setLore(ChatUtil.fixColor(new String[] { "", "&7Kliknij, PPM aby uzyc ANTY-NOG" }));
                final String items = "41:0-8:Bloki Zlota;317:0-1:Zlote Buty;";
                if (!ItemUtil.checkItems(player, items, 1)) {
                    ItemUtil.getItem(player, items, 1);
                    return;
                }
                ItemUtil.removeItems(player, items, 1);
                ItemUtil.giveItemsLore(player, boy2);
                ChatUtil.sendMessage(player, "&aPomyslnie wycraftowano!");
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("AntyNogiGui", category);
        menu.setName(ChatUtil.fixColor("&9CRAFTINGI"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("AntyNogiGui", menu);
    }
    
}
