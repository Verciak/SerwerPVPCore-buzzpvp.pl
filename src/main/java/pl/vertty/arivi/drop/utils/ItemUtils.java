// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.utils;

import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.item.Item;
import cn.nukkit.Player;

public class ItemUtils
{
    public static void recalculateDurability(final Player player, final Item item) {
        if (item.getId() == 285 || item.getId() == 278 || item.getId() == 285 || item.getId() == 257 || item.getId() == 274 || item.getId() == 270) {
            if (item.getMaxDurability() == 0) {
                return;
            }
            int enchantLevel = 0;
            final int d = item.getDamage();
            final int slot = player.getInventory().getHeldItemIndex();
            for (final Enchantment e2 : item.getEnchantments()) {
                if (e2.getId() == 17) {
                    if (e2.getLevel() == 1) {
                        enchantLevel = 1;
                        if (100 / (enchantLevel + 1) > RandomUtils.getRandInt(0, 100)) {
                            player.getInventory().removeItem(new Item[] { item });
                            item.setDamage(Integer.valueOf(d + 1));
                            player.getInventory().setItem(slot, item);
                        }
                    }
                    if (e2.getLevel() == 2) {
                        enchantLevel = 2;
                        if (200 / (enchantLevel + 1) > RandomUtils.getRandInt(0, 100)) {
                            player.getInventory().removeItem(new Item[] { item });
                            item.setDamage(Integer.valueOf(d + 1));
                            player.getInventory().setItem(slot, item);
                        }
                    }
                    if (e2.getLevel() == 3) {
                        enchantLevel = 3;
                        if (300 / (enchantLevel + 1) > RandomUtils.getRandInt(0, 100)) {
                            player.getInventory().removeItem(new Item[] { item });
                            item.setDamage(Integer.valueOf(d + 1));
                            player.getInventory().setItem(slot, item);
                        }
                    }
                    if (e2.getLevel() == 4) {
                        enchantLevel = 3;
                        if (400 / (enchantLevel + 1) > RandomUtils.getRandInt(0, 100)) {
                            player.getInventory().removeItem(new Item[] { item });
                            item.setDamage(Integer.valueOf(d + 1));
                            player.getInventory().setItem(slot, item);
                        }
                    }
                    if (e2.getLevel() == 5) {
                        enchantLevel = 3;
                        if (500 / (enchantLevel + 1) > RandomUtils.getRandInt(0, 100)) {
                            player.getInventory().removeItem(new Item[] { item });
                            item.setDamage(Integer.valueOf(d + 1));
                            player.getInventory().setItem(slot, item);
                        }
                    }
                    if (e2.getLevel() == 6) {
                        enchantLevel = 3;
                        if (600 / (enchantLevel + 1) > RandomUtils.getRandInt(0, 100)) {
                            player.getInventory().removeItem(new Item[] { item });
                            item.setDamage(Integer.valueOf(d + 1));
                            player.getInventory().setItem(slot, item);
                        }
                    }
                    if (e2.getLevel() == 7) {
                        enchantLevel = 3;
                        if (700 / (enchantLevel + 1) > RandomUtils.getRandInt(0, 100)) {
                            player.getInventory().removeItem(new Item[] { item });
                            item.setDamage(Integer.valueOf(d + 1));
                            player.getInventory().setItem(slot, item);
                        }
                    }
                }
            }
            player.getInventory().removeItem(new Item[] { item });
            item.setDamage(Integer.valueOf(d + 1));
            player.getInventory().setItem(slot, item);
            if (item.getId() == 270 && item.getDamage() >= 52) {
                player.getInventory().removeItem(new Item[] { item });
            }
            if (item.getId() == 274 && item.getDamage() >= 122) {
                player.getInventory().removeItem(new Item[] { item });
            }
            if (item.getId() == 257 && item.getDamage() >= 240) {
                player.getInventory().removeItem(new Item[] { item });
            }
            if (item.getId() == 285 && item.getDamage() >= 25) {
                player.getInventory().removeItem(new Item[] { item });
            }
            if (item.getId() == 278 && item.getDamage() >= 1551) {
                player.getInventory().removeItem(new Item[] { item });
            }
        }
    }
}
