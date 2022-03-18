// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.DyeColor;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.gui.action.SchowekAction;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.managers.ShopManager;
import pl.vertty.arivi.objects.Shop;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.exception.SkinChangeException;

public class SklepGui {
    public static void openSklep(final Player player) {
        User u = UserManager.getUser(player);
        final Shop shop = ShopManager.getUser(player);
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();


        category.addElement(10, new ItemData(Item.COBWEB, 0, 4, "&r&3Pajeczyna",
                new String[]{
                        "&r&8» &7Koszt: &f500",
                        (shop.isPajeczyna() ? "&r&8» &7Status: &akupiono" : "&r&8» &7Status: &cnie kupiono")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(shop.isPajeczyna() == true){
                    ChatUtil.sendMessage(p0, "&cZakupiono juz item staly!");
                    p0.getInventory().close(p0);
                    return;
                }
                if (u.getCoins() >= 500) {
                    shop.setPajeczyna(true);
                    ChatUtil.sendMessage(p0, "&aSukces! Pomyslnie zakupiono item staly!");
                    u.removeCoins(500);
                    SklepGui.openSklep(p0);
                }else {
                    ChatUtil.sendMessage(p0, "&cNie posiadasz &4500 &cmonet!");
                    p0.getInventory().close(p0);
                }
            }
        });
        category.addElement(11, new ItemData(Item.ICE, 0, 32, "&r&3Lod", new String[]{"&r&8» &7Koszt: &f1000",
                (shop.isLod() ? "&r&8» &7Status: &akupiono" : "&r&8» &7Status: &cnie kupiono")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(shop.isLod() == true){
                    ChatUtil.sendMessage(p0, "&cZakupiono juz item staly!");
                    p0.getInventory().close(p0);
                    return;
                }
                if (u.getCoins() >= 1000) {
                    shop.setLod(true);
                    ChatUtil.sendMessage(p0, "&aSukces! Pomyslnie zakupiono item staly!");
                    u.removeCoins(1000);
                    SklepGui.openSklep(p0);
                }else {
                    ChatUtil.sendMessage(p0, "&cNie posiadasz &41000 &cmonet!");
                    p0.getInventory().close(p0);
                }
            }
        });
        category.addElement(12, new ItemData(Item.SNOWBALL, 0, 8, "&r&3Sniezki", new String[]{"&r&8» &7Koszt: &f800",
                (shop.isSniezki() ? "&r&8» &7Status: &akupiono" : "&r&8» &7Status: &cnie kupiono")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(shop.isSniezki() == true){
                    ChatUtil.sendMessage(p0, "&cZakupiono juz item staly!");
                    p0.getInventory().close(p0);
                    return;
                }
                if (u.getCoins() >= 800) {
                    shop.setSniezki(true);
                    ChatUtil.sendMessage(p0, "&aSukces! Pomyslnie zakupiono item staly!");
                    u.removeCoins(800);
                    SklepGui.openSklep(p0);
                }else {
                    ChatUtil.sendMessage(p0, "&cNie posiadasz &4800 &cmonet!");
                    p0.getInventory().close(p0);
                }
            }
        });
        category.addElement(13, new ItemData(Item.BUCKET, 10, 1, "&r&3Wiaderko Lavy", new String[]{"&r&8» &7Koszt: &f500",
                (shop.isLava() ? "&r&8» &7Status: &akupiono" : "&r&8» &7Status: &cnie kupiono")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(shop.isLava() == true){
                    ChatUtil.sendMessage(p0, "&cZakupiono juz item staly!");
                    p0.getInventory().close(p0);
                    return;
                }
                if (u.getCoins() >= 500) {
                    shop.setLava(true);
                    ChatUtil.sendMessage(p0, "&aSukces! Pomyslnie zakupiono item staly!");
                    u.removeCoins(500);
                    SklepGui.openSklep(p0);
                }else {
                    ChatUtil.sendMessage(p0, "&cNie posiadasz &4500 &cmonet!");
                    p0.getInventory().close(p0);
                }
            }
        });
        Item lub = new Item(ItemID.BOW,0,1);
        lub.setCustomName(ChatUtil.fixColor("&r&3Luk 3/1"));
        lub.setLore(ChatUtil.fixColor(new String[]{"&r&8» &7Koszt: &f800",
                (shop.isLuk() ? "&r&8» &7Status: &akupiono" : "&r&8» &7Status: &cnie kupiono")}));
        lub.addEnchantment(Enchantment.getEnchantment(Enchantment.ID_BOW_POWER).setLevel(2));
        lub.addEnchantment(Enchantment.getEnchantment(Enchantment.ID_BOW_INFINITY).setLevel(1));

        category.addElement(14, ItemData.fromItem(lub), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(shop.isLuk() == true){
                    ChatUtil.sendMessage(p0, "&cZakupiono juz item staly!");
                    p0.getInventory().close(p0);
                    return;
                }
                if (u.getCoins() >= 800) {
                    shop.setLuk(true);
                    ChatUtil.sendMessage(p0, "&aSukces! Pomyslnie zakupiono item staly!");
                    u.removeCoins(800);
                    SklepGui.openSklep(p0);
                }else {
                    ChatUtil.sendMessage(p0, "&cNie posiadasz &4800 &cmonet!");
                    p0.getInventory().close(p0);
                }
            }
        });

        category.addElement(15, new ItemData(Item.COBBLESTONE, 0, 64, "&r&3Cobblestone", new String[]{"&r&8» &7Koszt: &f300",
                (shop.isCobblestone() ? "&r&8» &7Status: &akupiono" : "&r&8» &7Status: &cnie kupiono")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(shop.isCobblestone() == true){
                    ChatUtil.sendMessage(p0, "&cZakupiono juz item staly!");
                    p0.getInventory().close(p0);
                    return;
                }
                if (u.getCoins() >= 300) {
                    shop.setCobblestone(true);
                    ChatUtil.sendMessage(p0, "&aSukces! Pomyslnie zakupiono item staly!");
                    u.removeCoins(300);
                    SklepGui.openSklep(p0);
                }else {
                    ChatUtil.sendMessage(p0, "&cNie posiadasz &4300 &cmonet!");
                    p0.getInventory().close(p0);
                }
            }
        });

        category.addElement(16, new ItemData(Item.FLINT_AND_STEEL, 0, 1, "&r&3Zapalniczka", new String[]{"&r&8» &7Koszt: &f500",
                (shop.isZapalniczka() ? "&r&8» &7Status: &akupiono" : "&r&8» &7Status: &cnie kupiono")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(shop.isZapalniczka() == true){
                    ChatUtil.sendMessage(p0, "&cZakupiono juz item staly!");
                    p0.getInventory().close(p0);
                    return;
                }
                if (u.getCoins() >= 500) {
                    shop.setZapalniczka(true);
                    ChatUtil.sendMessage(p0, "&aSukces! Pomyslnie zakupiono item staly!");
                    u.removeCoins(500);
                    SklepGui.openSklep(p0);
                }else {
                    ChatUtil.sendMessage(p0, "&cNie posiadasz &4500 &cmonet!");
                    p0.getInventory().close(p0);
                }
            }
        });

        category.addElement(19, new ItemData(Item.SLIME_BLOCK, 0, 1, "&r&3Blok Slime", new String[]{"&r&8» &7Koszt: &f600",
                (shop.isSlime() ? "&r&8» &7Status: &akupiono" : "&r&8» &7Status: &cnie kupiono")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(shop.isSlime() == true){
                    ChatUtil.sendMessage(p0, "&cZakupiono juz item staly!");
                    p0.getInventory().close(p0);
                    return;
                }
                if (u.getCoins() >= 600) {
                    shop.setSlime(true);
                    ChatUtil.sendMessage(p0, "&aSukces! Pomyslnie zakupiono item staly!");
                    u.removeCoins(600);
                    SklepGui.openSklep(p0);
                }else {
                    ChatUtil.sendMessage(p0, "&cNie posiadasz &4600 &cmonet!");
                    p0.getInventory().close(p0);
                }
            }
        });

        category.addElement(20, new ItemData(Item.OBSIDIAN, 0, 16, "&r&3OBSYDIAN", new String[]{"&r&8» &7Koszt: &f700",
                (shop.isObs() ? "&r&8» &7Status: &akupiono" : "&r&8» &7Status: &cnie kupiono")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(shop.isObs() == true){
                    ChatUtil.sendMessage(p0, "&cZakupiono juz item staly!");
                    p0.getInventory().close(p0);
                    return;
                }
                if (u.getCoins() >= 700) {
                    shop.setObs(true);
                    ChatUtil.sendMessage(p0, "&aSukces! Pomyslnie zakupiono item staly!");
                    u.removeCoins(700);
                    SklepGui.openSklep(p0);
                }else {
                    ChatUtil.sendMessage(p0, "&cNie posiadasz &4700 &cmonet!");
                    p0.getInventory().close(p0);
                }
            }
        });

        category.addElement(21, new ItemData(Item.FEATHER, 0, 1, "&r&3FLY NA LOBBY", new String[]{"&r&8» &7Koszt: &f5000",
                (shop.isFly() ? "&r&8» &7Status: &akupiono" : "&r&8» &7Status: &cnie kupiono")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(shop.isFly() == true){
                    ChatUtil.sendMessage(p0, "&cZakupiono juz item staly!");
                    p0.getInventory().close(p0);
                    return;
                }
                if (u.getCoins() >= 5000) {
                    shop.setFly(true);
                    ChatUtil.sendMessage(p0, "&aSukces! Pomyslnie zakupiono item staly!");
                    u.removeCoins(5000);
                    SklepGui.openSklep(p0);
                }else {
                    ChatUtil.sendMessage(p0, "&cNie posiadasz &45000 &cmonet!");
                    p0.getInventory().close(p0);
                }
            }
        });



        category.addElement(40, new ItemData(Item.DYE, DyeColor.YELLOW.getDyeData(), 1, "&r&7Posiadasz &3" + u.getCoins() + " &7monet!"));
        category.addElement(0, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(1, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(2, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(3, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(4, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(5, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(6, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(7, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(8, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(9, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(18, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(27, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(36, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(17, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(26, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(35, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(44, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(45, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(46, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(47, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(48, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(49, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(50, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(51, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(52, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(53, new ItemData(160, 15, 1, "&r&8*"));
        menu.setMainCategory(category);
        menu.setDoubleChest();
        menu.addCategory("sklepgui", category);
        menu.setName(ChatUtil.fixColor("&9SKLEP ITEMOW STALYCH"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("sklepgui", menu);
    }
}
