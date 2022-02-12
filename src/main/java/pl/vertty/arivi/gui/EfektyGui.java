package pl.vertty.arivi.gui;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.potion.Effect;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.MainConstants;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;

public class EfektyGui
{
    public static void openSchowek(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(1, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(9, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(7, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(17, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(36, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(46, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(52, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(0, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(8, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(45, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(53, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(2, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(3, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(4, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(5, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(6, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(10, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(16, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(12, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(14, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(18, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(19, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(20, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(21, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(22, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(23, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(24, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(25, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(26, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(27, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(28, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(29, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(33, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(34, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(35, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(37, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(38, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(39, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(40, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(41, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(42, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(43, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(44, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(47, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(48, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(49, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(50, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(51, ItemData.fromItem(MainConstants.BLACK_GLASS));



        category.addElement(11, ItemData.fromItem(MainConstants.HIGH_JUMP), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, 0, 32);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.JUMP_BOOST)
                                    .setAmplifier(1)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(ia);
                }
                else {
                    ChatUtil.sendMessage(p, "&cNie posiadasz 32 emeraldow!");
                }
            }
        });

        category.addElement(13, ItemData.fromItem(MainConstants.SPEED), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, 0, 64);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.SPEED)
                                    .setAmplifier(0)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(ia);
                }
                else {
                    ChatUtil.sendMessage(p, "&cNie posiadasz 64 emeraldow!");
                }
            }
        });

        category.addElement(15, ItemData.fromItem(MainConstants.FIRE), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, 0, 64);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.FIRE_RESISTANCE)
                                    .setAmplifier(0)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(ia);
                }
                else {
                    ChatUtil.sendMessage(p, "&cNie posiadasz 64 emeraldow!");
                }
            }
        });

        category.addElement(30, ItemData.fromItem(MainConstants.HASTE_1), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, 0, 32);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.HASTE)
                                    .setAmplifier(0)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(ia);
                }
                else {
                    ChatUtil.sendMessage(p, "&cNie posiadasz 32 emeraldow!");
                }
            }
        });

        category.addElement(31, ItemData.fromItem(MainConstants.HASTE_2), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, 0, 64);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.HASTE)
                                    .setAmplifier(1)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(ia);
                }
                else {
                    ChatUtil.sendMessage(p, "&cNie posiadasz 64 emeraldow!");
                }
            }
        });

        category.addElement(32, ItemData.fromItem(MainConstants.HASTE_3), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, 0, 128);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.HASTE)
                                    .setAmplifier(2)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(ia);
                }
                else {
                    ChatUtil.sendMessage(p, "&cNie posiadasz 128 emeraldow!");
                }
            }
        });



        menu.setMainCategory(category);
        menu.addCategory("EfektyGUI", category);
        menu.setName(ChatUtil.fixColor("&9EFEKTY"));
        menu.setOnlyRead(true);
        menu.setDoubleChest();
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("EfektyGUI", menu);
    }
}
