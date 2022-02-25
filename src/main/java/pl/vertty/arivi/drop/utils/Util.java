package pl.vertty.arivi.drop.utils;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.DyeColor;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.commands.user.CobblexCommand;
import pl.vertty.arivi.drop.base.Drop;
import pl.vertty.arivi.drop.base.User;
import pl.vertty.arivi.drop.base.utils.DropUtils;
import pl.vertty.arivi.drop.base.utils.UserUtils;
import pl.vertty.arivi.drop.pierozek.PierozekManager;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.ItemUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Util
{
    public static long turbo;
    public static long turbo_exp;


    public static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static void giveItemOnDeath(Player killer, Player p, Item... t) {
        Item[] returns = killer.getInventory().addItem(t.clone());
        List<Item> drops = new ArrayList<>();
        for (Item returned : returns) {
            int maxStackSize = returned.getMaxStackSize();
            if (returned.getCount() <= maxStackSize) {
                drops.add(returned);
            } else {
                while (returned.getCount() > maxStackSize) {
                    Item drop = returned.clone();
                    int toDrop = Math.min(returned.getCount(), maxStackSize);
                    drop.setCount(toDrop);
                    returned.setCount(returned.getCount() - toDrop);
                    drops.add(drop);
                }
                if (!returned.isNull())
                    drops.add(returned);
            }
        }
        for (Item drop : drops)
            p.dropItem(drop);
    }

    public static boolean isTurbo() {
        return Util.turbo > System.currentTimeMillis() || Util.turbo == -1L;
    }
    
    public static boolean isTurboExp() {
        return Util.turbo_exp > System.currentTimeMillis() || Util.turbo_exp == -1L;
    }
    
    public static void loadTurbo() {
        final Config c = Main.getPlugin().getConfig();
        Util.turbo = c.getLong("turbo");
        Util.turbo_exp = c.getLong("turbo-exp");
    }
    
    public static void saveTurbo() {
        final Config c = Main.getPlugin().getConfig();
        c.set("turbo", Util.turbo);
        c.set("turbo-exp", Util.turbo_exp);
        c.save();
    }
    
    public static void sendInfo(final String msg) {
        System.out.println(msg);
    }
    
    public static void sendError(final String msg) {
        System.out.println(msg);
    }
    
    public static void openStone(final Player player) {
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final User userdrop = UserUtils.get(player.getName());
        for (final Drop drop : DropUtils.getDrops()) {
            category.addElement(drop.getSlot(), ItemData.fromItem(new Item(drop.getItem().getId(), Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor(drop.getInvName())).setLore(new String[] { ChatUtil.fixColor(c.getString("drop.lore").replace(">>", "»").replace("{CHANCE}", Double.toString(drop.getChance())).replace("{HEIGHT}", (drop.getHeight() == 0) ? "Kazda" : Integer.toString(drop.getHeight())).replace("{LVL}", (drop.getLvl() == 0) ? "Brak" : Integer.toString(drop.getLvl())).replace("{FORTUNE}", drop.isFortune() ? "&awlaczone" : "&cwylaczone").replace("{ENABLE}", drop.getDisabled().contains(player.getName()) ? "&cwylaczony" : "&awlaczony").replace("{WYKOPANE}", String.valueOf(userdrop.getDrop(drop.getName()))).replace("{N}", "\n")) })), new ItemClick() {
                @Override
                public void onClick(final Player player, final Item item) {
                    final Drop drop = Drop.getInv(item.getCustomName());
                    if (drop == null) {
                        return;
                    }
                    if (drop.isDisabled(player.getName())) {
                        drop.enable(player.getName());
                        Util.openStone(player);
                    }
                    else {
                        drop.disable(player.getName());
                        Util.openStone(player);
                    }
                }
            });
        }
        final Item i = new Item(160, Integer.valueOf(15), 1);
        i.setCustomName(ChatUtil.fixColor("&8#"));
        for (int ia = 36; ia < 45; ++ia) {
            category.addElement(ia, ItemData.fromItem(i));
        }
        final Item on = new Item(351, Integer.valueOf(10), 1);
        on.setCustomName(ChatUtil.fixColor("&a&lWlacz Wszystkie Dropy"));
        final Item off = new Item(351, Integer.valueOf(1), 1);
        off.setCustomName(ChatUtil.fixColor("&4&lWylacz Wszystkie Dropy"));
        final Item cobble = new Item(4, Integer.valueOf(0), 1);
        cobble.setCustomName(ChatUtil.fixColor("&4&lCobblestone"));
        cobble.setLore(new String[] { ChatUtil.fixColor("&8>> &6Drop: " + (DropUtils.isCobble(player.getName()) ? "&awlaczony" : "&cwylaczony")) });
        final Item wiad = new Item(339, Integer.valueOf(0), 1);
        wiad.setCustomName(ChatUtil.fixColor("&4&lWiadomosci"));
        wiad.setLore(new String[] { ChatUtil.fixColor("&r&8>> &6Aktywne: " + (DropUtils.isMsg(player.getName()) ? "&aTak" : "&cNie")), ChatUtil.fixColor("&l&4BONUSY NA SERWERZE"), ChatUtil.fixColor("&r&8>> &6DROP: &7Aktywny: " + (isTurbo() ? TimeUtils.getDurationBreakdown(Util.turbo - System.currentTimeMillis()) : "&cnie")), ChatUtil.fixColor("&r&8>> &6EXP: &7Aktywny: " + (isTurboExp() ? TimeUtils.getDurationBreakdown(Util.turbo_exp - System.currentTimeMillis()) : "&cnie")), ChatUtil.fixColor("&l&4TWOJE BONUSY"), ChatUtil.fixColor("&r&8>> &6DROP: &7Aktywny: " + (userdrop.isTurbo() ? TimeUtils.getDurationBreakdown(userdrop.getTurbo() - System.currentTimeMillis()) : "&cnie")), ChatUtil.fixColor("&r&8>> &6EXP: &7Aktywny: " + (userdrop.isTurboExp() ? TimeUtils.getDurationBreakdown(userdrop.getTurboExp() - System.currentTimeMillis()) : "&cnie")) });
        final Item exp = new Item(384, Integer.valueOf(0), 1);
        exp.setCustomName(ChatUtil.fixColor("&4&lDOSWIADCZENIE"));
        exp.setLore(new String[] { ChatUtil.fixColor("&8>> &7STONE: &64"), ChatUtil.fixColor("&8>> &7OBSIDIAN: &612") });
        final Item chest = new Item(54, Integer.valueOf(0), 1);
        chest.setCustomName(ChatUtil.fixColor("&4&lDrop ze skrzynek"));
        final Item cx = new Item(48, Integer.valueOf(0), 1);
        cx.setCustomName(ChatUtil.fixColor("&4&lDrop z CobbleX"));
        final Item pierozek = new Item(122, Integer.valueOf(0), 1);
        pierozek.setCustomName(ChatUtil.fixColor("&4&lDrop z pierozkow"));
        category.addElement(45, ItemData.fromItem(on), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                for (final Drop d : DropUtils.getDrops()) {
                    d.enable(player.getName());
                    Util.openStone(player);
                }
            }
        });
        category.addElement(46, ItemData.fromItem(off), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                for (final Drop d : DropUtils.getDrops()) {
                    d.disable(player.getName());
                    Util.openStone(player);
                }
            }
        });
        category.addElement(47, ItemData.fromItem(i));
        category.addElement(48, ItemData.fromItem(cobble), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                if (DropUtils.isCobble(player.getName())) {
                    DropUtils.disableCobble(player.getName());
                    Util.openStone(player);
                }
                else {
                    DropUtils.enableCobble(player.getName());
                    Util.openStone(player);
                }
            }
        });
        category.addElement(49, ItemData.fromItem(wiad), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                if (DropUtils.isMsg(player.getName())) {
                    DropUtils.disableMsg(player.getName());
                    Util.openStone(player);
                }
                else {
                    DropUtils.enableMsg(player.getName());
                    Util.openStone(player);
                }
            }
        });
        category.addElement(50, ItemData.fromItem(exp));
        category.addElement(51, ItemData.fromItem(i));
        category.addElement(52, ItemData.fromItem(cx), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                Util.openCobbleX(p);
            }
        });
        category.addElement(53, ItemData.fromItem(pierozek), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                Util.openPierozek(p);
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("DropGUI", category);
        menu.setName(ChatUtil.fixColor(c.getString("inventory-from-stone")));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("DropGUI", menu);
    }

    public static void openPierozek(final Player player) {
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final Item i = new Item(160, Integer.valueOf(1), 1);
        i.setCustomName(ChatUtil.fixColor("&8#"));
        for (int ia = 0; ia < 18; ++ia) {
            category.addElement(ia, ItemData.fromItem(i));
        }
        int a = 18;
        for (final Item iaaaa : PierozekManager.drop) {
            category.addElement(a, ItemData.fromItem(iaaaa));
            ++a;
        }
        for (int ia2 = 36; ia2 < 53; ++ia2) {
            category.addElement(ia2, ItemData.fromItem(i));
        }
        final Item ia3 = new Item(107, Integer.valueOf(0), 1);
        ia3.setCustomName(ChatUtil.fixColor("&4Powrot"));
        category.addElement(53, ItemData.fromItem(ia3), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                Util.openStone(player);
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("PandoraGUI", category);
        menu.setName(ChatUtil.fixColor("&6DROP Z PIEROZKA"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("PandoraGUI", menu);
    }
    
    public static void openCobbleX(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final Item i = new Item(160, Integer.valueOf(1), 1);
        i.setCustomName(ChatUtil.fixColor("&8#"));
        for (int ia = 0; ia < 18; ++ia) {
            category.addElement(ia, ItemData.fromItem(i));
        }
        int a = 18;
        for (final Item iaaaa : CobblexCommand.drops) {
            category.addElement(a, ItemData.fromItem(iaaaa));
            ++a;
        }
        for (int ia2 = 36; ia2 < 53; ++ia2) {
            category.addElement(ia2, ItemData.fromItem(i));
        }
        final Item ia3 = new Item(107, Integer.valueOf(0), 1);
        ia3.setCustomName(ChatUtil.fixColor("&4Powrot"));
        category.addElement(53, ItemData.fromItem(ia3), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                Util.openStone(player);
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("CobbleXGUI", category);
        menu.setName(ChatUtil.fixColor("&6DROP Z COBBLEX"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("CobbleXGUI", menu);
    }
    
    static {
        Util.turbo = 0L;
        Util.turbo_exp = 0L;
    }
}
