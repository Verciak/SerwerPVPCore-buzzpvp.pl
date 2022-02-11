package pl.vertty.arivi.gui;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;

public class AdminPanelGui
{
    public static void openTopki(final Player player) {
        final Config c = Main.getPlugin().getConfig();

        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final Item pandoreItem = Item.get(122);
        pandoreItem.setCustomName(ChatUtil.fixColor("&5Pandora"));
        pandoreItem.setLore(new String[] { ChatUtil.fixColor("&8» &7Aktualny status: " + (c.getBoolean("enable.pandora.status") ? "&a✔" : "&c✖")) });
        final Item kits = Item.get(368);
        kits.setCustomName(ChatUtil.fixColor("&5Kity"));
        kits.setLore(new String[] { ChatUtil.fixColor("&8» &7Aktualny status: " + (c.getBoolean("enable.kits.status") ? "&a✔" : "&c✖")) });

        category.addElement(1, ItemData.fromItem(pandoreItem), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                if(c.getBoolean("enable.pandora.status") == true){
                    c.set("enable.pandora.status", false);
                    c.save();

                    openTopki(player);
                }else{
                    c.set("enable.pandora.status", true);
                    c.save();
                    openTopki(player);
                }
            }
        });
        category.addElement(2, ItemData.fromItem(kits), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                if(c.getBoolean("enable.kits.status") == true){
                    c.set("enable.kits.status", false);
                    c.save();

                    openTopki(player);
                }else{
                    c.set("enable.kits.status", true);
                    c.save();
                    openTopki(player);
                }
            }
        });

        menu.setMainCategory(category);
        menu.addCategory("AdminPanelGUI", category);
        menu.setName(ChatUtil.fixColor("&9ADMINPANEL"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("AdminPanelGUI", menu);
    }
}
