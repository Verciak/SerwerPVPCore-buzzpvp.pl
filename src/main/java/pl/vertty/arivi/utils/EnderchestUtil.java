// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.utils;

import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import cn.nukkit.item.Item;
import cn.nukkit.utils.DyeColor;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;

public class EnderchestUtil
{
    public static void open(final Player p) {
        final User u = UserManager.getUser(p);
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final Item i = new Item(160, Integer.valueOf(DyeColor.BLACK.getWoolData()), 1);
        i.setCustomName(ChatUtil.fixColor("&8#"));
        for (int ia = 0; ia < 11; ++ia) {
            category.addElement(ia, ItemData.fromItem(i));
        }
        for (int ia = 16; ia < 26; ++ia) {
            category.addElement(ia, ItemData.fromItem(i));
        }
        category.addElement(11, ItemData.fromItem(new Item(130, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&r&7Enderchest &8(&9I&8)")).setLore(ChatUtil.fixColor(new String[] { "", "&r&8>> &7Dostepny dla rangi:", "&r&f* &9PLAYER", "&r&f* &9VIP", "&r&f* &9SVIP", "&r&f* &9YOUTUBER", "&r&f* &9SPONSOR" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                u.getEc1().show(p);
            }
        });
        category.addElement(12, ItemData.fromItem(new Item(130, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&r&7Enderchest &8(&9II&8)")).setLore(ChatUtil.fixColor(new String[] { "", "&r&8>> &7Dostepny dla rangi:", "&r&f* &9VIP", "&r&f* &9SVIP", "&r&f* &9YOUTUBER", "&r&f* &9SPONSOR" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                if (u.can(GroupType.VIP)) {
                    u.getEc2().show(p);
                }
                else {
                    ChatUtil.sendTitle(player, "", "&7Nie posiadasz rangi &9VIP");
                }
            }
        });
        category.addElement(13, ItemData.fromItem(new Item(130, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&r&7Enderchest &8(&9III&8)")).setLore(ChatUtil.fixColor(new String[] { "", "&r&8>> &7Dostepny dla rangi:", "&r&f* &9SVIP", "&r&f* &9YOUTUBER", "&r&f* &9SPONSOR" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                if (u.can(GroupType.SVIP)) {
                    u.getEc3().show(p);
                }
                else {
                    ChatUtil.sendTitle(player, "", "&7Nie posiadasz rangi &9SVIP");
                }
            }
        });
        category.addElement(14, ItemData.fromItem(new Item(130, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&r&7Enderchest &8(&9IV&8)")).setLore(ChatUtil.fixColor(new String[] { "", "&r&8>> &7Dostepny dla rangi:", "&r&f* &9YOUTUBER", "&r&f* &9SPONSOR" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                if (u.can(GroupType.YOUTUBER)) {
                    u.getEc4().show(p);
                }
                else {
                    ChatUtil.sendTitle(player, "", "&7Nie posiadasz rangi &9YOUTUBER");
                }
            }
        });
        category.addElement(15, ItemData.fromItem(new Item(130, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&r&7Enderchest &8(&9V&8)")).setLore(ChatUtil.fixColor(new String[] { "", "&r&8>> &7Dostepny dla rangi:", "&r&f* &9SPONSOR" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                if (u.can(GroupType.SPONSOR)) {
                    u.getEc5().show(p);
                }
                else {
                    ChatUtil.sendTitle(player, "", "&7Nie posiadasz rangi &9SPONSOR");
                }
            }
        });
        menu.setMainCategory(category);
        menu.addCategory("EnderChestGUI", category);
        menu.setName(ChatUtil.fixColor("&9Enderchesty"));
        menu.setOnlyRead(true);
        menu.show(p);
        InventoryMenuHandler.registerNewMenu("EnderChestGUI", menu);
    }
}
