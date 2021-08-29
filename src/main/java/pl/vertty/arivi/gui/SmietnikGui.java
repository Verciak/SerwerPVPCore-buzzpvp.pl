// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui;

import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import cn.nukkit.Player;

public class SmietnikGui
{
    public static void openSmietnik(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        menu.setMainCategory(category);
        menu.addCategory("SmietnikMenu", category);
        menu.setName(ChatUtil.fixColor("&9SMIETNIK"));
        menu.setOnlyRead(false);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("SmietnikMenu", menu);
    }
}
