
package pl.vertty.arivi.gui.guild;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.managers.TablistManager;
import pl.vertty.arivi.utils.ChatUtil;

public class TopkiGuildsGui
{
    public static void openTopki(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.setSmallServerGui();
        category.addElement(12, new ItemData(Item.SKULL, 3, 1, "&r&9ZABOJSTWA GIDLII", new String[] { ChatUtil.fixColor("&r" + TablistManager.getGuildKills(1)), ChatUtil.fixColor("&r" + TablistManager.getGuildKills(2)), ChatUtil.fixColor("&r" + TablistManager.getGuildKills(3)), ChatUtil.fixColor("&r" + TablistManager.getGuildKills(4)), ChatUtil.fixColor("&r" + TablistManager.getGuildKills(5)), ChatUtil.fixColor("&r" + TablistManager.getGuildKills(6)), ChatUtil.fixColor("&r" + TablistManager.getGuildKills(7)), ChatUtil.fixColor("&r" + TablistManager.getGuildKills(8)), ChatUtil.fixColor("&r" + TablistManager.getGuildKills(9)), ChatUtil.fixColor("&r" + TablistManager.getGuildKills(10)) }));
        category.addElement(13, new ItemData(Item.FEATHER, 0, 1, "&r&9PUNKTY GIDLII", new String[] { ChatUtil.fixColor("&r" + TablistManager.getGuildPoints(1)), ChatUtil.fixColor("&r" + TablistManager.getGuildPoints(2)), ChatUtil.fixColor("&r" + TablistManager.getGuildPoints(3)), ChatUtil.fixColor("&r" + TablistManager.getGuildPoints(4)), ChatUtil.fixColor("&r" + TablistManager.getGuildPoints(5)), ChatUtil.fixColor("&r" + TablistManager.getGuildPoints(6)), ChatUtil.fixColor("&r" + TablistManager.getGuildPoints(7)), ChatUtil.fixColor("&r" + TablistManager.getGuildPoints(8)), ChatUtil.fixColor("&r" + TablistManager.getGuildPoints(9)), ChatUtil.fixColor("&r" + TablistManager.getGuildPoints(10)) }));
        category.addElement(14, new ItemData(Item.SKULL, 0, 1, "&r&9SMIERCI GIDLII", new String[] { ChatUtil.fixColor("&r" + TablistManager.getGuildDeaths(1)), ChatUtil.fixColor("&r" + TablistManager.getGuildDeaths(2)), ChatUtil.fixColor("&r" + TablistManager.getGuildDeaths(3)), ChatUtil.fixColor("&r" + TablistManager.getGuildDeaths(4)), ChatUtil.fixColor("&r" + TablistManager.getGuildDeaths(5)), ChatUtil.fixColor("&r" + TablistManager.getGuildDeaths(6)), ChatUtil.fixColor("&r" + TablistManager.getGuildDeaths(7)), ChatUtil.fixColor("&r" + TablistManager.getGuildDeaths(8)), ChatUtil.fixColor("&r" + TablistManager.getGuildDeaths(9)), ChatUtil.fixColor("&r" + TablistManager.getGuildDeaths(10)) }));
        menu.setMainCategory(category);
        menu.addCategory("GuildTopsGui", category);
        menu.setName(ChatUtil.fixColor("&9TOPKI GILDII"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("GuildTopsGui", menu);
    }
}
