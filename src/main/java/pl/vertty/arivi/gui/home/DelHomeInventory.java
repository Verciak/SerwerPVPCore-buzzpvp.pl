// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui.home;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.level.Location;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.DyeColor;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;

public class DelHomeInventory
{
    public static void openDelHome(final Player player) {
        final User u = UserManager.getUser(player);
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final Item home1 = new Item(351, Integer.valueOf(DyeColor.LIME.getDyeData()), 1);
        home1.setCustomName(ChatUtil.fixColor("&9HOME 1 &8(&fKliknij, aby usunac dom!&8)"));
        final Item home2 = new Item(351, Integer.valueOf(DyeColor.LIME.getDyeData()), 1);
        home2.setCustomName(ChatUtil.fixColor("&9HOME 2 &8(&fKliknij, aby usunac dom!&8)"));
        final Item home3 = new Item(351, Integer.valueOf(DyeColor.LIME.getDyeData()), 1);
        home3.setCustomName(ChatUtil.fixColor("&9HOME 3 &8(&fKliknij, aby usunac dom!&8)"));
        final Item home4 = new Item(351, Integer.valueOf(DyeColor.LIME.getDyeData()), 1);
        home4.setCustomName(ChatUtil.fixColor("&9HOME 4 &8(&fKliknij, aby usunac dom!&8)"));
        final Item home5 = new Item(351, Integer.valueOf(DyeColor.LIME.getDyeData()), 1);
        home5.setCustomName(ChatUtil.fixColor("&9HOME 5 &8(&fKliknij, aby usunac dom!&8)"));
        final Item brak = new Item(351, Integer.valueOf(DyeColor.GRAY.getDyeData()), 1);
        brak.setCustomName(ChatUtil.fixColor("&cDostepne od rangi premium &8(&fSVIP&8)"));
        final Item nhome1 = new Item(351, Integer.valueOf(DyeColor.RED.getDyeData()), 1);
        nhome1.setCustomName(ChatUtil.fixColor("&9HOME 1 &8(&fKliknij, aby stworzyc!&8)"));
        final Item nhome2 = new Item(351, Integer.valueOf(DyeColor.RED.getDyeData()), 1);
        nhome2.setCustomName(ChatUtil.fixColor("&9HOME 2 &8(&fKliknij, aby stworzyc!&8)"));
        final Item nhome3 = new Item(351, Integer.valueOf(DyeColor.RED.getDyeData()), 1);
        nhome3.setCustomName(ChatUtil.fixColor("&9HOME 3 &8(&fKliknij, aby stworzyc!&8)"));
        final Item nhome4 = new Item(351, Integer.valueOf(DyeColor.RED.getDyeData()), 1);
        nhome4.setCustomName(ChatUtil.fixColor("&9HOME 4 &8(&fKliknij, aby stworzyc!&8)"));
        final Item nhome5 = new Item(351, Integer.valueOf(DyeColor.RED.getDyeData()), 1);
        nhome5.setCustomName(ChatUtil.fixColor("&9HOME 5 &8(&fKliknij, aby stworzyc!&8)"));
        if (u.getHome1().contains("0.0:0.0:0.0:0.0:0.0")) {
            category.addElement(11, ItemData.fromItem(nhome1), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    u.setHome1(p.getLocation());
                    ChatUtil.sendTitle(p, "&9HOME", "&6Pomyslnie ustawiono dom!");
                    DelHomeInventory.openDelHome(p);
                }
            });
        }
        else {
            category.addElement(11, ItemData.fromItem(home1), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    final Location loc = new Location(0.0, 0.0, 0.0, 0.0, 0.0);
                    loc.setComponents(0.0, 0.0, 0.0);
                    u.setHome1(loc);
                    ChatUtil.sendTitle(p, "&9HOME", "&6Pomyslnie usunieto dom!");
                    DelHomeInventory.openDelHome(p);
                }
            });
        }
        if (u.getHome2().contains("0.0:0.0:0.0:0.0:0.0")) {
            category.addElement(12, ItemData.fromItem(nhome2), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    u.setHome2(p.getLocation());
                    ChatUtil.sendTitle(p, "&9HOME", "&6Pomyslnie ustawiono dom!");
                    DelHomeInventory.openDelHome(p);
                }
            });
        }
        else {
            category.addElement(12, ItemData.fromItem(home2), new ItemClick() {
                @Override
                public void onClick(final Player p, final Item item) {
                    final Location loc = new Location(0.0, 0.0, 0.0, 0.0, 0.0);
                    loc.setComponents(0.0, 0.0, 0.0);
                    u.setHome2(loc);
                    ChatUtil.sendTitle(p, "&9HOME", "&6Pomyslnie usunieto dom!");
                    DelHomeInventory.openDelHome(p);
                }
            });
        }
        if (u.can(GroupType.VIP)) {
            if (u.getHome3().contains("0.0:0.0:0.0:0.0:0.0")) {
                category.addElement(13, ItemData.fromItem(nhome3), new ItemClick() {
                    @Override
                    public void onClick(final Player p, final Item item) {
                        u.setHome3(p.getLocation());
                        ChatUtil.sendTitle(p, "&9HOME", "&6Pomyslnie ustawiono dom!");
                        DelHomeInventory.openDelHome(p);
                    }
                });
            }
            else {
                category.addElement(13, ItemData.fromItem(home3), new ItemClick() {
                    @Override
                    public void onClick(final Player p, final Item item) {
                        final Location loc = new Location(0.0, 0.0, 0.0, 0.0, 0.0);
                        loc.setComponents(0.0, 0.0, 0.0);
                        u.setHome3(loc);
                        ChatUtil.sendTitle(p, "&9HOME", "&6Pomyslnie usunieto dom!");
                        DelHomeInventory.openDelHome(p);
                    }
                });
            }
        }
        if (u.can(GroupType.SVIP)) {
            if (u.getHome4().contains("0.0:0.0:0.0:0.0:0.0")) {
                category.addElement(14, ItemData.fromItem(nhome4), new ItemClick() {
                    @Override
                    public void onClick(final Player p, final Item item) {
                        u.setHome4(p.getLocation());
                        ChatUtil.sendTitle(p, "&9HOME", "&6Pomyslnie ustawiono dom!");
                        DelHomeInventory.openDelHome(p);
                    }
                });
            }
            else {
                category.addElement(14, ItemData.fromItem(home4), new ItemClick() {
                    @Override
                    public void onClick(final Player p, final Item item) {
                        final Location loc = new Location(0.0, 0.0, 0.0, 0.0, 0.0);
                        loc.setComponents(0.0, 0.0, 0.0);
                        u.setHome4(loc);
                        ChatUtil.sendTitle(p, "&9HOME", "&6Pomyslnie usunieto dom!");
                        DelHomeInventory.openDelHome(p);
                    }
                });
            }
            if (u.getHome5().contains("0.0:0.0:0.0:0.0:0.0")) {
                category.addElement(15, ItemData.fromItem(nhome5), new ItemClick() {
                    @Override
                    public void onClick(final Player p, final Item item) {
                        u.setHome5(p.getLocation());
                        ChatUtil.sendTitle(p, "&9HOME", "&6Pomyslnie ustawiono dom!");
                        DelHomeInventory.openDelHome(p);
                    }
                });
            }
            else {
                category.addElement(15, ItemData.fromItem(home5), new ItemClick() {
                    @Override
                    public void onClick(final Player p, final Item item) {
                        final Location loc = new Location(0.0, 0.0, 0.0, 0.0, 0.0);
                        loc.setComponents(0.0, 0.0, 0.0);
                        u.setHome5(loc);
                        ChatUtil.sendTitle(p, "&9HOME", "&6Pomyslnie usunieto dom!");
                        DelHomeInventory.openDelHome(p);
                    }
                });
            }
        }
        menu.setMainCategory(category);
        menu.addCategory("DelHomeInventory", category);
        menu.setName(ChatUtil.fixColor("&9DELHOME"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("DelHomeInventory", menu);
    }
}
