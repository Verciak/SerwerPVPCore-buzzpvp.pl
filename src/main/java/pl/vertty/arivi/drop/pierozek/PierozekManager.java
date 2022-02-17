package pl.vertty.arivi.drop.pierozek;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.math.Vector3;
import org.apache.commons.lang3.RandomUtils;
import pl.vertty.arivi.utils.ChatUtil;

import java.util.ArrayList;
import java.util.List;

public class PierozekManager
{
    public static Item pandoreItem;
    public static List<Item> drop;
    
    public static Item getPandoreItem() {
        return PierozekManager.pandoreItem;
    }
    
    public static void giveItem(final BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        event.setCancelled(true);
        final Item pandoreItemm = PierozekManager.drop.get(RandomUtils.nextInt(0, PierozekManager.drop.size()));
        if (pandoreItemm.getCustomName().contains(ChatUtil.fixColor("Beacon")) && !pl.vertty.arivi.drop.utils.RandomUtils.getChance(4.2)) {
            return;
        }
        if (pandoreItemm.getCustomName().contains(ChatUtil.fixColor("Kilof 6/3/3")) && !pl.vertty.arivi.drop.utils.RandomUtils.getChance(7.2)) {
            return;
        }
        final Item win = Item.get(pandoreItemm.getId(), Integer.valueOf(pandoreItemm.getDamage()), pandoreItemm.getCount());
        if (pandoreItemm.hasEnchantments()) {
            win.addEnchantment(pandoreItemm.getEnchantments());
        }
        final PlayerInventory inventoryAutoAdd = event.getPlayer().getInventory();
        final Item[] itemsToAdd = { win };
        for (int i = 0; i < itemsToAdd.length; ++i) {
            final boolean canAddItem = inventoryAutoAdd.canAddItem(itemsToAdd[i]);
            if (canAddItem) {
                inventoryAutoAdd.addItem(new Item[] { itemsToAdd[i] });
            }
            else {
                Server.getInstance().getDefaultLevel().dropItem(new Vector3(event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ()), win);
            }
        }
        final Item itemInHand = event.getPlayer().getInventory().getItemInHand();
        if (itemInHand.getCount() <= 1) {
            event.getPlayer().getInventory().setItemInHand(new Item(0, Integer.valueOf(0), 0));
        }
        else {
            itemInHand.setCount(itemInHand.getCount() - 1);
            event.getPlayer().getInventory().setItemInHand(itemInHand);
        }
        if (pandoreItemm.getCustomName().contains(ChatUtil.fixColor("Beacon"))) {
            Server.getInstance().broadcastMessage(ChatUtil.fixColor("&7Gracz: &f{PLAYER} &7wydropil: &e{NAME} &7z &5Pandory!").replace("{PLAYER}", player.getName()).replace("{NAME}", pandoreItemm.getName()));
        }
        if (pandoreItemm.getCustomName().contains(ChatUtil.fixColor("Kilof 6/3/3"))) {
            Server.getInstance().broadcastMessage(ChatUtil.fixColor("&7Gracz: &f{PLAYER} &7wydropil: &e{NAME} &7z &5Pandory!").replace("{PLAYER}", player.getName()).replace("{NAME}", pandoreItemm.getName()));
        }
    }
    
    static {
        PierozekManager.drop = new ArrayList<>();
        final Item helm = new Item(306, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Zelazny Helm 3/2"));
        helm.addEnchantment(new Enchantment[] { Enchantment.get(0).setLevel(3, true) });
        helm.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(2, true) });
        final Item klata = new Item(307, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Zelazna Klata 3/2"));
        klata.addEnchantment(new Enchantment[] { Enchantment.get(0).setLevel(3, true) });
        klata.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(2, true) });
        final Item spodnie = new Item(308, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Zelazne Spodnie 3/2"));
        spodnie.addEnchantment(new Enchantment[] { Enchantment.get(0).setLevel(3, true) });
        spodnie.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(2, true) });
        final Item buty = new Item(309, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Zelazne Buty 3/2"));
        buty.addEnchantment(new Enchantment[] { Enchantment.get(0).setLevel(3, true) });
        buty.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(2, true) });
        final Item miecz = new Item(267, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Zelazny Miecz 3/2/3"));
        miecz.addEnchantment(new Enchantment[] { Enchantment.get(9).setLevel(3, true) });
        miecz.addEnchantment(new Enchantment[] { Enchantment.get(13).setLevel(2, true) });
        miecz.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(3, true) });
        final Item knock = new Item(267, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Zelazny Miecz 2/3"));
        knock.addEnchantment(new Enchantment[] { Enchantment.get(12).setLevel(2, true) });
        knock.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(3, true) });
        PierozekManager.drop.add(new Item(322, Integer.valueOf(0), 12).setCustomName(ChatUtil.fixColor("Refil")));
        PierozekManager.drop.add(new Item(466, Integer.valueOf(0), 2).setCustomName(ChatUtil.fixColor("Kox")));
        PierozekManager.drop.add(helm);
        PierozekManager.drop.add(klata);
        PierozekManager.drop.add(spodnie);
        PierozekManager.drop.add(buty);
        PierozekManager.drop.add(miecz);
        PierozekManager.drop.add(knock);
        PierozekManager.drop.add(new Item(46, Integer.valueOf(0), 32).setCustomName(ChatUtil.fixColor("TNT")));
        PierozekManager.drop.add(new Item(46, Integer.valueOf(0), 64).setCustomName(ChatUtil.fixColor("TNT")));
        final Item kilof533 = new Item(278, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Kilof 5/3/3"));
        kilof533.addEnchantment(new Enchantment[] { Enchantment.get(15).setLevel(5, true) });
        kilof533.addEnchantment(new Enchantment[] { Enchantment.get(18).setLevel(3, true) });
        kilof533.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(3, true) });
        PierozekManager.drop.add(kilof533);
        final Item kilof534 = new Item(278, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Kilof 6/3/3"));
        kilof534.addEnchantment(new Enchantment[] { Enchantment.get(15).setLevel(6, false) });
        kilof534.addEnchantment(new Enchantment[] { Enchantment.get(18).setLevel(3, true) });
        kilof534.addEnchantment(new Enchantment[] { Enchantment.get(17).setLevel(3, true) });
        PierozekManager.drop.add(kilof534);
        PierozekManager.drop.add(new Item(368, Integer.valueOf(0), 2).setCustomName(ChatUtil.fixColor("Perla")));
        PierozekManager.drop.add(new Item(3, Integer.valueOf(0), 64).setCustomName(ChatUtil.fixColor("Dirt")));
        PierozekManager.drop.add(new Item(266, Integer.valueOf(0), 16).setCustomName(ChatUtil.fixColor("Sztabka Zlota")));
        PierozekManager.drop.add(new Item(266, Integer.valueOf(0), 32).setCustomName(ChatUtil.fixColor("Sztabka Zlota")));
        PierozekManager.drop.add(new Item(265, Integer.valueOf(0), 16).setCustomName(ChatUtil.fixColor("Sztabka Zelaza")));
        PierozekManager.drop.add(new Item(265, Integer.valueOf(0), 32).setCustomName(ChatUtil.fixColor("Sztabka Zelaza")));
        PierozekManager.drop.add(new Item(264, Integer.valueOf(0), 16).setCustomName(ChatUtil.fixColor("Diament")));
        PierozekManager.drop.add(new Item(264, Integer.valueOf(0), 32).setCustomName(ChatUtil.fixColor("Diament")));
        PierozekManager.drop.add(new Item(388, Integer.valueOf(0), 16).setCustomName(ChatUtil.fixColor("Emerald")));
        PierozekManager.drop.add(new Item(388, Integer.valueOf(0), 32).setCustomName(ChatUtil.fixColor("Emerald")));
        PierozekManager.drop.add(new Item(145, Integer.valueOf(0), 3).setCustomName(ChatUtil.fixColor("Kowadlo")));
        PierozekManager.drop.add(new Item(Item.BEACON, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("Beacon")));
        (PierozekManager.pandoreItem = Item.get(122)).setCustomName(ChatUtil.fixColor("&r&5&lPandora"));
    }
}
