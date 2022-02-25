
package pl.vertty.arivi.utils.guild.itemstack;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.item.Item;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.utils.guild.ChatUtil;

import java.util.*;

public class ItemStackUtil
{
    public static List<Item> getItems(final String string, final int modifier) {
        final List<Item> items = new ArrayList<Item>();
        for (final String s : string.split(";")) {
            final String[] split = s.split("-");
            final int id = Integer.parseInt(split[0].split(":")[0]);
            final int data = Integer.parseInt(split[0].split(":")[1]);
            final int amount = Integer.parseInt(split[1].split(":")[0]) * modifier;
            final String name = split[1].split(":")[1];
            final Item is = new Item(id, Integer.valueOf(data), amount);
            is.setCustomName(name);
            items.add(is);
        }
        return items;
    }

    public static boolean checkItems(final Player p, final String it, final int mod) {
        final List<Item> items = getItems(it, mod);
        return items.stream().map(is -> new Item(is.getId(), Integer.valueOf(is.getDamage()), is.getCount())).allMatch(item -> p.getInventory().contains(item));
    }

    public static int getItem(final String it, final int mod) {
        final List<Item> items = getItems(it, mod);
        return items.size();
    }

    public static String getItem(final Player p, final String it, final int mod) {
        final List<Item> items = getItems(it, mod);
        ChatUtil.sendMessage((CommandSender)p, "&7Brakuje ci:");
        for (final Item is : items) {
            final int id = is.getId();
            final int data = is.getDamage();
            final int amount = is.getCount();
            final int ii = getItemAmount(is, p);
            ChatUtil.sendMessage((CommandSender)p, color(ii, amount) + " - " + is.getCustomName() + " " + ii + "/" + amount + " - " + ii / (double)amount * 100.0 + "%\n");
        }
        return null;
    }

    public static String getItemJoin(final Player p, final String it, final int mod) {
        final List<Item> items = getItems(it, mod);
        String s = "&7Aby dolaczyc do gildii potrzbujesz &6";
        for (final Item is : items) {
            final int id = is.getId();
            final int data = is.getDamage();
            final int amount = is.getCount();
            final int ii = getItemAmount(is, p);
            s = s + is.getCustomName() + " " + amount + " &7sztuk";
        }
        ChatUtil.sendMessage((CommandSender)p, s);
        return null;
    }

    public static int getAmount(final int i) {
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public static void removeItems(final Player p, final String it, final int mod) {
        final List<Item> items = getItems(it, mod);
        for (final Item is : items) {
            final Item item = new Item(is.getId(), Integer.valueOf(is.getDamage()), is.getCount());
            if (p.getInventory().contains(item)) {
                p.getInventory().removeItem(new Item[] { item });
            }
        }
    }

    public static int getItemAmount(final Item material, final Player player) {
        int amount = 0;
        for (final Item itemStack : player.getInventory().getContents().values()) {
            if (itemStack.getId() == material.getId()) {
                amount += itemStack.getCount();
            }
        }
        return amount;
    }

    public static int getAmountOfItem(final Item is, final Player player, final short durability) {
        int amount = 0;
        for (final Item itemStack : player.getInventory().getContents().values()) {
            if (itemStack != null && itemStack.getDamage() == durability) {
                amount += itemStack.getCount();
            }
        }
        return amount;
    }

    private static String color(final int i, final int i2) {
        if (i >= i2) {
            return ChatUtil.fixColor("&a");
        }
        return ChatUtil.fixColor("&c");
    }

    public static int remove(final Item base, final Player player, final int amount) {
        int actual = 0;
        int remaining = amount;
        for (final Item itemStack : player.getInventory().getContents().values()) {
            if (actual == amount) {
                break;
            }
            if (itemStack == null || !itemStack.equals((Object)base)) {
                continue;
            }
            if (itemStack.getDamage() != base.getDamage()) {
                continue;
            }
            if (remaining == 0) {
                actual += itemStack.getCount();
                player.getInventory().remove(itemStack);
            }
            else if (itemStack.getCount() >= amount) {
                actual += itemStack.getCount() - amount;
                itemStack.setCount(amount);
                remaining = 0;
            }
            else {
                final int add = itemStack.getCount();
                remaining -= add;
                player.getInventory().remove(itemStack);
                actual += add;
            }
        }
        return actual;
    }

    public static void giveItem(final Player player, final Item item) {
        final Item daj = Item.get(item.getId(), Integer.valueOf(item.getDamage()), item.getCount());
        if (item.hasCustomName()) {
            daj.setCustomName(ChatUtil.fixColor(item.getCustomName()));
        }
        if (item.hasEnchantments()) {
            daj.addEnchantment(item.getEnchantments());
        }
        final PlayerInventory inventoryAutoAdd = player.getInventory();
        final Item[] itemsToAdd = { daj };
        for (int i = 0; i < itemsToAdd.length; ++i) {
            final boolean canAddItem = inventoryAutoAdd.canAddItem(itemsToAdd[i]);
            if (canAddItem) {
                inventoryAutoAdd.addItem(new Item[] { itemsToAdd[i] });
            }
            else {
                Server.getInstance().getDefaultLevel().dropItem(new Vector3(player.getX(), player.getY(), player.getZ()), daj);
            }
        }
    }

    public static void giveItems(final Player player, final Item... Items) {
        for (final Item item : Items) {
            final Item daj = Item.get(item.getId(), Integer.valueOf(item.getDamage()), item.getCount());
            if (item.hasCustomName()) {
                daj.setCustomName(ChatUtil.fixColor(item.getCustomName()));
            }
            if (item.hasEnchantments()) {
                daj.addEnchantment(item.getEnchantments());
            }
            giveItem(player, daj);
        }
    }

}
