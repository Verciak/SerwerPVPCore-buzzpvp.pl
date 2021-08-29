// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.utils;

import java.util.Map;
import java.util.Iterator;
import cn.nukkit.Player;
import cn.nukkit.item.Item;

public class RepairUtil
{
    private static final Item[] repairable;
    
    private static Item[] getRepairableItems() {
        return RepairUtil.repairable;
    }
    
    private static boolean containsRepairable(final Item[] repairable, final Item material) {
        for (final Item mat : repairable) {
            if (material == mat) {
                return true;
            }
        }
        return false;
    }
    
    private static int repairArmor(final Player player) {
        int in = 0;
        for (final Item i : player.getInventory().getArmorContents()) {
            if (i != null && i.getDamage() != new Item(i.getId()).getDamage()) {
                i.setDamage(Integer.valueOf(0));
                ++in;
            }
        }
        return in;
    }
    
    public static void repairAll(final Player player) {
        for (final Item i : player.getInventory().getContents().values()) {
            if (i != null && i.getDamage() != new Item(i.getId()).getDamage()) {
                player.getInventory().all(i).entrySet().forEach(entry -> {
                    Item cloned = entry.getValue().clone();
                    cloned.setDamage(Integer.valueOf(0));
                    player.getInventory().setItem((int)entry.getKey(), cloned);
                });
            }
        }
    }
    
    static {
        repairable = new Item[] { Item.get(278), Item.get(276), Item.get(279), Item.get(293), Item.get(310), Item.get(311), Item.get(312), Item.get(313), Item.get(257), Item.get(267), Item.get(258), Item.get(292), Item.get(306), Item.get(307), Item.get(308), Item.get(309), Item.get(285), Item.get(283), Item.get(286), Item.get(294), Item.get(314), Item.get(315), Item.get(316), Item.get(317), Item.get(274), Item.get(272), Item.get(275), Item.get(291), Item.get(305), Item.get(303), Item.get(304), Item.get(305), Item.get(270), Item.get(268), Item.get(271), Item.get(290), Item.get(259), Item.get(359), Item.get(261), Item.get(346), Item.get(145) };
    }
}
