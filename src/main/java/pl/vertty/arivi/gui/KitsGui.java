
package pl.vertty.arivi.gui;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.enums.TimeUtil;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.DataUtil;

public class KitsGui
{
    private static boolean isActive(final long czas) {
        return czas >= System.currentTimeMillis();
    }
    
    public static void openKits(final Player player) {
        final User u = UserManager.getUser(player);
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(2, new ItemData(160, 11, 1, "&8*"));
        category.addElement(4, new ItemData(160, 11, 1, "&8*"));
        category.addElement(6, new ItemData(160, 11, 1, "&8*"));
        category.addElement(10, new ItemData(160, 11, 1, "&8*"));
        category.addElement(12, new ItemData(160, 11, 1, "&8*"));
        category.addElement(14, new ItemData(160, 11, 1, "&8*"));
        category.addElement(16, new ItemData(160, 11, 1, "&8*"));
        category.addElement(20, new ItemData(160, 11, 1, "&8*"));
        category.addElement(24, new ItemData(160, 11, 1, "&8*"));
        category.addElement(44, new ItemData(160, 11, 1, "&8*"));
        category.addElement(28, new ItemData(160, 11, 1, "&8*"));
        category.addElement(38, new ItemData(160, 11, 1, "&8*"));
        category.addElement(46, new ItemData(160, 11, 1, "&8*"));
        category.addElement(34, new ItemData(160, 11, 1, "&8*"));
        category.addElement(42, new ItemData(160, 11, 1, "&8*"));
        category.addElement(36, new ItemData(160, 11, 1, "&8*"));
        category.addElement(52, new ItemData(160, 11, 1, "&8*"));
        category.addElement(13, new ItemData(263, 0, 1, "&9GRACZ", new String[] { ChatUtil.fixColor("&8» &7Dostepny dla rangi: &ePLAYER"), ChatUtil.fixColor("&8» &7Czas: &e3 minut"), "", ChatUtil.fixColor("&8» &7Kliknij, aby wyswietlic przedmioty w zestawie!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                KitsGui.openPlayerKit(p);
            }
        });
        category.addElement(43, new ItemData(46, 0, 1, "&9TNT", new String[] { ChatUtil.fixColor("&8» &7Dostepny dla rangi: &eSPONSOR"), ChatUtil.fixColor("&8» &7Czas: &e12 godzin"), "", ChatUtil.fixColor("&8» &7Kliknij, aby wyswietlic przedmioty w zestawie!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                KitsGui.openTNT(p);
            }
        });
        category.addElement(11, new ItemData(265, 0, 1, "&9VIP", new String[] { ChatUtil.fixColor("&8» &7Dostepny dla rangi: &eVIP"), ChatUtil.fixColor("&8» &7Czas: &e6 godzin"), "", ChatUtil.fixColor("&8» &7Kliknij, aby wyswietlic przedmioty w zestawie!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                KitsGui.openVipKit(p);
            }
        });
        category.addElement(15, new ItemData(266, 0, 1, "&9SVIP", new String[] { ChatUtil.fixColor("&8» &7Dostepny dla rangi: &eSVIP | YOUTUBE"), ChatUtil.fixColor("&8» &7Czas: &e6 godzin"), "", ChatUtil.fixColor("&8» &7Kliknij, aby wyswietlic przedmioty w zestawie!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                KitsGui.openSvipKit(p);
            }
        });
        category.addElement(37, new ItemData(264, 0, 1, "&9SPONSOR", new String[] { ChatUtil.fixColor("&8» &7Dostepny dla rangi: &eSPONSOR"), ChatUtil.fixColor("&8» &7Czas: &e6 godzin"), "", ChatUtil.fixColor("&8» &7Kliknij, aby wyswietlic przedmioty w zestawie!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                KitsGui.openSponsor(p);
            }
        });
        category.addElement(2, new ItemData(160, 11, 1, "&8*"));
        category.addElement(4, new ItemData(160, 11, 1, "&8*"));
        category.addElement(6, new ItemData(160, 11, 1, "&8*"));
        category.addElement(10, new ItemData(160, 11, 1, "&8*"));
        category.addElement(12, new ItemData(160, 11, 1, "&8*"));
        category.addElement(14, new ItemData(160, 11, 1, "&8*"));
        category.addElement(16, new ItemData(160, 11, 1, "&8*"));
        category.addElement(20, new ItemData(160, 11, 1, "&8*"));
        category.addElement(22, new ItemData(160, 11, 1, "&8*"));
        category.addElement(24, new ItemData(160, 11, 1, "&8*"));
        category.addElement(31, new ItemData(160, 11, 1, "&8*"));
        category.addElement(39, new ItemData(160, 11, 1, "&8*"));
        category.addElement(40, new ItemData(364, 0, 1, "&9MIESO", new String[] { ChatUtil.fixColor("&8» &7Dostepny dla rangi: &ePLAYER"), ChatUtil.fixColor("&8» &7Czas: &e1 minuty"), "", ChatUtil.fixColor("&8» &7Kliknij, aby wyswietlic przedmioty w zestawie!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                KitsGui.openMiesoKit(p);
            }
        });
        category.addElement(41, new ItemData(160, 11, 1, "&8*"));
        category.addElement(49, new ItemData(160, 11, 1, "&8*"));
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("kitsGui", category);
        menu.setName(ChatUtil.fixColor("&9KITY"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("kitsGui", menu);
    }
    
    public static void openTNT(final Player player) {
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final ItemData i = new ItemData(160, 11, 1, "&8#");
        final User u = UserManager.getUser(player);
        for (int ia = 0; ia < 9; ++ia) {
            category.addElement(ia, i);
        }
        final ItemData tnt = new ItemData(46, 0, 64);
        category.addElement(9, tnt);
        category.addElement(10, tnt);
        category.addElement(11, tnt);
        category.addElement(12, tnt);
        category.addElement(13, tnt);
        for (int ia2 = 36; ia2 < 52; ++ia2) {
            category.addElement(ia2, i);
        }
        category.addElement(52, new ItemData(351, 1, 1, "&4Powrot"), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                KitsGui.openKits(p);
            }
        });
        if (isActive(u.getKit_tnt())) {
            category.addElement(53, new ItemData(351, 8, 1, "&cZestaw niedostepny czasowo"));
        }
        else {
            category.addElement(53, new ItemData(351, 10, 1, "&aOdbierz zestaw"), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    if (!c.getBoolean("enable.kits.status")) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                        return;
                    }
                    if (!u.can(GroupType.SPONSOR)) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&cWymagana ranga: &3SPONSOR"));
                        return;
                    }
                    if (isActive(u.getKit_tnt()) && !u.can(GroupType.ADMIN)) {
                        p.sendMessage(ChatUtil.fixColor(" &8>> &cKit TNT mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_tnt() - System.currentTimeMillis(), false)));
                        return;
                    }
                    final Item tnt = Item.get(46, Integer.valueOf(0), 64);
                    ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6TNT"));
                    p.getInventory().addItem(new Item[] { tnt });
                    p.getInventory().addItem(new Item[] { tnt });
                    p.getInventory().addItem(new Item[] { tnt });
                    p.getInventory().addItem(new Item[] { tnt });
                    p.getInventory().addItem(new Item[] { tnt });
                    u.setKit_tnt(System.currentTimeMillis() + TimeUtil.HOUR.getTime(12));
                }
            });
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("kittntKit", category);
        menu.setName(ChatUtil.fixColor("&9KIT TNT"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("kittntKit", menu);
    }
    
    public static void openMiesoKit(final Player player) {
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final ItemData i = new ItemData(160, 11, 1, "&8#");
        final User u = UserManager.getUser(player);
        for (int ia = 0; ia < 9; ++ia) {
            category.addElement(ia, i);
        }
        final ItemData jedzenie = new ItemData(320, 0, 64);
        category.addElement(9, jedzenie);
        for (int ia2 = 36; ia2 < 52; ++ia2) {
            category.addElement(ia2, i);
        }
        category.addElement(52, new ItemData(351, 1, 1, "&4Powrot"), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                KitsGui.openKits(p);
            }
        });
        if (isActive(u.getKit_mieso())) {
            category.addElement(53, new ItemData(351, 8, 1, "&cZestaw niedostepny czasowo"));
        }
        else {
            category.addElement(53, new ItemData(351, 10, 1, "&aOdbierz zestaw"), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    if (isActive(u.getKit_mieso()) && !u.can(GroupType.ADMIN)) {
                        p.sendMessage(ChatUtil.fixColor(" &8>> &cKit MIESO mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_mieso() - System.currentTimeMillis(), false)));
                        return;
                    }
                    final Item mieso = Item.get(320, Integer.valueOf(0), 64);
                    ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6MIESO"));
                    p.getInventory().addItem(new Item[] { mieso });
                    u.setKit_mieso(System.currentTimeMillis() + TimeUtil.MINUTE.getTime(1));
                }
            });
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("kitMiesoKit", category);
        menu.setName(ChatUtil.fixColor("&9KIT MIESO"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("kitMiesoKit", menu);
    }
    
    public static void openPlayerKit(final Player player) {
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final ItemData i = new ItemData(160, 11, 1, "&8#");
        final User u = UserManager.getUser(player);
        for (int ia = 0; ia < 9; ++ia) {
            category.addElement(ia, i);
        }
        final Item kilof = new Item(274, 0, 1);
        kilof.addEnchantment(Enchantment.get(Enchantment.ID_DURABILITY).setLevel(3));
        final ItemData jedzenie = new ItemData(320, 0, 64);
        final ItemData ender = new ItemData(130, 0, 1);
        final ItemData drewno = new ItemData(Item.WOOD, 0, 32);
        final ItemData woda = new ItemData(ItemID.BUCKET, 8, 1);
        category.addElement(9, ItemData.fromItem(kilof));
        category.addElement(10, jedzenie);
        category.addElement(11, ender);
        category.addElement(12, drewno);
        category.addElement(13, woda);
        for (int ia2 = 36; ia2 < 52; ++ia2) {
            category.addElement(ia2, i);
        }
        category.addElement(52, new ItemData(351, 1, 1, "&4Powrot"), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                KitsGui.openKits(p);
            }
        });
        if (isActive(u.getKit_start())) {
            category.addElement(53, new ItemData(351, 8, 1, "&cZestaw niedostepny czasowo"));
        }
        else {
            category.addElement(53, new ItemData(351, 10, 1, "&aOdbierz zestaw"), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    if (isActive(u.getKit_start()) && !u.can(GroupType.ADMIN)) {
                        p.sendMessage(ChatUtil.fixColor(" &8>> &cKit GRACZ mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_start() - System.currentTimeMillis(), false)));
                        return;
                    }
                    final Item pickaxe = Item.get(274, Integer.valueOf(0), 1);
                    pickaxe.addEnchantment(Enchantment.get(Enchantment.ID_DURABILITY).setLevel(3));
                    final Item ec = Item.get(130, Integer.valueOf(0), 1);
                    final Item mieso = Item.get(320, Integer.valueOf(0), 64);
                    final Item drewno = Item.get(Item.WOOD, 0, 32);

                    final Item woda = Item.get(ItemID.BUCKET, 8, 1);
                    ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6GRACZ"));
                    p.getInventory().addItem(new Item[] { pickaxe });
                    p.getInventory().addItem(new Item[] { mieso });
                    p.getInventory().addItem(new Item[] { ec });
                    p.getInventory().addItem(new Item[] { drewno });
                    p.getInventory().addItem(new Item[] { woda });
                    u.setKit_start(System.currentTimeMillis() + TimeUtil.MINUTE.getTime(3));
                }
            });
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("kitPlayerKit", category);
        menu.setName(ChatUtil.fixColor("&9KIT GRACZ"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("kitPlayerKit", menu);
    }
    
    public static void openVipKit(final Player player) {
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final ItemData i = new ItemData(160, 11, 1, "&8#");
        final User u = UserManager.getUser(player);
        for (int ia = 0; ia < 9; ++ia) {
            category.addElement(ia, i);
        }
        final Item punch = Item.get(261, Integer.valueOf(0), 1);
        punch.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(21).setLevel(1) });
        punch.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
        final Item arrow = Item.get(262, Integer.valueOf(0), 64);
        final Item miecz32 = Item.get(267, Integer.valueOf(0), 1);
        miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
        miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(12).setLevel(2) });
        miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
        final Item miecz33 = Item.get(267, Integer.valueOf(0), 1);
        miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
        miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(13).setLevel(2) });
        miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
        final Item buty = Item.get(309, Integer.valueOf(0), 1);
        buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item klata = Item.get(307, Integer.valueOf(0), 1);
        klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item bania = Item.get(306, Integer.valueOf(0), 1);
        bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item spodnie = Item.get(308, Integer.valueOf(0), 1);
        spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item kilof = Item.get(278, Integer.valueOf(0), 1);
        kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(15).setLevel(5) });
        kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
        kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(18).setLevel(3) });
        final Item kox = Item.get(466, Integer.valueOf(0), 1);
        final Item refile = Item.get(322, Integer.valueOf(0), 8);
        final Item pa = Item.get(368, Integer.valueOf(0), 3);
        category.addElement(9, ItemData.fromItem(bania));
        category.addElement(10, ItemData.fromItem(klata));
        category.addElement(11, ItemData.fromItem(spodnie));
        category.addElement(12, ItemData.fromItem(buty));
        category.addElement(13, ItemData.fromItem(miecz32));
        category.addElement(14, ItemData.fromItem(kox));
        category.addElement(15, ItemData.fromItem(refile));
        category.addElement(16, ItemData.fromItem(pa));
        category.addElement(17, ItemData.fromItem(miecz33));
        category.addElement(18, ItemData.fromItem(kilof));
        category.addElement(19, ItemData.fromItem(punch));
        category.addElement(20, ItemData.fromItem(arrow));
        for (int ia2 = 36; ia2 < 52; ++ia2) {
            category.addElement(ia2, i);
        }
        category.addElement(52, new ItemData(351, 1, 1, "&4Powrot"), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                KitsGui.openKits(p);
            }
        });
        if (isActive(u.getKit_vip())) {
            category.addElement(53, new ItemData(351, 8, 1, "&cZestaw niedostepny czasowo"));
        }
        else {
            category.addElement(53, new ItemData(351, 10, 1, "&aOdbierz zestaw"), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    if (!c.getBoolean("enable.kits.status")) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                        return;
                    }
                    if (!u.can(GroupType.VIP)) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&cWymagana ranga: &3VIP"));
                        return;
                    }
                    if (isActive(u.getKit_vip()) && !u.can(GroupType.ADMIN)) {
                        p.sendMessage(ChatUtil.fixColor(" &8>> &cKit VIP mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_vip() - System.currentTimeMillis(), false)));
                        return;
                    }
                    ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6VIP"));
                    final Item miecz32 = Item.get(267, Integer.valueOf(0), 1);
                    miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
                    miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(12).setLevel(2) });
                    miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                    final Item miecz33 = Item.get(267, Integer.valueOf(0), 1);
                    miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
                    miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(13).setLevel(2) });
                    miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                    final Item buty = Item.get(309, Integer.valueOf(0), 1);
                    buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                    buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                    final Item klata = Item.get(307, Integer.valueOf(0), 1);
                    klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                    klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                    final Item bania = Item.get(306, Integer.valueOf(0), 1);
                    bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                    bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                    final Item spodnie = Item.get(308, Integer.valueOf(0), 1);
                    spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                    spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                    final Item kilof = Item.get(278, Integer.valueOf(0), 1);
                    kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(15).setLevel(5) });
                    kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                    kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(18).setLevel(3) });
                    final Item kox = Item.get(466, Integer.valueOf(0), 1);
                    final Item refile = Item.get(322, Integer.valueOf(0), 8);
                    final Item pa = Item.get(368, Integer.valueOf(0), 3);
                    final Item punch = Item.get(261, Integer.valueOf(0), 1);
                    punch.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(21).setLevel(1) });
                    punch.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                    final Item arrow = Item.get(262, Integer.valueOf(0), 64);
                    p.getInventory().addItem(new Item[] { miecz33 });
                    p.getInventory().addItem(new Item[] { miecz32 });
                    p.getInventory().addItem(new Item[] { bania });
                    p.getInventory().addItem(new Item[] { klata });
                    p.getInventory().addItem(new Item[] { spodnie });
                    p.getInventory().addItem(new Item[] { buty });
                    p.getInventory().addItem(new Item[] { kox });
                    p.getInventory().addItem(new Item[] { refile });
                    p.getInventory().addItem(new Item[] { pa });
                    p.getInventory().addItem(new Item[] { kilof });
                    p.getInventory().addItem(new Item[] { punch });
                    p.getInventory().addItem(new Item[] { arrow });
                    u.setKit_vip(System.currentTimeMillis() + TimeUtil.HOUR.getTime(6));
                }
            });
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("kitVIPKit", category);
        menu.setName(ChatUtil.fixColor("&9KIT VIP"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("kitVIPKit", menu);
    }
    
    public static void openSvipKit(final Player player) {
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final ItemData i = new ItemData(160, 11, 1, "&8#");
        final User u = UserManager.getUser(player);
        for (int ia = 0; ia < 9; ++ia) {
            category.addElement(ia, i);
        }
        final Item miecz32 = Item.get(267, Integer.valueOf(0), 1);
        miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
        miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(12).setLevel(2) });
        miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
        final Item miecz33 = Item.get(267, Integer.valueOf(0), 1);
        miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
        miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(13).setLevel(2) });
        miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
        final Item buty = Item.get(309, Integer.valueOf(0), 1);
        buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item klata = Item.get(307, Integer.valueOf(0), 1);
        klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item bania = Item.get(306, Integer.valueOf(0), 1);
        bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item spodnie = Item.get(308, Integer.valueOf(0), 1);
        spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item kilof = Item.get(278, Integer.valueOf(0), 1);
        kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(15).setLevel(5) });
        kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
        kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(18).setLevel(3) });
        final Item kox = Item.get(466, Integer.valueOf(0), 2);
        final Item refile = Item.get(322, Integer.valueOf(0), 16);
        final Item pa = Item.get(368, Integer.valueOf(0), 6);
        final Item punch = Item.get(261, Integer.valueOf(0), 1);
        punch.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(21).setLevel(1) });
        punch.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
        final Item arrow = Item.get(262, Integer.valueOf(0), 64);
        category.addElement(9, ItemData.fromItem(miecz33));
        category.addElement(10, ItemData.fromItem(bania));
        category.addElement(11, ItemData.fromItem(klata));
        category.addElement(12, ItemData.fromItem(spodnie));
        category.addElement(13, ItemData.fromItem(buty));
        category.addElement(14, ItemData.fromItem(miecz32));
        category.addElement(15, ItemData.fromItem(kox));
        category.addElement(16, ItemData.fromItem(refile));
        category.addElement(17, ItemData.fromItem(pa));
        category.addElement(18, ItemData.fromItem(miecz33));
        category.addElement(19, ItemData.fromItem(bania));
        category.addElement(20, ItemData.fromItem(klata));
        category.addElement(21, ItemData.fromItem(spodnie));
        category.addElement(22, ItemData.fromItem(buty));
        category.addElement(23, ItemData.fromItem(miecz32));
        category.addElement(24, ItemData.fromItem(kilof));
        category.addElement(25, ItemData.fromItem(kilof));
        category.addElement(26, ItemData.fromItem(punch));
        category.addElement(27, ItemData.fromItem(punch));
        category.addElement(28, ItemData.fromItem(arrow));
        category.addElement(29, ItemData.fromItem(arrow));
        for (int ia2 = 36; ia2 < 52; ++ia2) {
            category.addElement(ia2, i);
        }
        category.addElement(52, new ItemData(351, 1, 1, "&4Powrot"), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                KitsGui.openKits(p);
            }
        });
        if (isActive(u.getKit_svip())) {
            category.addElement(53, new ItemData(351, 8, 1, "&cZestaw niedostepny czasowo"));
        }
        else {
            category.addElement(53, new ItemData(351, 10, 1, "&aOdbierz zestaw"), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    if (!c.getBoolean("enable.kits.status")) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                        return;
                    }
                    if (!u.can(GroupType.SVIP)) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&cWymagana ranga: &3SVIP &8| &3YOUTUBE"));
                        return;
                    }
                    if (isActive(u.getKit_svip()) && !u.can(GroupType.ADMIN)) {
                        p.sendMessage(ChatUtil.fixColor(" &8>> &cKit SVIP mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_svip() - System.currentTimeMillis(), false)));
                        return;
                    }
                    ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6SVIP"));
                    final Item miecz32 = Item.get(267, Integer.valueOf(0), 1);
                    miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
                    miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(12).setLevel(2) });
                    miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                    final Item miecz33 = Item.get(267, Integer.valueOf(0), 1);
                    miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
                    miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(13).setLevel(2) });
                    miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                    final Item buty = Item.get(309, Integer.valueOf(0), 1);
                    buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                    buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                    final Item klata = Item.get(307, Integer.valueOf(0), 1);
                    klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                    klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                    final Item bania = Item.get(306, Integer.valueOf(0), 1);
                    bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                    bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                    final Item spodnie = Item.get(308, Integer.valueOf(0), 1);
                    spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                    spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                    final Item kilof = Item.get(278, Integer.valueOf(0), 1);
                    kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(15).setLevel(5) });
                    kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                    kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(18).setLevel(3) });
                    final Item kox = Item.get(466, Integer.valueOf(0), 2);
                    final Item refile = Item.get(322, Integer.valueOf(0), 16);
                    final Item pa = Item.get(368, Integer.valueOf(0), 6);
                    final Item punch = Item.get(261, Integer.valueOf(0), 1);
                    punch.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(21).setLevel(1) });
                    punch.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                    final Item arrow = Item.get(262, Integer.valueOf(0), 64);
                    p.getInventory().addItem(new Item[] { punch });
                    p.getInventory().addItem(new Item[] { punch });
                    p.getInventory().addItem(new Item[] { arrow });
                    p.getInventory().addItem(new Item[] { arrow });
                    p.getInventory().addItem(new Item[] { miecz33 });
                    p.getInventory().addItem(new Item[] { miecz32 });
                    p.getInventory().addItem(new Item[] { bania });
                    p.getInventory().addItem(new Item[] { klata });
                    p.getInventory().addItem(new Item[] { spodnie });
                    p.getInventory().addItem(new Item[] { buty });
                    p.getInventory().addItem(new Item[] { miecz33 });
                    p.getInventory().addItem(new Item[] { miecz32 });
                    p.getInventory().addItem(new Item[] { bania });
                    p.getInventory().addItem(new Item[] { klata });
                    p.getInventory().addItem(new Item[] { spodnie });
                    p.getInventory().addItem(new Item[] { buty });
                    p.getInventory().addItem(new Item[] { kox });
                    p.getInventory().addItem(new Item[] { refile });
                    p.getInventory().addItem(new Item[] { pa });
                    p.getInventory().addItem(new Item[] { kilof });
                    p.getInventory().addItem(new Item[] { kilof });
                    u.setKit_svip(System.currentTimeMillis() + TimeUtil.HOUR.getTime(6));
                }
            });
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("kitSVIPKit", category);
        menu.setName(ChatUtil.fixColor("&9KIT SVIP"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("kitSVIPKit", menu);
    }
    
    public static void openSponsor(final Player player) {
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final ItemData i = new ItemData(160, 11, 1, "&8#");
        final User u = UserManager.getUser(player);
        for (int ia = 0; ia < 9; ++ia) {
            category.addElement(ia, i);
        }
        final Item miecz32 = Item.get(267, Integer.valueOf(0), 1);
        miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
        miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(12).setLevel(2) });
        miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
        final Item miecz33 = Item.get(267, Integer.valueOf(0), 1);
        miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
        miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(13).setLevel(2) });
        miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
        final Item buty = Item.get(309, Integer.valueOf(0), 1);
        buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item klata = Item.get(307, Integer.valueOf(0), 1);
        klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item bania = Item.get(306, Integer.valueOf(0), 1);
        bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item spodnie = Item.get(308, Integer.valueOf(0), 1);
        spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item kilof = Item.get(278, Integer.valueOf(0), 1);
        kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(15).setLevel(5) });
        kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
        kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(18).setLevel(3) });
        final Item kox = Item.get(466, Integer.valueOf(0), 8);
        final Item refile = Item.get(322, Integer.valueOf(0), 64);
        final Item pa = Item.get(368, Integer.valueOf(0), 6);
        final Item punch = Item.get(261, Integer.valueOf(0), 1);
        punch.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(21).setLevel(1) });
        punch.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
        final Item arrow = Item.get(262, Integer.valueOf(0), 64);
        category.addElement(9, ItemData.fromItem(miecz33));
        category.addElement(10, ItemData.fromItem(bania));
        category.addElement(11, ItemData.fromItem(klata));
        category.addElement(12, ItemData.fromItem(spodnie));
        category.addElement(13, ItemData.fromItem(buty));
        category.addElement(14, ItemData.fromItem(miecz32));
        category.addElement(15, ItemData.fromItem(kox));
        category.addElement(16, ItemData.fromItem(refile));
        category.addElement(17, ItemData.fromItem(pa));
        category.addElement(18, ItemData.fromItem(miecz33));
        category.addElement(19, ItemData.fromItem(bania));
        category.addElement(20, ItemData.fromItem(klata));
        category.addElement(21, ItemData.fromItem(spodnie));
        category.addElement(22, ItemData.fromItem(buty));
        category.addElement(23, ItemData.fromItem(miecz32));
        category.addElement(24, ItemData.fromItem(kilof));
        category.addElement(25, ItemData.fromItem(kilof));
        category.addElement(26, ItemData.fromItem(kilof));
        category.addElement(27, ItemData.fromItem(miecz33));
        category.addElement(28, ItemData.fromItem(bania));
        category.addElement(29, ItemData.fromItem(klata));
        category.addElement(30, ItemData.fromItem(spodnie));
        category.addElement(31, ItemData.fromItem(buty));
        category.addElement(32, ItemData.fromItem(miecz32));
        category.addElement(33, ItemData.fromItem(punch));
        category.addElement(34, ItemData.fromItem(punch));
        category.addElement(35, ItemData.fromItem(punch));
        category.addElement(36, ItemData.fromItem(arrow));
        category.addElement(37, ItemData.fromItem(arrow));
        category.addElement(38, ItemData.fromItem(arrow));
        for (int ia2 = 39; ia2 < 52; ++ia2) {
            category.addElement(ia2, i);
        }
        category.addElement(52, new ItemData(351, 1, 1, "&4Powrot"), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                KitsGui.openKits(p);
            }
        });
        if (isActive(u.getKit_yt())) {
            category.addElement(53, new ItemData(351, 8, 1, "&cZestaw niedostepny czasowo"));
        }
        else {
            category.addElement(53, new ItemData(351, 10, 1, "&aOdbierz zestaw"), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    if (!c.getBoolean("enable.kits.status")) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                        return;
                    }
                    if (!u.can(GroupType.SPONSOR)) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&cWymagana ranga: &3SPONSOR"));
                        return;
                    }
                    if (isActive(u.getKit_yt()) && !u.can(GroupType.ADMIN)) {
                        p.sendMessage(ChatUtil.fixColor(" &8>> &cKit SPONSOR mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_yt() - System.currentTimeMillis(), false)));
                        return;
                    }
                    ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6SPONSOR"));
                    final Item miecz32 = Item.get(267, Integer.valueOf(0), 1);
                    miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
                    miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(12).setLevel(2) });
                    miecz32.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                    final Item miecz33 = Item.get(267, Integer.valueOf(0), 1);
                    miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
                    miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(13).setLevel(2) });
                    miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                    final Item buty = Item.get(309, Integer.valueOf(0), 1);
                    buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                    buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                    final Item klata = Item.get(307, Integer.valueOf(0), 1);
                    klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                    klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                    final Item bania = Item.get(306, Integer.valueOf(0), 1);
                    bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                    bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                    final Item spodnie = Item.get(308, Integer.valueOf(0), 1);
                    spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                    spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                    final Item kilof = Item.get(278, Integer.valueOf(0), 1);
                    kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(15).setLevel(5) });
                    kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                    kilof.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(18).setLevel(3) });
                    final Item kox = Item.get(466, Integer.valueOf(0), 8);
                    final Item refile = Item.get(322, Integer.valueOf(0), 64);
                    final Item pa = Item.get(368, Integer.valueOf(0), 6);
                    final Item punch = Item.get(261, Integer.valueOf(0), 1);
                    punch.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(21).setLevel(1) });
                    punch.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                    final Item arrow = Item.get(262, Integer.valueOf(0), 64);
                    p.getInventory().addItem(new Item[] { punch });
                    p.getInventory().addItem(new Item[] { punch });
                    p.getInventory().addItem(new Item[] { punch });
                    p.getInventory().addItem(new Item[] { arrow });
                    p.getInventory().addItem(new Item[] { arrow });
                    p.getInventory().addItem(new Item[] { arrow });
                    p.getInventory().addItem(new Item[] { miecz33 });
                    p.getInventory().addItem(new Item[] { miecz32 });
                    p.getInventory().addItem(new Item[] { bania });
                    p.getInventory().addItem(new Item[] { klata });
                    p.getInventory().addItem(new Item[] { spodnie });
                    p.getInventory().addItem(new Item[] { buty });
                    p.getInventory().addItem(new Item[] { miecz33 });
                    p.getInventory().addItem(new Item[] { miecz32 });
                    p.getInventory().addItem(new Item[] { bania });
                    p.getInventory().addItem(new Item[] { klata });
                    p.getInventory().addItem(new Item[] { spodnie });
                    p.getInventory().addItem(new Item[] { buty });
                    p.getInventory().addItem(new Item[] { miecz33 });
                    p.getInventory().addItem(new Item[] { miecz32 });
                    p.getInventory().addItem(new Item[] { bania });
                    p.getInventory().addItem(new Item[] { klata });
                    p.getInventory().addItem(new Item[] { spodnie });
                    p.getInventory().addItem(new Item[] { buty });
                    p.getInventory().addItem(new Item[] { kox });
                    p.getInventory().addItem(new Item[] { refile });
                    p.getInventory().addItem(new Item[] { pa });
                    p.getInventory().addItem(new Item[] { kilof });
                    p.getInventory().addItem(new Item[] { kilof });
                    p.getInventory().addItem(new Item[] { kilof });
                    u.setKit_yt(System.currentTimeMillis() + TimeUtil.HOUR.getTime(6));
                }
            });
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("kitSPONSORkit", category);
        menu.setName(ChatUtil.fixColor("&9KIT SPONSOR"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("kitSPONSORkit", menu);
    }
}
