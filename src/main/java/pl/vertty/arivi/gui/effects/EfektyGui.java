package pl.vertty.arivi.gui.effects;

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
        category.setDoubleEffectsGui();


        category.addElement(20, ItemData.fromItem(MainConstants.SPEED), new ItemClick() {
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
                    menu.forceDestroy(p);
                }
                else {
                    menu.forceDestroy(p);
                    ChatUtil.sendMessage(p, "&cNie posiadasz 64 emeraldow!");
                }
            }
        });

        category.addElement(29, ItemData.fromItem(MainConstants.SPEED2));


        category.addElement(21, ItemData.fromItem(MainConstants.FIRE), new ItemClick() {
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
                    menu.forceDestroy(p);
                }
                else {
                    menu.forceDestroy(p);
                    ChatUtil.sendMessage(p, "&cNie posiadasz 64 emeraldow!");
                }
            }
        });

        category.addElement(22, ItemData.fromItem(MainConstants.SILA1));
        category.addElement(31, ItemData.fromItem(MainConstants.SILA2));






        category.addElement(23, ItemData.fromItem(MainConstants.HIGH_JUMP), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, 0, 32);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.JUMP_BOOST)
                                    .setAmplifier(0)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(ia);
                    menu.forceDestroy(p);
                }
                else {
                    menu.forceDestroy(p);
                    ChatUtil.sendMessage(p, "&cNie posiadasz 32 emeraldow!");
                }
            }
        });
        category.addElement(32, ItemData.fromItem(MainConstants.HIGH_JUMP2), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, 0, 64);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.JUMP_BOOST)
                                    .setAmplifier(1)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(ia);
                    menu.forceDestroy(p);
                }
                else {
                    menu.forceDestroy(p);
                    ChatUtil.sendMessage(p, "&cNie posiadasz 64 emeraldow!");
                }
            }
        });


        category.addElement(24, ItemData.fromItem(MainConstants.HASTE_1), new ItemClick() {
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
                    menu.forceDestroy(p);
                }
                else {
                    menu.forceDestroy(p);
                    ChatUtil.sendMessage(p, "&cNie posiadasz 32 emeraldow!");
                }
            }
        });

        category.addElement(33, ItemData.fromItem(MainConstants.HASTE_2), new ItemClick() {
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
                    menu.forceDestroy(p);
                }
                else {
                    menu.forceDestroy(p);
                    ChatUtil.sendMessage(p, "&cNie posiadasz 64 emeraldow!");
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
