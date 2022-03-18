// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.utils.DyeColor;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.managers.ShopManager;
import pl.vertty.arivi.managers.TablistManager;
import pl.vertty.arivi.utils.ChatUtil;

public class UstawieniaGui
{
    public static void openTopki(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
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
        category.addElement(17, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(18, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(19, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(20, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(21, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(22, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(23, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(24, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(25, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(26, new ItemData(160, 15, 1, "&r&8*"));


        if(UserManager.getUser(player).isFlying() == false) {
            category.addElement(12, new ItemData(Item.FEATHER, 0, 1, "&r&aWlacz FLY na lobby"), new ItemClick() {
                @Override
                public void onClick(Player p0, Item p1) {
                    if(UserManager.getUser(p0).can(GroupType.SPONSOR)){
                        if("tp".contains(p0.getLevel().getName())){
                            ChatUtil.sendMessage(p0, "&cNie mozna uruchomic fly na mapie GrupoweTP");
                            menu.forceDestroy(p0);
                            return;
                        }
                        p0.setAllowFlight(true);
                        UserManager.getUser(p0).setFlying(true);
                        UstawieniaGui.openTopki(p0);
                    }
                    else if(ShopManager.getUser(p0).isFly() == true){
                        if("tp".contains(p0.getLevel().getName())){
                            ChatUtil.sendMessage(p0, "&cNie mozna uruchomic fly na mapie GrupoweTP");
                            menu.forceDestroy(p0);
                            return;
                        }
                        p0.setAllowFlight(true);
                        UserManager.getUser(p0).setFlying(true);
                        UstawieniaGui.openTopki(p0);
                    }else {
                        ChatUtil.sendMessage(p0, "&cZakup latanie pod &c/sklep");
                    }

                }
            });
        }else {
            category.addElement(12, new ItemData(Item.FEATHER, 0, 1, "&r&cWylacz FLY na lobby"), new ItemClick() {
                @Override
                public void onClick(Player p0, Item p1) {
                    p0.setAllowFlight(false);
                    UserManager.getUser(p0).setFlying(false);
                    UstawieniaGui.openTopki(p0);
                }
            });
        }
        if(UserManager.getUser(player).isSprint() == false) {
            category.addElement(14, new ItemData(Item.DYE, DyeColor.ORANGE.getDyeData(), 1, "&r&aWlacz AutoSprint &4{CHWILOWO OFF}"), new ItemClick() {
                @Override
                public void onClick(Player p0, Item p1) {
                    UstawieniaGui.openTopki(p0);
                }
            });
        }else {
            category.addElement(14, new ItemData(Item.DYE, DyeColor.ORANGE.getDyeData(), 1, "&r&cWylacz AutoSprint &4{CHWILOWO OFF}"), new ItemClick() {
                @Override
                public void onClick(Player p0, Item p1) {
                    UstawieniaGui.openTopki(p0);
                }
            });
        }



        menu.setMainCategory(category);
        menu.addCategory("UstawieniaGui", category);
        menu.setName(ChatUtil.fixColor("&9USTAWIENIA"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("UstawieniaGui", menu);
    }
}
