// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui;

import cn.nukkit.utils.Config;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ItemUtil;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.item.Item;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;

public class CraftingiGui
{
    public static void openEnderchest(final Player player) {
        final User u = UserManager.getUser(player);
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final Item stone = new Item(49, Integer.valueOf(0), 1);
        stone.setCustomName(ChatUtil.fixColor("&9OBSYDIAN"));
        final Item kilof = new Item(368, Integer.valueOf(0), 1);
        kilof.setCustomName(ChatUtil.fixColor("&9PERLA"));
        final Item crafting = new Item(58, Integer.valueOf(0), 1);
        crafting.setCustomName(ChatUtil.fixColor("&9Kliknij, aby stworzyc ENDERCHEST"));
        final Item boy = new Item(130, Integer.valueOf(0), 1);
        boy.setCustomName(ChatUtil.fixColor("&9ENDERCHEST"));
        final Item antynogi = new Item(317, Integer.valueOf(0), 1);
        antynogi.setCustomName(ChatUtil.fixColor("&9ANTY-NOGI &8(&fCrafting&8)"));
        antynogi.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item boya = new Item(82, Integer.valueOf(0), 1);
        boya.setCustomName(ChatUtil.fixColor("&9BOYFARMER &8(&fCrafting&8)"));
        boya.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item kopacz = new Item(82, Integer.valueOf(0), 1);
        kopacz.setCustomName(ChatUtil.fixColor("&9KOPACZ FOSY &8(&fCrafting&8)"));
        kopacz.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item rzucak = new Item(46, Integer.valueOf(0), 1);
        rzucak.setCustomName(ChatUtil.fixColor("&9RZUCANETNT &8(&fCrafting&8)"));
        rzucak.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item stoniarka = new Item(121, Integer.valueOf(0), 1);
        stoniarka.setCustomName(ChatUtil.fixColor("&9STONIARKA &8(&fCrafting&8)"));
        stoniarka.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item enderchest = new Item(130, Integer.valueOf(0), 1);
        enderchest.setCustomName(ChatUtil.fixColor("&9ENDERCHEST &8(&fCrafting&8)"));
        enderchest.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        category.addElement(10, ItemData.fromItem(stone));
        category.addElement(11, ItemData.fromItem(stone));
        category.addElement(12, ItemData.fromItem(stone));
        category.addElement(19, ItemData.fromItem(stone));
        category.addElement(21, ItemData.fromItem(stone));
        category.addElement(28, ItemData.fromItem(stone));
        category.addElement(29, ItemData.fromItem(stone));
        category.addElement(30, ItemData.fromItem(stone));
        category.addElement(20, ItemData.fromItem(kilof));
        category.addElement(24, ItemData.fromItem(boy));
        category.addElement(45, ItemData.fromItem(boya), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openBoyFarmer(player);
            }
        });
        category.addElement(46, ItemData.fromItem(antynogi), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openAntyNogi(player);
            }
        });
        category.addElement(47, ItemData.fromItem(kopacz), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openKopacz(player);
            }
        });
        category.addElement(48, ItemData.fromItem(rzucak), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openRzucak(player);
            }
        });
        category.addElement(49, ItemData.fromItem(stoniarka), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openStoniarka(player);
            }
        });
        category.addElement(50, ItemData.fromItem(enderchest), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openEnderchest(player);
            }
        });
        category.addElement(53, ItemData.fromItem(crafting), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final Item boy2 = new Item(130, Integer.valueOf(0), 1);
                final String items = "49:0-8:Obsydian;368:0-1:Perla;";
                if (!ItemUtil.checkItems(player, items, 1)) {
                    ItemUtil.getItem(player, items, 1);
                    return;
                }
                ItemUtil.removeItems(player, items, 1);
                ItemUtil.giveItemsLore(player, boy2);
                ChatUtil.sendMessage((CommandSender)player, "&aPomyslnie wycraftowano!");
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
        final User u = UserManager.getUser(player);
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final Item stone = new Item(4, Integer.valueOf(0), 1);
        stone.setCustomName(ChatUtil.fixColor("&9COBBLESTONE"));
        final Item kilof = new Item(264, Integer.valueOf(0), 1);
        kilof.setCustomName(ChatUtil.fixColor("&9DIAMENT"));
        final Item crafting = new Item(58, Integer.valueOf(0), 1);
        crafting.setCustomName(ChatUtil.fixColor("&9Kliknij, aby stworzyc STONIARKA"));
        final Item boy = new Item(121, Integer.valueOf(0), 1);
        boy.setCustomName(ChatUtil.fixColor("&9STONIARKA"));
        boy.setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&7Kliknij, PPM aby postawic STONIARKA") });
        final Item antynogi = new Item(317, Integer.valueOf(0), 1);
        antynogi.setCustomName(ChatUtil.fixColor("&9ANTY-NOGI &8(&fCrafting&8)"));
        antynogi.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item boya = new Item(82, Integer.valueOf(0), 1);
        boya.setCustomName(ChatUtil.fixColor("&9BOYFARMER &8(&fCrafting&8)"));
        boya.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item kopacz = new Item(82, Integer.valueOf(0), 1);
        kopacz.setCustomName(ChatUtil.fixColor("&9KOPACZ FOSY &8(&fCrafting&8)"));
        kopacz.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item rzucak = new Item(46, Integer.valueOf(0), 1);
        rzucak.setCustomName(ChatUtil.fixColor("&9RZUCANETNT &8(&fCrafting&8)"));
        rzucak.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item stoniarka = new Item(121, Integer.valueOf(0), 1);
        stoniarka.setCustomName(ChatUtil.fixColor("&9STONIARKA &8(&fCrafting&8)"));
        stoniarka.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item enderchest = new Item(130, Integer.valueOf(0), 1);
        enderchest.setCustomName(ChatUtil.fixColor("&9ENDERCHEST &8(&fCrafting&8)"));
        enderchest.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        category.addElement(10, ItemData.fromItem(stone));
        category.addElement(11, ItemData.fromItem(stone));
        category.addElement(12, ItemData.fromItem(stone));
        category.addElement(19, ItemData.fromItem(stone));
        category.addElement(21, ItemData.fromItem(stone));
        category.addElement(28, ItemData.fromItem(stone));
        category.addElement(29, ItemData.fromItem(stone));
        category.addElement(30, ItemData.fromItem(stone));
        category.addElement(20, ItemData.fromItem(kilof));
        category.addElement(24, ItemData.fromItem(boy));
        category.addElement(45, ItemData.fromItem(boya), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openBoyFarmer(player);
            }
        });
        category.addElement(46, ItemData.fromItem(antynogi), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openAntyNogi(player);
            }
        });
        category.addElement(47, ItemData.fromItem(kopacz), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openKopacz(player);
            }
        });
        category.addElement(48, ItemData.fromItem(rzucak), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openRzucak(player);
            }
        });
        category.addElement(49, ItemData.fromItem(stoniarka), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openStoniarka(player);
            }
        });
        category.addElement(50, ItemData.fromItem(enderchest), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openEnderchest(player);
            }
        });
        category.addElement(53, ItemData.fromItem(crafting), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final Item boy2 = new Item(121, Integer.valueOf(0), 1);
                boy2.setCustomName(ChatUtil.fixColor("&9STONIARKA"));
                boy2.setLore(ChatUtil.fixColor(new String[] { "", "&7Kliknij, PPM aby postawic STONIARKA" }));
                final String items = "4:0-8:Cobblestone;264:0-1:Diament;";
                if (!ItemUtil.checkItems(player, items, 1)) {
                    ItemUtil.getItem(player, items, 1);
                    return;
                }
                ItemUtil.removeItems(player, items, 1);
                ItemUtil.giveItemsLore(player, boy2);
                ChatUtil.sendMessage((CommandSender)player, "&aPomyslnie wycraftowano!");
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
        final User u = UserManager.getUser(player);
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final Item stone = new Item(46, Integer.valueOf(0), 64);
        stone.setCustomName(ChatUtil.fixColor("&9TNT"));
        final Item crafting = new Item(58, Integer.valueOf(0), 1);
        crafting.setCustomName(ChatUtil.fixColor("&9Kliknij, aby stworzyc RZUCAK"));
        final Item boy = new Item(46, Integer.valueOf(0), 1);
        boy.setCustomName(ChatUtil.fixColor("&9RZUCANETNT"));
        boy.setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&7Kliknij, PPM aby postawic RZUCANETNT") });
        final Item antynogi = new Item(317, Integer.valueOf(0), 1);
        antynogi.setCustomName(ChatUtil.fixColor("&9ANTY-NOGI &8(&fCrafting&8)"));
        antynogi.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item boya = new Item(82, Integer.valueOf(0), 1);
        boya.setCustomName(ChatUtil.fixColor("&9BOYFARMER &8(&fCrafting&8)"));
        boya.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item kopacz = new Item(82, Integer.valueOf(0), 1);
        kopacz.setCustomName(ChatUtil.fixColor("&9KOPACZ FOSY &8(&fCrafting&8)"));
        kopacz.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item rzucak = new Item(46, Integer.valueOf(0), 1);
        rzucak.setCustomName(ChatUtil.fixColor("&9RZUCANETNT &8(&fCrafting&8)"));
        rzucak.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item stoniarka = new Item(121, Integer.valueOf(0), 1);
        stoniarka.setCustomName(ChatUtil.fixColor("&9STONIARKA &8(&fCrafting&8)"));
        stoniarka.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item enderchest = new Item(130, Integer.valueOf(0), 1);
        enderchest.setCustomName(ChatUtil.fixColor("&9ENDERCHEST &8(&fCrafting&8)"));
        enderchest.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        category.addElement(10, ItemData.fromItem(stone));
        category.addElement(11, ItemData.fromItem(stone));
        category.addElement(12, ItemData.fromItem(stone));
        category.addElement(19, ItemData.fromItem(stone));
        category.addElement(21, ItemData.fromItem(stone));
        category.addElement(28, ItemData.fromItem(stone));
        category.addElement(29, ItemData.fromItem(stone));
        category.addElement(30, ItemData.fromItem(stone));
        category.addElement(20, ItemData.fromItem(stone));
        category.addElement(24, ItemData.fromItem(boy));
        category.addElement(45, ItemData.fromItem(boya), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openBoyFarmer(player);
            }
        });
        category.addElement(46, ItemData.fromItem(antynogi), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openAntyNogi(player);
            }
        });
        category.addElement(47, ItemData.fromItem(kopacz), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openKopacz(player);
            }
        });
        category.addElement(48, ItemData.fromItem(rzucak), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openRzucak(player);
            }
        });
        category.addElement(49, ItemData.fromItem(stoniarka), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openStoniarka(player);
            }
        });
        category.addElement(50, ItemData.fromItem(enderchest), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openEnderchest(player);
            }
        });
        category.addElement(53, ItemData.fromItem(crafting), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final Item boy2 = new Item(46, Integer.valueOf(0), 1);
                boy2.setCustomName(ChatUtil.fixColor("&9RZUCANETNT"));
                boy2.setLore(ChatUtil.fixColor(new String[] { "", "&7Kliknij, PPM aby postawic RZUCANETNT" }));
                final String items = "46:0-576:TNT;";
                if (!ItemUtil.checkItems(player, items, 1)) {
                    ItemUtil.getItem(player, items, 1);
                    return;
                }
                ItemUtil.removeItems(player, items, 1);
                ItemUtil.giveItemsLore(player, boy2);
                ChatUtil.sendMessage((CommandSender)player, "&aPomyslnie wycraftowano!");
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
    
    public static void openKopacz(final Player player) {
        final User u = UserManager.getUser(player);
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final Item stone = new Item(1, Integer.valueOf(0), 1);
        stone.setCustomName(ChatUtil.fixColor("&9STONE"));
        final Item kilof = new Item(278, Integer.valueOf(0), 1);
        kilof.setCustomName(ChatUtil.fixColor("&9DIAMENTOWY KILOF"));
        final Item crafting = new Item(58, Integer.valueOf(0), 1);
        crafting.setCustomName(ChatUtil.fixColor("&9Kliknij, aby stworzyc KOPACZ"));
        final Item boy = new Item(82, Integer.valueOf(0), 1);
        boy.setCustomName(ChatUtil.fixColor("&9KOPACZ"));
        boy.setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&7Kliknij, PPM aby postawic KOPACZ") });
        final Item antynogi = new Item(317, Integer.valueOf(0), 1);
        antynogi.setCustomName(ChatUtil.fixColor("&9ANTY-NOGI &8(&fCrafting&8)"));
        antynogi.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item boya = new Item(82, Integer.valueOf(0), 1);
        boya.setCustomName(ChatUtil.fixColor("&9BOYFARMER &8(&fCrafting&8)"));
        boya.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item kopacz = new Item(82, Integer.valueOf(0), 1);
        kopacz.setCustomName(ChatUtil.fixColor("&9KOPACZ FOSY &8(&fCrafting&8)"));
        kopacz.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item rzucak = new Item(46, Integer.valueOf(0), 1);
        rzucak.setCustomName(ChatUtil.fixColor("&9RZUCANETNT &8(&fCrafting&8)"));
        rzucak.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item stoniarka = new Item(121, Integer.valueOf(0), 1);
        stoniarka.setCustomName(ChatUtil.fixColor("&9STONIARKA &8(&fCrafting&8)"));
        stoniarka.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item enderchest = new Item(130, Integer.valueOf(0), 1);
        enderchest.setCustomName(ChatUtil.fixColor("&9ENDERCHEST &8(&fCrafting&8)"));
        enderchest.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        category.addElement(10, ItemData.fromItem(stone));
        category.addElement(11, ItemData.fromItem(stone));
        category.addElement(12, ItemData.fromItem(stone));
        category.addElement(19, ItemData.fromItem(stone));
        category.addElement(21, ItemData.fromItem(stone));
        category.addElement(28, ItemData.fromItem(stone));
        category.addElement(29, ItemData.fromItem(stone));
        category.addElement(30, ItemData.fromItem(stone));
        category.addElement(20, ItemData.fromItem(kilof));
        category.addElement(24, ItemData.fromItem(boy));
        category.addElement(45, ItemData.fromItem(boya), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openBoyFarmer(player);
            }
        });
        category.addElement(46, ItemData.fromItem(antynogi), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openAntyNogi(player);
            }
        });
        category.addElement(47, ItemData.fromItem(kopacz), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openKopacz(player);
            }
        });
        category.addElement(48, ItemData.fromItem(rzucak), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openRzucak(player);
            }
        });
        category.addElement(49, ItemData.fromItem(stoniarka), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openStoniarka(player);
            }
        });
        category.addElement(50, ItemData.fromItem(enderchest), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openEnderchest(player);
            }
        });
        category.addElement(53, ItemData.fromItem(crafting), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final Item boy2 = new Item(82, Integer.valueOf(0), 1);
                boy2.setCustomName(ChatUtil.fixColor("&9KOPACZ"));
                boy2.setLore(ChatUtil.fixColor(new String[] { "", "&7Kliknij, PPM aby postawic KOPACZ" }));
                final String items = "1:0-8:Stone;278:0-1:Diamentowy Kilof;";
                if (!ItemUtil.checkItems(player, items, 1)) {
                    ItemUtil.getItem(player, items, 1);
                    return;
                }
                ItemUtil.removeItems(player, items, 1);
                ItemUtil.giveItemsLore(player, boy2);
                ChatUtil.sendMessage((CommandSender)player, "&aPomyslnie wycraftowano!");
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("KopaczGUI", category);
        menu.setName(ChatUtil.fixColor("&9CRAFTINGI"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("KopaczGUI", menu);
    }
    
    public static void openAntyNogi(final Player player) {
        final User u = UserManager.getUser(player);
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final Item stone = new Item(41, Integer.valueOf(0), 1);
        stone.setCustomName(ChatUtil.fixColor("&9BLOK ZLOTA"));
        final Item kilof = new Item(317, Integer.valueOf(0), 1);
        kilof.setCustomName(ChatUtil.fixColor("&9ZLOTE BUTY"));
        final Item crafting = new Item(58, Integer.valueOf(0), 1);
        crafting.setCustomName(ChatUtil.fixColor("&9Kliknij, aby stworzyc ANTY-NOGI"));
        final Item boy = new Item(317, Integer.valueOf(0), 1);
        boy.setCustomName(ChatUtil.fixColor("&9ANTY-NOGI"));
        boy.setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&7Kliknij, PPM aby uzyc ANTY-NOG") });
        final Item antynogi = new Item(317, Integer.valueOf(0), 1);
        antynogi.setCustomName(ChatUtil.fixColor("&9ANTY-NOGI &8(&fCrafting&8)"));
        antynogi.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item boya = new Item(82, Integer.valueOf(0), 1);
        boya.setCustomName(ChatUtil.fixColor("&9BOYFARMER &8(&fCrafting&8)"));
        boya.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item kopacz = new Item(82, Integer.valueOf(0), 1);
        kopacz.setCustomName(ChatUtil.fixColor("&9KOPACZ FOSY &8(&fCrafting&8)"));
        kopacz.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item rzucak = new Item(46, Integer.valueOf(0), 1);
        rzucak.setCustomName(ChatUtil.fixColor("&9RZUCANETNT &8(&fCrafting&8)"));
        rzucak.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item stoniarka = new Item(121, Integer.valueOf(0), 1);
        stoniarka.setCustomName(ChatUtil.fixColor("&9STONIARKA &8(&fCrafting&8)"));
        stoniarka.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item enderchest = new Item(130, Integer.valueOf(0), 1);
        enderchest.setCustomName(ChatUtil.fixColor("&9ENDERCHEST &8(&fCrafting&8)"));
        enderchest.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        category.addElement(10, ItemData.fromItem(stone));
        category.addElement(11, ItemData.fromItem(stone));
        category.addElement(12, ItemData.fromItem(stone));
        category.addElement(19, ItemData.fromItem(stone));
        category.addElement(21, ItemData.fromItem(stone));
        category.addElement(28, ItemData.fromItem(stone));
        category.addElement(29, ItemData.fromItem(stone));
        category.addElement(30, ItemData.fromItem(stone));
        category.addElement(20, ItemData.fromItem(kilof));
        category.addElement(24, ItemData.fromItem(boy));
        category.addElement(45, ItemData.fromItem(boya), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openBoyFarmer(player);
            }
        });
        category.addElement(46, ItemData.fromItem(antynogi), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openAntyNogi(player);
            }
        });
        category.addElement(47, ItemData.fromItem(kopacz), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openKopacz(player);
            }
        });
        category.addElement(48, ItemData.fromItem(rzucak), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openRzucak(player);
            }
        });
        category.addElement(49, ItemData.fromItem(stoniarka), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openStoniarka(player);
            }
        });
        category.addElement(50, ItemData.fromItem(enderchest), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openEnderchest(player);
            }
        });
        category.addElement(53, ItemData.fromItem(crafting), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final Item boy2 = new Item(317, Integer.valueOf(0), 1);
                boy2.setCustomName(ChatUtil.fixColor("&9ANTY-NOGI"));
                boy2.setLore(ChatUtil.fixColor(new String[] { "", "&7Kliknij, PPM aby uzyc ANTY-NOG" }));
                final String items = "41:0-8:Bloki Zlota;317:0-1:Zlote Buty;";
                if (!ItemUtil.checkItems(player, items, 1)) {
                    ItemUtil.getItem(player, items, 1);
                    return;
                }
                ItemUtil.removeItems(player, items, 1);
                ItemUtil.giveItemsLore(player, boy2);
                ChatUtil.sendMessage((CommandSender)player, "&aPomyslnie wycraftowano!");
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
    
    public static void openBoyFarmer(final Player player) {
        final User u = UserManager.getUser(player);
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final Item stone = new Item(49, Integer.valueOf(0), 1);
        stone.setCustomName(ChatUtil.fixColor("&9OBSYDIAN"));
        final Item kilof = new Item(388, Integer.valueOf(0), 1);
        kilof.setCustomName(ChatUtil.fixColor("&9EMERALD"));
        final Item crafting = new Item(58, Integer.valueOf(0), 1);
        crafting.setCustomName(ChatUtil.fixColor("&9Kliknij, aby stworzyc BOYFARMER"));
        final Item boy = new Item(82, Integer.valueOf(0), 1);
        boy.setCustomName(ChatUtil.fixColor("&9BOYFARMER"));
        boy.setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&7Kliknij, PPM aby postawic BOYFARMER") });
        final Item antynogi = new Item(317, Integer.valueOf(0), 1);
        antynogi.setCustomName(ChatUtil.fixColor("&9ANTY-NOGI &8(&fCrafting&8)"));
        antynogi.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item boya = new Item(82, Integer.valueOf(0), 1);
        boya.setCustomName(ChatUtil.fixColor("&9BOYFARMER &8(&fCrafting&8)"));
        boya.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item kopacz = new Item(82, Integer.valueOf(0), 1);
        kopacz.setCustomName(ChatUtil.fixColor("&9KOPACZ FOSY &8(&fCrafting&8)"));
        kopacz.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item rzucak = new Item(46, Integer.valueOf(0), 1);
        rzucak.setCustomName(ChatUtil.fixColor("&9RZUCANETNT &8(&fCrafting&8)"));
        rzucak.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item stoniarka = new Item(121, Integer.valueOf(0), 1);
        stoniarka.setCustomName(ChatUtil.fixColor("&9STONIARKA &8(&fCrafting&8)"));
        stoniarka.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        final Item enderchest = new Item(130, Integer.valueOf(0), 1);
        enderchest.setCustomName(ChatUtil.fixColor("&9ENDERCHEST &8(&fCrafting&8)"));
        enderchest.setLore(new String[] { ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting") });
        category.addElement(10, ItemData.fromItem(stone));
        category.addElement(11, ItemData.fromItem(stone));
        category.addElement(12, ItemData.fromItem(stone));
        category.addElement(19, ItemData.fromItem(stone));
        category.addElement(21, ItemData.fromItem(stone));
        category.addElement(28, ItemData.fromItem(stone));
        category.addElement(29, ItemData.fromItem(stone));
        category.addElement(30, ItemData.fromItem(stone));
        category.addElement(20, ItemData.fromItem(kilof));
        category.addElement(24, ItemData.fromItem(boy));
        category.addElement(45, ItemData.fromItem(boya), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openBoyFarmer(player);
            }
        });
        category.addElement(46, ItemData.fromItem(antynogi), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openAntyNogi(player);
            }
        });
        category.addElement(47, ItemData.fromItem(kopacz), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openKopacz(player);
            }
        });
        category.addElement(48, ItemData.fromItem(rzucak), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openRzucak(player);
            }
        });
        category.addElement(49, ItemData.fromItem(stoniarka), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openStoniarka(player);
            }
        });
        category.addElement(50, ItemData.fromItem(enderchest), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                CraftingiGui.openEnderchest(player);
            }
        });
        category.addElement(53, ItemData.fromItem(crafting), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final Item boy2 = new Item(82, Integer.valueOf(0), 1);
                boy2.setCustomName(ChatUtil.fixColor("&9BOYFARMER"));
                boy2.setLore(ChatUtil.fixColor(new String[] { "", "&7Kliknij, PPM aby postawic BOYFARMER" }));
                final String items = "49:0-8:Obsydian;388:0-1:Szmaragd;";
                if (!ItemUtil.checkItems(player, items, 1)) {
                    ItemUtil.getItem(player, items, 1);
                    return;
                }
                ItemUtil.removeItems(player, items, 1);
                ItemUtil.giveItemsLore(player, boy2);
                ChatUtil.sendMessage((CommandSender)player, "&aPomyslnie wycraftowano!");
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("BoyFarmerGUI", category);
        menu.setName(ChatUtil.fixColor("&9CRAFTINGI"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("BoyFarmerGUI", menu);
    }
}
