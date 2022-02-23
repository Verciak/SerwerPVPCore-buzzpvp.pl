
package pl.vertty.arivi.gui.user;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.MainConstants;
import pl.vertty.arivi.drop.pierozek.PierozekManager;
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
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();

        category.setSmallServerGui();

        category.addElement(10, new ItemData(320, 0, 1, "&r&9MIESO", new String[] { ChatUtil.fixColor("&r&8» &7Dostepny dla rangi: &ePLAYER"), ChatUtil.fixColor("&r&8» &7Czas: &f1 minute"), "&r", ChatUtil.fixColor("&r&8» &7Kliknij, aby wyswietlic przedmioty w zestawie!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> KitsGui.openMiesoKit(player), 15);

            }
        });

        category.addElement(11, new ItemData(299, 0, 1, "&r&9GRACZ", new String[] { ChatUtil.fixColor("&r&8» &7Dostepny dla rangi: &ePLAYER"), ChatUtil.fixColor("&r&8» &7Czas: &f3 minuty"), "&r", ChatUtil.fixColor("&r&8» &7Kliknij, aby wyswietlic przedmioty w zestawie!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> KitsGui.openPlayerKit(player), 15);
            }
        });


        category.addElement(12, ItemData.fromItem(MainConstants.BLACK_GLASS));

        category.addElement(13, new ItemData(315, 0, 1, "&r&9VIP", new String[] { ChatUtil.fixColor("&r&8» &7Dostepny dla rangi: &eVIP"), ChatUtil.fixColor("&r&8» &7Czas: &f12 godzin"), "&r", ChatUtil.fixColor("&r&8» &7Kliknij, aby wyswietlic przedmioty w zestawie!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> KitsGui.openVipKit(player), 15);

            }
        });

        category.addElement(14, new ItemData(307, 0, 1, "&r&9SVIP", new String[] { ChatUtil.fixColor("&r&8» &7Dostepny dla rangi: &eSVIP"), ChatUtil.fixColor("&r&8» &7Czas: &f12 godzin"), "&r", ChatUtil.fixColor("&r&8» &7Kliknij, aby wyswietlic przedmioty w zestawie!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> KitsGui.openSvipKit(player), 15);

            }
        });

        category.addElement(15, new ItemData(311, 0, 1, "&r&9SPONSOR", new String[] { ChatUtil.fixColor("&r&8» &7Dostepny dla rangi: &eSPONSOR"), ChatUtil.fixColor("&r&8» &7Czas: &f12 godzin"), "&r", ChatUtil.fixColor("&r&8» &7Kliknij, aby wyswietlic przedmioty w zestawie!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> KitsGui.openSponsor(player), 15);

            }
        });

        category.addElement(16, new ItemData(46, 0, 1, "&r&9TNT", new String[] { ChatUtil.fixColor("&r&8» &7Dostepny dla rangi: &eSPONSOR"), ChatUtil.fixColor("&r&8» &7Czas: &f24 godziny"), "&r", ChatUtil.fixColor("&r&8» &7Kliknij, aby wyswietlic przedmioty w zestawie!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> KitsGui.openTNT(player), 15);

            }
        });

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
        final User u = UserManager.getUser(player);

        category.setDoubleKitServerGui();
        final ItemData tnt = new ItemData(46, 0, 64);
        final Item rzucak = new Item(46, 0, 3);
        rzucak.addEnchantment(Enchantment.get(Enchantment.ID_DURABILITY));
        rzucak.setCustomName(ChatUtil.fixColor("&r&9RZUCANETNT"));

        category.addElement(9, tnt);
        category.addElement(10, tnt);
        category.addElement(11, tnt);
        category.addElement(12, tnt);
        category.addElement(13, ItemData.fromItem(rzucak));

        category.addElement(46, new ItemData(351, 1, 1, "&r&4POWROT"), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> KitsGui.openKits(player), 15);
            }
        });


        if(u.can(GroupType.ROOT)){
            category.addElement(52, new ItemData(351, 10, 1, "&r&aODBIERZ ZESTAW"), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    if (!c.getBoolean("enable.kits.status")) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                        menu.forceDestroy(player);
                        return;
                    }
                    if (!u.can(GroupType.SPONSOR)) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&cWymagana ranga: &3SPONSOR"));
                        menu.forceDestroy(player);
                        return;
                    }
                    if (isActive(u.getKit_tnt()) && !u.can(GroupType.ADMIN)) {
                        p.sendMessage(ChatUtil.fixColor(" &8>> &cKit TNT mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_tnt() - System.currentTimeMillis(), false)));
                        menu.forceDestroy(player);
                        return;
                    }
                    final Item tnt = Item.get(46, 0, 64);
                    ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6TNT"));

                    final Item rzucak = new Item(46, 0, 3);
                    rzucak.addEnchantment(Enchantment.get(Enchantment.ID_DURABILITY));
                    rzucak.setCustomName(ChatUtil.fixColor("&r&9RZUCANETNT"));

                    p.getInventory().addItem(tnt);
                    p.getInventory().addItem(tnt);
                    p.getInventory().addItem(tnt);
                    p.getInventory().addItem(tnt);
                    p.getInventory().addItem(rzucak);
                    u.setKit_tnt(System.currentTimeMillis() + TimeUtil.HOUR.getTime(24));
                    menu.forceDestroy(player);
                }
            });
        }else {
            if (isActive(u.getKit_tnt())) {
                category.addElement(52, new ItemData(351, 8, 1, "&r&cZESTAW NIEDOSTEPNY CZASOWO"));
            }
            else {
                category.addElement(52, new ItemData(351, 10, 1, "&r&aODBIERZ ZESTAW"), new ItemClick() {
                    @Override
                    public void onClick(final Player p, final Item item) {
                        if (!c.getBoolean("enable.kits.status")) {
                            ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                            menu.forceDestroy(player);
                            return;
                        }
                        if (!u.can(GroupType.SPONSOR)) {
                            ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&cWymagana ranga: &3SPONSOR"));
                            menu.forceDestroy(player);
                            return;
                        }
                        if (isActive(u.getKit_tnt()) && !u.can(GroupType.ADMIN)) {
                            p.sendMessage(ChatUtil.fixColor(" &8>> &cKit TNT mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_tnt() - System.currentTimeMillis(), false)));
                            menu.forceDestroy(player);
                            return;
                        }
                        final Item tnt = Item.get(46, 0, 64);
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6TNT"));

                        final Item rzucak = new Item(46, 0, 3);
                        rzucak.addEnchantment(Enchantment.get(Enchantment.ID_DURABILITY));
                        rzucak.setCustomName(ChatUtil.fixColor("&r&9RZUCANETNT"));

                        p.getInventory().addItem(tnt);
                        p.getInventory().addItem(tnt);
                        p.getInventory().addItem(tnt);
                        p.getInventory().addItem(tnt);
                        p.getInventory().addItem(rzucak);
                        u.setKit_tnt(System.currentTimeMillis() + TimeUtil.HOUR.getTime(24));
                        menu.forceDestroy(player);
                    }
                });
            }
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("kittntKit", category);
        menu.setName(ChatUtil.fixColor("&9KIT TNT"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("kittntKit", menu);
    }

    public static void openVipKit(final Player player) {
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final User u = UserManager.getUser(player);

        category.setDoubleKitServerGui();
        final Item punch = Item.get(261, 0, 1);
        punch.addEnchantment(Enchantment.getEnchantment(21).setLevel(1));
        punch.addEnchantment(Enchantment.getEnchantment(17).setLevel(3));

        final Item arrow = Item.get(262, 0, 64);

        final Item knock = Item.get(267, 0, 1);
        knock.addEnchantment(Enchantment.getEnchantment(9).setLevel(3));
        knock.addEnchantment(Enchantment.getEnchantment(12).setLevel(2));
        knock.addEnchantment(Enchantment.getEnchantment(17).setLevel(3));

        final Item sharp = Item.get(267, 0, 1);
        sharp.addEnchantment(Enchantment.getEnchantment(9).setLevel(3));
        sharp.addEnchantment(Enchantment.getEnchantment(13).setLevel(2));
        sharp.addEnchantment(Enchantment.getEnchantment(17).setLevel(3));

        final Item buty = Item.get(309, 0, 1);
        buty.addEnchantment(Enchantment.getEnchantment(0).setLevel(4));
        buty.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));

        final Item klata = Item.get(307, 0, 1);
        klata.addEnchantment(Enchantment.getEnchantment(0).setLevel(4));
        klata.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));

        final Item bania = Item.get(306, 0, 1);
        bania.addEnchantment(Enchantment.getEnchantment(0).setLevel(4));
        bania.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));

        final Item spodnie = Item.get(308, 0, 1);
        spodnie.addEnchantment(Enchantment.getEnchantment(0).setLevel(4));
        spodnie.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));

        final Item kilof = Item.get(278, 0, 1);
        kilof.addEnchantment(Enchantment.getEnchantment(15).setLevel(5));
        kilof.addEnchantment(Enchantment.getEnchantment(17).setLevel(3));
        kilof.addEnchantment(Enchantment.getEnchantment(18).setLevel(3));

        final Item kox = Item.get(466, 0, 2);
        final Item refile = Item.get(322, 0, 16);
        final Item perly = Item.get(368, 0, 4);
        final Item sniezki = Item.get(332, 0, 16);

        final Item pandora = PierozekManager.getPandoreItem();
        pandora.setCount(1);
        category.addElement(9, ItemData.fromItem(sharp));
        category.addElement(10, ItemData.fromItem(bania));
        category.addElement(11, ItemData.fromItem(klata));
        category.addElement(12, ItemData.fromItem(spodnie));
        category.addElement(13, ItemData.fromItem(buty));
        category.addElement(14, ItemData.fromItem(knock));
        category.addElement(15, ItemData.fromItem(kilof));
        category.addElement(16, ItemData.fromItem(punch));
        category.addElement(17, ItemData.fromItem(arrow));
        category.addElement(18, ItemData.fromItem(kox));
        category.addElement(19, ItemData.fromItem(refile));
        category.addElement(20, ItemData.fromItem(sniezki));
        category.addElement(21, ItemData.fromItem(perly));
        category.addElement(26, ItemData.fromItem(pandora));

        category.addElement(46, new ItemData(351, 1, 1, "&r&4POWROT"), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> KitsGui.openKits(player), 15);
            }
        });

        if(u.can(GroupType.ROOT)){
            category.addElement(52, new ItemData(351, 10, 1, "&r&aODBIERZ ZESTAW"), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    if (!c.getBoolean("enable.kits.status")) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                        menu.forceDestroy(player);
                        return;
                    }
                    if (!u.can(GroupType.VIP)) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&cWymagana ranga: &3VIP"));
                        menu.forceDestroy(player);
                        return;
                    }
                    if (isActive(u.getKit_vip()) && !u.can(GroupType.ADMIN)) {
                        p.sendMessage(ChatUtil.fixColor(" &8>> &cKit VIP mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_vip() - System.currentTimeMillis(), false)));
                        menu.forceDestroy(player);
                        return;
                    }
                    ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6VIP"));

                    p.getInventory().addItem(sharp);
                    p.getInventory().addItem(bania);
                    p.getInventory().addItem(klata);
                    p.getInventory().addItem(spodnie);
                    p.getInventory().addItem(buty);
                    p.getInventory().addItem(knock);
                    p.getInventory().addItem(kilof);
                    p.getInventory().addItem(punch);
                    p.getInventory().addItem(arrow);
                    p.getInventory().addItem(kox);
                    p.getInventory().addItem(refile);
                    p.getInventory().addItem(sniezki);
                    p.getInventory().addItem(perly);
                    p.getInventory().addItem(pandora);
                    u.setKit_vip(System.currentTimeMillis() + TimeUtil.HOUR.getTime(12));
                    menu.forceDestroy(player);
                }
            });
        }else {
            if (isActive(u.getKit_vip())) {
                category.addElement(52, new ItemData(351, 8, 1, "&r&cZESTAW NIEDOSTEPNY CZASOWO"));
            }
            else {
                category.addElement(52, new ItemData(351, 10, 1, "&r&aODBIERZ ZESTAW"), new ItemClick() {
                    @Override
                    public void onClick(final Player p, final Item item) {
                        if (!c.getBoolean("enable.kits.status")) {
                            ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                            menu.forceDestroy(player);
                            return;
                        }
                        if (!u.can(GroupType.VIP)) {
                            ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&cWymagana ranga: &3VIP"));
                            menu.forceDestroy(player);
                            return;
                        }
                        if (isActive(u.getKit_vip()) && !u.can(GroupType.ADMIN)) {
                            p.sendMessage(ChatUtil.fixColor(" &8>> &cKit VIP mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_vip() - System.currentTimeMillis(), false)));
                            menu.forceDestroy(player);
                            return;
                        }
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6VIP"));

                        p.getInventory().addItem(sharp);
                        p.getInventory().addItem(bania);
                        p.getInventory().addItem(klata);
                        p.getInventory().addItem(spodnie);
                        p.getInventory().addItem(buty);
                        p.getInventory().addItem(knock);
                        p.getInventory().addItem(kilof);
                        p.getInventory().addItem(punch);
                        p.getInventory().addItem(arrow);
                        p.getInventory().addItem(kox);
                        p.getInventory().addItem(refile);
                        p.getInventory().addItem(sniezki);
                        p.getInventory().addItem(perly);
                        p.getInventory().addItem(pandora);
                        u.setKit_vip(System.currentTimeMillis() + TimeUtil.HOUR.getTime(12));
                        menu.forceDestroy(player);
                    }
                });
            }
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("kitvipKit", category);
        menu.setName(ChatUtil.fixColor("&9KIT VIP"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("kitvipKit", menu);
    }



    public static void openSvipKit(final Player player) {
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final User u = UserManager.getUser(player);

        category.setDoubleKitServerGui();
        final Item punch = Item.get(261, 0, 1);
        punch.addEnchantment(Enchantment.getEnchantment(21).setLevel(1));
        punch.addEnchantment(Enchantment.getEnchantment(17).setLevel(3));

        final Item arrow = Item.get(262, 0, 64);

        final Item knock = Item.get(267, 0, 1);
        knock.addEnchantment(Enchantment.getEnchantment(9).setLevel(3));
        knock.addEnchantment(Enchantment.getEnchantment(12).setLevel(2));
        knock.addEnchantment(Enchantment.getEnchantment(17).setLevel(3));

        final Item sharp = Item.get(267, 0, 1);
        sharp.addEnchantment(Enchantment.getEnchantment(9).setLevel(3));
        sharp.addEnchantment(Enchantment.getEnchantment(13).setLevel(2));
        sharp.addEnchantment(Enchantment.getEnchantment(17).setLevel(3));

        final Item buty = Item.get(309, 0, 1);
        buty.addEnchantment(Enchantment.getEnchantment(0).setLevel(4));
        buty.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));

        final Item klata = Item.get(307, 0, 1);
        klata.addEnchantment(Enchantment.getEnchantment(0).setLevel(4));
        klata.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));

        final Item bania = Item.get(306, 0, 1);
        bania.addEnchantment(Enchantment.getEnchantment(0).setLevel(4));
        bania.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));

        final Item spodnie = Item.get(308, 0, 1);
        spodnie.addEnchantment(Enchantment.getEnchantment(0).setLevel(4));
        spodnie.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));

        final Item kilof = Item.get(278, 0, 1);
        kilof.addEnchantment(Enchantment.getEnchantment(15).setLevel(5));
        kilof.addEnchantment(Enchantment.getEnchantment(17).setLevel(3));
        kilof.addEnchantment(Enchantment.getEnchantment(18).setLevel(3));

        final Item kox = Item.get(466, 0, 3);
        final Item refile = Item.get(322, 0, 24);
        final Item perly = Item.get(368, 0, 8);
        final Item sniezki = Item.get(332, 0, 16);

        final Item pandora = PierozekManager.getPandoreItem();
        pandora.setCount(3);
        category.addElement(9, ItemData.fromItem(sharp));
        category.addElement(10, ItemData.fromItem(bania));
        category.addElement(11, ItemData.fromItem(klata));
        category.addElement(12, ItemData.fromItem(spodnie));
        category.addElement(13, ItemData.fromItem(buty));
        category.addElement(14, ItemData.fromItem(knock));
        category.addElement(15, ItemData.fromItem(kilof));
        category.addElement(16, ItemData.fromItem(punch));
        category.addElement(17, ItemData.fromItem(arrow));
        category.addElement(18, ItemData.fromItem(sharp));
        category.addElement(19, ItemData.fromItem(bania));
        category.addElement(20, ItemData.fromItem(klata));
        category.addElement(21, ItemData.fromItem(spodnie));
        category.addElement(22, ItemData.fromItem(buty));
        category.addElement(23, ItemData.fromItem(knock));
        category.addElement(24, ItemData.fromItem(kilof));
        category.addElement(25, ItemData.fromItem(punch));
        category.addElement(26, ItemData.fromItem(arrow));


        category.addElement(27, ItemData.fromItem(kox));
        category.addElement(28, ItemData.fromItem(refile));
        category.addElement(29, ItemData.fromItem(perly));
        category.addElement(30, ItemData.fromItem(sniezki));
        category.addElement(31, ItemData.fromItem(sniezki));
        category.addElement(35, ItemData.fromItem(pandora));



        category.addElement(46, new ItemData(351, 1, 1, "&r&4POWROT"), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> KitsGui.openKits(player), 15);
            }
        });


        if(u.can(GroupType.ROOT)){
            category.addElement(52, new ItemData(351, 10, 1, "&r&aODBIERZ ZESTAW"), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    if (!c.getBoolean("enable.kits.status")) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                        menu.forceDestroy(player);
                        return;
                    }
                    if (!u.can(GroupType.SVIP)) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&cWymagana ranga: &3SVIP"));
                        menu.forceDestroy(player);
                        return;
                    }
                    if (isActive(u.getKit_svip()) && !u.can(GroupType.ADMIN)) {
                        p.sendMessage(ChatUtil.fixColor(" &8>> &cKit SVIP mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_svip() - System.currentTimeMillis(), false)));
                        menu.forceDestroy(player);
                        return;
                    }
                    ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6SVIP"));

                    p.getInventory().addItem(sharp);
                    p.getInventory().addItem(bania);
                    p.getInventory().addItem(klata);
                    p.getInventory().addItem(spodnie);
                    p.getInventory().addItem(buty);
                    p.getInventory().addItem(knock);
                    p.getInventory().addItem(kilof);
                    p.getInventory().addItem(punch);
                    p.getInventory().addItem(arrow);
                    p.getInventory().addItem(sharp);
                    p.getInventory().addItem(bania);
                    p.getInventory().addItem(klata);
                    p.getInventory().addItem(spodnie);
                    p.getInventory().addItem(buty);
                    p.getInventory().addItem(knock);
                    p.getInventory().addItem(kilof);
                    p.getInventory().addItem(punch);
                    p.getInventory().addItem(arrow);
                    p.getInventory().addItem(kox);
                    p.getInventory().addItem(refile);
                    p.getInventory().addItem(sniezki);
                    p.getInventory().addItem(sniezki);
                    p.getInventory().addItem(perly);
                    p.getInventory().addItem(pandora);
                    u.setKit_svip(System.currentTimeMillis() + TimeUtil.HOUR.getTime(12));
                    menu.forceDestroy(player);
                }
            });
        }else {
            if (isActive(u.getKit_svip())) {
                category.addElement(52, new ItemData(351, 8, 1, "&r&cZESTAW NIEDOSTEPNY CZASOWO"));
            }
            else {
                category.addElement(52, new ItemData(351, 10, 1, "&r&aODBIERZ ZESTAW"), new ItemClick() {
                    @Override
                    public void onClick(final Player p, final Item item) {
                        if (!c.getBoolean("enable.kits.status")) {
                            ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                            menu.forceDestroy(player);
                            return;
                        }
                        if (!u.can(GroupType.SVIP)) {
                            ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&cWymagana ranga: &3SVIP"));
                            menu.forceDestroy(player);
                            return;
                        }
                        if (isActive(u.getKit_svip()) && !u.can(GroupType.ADMIN)) {
                            p.sendMessage(ChatUtil.fixColor(" &8>> &cKit SVIP mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_svip() - System.currentTimeMillis(), false)));
                            menu.forceDestroy(player);
                            return;
                        }
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6SVIP"));

                        p.getInventory().addItem(sharp);
                        p.getInventory().addItem(bania);
                        p.getInventory().addItem(klata);
                        p.getInventory().addItem(spodnie);
                        p.getInventory().addItem(buty);
                        p.getInventory().addItem(knock);
                        p.getInventory().addItem(kilof);
                        p.getInventory().addItem(punch);
                        p.getInventory().addItem(arrow);
                        p.getInventory().addItem(sharp);
                        p.getInventory().addItem(bania);
                        p.getInventory().addItem(klata);
                        p.getInventory().addItem(spodnie);
                        p.getInventory().addItem(buty);
                        p.getInventory().addItem(knock);
                        p.getInventory().addItem(kilof);
                        p.getInventory().addItem(punch);
                        p.getInventory().addItem(arrow);
                        p.getInventory().addItem(kox);
                        p.getInventory().addItem(refile);
                        p.getInventory().addItem(sniezki);
                        p.getInventory().addItem(sniezki);
                        p.getInventory().addItem(perly);
                        p.getInventory().addItem(pandora);
                        u.setKit_svip(System.currentTimeMillis() + TimeUtil.HOUR.getTime(12));
                        menu.forceDestroy(player);
                    }
                });
            }
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("kitsvipKit", category);
        menu.setName(ChatUtil.fixColor("&9KIT SVIP"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("kitsvipKit", menu);
    }



    public static void openSponsor(final Player player) {
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final User u = UserManager.getUser(player);

        category.setDoubleKitServerGui();
        final Item punch = Item.get(261, 0, 1);
        punch.addEnchantment(Enchantment.getEnchantment(21).setLevel(1));
        punch.addEnchantment(Enchantment.getEnchantment(17).setLevel(3));

        final Item arrow = Item.get(262, 0, 64);

        final Item knock = Item.get(267, 0, 1);
        knock.addEnchantment(Enchantment.getEnchantment(9).setLevel(3));
        knock.addEnchantment(Enchantment.getEnchantment(12).setLevel(2));
        knock.addEnchantment(Enchantment.getEnchantment(17).setLevel(3));

        final Item sharp = Item.get(267, 0, 1);
        sharp.addEnchantment(Enchantment.getEnchantment(9).setLevel(3));
        sharp.addEnchantment(Enchantment.getEnchantment(13).setLevel(2));
        sharp.addEnchantment(Enchantment.getEnchantment(17).setLevel(3));

        final Item buty = Item.get(309, 0, 1);
        buty.addEnchantment(Enchantment.getEnchantment(0).setLevel(4));
        buty.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));

        final Item klata = Item.get(307, 0, 1);
        klata.addEnchantment(Enchantment.getEnchantment(0).setLevel(4));
        klata.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));

        final Item bania = Item.get(306, 0, 1);
        bania.addEnchantment(Enchantment.getEnchantment(0).setLevel(4));
        bania.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));

        final Item spodnie = Item.get(308, 0, 1);
        spodnie.addEnchantment(Enchantment.getEnchantment(0).setLevel(4));
        spodnie.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));

        final Item kilof = Item.get(278, 0, 1);
        kilof.addEnchantment(Enchantment.getEnchantment(15).setLevel(5));
        kilof.addEnchantment(Enchantment.getEnchantment(17).setLevel(3));
        kilof.addEnchantment(Enchantment.getEnchantment(18).setLevel(3));

        final Item kox = Item.get(466, 0, 6);
        final Item refile = Item.get(322, 0, 32);
        final Item perly = Item.get(368, 0, 14);
        final Item sniezki = Item.get(332, 0, 16);

        final Item pandora = PierozekManager.getPandoreItem();
        pandora.setCount(5);
        category.addElement(9, ItemData.fromItem(sharp));
        category.addElement(10, ItemData.fromItem(bania));
        category.addElement(11, ItemData.fromItem(klata));
        category.addElement(12, ItemData.fromItem(spodnie));
        category.addElement(13, ItemData.fromItem(buty));
        category.addElement(14, ItemData.fromItem(knock));
        category.addElement(15, ItemData.fromItem(kilof));
        category.addElement(16, ItemData.fromItem(punch));
        category.addElement(17, ItemData.fromItem(arrow));
        category.addElement(18, ItemData.fromItem(sharp));
        category.addElement(19, ItemData.fromItem(bania));
        category.addElement(20, ItemData.fromItem(klata));
        category.addElement(21, ItemData.fromItem(spodnie));
        category.addElement(22, ItemData.fromItem(buty));
        category.addElement(23, ItemData.fromItem(knock));
        category.addElement(24, ItemData.fromItem(kilof));
        category.addElement(25, ItemData.fromItem(punch));
        category.addElement(26, ItemData.fromItem(arrow));
        category.addElement(27, ItemData.fromItem(sharp));
        category.addElement(28, ItemData.fromItem(bania));
        category.addElement(29, ItemData.fromItem(klata));
        category.addElement(30, ItemData.fromItem(spodnie));
        category.addElement(31, ItemData.fromItem(buty));
        category.addElement(32, ItemData.fromItem(knock));
        category.addElement(33, ItemData.fromItem(kilof));
        category.addElement(34, ItemData.fromItem(punch));
        category.addElement(35, ItemData.fromItem(arrow));


        category.addElement(36, ItemData.fromItem(kox));
        category.addElement(37, ItemData.fromItem(refile));
        category.addElement(38, ItemData.fromItem(perly));
        category.addElement(39, ItemData.fromItem(sniezki));
        category.addElement(40, ItemData.fromItem(sniezki));
        category.addElement(41, ItemData.fromItem(sniezki));
        category.addElement(44, ItemData.fromItem(pandora));



        category.addElement(46, new ItemData(351, 1, 1, "&r&4POWROT"), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> KitsGui.openKits(player), 15);
            }
        });


        if(u.can(GroupType.ROOT)){
            category.addElement(52, new ItemData(351, 10, 1, "&r&aODBIERZ ZESTAW"), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    if (!c.getBoolean("enable.kits.status")) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                        menu.forceDestroy(player);
                        return;
                    }
                    if (!u.can(GroupType.SPONSOR)) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&cWymagana ranga: &3SPONSOR"));
                        menu.forceDestroy(player);
                        return;
                    }
                    if (isActive(u.getKit_yt()) && !u.can(GroupType.ADMIN)) {
                        p.sendMessage(ChatUtil.fixColor(" &8>> &cKit SPONSOR mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_yt() - System.currentTimeMillis(), false)));
                        menu.forceDestroy(player);
                        return;
                    }
                    ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6SPONSOR"));

                    p.getInventory().addItem(sharp);
                    p.getInventory().addItem(bania);
                    p.getInventory().addItem(klata);
                    p.getInventory().addItem(spodnie);
                    p.getInventory().addItem(buty);
                    p.getInventory().addItem(knock);
                    p.getInventory().addItem(kilof);
                    p.getInventory().addItem(punch);
                    p.getInventory().addItem(arrow);
                    p.getInventory().addItem(sharp);
                    p.getInventory().addItem(bania);
                    p.getInventory().addItem(klata);
                    p.getInventory().addItem(spodnie);
                    p.getInventory().addItem(buty);
                    p.getInventory().addItem(knock);
                    p.getInventory().addItem(kilof);
                    p.getInventory().addItem(punch);
                    p.getInventory().addItem(arrow);
                    p.getInventory().addItem(sharp);
                    p.getInventory().addItem(bania);
                    p.getInventory().addItem(klata);
                    p.getInventory().addItem(spodnie);
                    p.getInventory().addItem(buty);
                    p.getInventory().addItem(knock);
                    p.getInventory().addItem(kilof);
                    p.getInventory().addItem(punch);
                    p.getInventory().addItem(arrow);
                    p.getInventory().addItem(kox);
                    p.getInventory().addItem(refile);
                    p.getInventory().addItem(sniezki);
                    p.getInventory().addItem(sniezki);
                    p.getInventory().addItem(sniezki);
                    p.getInventory().addItem(perly);
                    p.getInventory().addItem(pandora);
                    u.setKit_yt(System.currentTimeMillis() + TimeUtil.HOUR.getTime(12));
                    menu.forceDestroy(player);
                }
            });
        }else {
            if (isActive(u.getKit_yt())) {
                category.addElement(52, new ItemData(351, 8, 1, "&r&cZESTAW NIEDOSTEPNY CZASOWO"));
            }
            else {
                category.addElement(52, new ItemData(351, 10, 1, "&r&aODBIERZ ZESTAW"), new ItemClick() {
                    @Override
                    public void onClick(final Player p, final Item item) {
                        if (!c.getBoolean("enable.kits.status")) {
                            ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                            menu.forceDestroy(player);
                            return;
                        }
                        if (!u.can(GroupType.SPONSOR)) {
                            ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&cWymagana ranga: &3SPONSOR"));
                            menu.forceDestroy(player);
                            return;
                        }
                        if (isActive(u.getKit_yt()) && !u.can(GroupType.ADMIN)) {
                            p.sendMessage(ChatUtil.fixColor(" &8>> &cKit SPONSOR mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_yt() - System.currentTimeMillis(), false)));
                            menu.forceDestroy(player);
                            return;
                        }
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6SPONSOR"));

                        p.getInventory().addItem(sharp);
                        p.getInventory().addItem(bania);
                        p.getInventory().addItem(klata);
                        p.getInventory().addItem(spodnie);
                        p.getInventory().addItem(buty);
                        p.getInventory().addItem(knock);
                        p.getInventory().addItem(kilof);
                        p.getInventory().addItem(punch);
                        p.getInventory().addItem(arrow);
                        p.getInventory().addItem(sharp);
                        p.getInventory().addItem(bania);
                        p.getInventory().addItem(klata);
                        p.getInventory().addItem(spodnie);
                        p.getInventory().addItem(buty);
                        p.getInventory().addItem(knock);
                        p.getInventory().addItem(kilof);
                        p.getInventory().addItem(punch);
                        p.getInventory().addItem(arrow);
                        p.getInventory().addItem(sharp);
                        p.getInventory().addItem(bania);
                        p.getInventory().addItem(klata);
                        p.getInventory().addItem(spodnie);
                        p.getInventory().addItem(buty);
                        p.getInventory().addItem(knock);
                        p.getInventory().addItem(kilof);
                        p.getInventory().addItem(punch);
                        p.getInventory().addItem(arrow);
                        p.getInventory().addItem(kox);
                        p.getInventory().addItem(refile);
                        p.getInventory().addItem(sniezki);
                        p.getInventory().addItem(sniezki);
                        p.getInventory().addItem(sniezki);
                        p.getInventory().addItem(perly);
                        p.getInventory().addItem(pandora);
                        u.setKit_yt(System.currentTimeMillis() + TimeUtil.HOUR.getTime(12));
                        menu.forceDestroy(player);
                    }
                });
            }
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("kitsponsorKit", category);
        menu.setName(ChatUtil.fixColor("&9KIT SPONSOR"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("kitsponsorKit", menu);
    }

    public static void openMiesoKit(final Player player) {
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final User u = UserManager.getUser(player);

        category.setDoubleKitServerGui();
        final Item mieso = Item.get(320, 0, 64);
        category.addElement(9, ItemData.fromItem(mieso));

        category.addElement(46, new ItemData(351, 1, 1, "&r&4POWROT"), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> KitsGui.openKits(player), 15);
            }
        });


        if(u.can(GroupType.ROOT)){
            category.addElement(52, new ItemData(351, 10, 1, "&r&aODBIERZ ZESTAW"), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    if (!c.getBoolean("enable.kits.status")) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                        menu.forceDestroy(player);
                        return;
                    }

                    if (isActive(u.getKit_mieso()) && !u.can(GroupType.ADMIN)) {
                        p.sendMessage(ChatUtil.fixColor(" &8>> &cKit MIESO mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_mieso() - System.currentTimeMillis(), false)));
                        menu.forceDestroy(player);
                        return;
                    }
                    ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6MIESO"));


                    p.getInventory().addItem(mieso);
                    u.setKit_mieso(System.currentTimeMillis() + TimeUtil.MINUTE.getTime(1));
                    menu.forceDestroy(player);
                }
            });
        }else {
            if (isActive(u.getKit_mieso())) {
                category.addElement(52, new ItemData(351, 8, 1, "&r&cZESTAW NIEDOSTEPNY CZASOWO"));
            }
            else {
                category.addElement(52, new ItemData(351, 10, 1, "&r&aODBIERZ ZESTAW"), new ItemClick() {
                    @Override
                    public void onClick(final Player p, final Item item) {
                        if (!c.getBoolean("enable.kits.status")) {
                            ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                            menu.forceDestroy(player);
                            return;
                        }

                        if (isActive(u.getKit_mieso()) && !u.can(GroupType.ADMIN)) {
                            p.sendMessage(ChatUtil.fixColor(" &8>> &cKit MIESO mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_mieso() - System.currentTimeMillis(), false)));
                            menu.forceDestroy(player);
                            return;
                        }
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6MIESO"));


                        p.getInventory().addItem(mieso);
                        u.setKit_mieso(System.currentTimeMillis() + TimeUtil.MINUTE.getTime(1));
                        menu.forceDestroy(player);
                    }
                });
            }
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("kitmiesokit", category);
        menu.setName(ChatUtil.fixColor("&9KIT MIESO"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("kitmiesokit", menu);
    }


    public static void openPlayerKit(final Player player) {
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final User u = UserManager.getUser(player);

        category.setDoubleKitServerGui();

        final Item kilof = Item.get(274, 0, 1);
        kilof.addEnchantment(Enchantment.get(Enchantment.ID_DURABILITY).setLevel(3));
        final Item ender = Item.get(130, 0, 1);
        final Item drewno = Item.get(Item.WOOD, 0, 32);
        final Item woda = Item.get(ItemID.BUCKET, 8, 1);

        category.addElement(9, ItemData.fromItem(kilof));
        category.addElement(10, ItemData.fromItem(ender));
        category.addElement(11, ItemData.fromItem(drewno));
        category.addElement(12, ItemData.fromItem(woda));

        category.addElement(46, new ItemData(351, 1, 1, "&r&4POWROT"), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> KitsGui.openKits(player), 15);
            }
        });


        if(u.can(GroupType.ROOT)){
            category.addElement(52, new ItemData(351, 10, 1, "&r&aODBIERZ ZESTAW"), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    if (!c.getBoolean("enable.kits.status")) {
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                        menu.forceDestroy(player);
                        return;
                    }

                    if (isActive(u.getKit_start()) && !u.can(GroupType.ADMIN)) {
                        p.sendMessage(ChatUtil.fixColor(" &8>> &cKit START mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_start() - System.currentTimeMillis(), false)));
                        menu.forceDestroy(player);
                        return;
                    }
                    ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6START"));


                    p.getInventory().addItem(kilof);
                    p.getInventory().addItem(ender);
                    p.getInventory().addItem(drewno);
                    p.getInventory().addItem(woda);
                    u.setKit_start(System.currentTimeMillis() + TimeUtil.MINUTE.getTime(3));
                    menu.forceDestroy(player);
                }
            });
        }else {
            if (isActive(u.getKit_start())) {
                category.addElement(52, new ItemData(351, 8, 1, "&r&cZESTAW NIEDOSTEPNY CZASOWO"));
            }
            else {
                category.addElement(52, new ItemData(351, 10, 1, "&r&aODBIERZ ZESTAW"), new ItemClick() {
                    @Override
                    public void onClick(final Player p, final Item item) {
                        if (!c.getBoolean("enable.kits.status")) {
                            ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor(c.getString("enable.kits.message")));
                            menu.forceDestroy(player);
                            return;
                        }

                        if (isActive(u.getKit_start()) && !u.can(GroupType.ADMIN)) {
                            p.sendMessage(ChatUtil.fixColor(" &8>> &cKit START mozesz odebrac dopiero za: &3" + DataUtil.parseLong(u.getKit_start() - System.currentTimeMillis(), false)));
                            menu.forceDestroy(player);
                            return;
                        }
                        ChatUtil.sendTitle(p, "&9KITY", ChatUtil.fixColor("&7Odebrales zestaw &6START"));


                        p.getInventory().addItem(kilof);
                        p.getInventory().addItem(ender);
                        p.getInventory().addItem(drewno);
                        p.getInventory().addItem(woda);
                        u.setKit_start(System.currentTimeMillis() + TimeUtil.MINUTE.getTime(3));
                        menu.forceDestroy(player);
                    }
                });
            }
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("kitstartkit", category);
        menu.setName(ChatUtil.fixColor("&9KIT GRACZ"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("kitstartkit", menu);
    }
}
