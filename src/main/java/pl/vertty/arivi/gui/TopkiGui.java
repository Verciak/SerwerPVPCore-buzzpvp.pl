
package pl.vertty.arivi.gui;

import cn.nukkit.Player;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.managers.TablistManager;
import pl.vertty.arivi.utils.ChatUtil;

public class TopkiGui
{
    public static void openTopki(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(2, new ItemData(160, 11, 1, "&8*"));
        category.addElement(6, new ItemData(160, 11, 1, "&8*"));
        category.addElement(10, new ItemData(160, 11, 1, "&8*"));
        category.addElement(12, new ItemData(160, 11, 1, "&8*"));
        category.addElement(14, new ItemData(160, 11, 1, "&8*"));
        category.addElement(16, new ItemData(160, 11, 1, "&8*"));
        category.addElement(20, new ItemData(160, 11, 1, "&8*"));
        category.addElement(24, new ItemData(160, 11, 1, "&8*"));
        category.addElement(11, new ItemData(466, 0, 1, "&6TOPKI PUNKTOW", new String[] { ChatUtil.fixColor(TablistManager.getReplacementR(1)), ChatUtil.fixColor(TablistManager.getReplacementR(2)), ChatUtil.fixColor(TablistManager.getReplacementR(3)), ChatUtil.fixColor(TablistManager.getReplacementR(4)), ChatUtil.fixColor(TablistManager.getReplacementR(5)), ChatUtil.fixColor(TablistManager.getReplacementR(6)), ChatUtil.fixColor(TablistManager.getReplacementR(7)), ChatUtil.fixColor(TablistManager.getReplacementR(8)), ChatUtil.fixColor(TablistManager.getReplacementR(9)) }));
        category.addElement(15, new ItemData(322, 0, 1, "&6TOPKI GILDII", new String[] { ChatUtil.fixColor(TablistManager.getReplacementG(1)), ChatUtil.fixColor(TablistManager.getReplacementG(2)), ChatUtil.fixColor(TablistManager.getReplacementG(3)), ChatUtil.fixColor(TablistManager.getReplacementG(4)), ChatUtil.fixColor(TablistManager.getReplacementG(5)), ChatUtil.fixColor(TablistManager.getReplacementG(6)), ChatUtil.fixColor(TablistManager.getReplacementG(7)), ChatUtil.fixColor(TablistManager.getReplacementG(8)), ChatUtil.fixColor(TablistManager.getReplacementG(9)) }));
        menu.setMainCategory(category);
        menu.addCategory("TopkiGui", category);
        menu.setName(ChatUtil.fixColor("&9TOPKI"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("TopkiGui", menu);
    }
}
