package pl.vertty.arivi.gui;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.potion.Effect;
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

public class EfektyGui
{
    public static void openSchowek(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(1, new ItemData(160, 15, 1, "&8*"));
        category.addElement(9, new ItemData(160, 15, 1, "&8*"));
        category.addElement(7, new ItemData(160, 15, 1, "&8*"));
        category.addElement(17, new ItemData(160, 15, 1, "&8*"));
        category.addElement(36, new ItemData(160, 15, 1, "&8*"));
        category.addElement(46, new ItemData(160, 15, 1, "&8*"));
        category.addElement(52, new ItemData(160, 15, 1, "&8*"));
        category.addElement(0, new ItemData(160, 3, 1, "&8*"));
        category.addElement(8, new ItemData(160, 3, 1, "&8*"));
        category.addElement(45, new ItemData(160, 3, 1, "&8*"));
        category.addElement(53, new ItemData(160, 3, 1, "&8*"));
        category.addElement(2, new ItemData(160, 3, 1, "&8*"));
        category.addElement(3, new ItemData(160, 3, 1, "&8*"));
        category.addElement(4, new ItemData(160, 3, 1, "&8*"));
        category.addElement(5, new ItemData(160, 3, 1, "&8*"));
        category.addElement(6, new ItemData(160, 3, 1, "&8*"));
        category.addElement(10, new ItemData(160, 3, 1, "&8*"));
        category.addElement(16, new ItemData(160, 3, 1, "&8*"));
        category.addElement(12, new ItemData(160, 3, 1, "&8*"));
        category.addElement(14, new ItemData(160, 3, 1, "&8*"));
        category.addElement(18, new ItemData(160, 3, 1, "&8*"));
        category.addElement(19, new ItemData(160, 3, 1, "&8*"));
        category.addElement(20, new ItemData(160, 3, 1, "&8*"));
        category.addElement(21, new ItemData(160, 3, 1, "&8*"));
        category.addElement(22, new ItemData(160, 3, 1, "&8*"));
        category.addElement(23, new ItemData(160, 3, 1, "&8*"));
        category.addElement(24, new ItemData(160, 3, 1, "&8*"));
        category.addElement(25, new ItemData(160, 3, 1, "&8*"));
        category.addElement(26, new ItemData(160, 3, 1, "&8*"));
        category.addElement(27, new ItemData(160, 3, 1, "&8*"));
        category.addElement(28, new ItemData(160, 3, 1, "&8*"));
        category.addElement(29, new ItemData(160, 3, 1, "&8*"));
        category.addElement(33, new ItemData(160, 3, 1, "&8*"));
        category.addElement(34, new ItemData(160, 3, 1, "&8*"));
        category.addElement(35, new ItemData(160, 3, 1, "&8*"));
        category.addElement(37, new ItemData(160, 3, 1, "&8*"));
        category.addElement(38, new ItemData(160, 3, 1, "&8*"));
        category.addElement(39, new ItemData(160, 3, 1, "&8*"));
        category.addElement(40, new ItemData(160, 3, 1, "&8*"));
        category.addElement(41, new ItemData(160, 3, 1, "&8*"));
        category.addElement(42, new ItemData(160, 3, 1, "&8*"));
        category.addElement(43, new ItemData(160, 3, 1, "&8*"));
        category.addElement(44, new ItemData(160, 15, 1, "&8*"));
        category.addElement(47, new ItemData(160, 3, 1, "&8*"));
        category.addElement(48, new ItemData(160, 3, 1, "&8*"));
        category.addElement(49, new ItemData(160, 3, 1, "&8*"));
        category.addElement(50, new ItemData(160, 3, 1, "&8*"));
        category.addElement(51, new ItemData(160, 3, 1, "&8*"));



        category.addElement(11, new ItemData(Item.IRON_BOOTS, 0, 1, "&9WYSOKIE SKAKANIE II", new String[] {
                ChatUtil.fixColor("&8» &7Czas trwania: &32 minuty"),
                ChatUtil.fixColor("&8» &7Koszt: &332 emeraldy"),
                "",
                ChatUtil.fixColor("&8» &7Kliknij, aby zakupic!")
        }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, Integer.valueOf(0), 32);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.JUMP_BOOST)
                                    .setAmplifier(1)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(new Item[] { ia });
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cNie posiadasz 32 emeraldow!");
                }
            }
        });

        category.addElement(13, new ItemData(Item.SUGAR, 0, 1, "&9SPEED I", new String[] {
                ChatUtil.fixColor("&8» &7Czas trwania: &32 minuty"),
                ChatUtil.fixColor("&8» &7Koszt: &364 emeraldy"),
                "",
                ChatUtil.fixColor("&8» &7Kliknij, aby zakupic!")
        }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, Integer.valueOf(0), 64);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.SPEED)
                                    .setAmplifier(0)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(new Item[] { ia });
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cNie posiadasz 64 emeraldow!");
                }
            }
        });

        category.addElement(15, new ItemData(Item.BLAZE_POWDER, 0, 1, "&9OCHRONA PRZED OGNIEM I", new String[] {
                ChatUtil.fixColor("&8» &7Czas trwania: &32 minuty"),
                ChatUtil.fixColor("&8» &7Koszt: &364 emeraldy"),
                "",
                ChatUtil.fixColor("&8» &7Kliknij, aby zakupic!")
        }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, Integer.valueOf(0), 64);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.FIRE_RESISTANCE)
                                    .setAmplifier(0)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(new Item[] { ia });
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cNie posiadasz 64 emeraldow!");
                }
            }
        });

        category.addElement(30, new ItemData(Item.DIAMOND_PICKAXE, 0, 1, "&9HASTE I", new String[] {
                ChatUtil.fixColor("&8» &7Czas trwania: &32 minuty"),
                ChatUtil.fixColor("&8» &7Koszt: &332 emeraldy"),
                "",
                ChatUtil.fixColor("&8» &7Kliknij, aby zakupic!")
        }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, Integer.valueOf(0), 32);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.HASTE)
                                    .setAmplifier(0)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(new Item[] { ia });
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cNie posiadasz 32 emeraldow!");
                }
            }
        });

        category.addElement(31, new ItemData(Item.DIAMOND_PICKAXE, 0, 1, "&9HASTE II", new String[] {
                ChatUtil.fixColor("&8» &7Czas trwania: &32 minuty"),
                ChatUtil.fixColor("&8» &7Koszt: &364 emeraldy"),
                "",
                ChatUtil.fixColor("&8» &7Kliknij, aby zakupic!")
        }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, Integer.valueOf(0), 64);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.HASTE)
                                    .setAmplifier(1)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(new Item[] { ia });
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cNie posiadasz 64 emeraldow!");
                }
            }
        });

        category.addElement(32, new ItemData(Item.DIAMOND_PICKAXE, 0, 1, "&9HASTE III", new String[] {
                ChatUtil.fixColor("&8» &7Czas trwania: &32 minuty"),
                ChatUtil.fixColor("&8» &7Koszt: &3128 emeraldy"),
                "",
                ChatUtil.fixColor("&8» &7Kliknij, aby zakupic!")
        }), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                final Item ia = new Item(388, Integer.valueOf(0), 128);
                if (p.getInventory().contains(ia)) {
                    p.addEffect(
                            Effect.getEffect(Effect.HASTE)
                                    .setAmplifier(2)
                                    .setDuration(20*120)
                                    .setVisible(true));
                    p.getInventory().removeItem(new Item[] { ia });
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cNie posiadasz 128 emeraldow!");
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
