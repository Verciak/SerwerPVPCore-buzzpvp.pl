// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui;

import cn.nukkit.utils.Config;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.gui.action.SchowekAction;
import cn.nukkit.item.Item;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;

public class SchowekGui
{
    public static void openSchowek(final Player player) {
        final User u = UserManager.getUser(player);
        final Config c = Main.getPlugin().getConfig();
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


        category.addElement(10, new ItemData(466, 0, 1, "&r&9KOXY", new String[] { ChatUtil.fixColor("&r&8» &7Posiadasz: &e" + u.getKox()), ChatUtil.fixColor("&r&8» &7Obecny limit: &e" + c.getInt("limit.kox")), "", ChatUtil.fixColor("&r&8» &7Kliknij, aby wyplacic!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                SchowekAction.checkKoxy(p, true);
            }
        });
        category.addElement(12, new ItemData(368, 0, 1, "&r&9PERLY", new String[] { ChatUtil.fixColor("&r&8» &7Posiadasz: &e" + u.getPerly()), ChatUtil.fixColor("&r&8» &7Obecny limit: &e" + c.getInt("limit.perly")), "", ChatUtil.fixColor("&r&8» &7Kliknij, aby wyplacic!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                SchowekAction.checkPerly(p, true);
            }
        });
        category.addElement(11, new ItemData(322, 0, 1, "&r&9REFY", new String[] { ChatUtil.fixColor("&r&8» &7Posiadasz: &e" + u.getRefy()), ChatUtil.fixColor("&r&8» &7Obecny limit: &e" + c.getInt("limit.refy")), "", ChatUtil.fixColor("&r&8» &7Kliknij, aby wyplacic!") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                SchowekAction.checkRefile(p, true);
            }
        });
        category.addElement(15, new ItemData(410, 0, 1, "&r&9WYPLAC WSZYSTKO", new String[] { ChatUtil.fixColor("&r&8» &7Kliknij, aby wyplacic"), ChatUtil.fixColor("&r&8» &7wszystko do limitu") }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                SchowekAction.checkKoxy(p, true);
                SchowekAction.checkRefile(p, true);
                SchowekAction.checkPerly(p, true);
            }
        });


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
        menu.addCategory("SchowekGui", category);
        menu.setName(ChatUtil.fixColor("&9SCHOWEK"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("SchowekGui", menu);
    }
}
