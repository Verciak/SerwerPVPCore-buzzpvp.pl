// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui;

import cn.nukkit.item.Item;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.managers.TablistManager;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import cn.nukkit.Player;

public class TopkiGui
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



        category.addElement(11, new ItemData(466, 0, 1, "&r&3TOPKI PUNKTOW", new String[] { ChatUtil.fixColor(TablistManager.getReplacementR(1)), ChatUtil.fixColor(TablistManager.getReplacementR(2)), ChatUtil.fixColor(TablistManager.getReplacementR(3)), ChatUtil.fixColor(TablistManager.getReplacementR(4)), ChatUtil.fixColor(TablistManager.getReplacementR(5)), ChatUtil.fixColor(TablistManager.getReplacementR(6)), ChatUtil.fixColor(TablistManager.getReplacementR(7)), ChatUtil.fixColor(TablistManager.getReplacementR(8)), ChatUtil.fixColor(TablistManager.getReplacementR(9)) }));
        category.addElement(12, new ItemData(Item.BLAZE_ROD, 0, 1, "&r&3TOPKI ZABOJSTW", new String[] { ChatUtil.fixColor(TablistManager.getReplacementKills(1)), ChatUtil.fixColor(TablistManager.getReplacementKills(2)), ChatUtil.fixColor(TablistManager.getReplacementKills(3)), ChatUtil.fixColor(TablistManager.getReplacementKills(4)), ChatUtil.fixColor(TablistManager.getReplacementKills(5)), ChatUtil.fixColor(TablistManager.getReplacementKills(6)), ChatUtil.fixColor(TablistManager.getReplacementKills(7)), ChatUtil.fixColor(TablistManager.getReplacementKills(8)), ChatUtil.fixColor(TablistManager.getReplacementKills(9)) }));
        category.addElement(14, new ItemData(Item.SKULL, 3, 1, "&r&3TOPKI SMIERCI", new String[] { ChatUtil.fixColor(TablistManager.getReplacementDeaths(1)), ChatUtil.fixColor(TablistManager.getReplacementDeaths(2)), ChatUtil.fixColor(TablistManager.getReplacementDeaths(3)), ChatUtil.fixColor(TablistManager.getReplacementDeaths(4)), ChatUtil.fixColor(TablistManager.getReplacementDeaths(5)), ChatUtil.fixColor(TablistManager.getReplacementDeaths(6)), ChatUtil.fixColor(TablistManager.getReplacementDeaths(7)), ChatUtil.fixColor(TablistManager.getReplacementDeaths(8)), ChatUtil.fixColor(TablistManager.getReplacementDeaths(9)) }));
        category.addElement(15, new ItemData(Item.GOLD_INGOT, 0, 1, "&r&3TOPKI MONET", new String[] { ChatUtil.fixColor(TablistManager.getReplacementDCoins(1)), ChatUtil.fixColor(TablistManager.getReplacementDCoins(2)), ChatUtil.fixColor(TablistManager.getReplacementDCoins(3)), ChatUtil.fixColor(TablistManager.getReplacementDCoins(4)), ChatUtil.fixColor(TablistManager.getReplacementDCoins(5)), ChatUtil.fixColor(TablistManager.getReplacementDCoins(6)), ChatUtil.fixColor(TablistManager.getReplacementDCoins(7)), ChatUtil.fixColor(TablistManager.getReplacementDCoins(8)), ChatUtil.fixColor(TablistManager.getReplacementDCoins(9)) }));



        category.addElement(18, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(19, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(20, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(21, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(22, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(23, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(24, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(25, new ItemData(160, 15, 1, "&r&8*"));
        category.addElement(26, new ItemData(160, 15, 1, "&r&8*"));

        menu.setMainCategory(category);
        menu.addCategory("TopkiGui", category);
        menu.setName(ChatUtil.fixColor("&9TOPKI"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("TopkiGui", menu);
    }
}
