// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui.osiagniecia;

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

public class OsiagnieciaInventory
{
    public static void guiStone(final Player p) {
        final User u = UserManager.getUser(p);
        final Config c = Main.getPlugin().getConfig();
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        for (int i = 0; i <= 26; ++i) {
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23 || i == 24 || i == 25 || i == 26) {
                category.addElement(i, ItemData.fromItem(new Item(160, Integer.valueOf(15), 1).setCustomName(ChatUtil.fixColor("&a"))));
            }
        }
        category.addElement(11, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&6Wykopany kamien")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&eMusisz kopac kamien"), ChatUtil.fixColor("&eaby odblokowac osiagniecia"), ChatUtil.fixColor(""), ChatUtil.fixColor("&7Kliknij aby rozwinac liste!"), ChatUtil.fixColor("") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                KamienInventory.guiStone(player);
            }
        });
        category.addElement(12, ItemData.fromItem(new Item(276).setCustomName(ChatUtil.fixColor("&6Zabici gracze")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&eMusisz zabijac graczy"), ChatUtil.fixColor("&eaby odblokowac osiagniecia"), ChatUtil.fixColor(""), ChatUtil.fixColor("&7Kliknij aby rozwinac liste!"), ChatUtil.fixColor("") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                ZabojstwaInventory.guiStone(player);
            }
        });
        category.addElement(13, ItemData.fromItem(new Item(268).setCustomName(ChatUtil.fixColor("&6Poniesione smierci")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&eMusisz zginac"), ChatUtil.fixColor("&eaby odblokowac osiagniecia"), ChatUtil.fixColor(""), ChatUtil.fixColor("&7Kliknij aby rozwinac liste!"), ChatUtil.fixColor("") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                SmierciInventory.guiStone(player);
            }
        });
        category.addElement(14, ItemData.fromItem(new Item(466).setCustomName(ChatUtil.fixColor("&6Zjedzone koxy")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&eMusisz jesc koxy"), ChatUtil.fixColor("&eaby odblokowac osiagniecia"), ChatUtil.fixColor(""), ChatUtil.fixColor("&7Kliknij aby rozwinac liste!"), ChatUtil.fixColor("") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                KoxyInventory.guiStone(player);
            }
        });
        category.addElement(15, ItemData.fromItem(new Item(322).setCustomName(ChatUtil.fixColor("&6Zjedzone refile")).setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&eMusisz jesc refile"), ChatUtil.fixColor("&eaby odblokowac osiagniecia"), ChatUtil.fixColor(""), ChatUtil.fixColor("&7Kliknij aby rozwinac liste!"), ChatUtil.fixColor("") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                RefileInventory.guiStone(player);
            }
        });
        menu.setMainCategory(category);
        menu.addCategory("osGui", category);
        menu.setName(ChatUtil.fixColor("&e&lOSIAGNIECIA"));
        menu.setOnlyRead(true);
        menu.show(p);
        InventoryMenuHandler.registerNewMenu("osGui", menu);
    }
}
