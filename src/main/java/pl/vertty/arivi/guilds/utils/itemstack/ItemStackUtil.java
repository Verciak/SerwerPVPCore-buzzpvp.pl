
package pl.vertty.arivi.guilds.utils.itemstack;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import pl.vertty.arivi.guilds.utils.ChatUtil;

import java.util.*;

public class ItemStackUtil
{
    public static int getItemAmount(final Item material, final Player player, final short durability) {
        int amount = 0;
        for (final Item i : player.getInventory().getContents().values()) {
            if (i.getId() == material.getId()) {
                amount += i.getCount();
            }
            else {
                amount = 0;
            }
        }
        return amount;
    }
    
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
    
    public static void removeItems(final Player p, final String it, final int mod) {
        final List<Item> items = getItems(it, mod);
        for (final Item is : items) {
            final Item item = new Item(is.getId(), Integer.valueOf(is.getDamage()), is.getCount());
            if (p.getInventory().contains(item)) {
                p.getInventory().removeItem(new Item[] { item });
            }
        }
    }
    
    public static boolean checkItems(final Player p, final String it, final int mod) {
        final List<Item> items = getItems(it, mod);
        return items.stream().map(is -> new Item(is.getId(), Integer.valueOf(is.getDamage()), is.getCount())).allMatch(item -> p.getInventory().contains(item));
    }
    
    public static String getItem(final Player p, final String it, final int mod) {
        final List<Item> items = getItems(it, mod);
        ChatUtil.sendMessage((CommandSender)p, "&7Brakuje ci:");
        for (final Item is : items) {
            final int id = is.getId();
            final int data = is.getDamage();
            final int amount = is.getCount();
            final int ii = getItemAmount(is, p, (short)data);
            ChatUtil.sendMessage(p, " &8>> &f" + is.getCustomName() + " &7" + ii + "/" + amount +"\n");
        }
        return null;
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
    
    public static String getItem(final String s, final int n) {
        final Iterator<Item> iterator = getItems(s, n).iterator();
        if (iterator.hasNext()) {
            final Item itemStack = iterator.next();
            return String.valueOf(new StringBuilder().append(itemStack.getCount()).append(" &9").append(itemStack.getCustomName()));
        }
        return "puste";
    }
    
    private static String color(final int n, final int n2) {
        if (n >= n2) {
            return ChatUtil.fixColor("&8&l");
        }
        return ChatUtil.fixColor("&8&l");
    }
    
    public static Map<Block, Integer> getExplodedBlocks(final List<String> list) {
        final HashMap<Block, Integer> hashMap = new HashMap<Block, Integer>();
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            final String[] split = iterator.next().split(":");
            hashMap.put(Block.get(Integer.parseInt(split[0])), Integer.parseInt(split[1]));
        }
        return hashMap;
    }
    
    public static List<Block> getRegenerationBlocks(final List<String> list) {
        final ArrayList<Block> list2 = new ArrayList<Block>();
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(Block.get(Integer.parseInt(iterator.next())));
        }
        return list2;
    }
}
