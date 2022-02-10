// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.skrzynka;

import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.utils.ChatUtil;

import java.util.ArrayList;
import java.util.List;

public class SkrzynkaManager
{
    public static List<Item> drop;
    public static Item key;
    public static Item mcase;
    
    static {
        SkrzynkaManager.drop = new ArrayList<Item>();
        final Item helm = new Item(306, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Zelazny Helm 4/1"));
        helm.addEnchantment(new Enchantment[] { Enchantment.get(0).setLevel(4, true) });
        helm.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(1, true) });
        final Item klata = new Item(307, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Zelazna Klata 4/1"));
        klata.addEnchantment(new Enchantment[] { Enchantment.get(0).setLevel(4, true) });
        klata.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(1, true) });
        final Item spodnie = new Item(308, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Zelazne Spodnie 4/1"));
        spodnie.addEnchantment(new Enchantment[] { Enchantment.get(0).setLevel(4, true) });
        spodnie.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(1, true) });
        final Item buty = new Item(309, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Zelazne Buty 4/1"));
        buty.addEnchantment(new Enchantment[] { Enchantment.get(0).setLevel(4, true) });
        buty.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(1, true) });
        final Item miecz = new Item(267, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Zelazny Miecz 3/2/3"));
        miecz.addEnchantment(new Enchantment[] { Enchantment.get(9).setLevel(3, true) });
        miecz.addEnchantment(new Enchantment[] { Enchantment.get(13).setLevel(2, true) });
        miecz.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(3, true) });
        final Item knock = new Item(267, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Zelazny Miecz 2/3"));
        knock.addEnchantment(new Enchantment[] { Enchantment.get(12).setLevel(2, true) });
        knock.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(3, true) });
        SkrzynkaManager.drop.add(helm);
        SkrzynkaManager.drop.add(klata);
        SkrzynkaManager.drop.add(spodnie);
        SkrzynkaManager.drop.add(buty);
        SkrzynkaManager.drop.add(miecz);
        SkrzynkaManager.drop.add(knock);
        SkrzynkaManager.drop.add(new Item(466, Integer.valueOf(0), 1));
        SkrzynkaManager.drop.add(new Item(466, Integer.valueOf(0), 2));
        SkrzynkaManager.drop.add(new Item(322, Integer.valueOf(0), 1));
        SkrzynkaManager.drop.add(new Item(322, Integer.valueOf(0), 4));
        SkrzynkaManager.drop.add(new Item(322, Integer.valueOf(0), 8));
        SkrzynkaManager.drop.add(new Item(322, Integer.valueOf(0), 12));
        SkrzynkaManager.drop.add(new Item(368, Integer.valueOf(0), 1));
        SkrzynkaManager.drop.add(new Item(368, Integer.valueOf(0), 2));
        SkrzynkaManager.drop.add(new Item(368, Integer.valueOf(0), 3));
        final Item kilof53 = new Item(278, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Kilof 5/3"));
        kilof53.addEnchantment(new Enchantment[] { Enchantment.get(15).setLevel(5, true) });
        kilof53.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(3, true) });
        final Item kilof54 = new Item(278, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Kilof 5/3/3"));
        kilof54.addEnchantment(new Enchantment[] { Enchantment.get(15).setLevel(5, true) });
        kilof54.addEnchantment(new Enchantment[] { Enchantment.get(18).setLevel(3, true) });
        kilof54.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(3, true) });
        SkrzynkaManager.drop.add(kilof53);
        SkrzynkaManager.drop.add(kilof54);
        SkrzynkaManager.drop.add(new Item(3, Integer.valueOf(0), 64).setCustomName(ChatUtil.fixColor("Dirt")));
        SkrzynkaManager.drop.add(new Item(145, Integer.valueOf(0), 6).setCustomName(ChatUtil.fixColor("Kowadlo")));
        SkrzynkaManager.drop.add(new Item(266, Integer.valueOf(0), 32).setCustomName(ChatUtil.fixColor("Sztabka Zlota")));
        SkrzynkaManager.drop.add(new Item(266, Integer.valueOf(0), 64).setCustomName(ChatUtil.fixColor("Sztabka Zlota")));
        SkrzynkaManager.drop.add(new Item(265, Integer.valueOf(0), 32).setCustomName(ChatUtil.fixColor("Sztabka Zelaza")));
        SkrzynkaManager.drop.add(new Item(265, Integer.valueOf(0), 64).setCustomName(ChatUtil.fixColor("Sztabka Zelaza")));
        SkrzynkaManager.drop.add(new Item(264, Integer.valueOf(0), 32).setCustomName(ChatUtil.fixColor("Diament")));
        SkrzynkaManager.drop.add(new Item(264, Integer.valueOf(0), 64).setCustomName(ChatUtil.fixColor("Diament")));
        SkrzynkaManager.drop.add(new Item(388, Integer.valueOf(0), 32).setCustomName(ChatUtil.fixColor("Emerald")));
        SkrzynkaManager.drop.add(new Item(388, Integer.valueOf(0), 64).setCustomName(ChatUtil.fixColor("Emerald")));
        SkrzynkaManager.drop.add(new Item(138, Integer.valueOf(0), 1));
        final Item magiccase = Item.get(54, Integer.valueOf(0), 1);
        magiccase.setCustomName(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("case.name")));
        magiccase.setLore(new String[] { ChatUtil.fixColor(Main.getPlugin().getConfig().getString("case.lore1")), ChatUtil.fixColor(Main.getPlugin().getConfig().getString("case.lore2")) });
        magiccase.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(10, false) });
        final Item i = Item.get(421, Integer.valueOf(0), 1);
        i.setCustomName(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("key.name")));
        SkrzynkaManager.key = i;
        SkrzynkaManager.mcase = magiccase;
    }
}
