
package pl.vertty.arivi.gui;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
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
        category.setSmallServerGui();
        category.addElement(10, new ItemData(466, 0, 1, "&r&9ZJEDZONE KOXY", new String[] { ChatUtil.fixColor("&r" + TablistManager.getKox(1)), ChatUtil.fixColor("&r" + TablistManager.getKox(2)), ChatUtil.fixColor("&r" + TablistManager.getKox(3)), ChatUtil.fixColor("&r" + TablistManager.getKox(4)), ChatUtil.fixColor("&r" + TablistManager.getKox(5)), ChatUtil.fixColor("&r" + TablistManager.getKox(6)), ChatUtil.fixColor("&r" + TablistManager.getKox(7)), ChatUtil.fixColor("&r" + TablistManager.getKox(8)), ChatUtil.fixColor("&r" + TablistManager.getKox(9)), ChatUtil.fixColor("&r" + TablistManager.getKox(10)) }));
        category.addElement(11, new ItemData(322, 0, 1, "&r&9ZJEDZONE REFILE", new String[] { ChatUtil.fixColor("&r" + TablistManager.getRefil(1)), ChatUtil.fixColor("&r" + TablistManager.getRefil(2)), ChatUtil.fixColor("&r" + TablistManager.getRefil(3)), ChatUtil.fixColor("&r" + TablistManager.getRefil(4)), ChatUtil.fixColor("&r" + TablistManager.getRefil(5)), ChatUtil.fixColor("&r" + TablistManager.getRefil(6)), ChatUtil.fixColor("&r" + TablistManager.getRefil(7)), ChatUtil.fixColor("&r" + TablistManager.getRefil(8)), ChatUtil.fixColor("&r" + TablistManager.getRefil(9)), ChatUtil.fixColor("&r" + TablistManager.getRefil(10)) }));
        category.addElement(12, new ItemData(Item.BLAZE_ROD, 0, 1, "&r&9ZABICI GRACZE", new String[] { ChatUtil.fixColor("&r" + TablistManager.getKills(1)), ChatUtil.fixColor("&r" + TablistManager.getKills(2)), ChatUtil.fixColor("&r" + TablistManager.getKills(3)), ChatUtil.fixColor("&r" + TablistManager.getKills(4)), ChatUtil.fixColor("&r" + TablistManager.getKills(5)), ChatUtil.fixColor("&r" + TablistManager.getKills(6)), ChatUtil.fixColor("&r" + TablistManager.getKills(7)), ChatUtil.fixColor("&r" + TablistManager.getKills(8)), ChatUtil.fixColor("&r" + TablistManager.getKills(9)), ChatUtil.fixColor("&r" + TablistManager.getKills(10)) }));
        category.addElement(13, new ItemData(Item.FEATHER, 0, 1, "&r&9PUNKTY GRACZY", new String[] { ChatUtil.fixColor("&r" + TablistManager.getReplacementR(1)), ChatUtil.fixColor("&r" + TablistManager.getReplacementR(2)), ChatUtil.fixColor("&r" + TablistManager.getReplacementR(3)), ChatUtil.fixColor("&r" + TablistManager.getReplacementR(4)), ChatUtil.fixColor("&r" + TablistManager.getReplacementR(5)), ChatUtil.fixColor("&r" + TablistManager.getReplacementR(6)), ChatUtil.fixColor("&r" + TablistManager.getReplacementR(7)), ChatUtil.fixColor("&r" + TablistManager.getReplacementR(8)), ChatUtil.fixColor("&r" + TablistManager.getReplacementR(9)), ChatUtil.fixColor("&r" + TablistManager.getReplacementR(10)) }));
        category.addElement(14, new ItemData(397, 0, 1, "&r&9SMIERCI GRACZY", new String[] { ChatUtil.fixColor("&r" + TablistManager.getDeaths(1)), ChatUtil.fixColor("&r" + TablistManager.getDeaths(2)), ChatUtil.fixColor("&r" + TablistManager.getDeaths(3)), ChatUtil.fixColor("&r" + TablistManager.getDeaths(4)), ChatUtil.fixColor("&r" + TablistManager.getDeaths(5)), ChatUtil.fixColor("&r" + TablistManager.getDeaths(6)), ChatUtil.fixColor("&r" + TablistManager.getDeaths(7)), ChatUtil.fixColor("&r" + TablistManager.getDeaths(8)), ChatUtil.fixColor("&r" + TablistManager.getDeaths(9)), ChatUtil.fixColor("&r" + TablistManager.getDeaths(10)) }));
        category.addElement(15, new ItemData(368, 0, 1, "&r&9RZUCONE PERLY", new String[] { ChatUtil.fixColor("&r" + TablistManager.getPerly(1)), ChatUtil.fixColor("&r" + TablistManager.getPerly(2)), ChatUtil.fixColor("&r" + TablistManager.getPerly(3)), ChatUtil.fixColor("&r" + TablistManager.getPerly(4)), ChatUtil.fixColor("&r" + TablistManager.getPerly(5)), ChatUtil.fixColor("&r" + TablistManager.getPerly(6)), ChatUtil.fixColor("&r" + TablistManager.getPerly(7)), ChatUtil.fixColor("&r" + TablistManager.getPerly(8)), ChatUtil.fixColor("&r" + TablistManager.getPerly(9)), ChatUtil.fixColor("&r" + TablistManager.getPerly(10)) }));
        category.addElement(16, new ItemData(1, 0, 1, "&r&9WYKOPANY KAMIEN", new String[] { ChatUtil.fixColor("&r" + TablistManager.getKamien(1)), ChatUtil.fixColor("&r" + TablistManager.getKamien(2)), ChatUtil.fixColor("&r" + TablistManager.getKamien(3)), ChatUtil.fixColor("&r" + TablistManager.getKamien(4)), ChatUtil.fixColor("&r" + TablistManager.getKamien(5)), ChatUtil.fixColor("&r" + TablistManager.getKamien(6)), ChatUtil.fixColor("&r" + TablistManager.getKamien(7)), ChatUtil.fixColor("&r" + TablistManager.getKamien(8)), ChatUtil.fixColor("&r" + TablistManager.getKamien(9)), ChatUtil.fixColor("&r" + TablistManager.getKamien(10)) }));
        menu.setMainCategory(category);
        menu.addCategory("TopkiGui", category);
        menu.setName(ChatUtil.fixColor("&9TOPKI"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("TopkiGui", menu);
    }
}
