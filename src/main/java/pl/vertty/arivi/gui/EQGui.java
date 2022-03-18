package pl.vertty.arivi.gui;

import cn.nukkit.Player;
import cn.nukkit.block.BlockID;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.inventory.InventoryClickEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;
import com.google.common.io.ByteStreams;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import pl.vertty.arivi.eq.SerializerUtil;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.SimpleInventoryMenu;
import pl.vertty.arivi.utils.ChatUtil;

import java.util.Map;

public class EQGui implements Listener

{

    public static final String GUI_TITLE = "&r&7ZAPISZ EQ";

    private static final String SAVE_ITEM_NAME = "&r&aZAPISZ EQ";

    public static boolean isSaveItem(final Item item) {
        return item.getCustomName().equals(ChatUtil.fixColor(SAVE_ITEM_NAME));
    }

    public static boolean isGlassItem(final Item item) {
        return item.getCustomName().equals(ChatUtil.fixColor("&r&8*"));
    }

    public static void openTopki(final Player player) {


        final User user = UserManager.getUser(player);
        user.setStatus(true);
        final SimpleInventoryMenu menu = new SimpleInventoryMenu(true, ChatUtil.fixColor(GUI_TITLE));

        Item zapisz = new Item(BlockID.STONE);
        zapisz.setCustomName(ChatUtil.fixColor(SAVE_ITEM_NAME));


        Item szklo = new Item(BlockID.STAINED_GLASS_PANE, 15, 1);
        szklo.setCustomName(ChatUtil.fixColor("&r&8*"));

        menu.setItem(0, zapisz);


        menu.setItem(1, szklo);
        menu.setItem(2, szklo);
        menu.setItem(3, szklo);
        menu.setItem(4, szklo);
        menu.setItem(5, szklo);
        menu.setItem(6, szklo);
        menu.setItem(7, szklo);
        menu.setItem(8, szklo);
        menu.setItem(9, szklo);
        menu.setItem(10, szklo);
        menu.setItem(11, szklo);
        menu.setItem(12, szklo);
        menu.setItem(13, szklo);
        menu.setItem(14, szklo);
        menu.setItem(15, szklo);
        menu.setItem(16, szklo);
        menu.setItem(17, szklo);


        if (user.getEq_1().isEmpty()) {
            final Item miecz33 = Item.get(267, Integer.valueOf(0), 1);
            miecz33.addEnchantment(new Enchantment[]{Enchantment.getEnchantment(9).setLevel(3)});
            miecz33.addEnchantment(new Enchantment[]{Enchantment.getEnchantment(13).setLevel(1)});
            miecz33.addEnchantment(new Enchantment[]{Enchantment.getEnchantment(17).setLevel(3)});
            final Item kilof = Item.get(Item.DIAMOND_PICKAXE, Integer.valueOf(0), 1);
            kilof.addEnchantment(new Enchantment[]{Enchantment.getEnchantment(Enchantment.ID_EFFICIENCY).setLevel(5)});
            kilof.addEnchantment(new Enchantment[]{Enchantment.getEnchantment(Enchantment.ID_FORTUNE_DIGGING).setLevel(3)});
            kilof.addEnchantment(new Enchantment[]{Enchantment.getEnchantment(Enchantment.ID_DURABILITY).setLevel(3)});
            final Item knock = Item.get(267, Integer.valueOf(0), 1);
            knock.addEnchantment(new Enchantment[]{Enchantment.getEnchantment(Enchantment.ID_DAMAGE_ALL).setLevel(3)});
            knock.addEnchantment(new Enchantment[]{Enchantment.getEnchantment(Enchantment.ID_KNOCKBACK).setLevel(2)});
            final Item stone = Item.get(BlockID.COBBLESTONE, Integer.valueOf(0), 64);
            final Item woda = Item.get(Item.BUCKET, Integer.valueOf(8), 1);
            final Item refile = Item.get(322, Integer.valueOf(0), 8);
            final Item koxy = Item.get(466, Integer.valueOf(0), 1);
            final Item perly = Item.get(368, Integer.valueOf(0), 3);
            final Item sniezki = Item.get(ItemID.SNOWBALL, Integer.valueOf(0), 8);

            menu.setItem(45, miecz33);
            menu.setItem(46, koxy);
            menu.setItem(47, refile);
            menu.setItem(48, knock);
            menu.setItem(49, kilof);
            menu.setItem(50, woda);
            menu.setItem(51, stone);
            menu.setItem(52, sniezki);
            menu.setItem(53, perly);
        } else {
            final Map<Integer, Item> items = SerializerUtil.deserialize(user.getEq_1());
            items.forEach((slot, item) -> {
                if (slot >= 0 && slot <= 8) {
                    slot += 45;
                } else {
                    slot += 9;
                }

                menu.setItem(slot, item);
            });
        }

        menu.show(player);
    }
}
