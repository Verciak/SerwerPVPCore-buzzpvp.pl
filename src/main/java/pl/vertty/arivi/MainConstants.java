package pl.vertty.arivi;

import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.utils.ChatUtil;

public class MainConstants {
    //BORDER MAPY
    public static int BORDER;

    //CRAFTINGI
    public static Item ANTI_LEGS_ITEM;
    public static Item RZUCAK_ITEM;
    public static Item STONIARKA_ITEM;
    public static Item ENDERCHEST_ITEM;
    public static Item OBSYDIAN;
    public static Item PERLA;
    public static Item DIAMENT;
    public static Item COBBLESTONE;
    public static Item TNT;
    public static Item GOLD_BLOCK;
    public static Item GOLD_BOOTS;
    public static Item ENDERCHEST_GUI_ITEM;
    public static Item ENDERCHEST;
    public static Item STONIARKA_GUI_ITEM;
    public static Item STONIARKA;
    public static Item RZUCAK_GUI_ITEM;
    public static Item RZUCAK;
    public static Item ANTI_LEGS_GUI_ITEM;
    public static Item ANTI_LEGS;

    static {
        //WCZYTYWANIE CFG
        Config config = Main.getPlugin().getConfig();
        //BORDER MAPY
        BORDER = config.getInt("border");

        //CRAFTINGI
        ANTI_LEGS_ITEM = new Item(317, 0, 1);
        ANTI_LEGS_ITEM.setCustomName(ChatUtil.fixColor("&9ANTY-NOGI &8(&fCrafting&8)"));
        ANTI_LEGS_ITEM.setLore(ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting"));
        RZUCAK_ITEM = new Item(46, 0, 1);
        RZUCAK_ITEM.setCustomName(ChatUtil.fixColor("&9RZUCANETNT &8(&fCrafting&8)"));
        RZUCAK_ITEM.setLore(ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting"));
        STONIARKA_ITEM = new Item(121, 0, 1);
        STONIARKA_ITEM.setCustomName(ChatUtil.fixColor("&9STONIARKA &8(&fCrafting&8)"));
        STONIARKA_ITEM.setLore(ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting"));
        ENDERCHEST_ITEM = new Item(130, 0, 1);
        ENDERCHEST_ITEM.setCustomName(ChatUtil.fixColor("&9ENDERCHEST &8(&fCrafting&8)"));
        ENDERCHEST_ITEM.setLore(ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting"));
        OBSYDIAN = new Item(49, 0, 1);
        OBSYDIAN.setCustomName(ChatUtil.fixColor("&9OBSYDIAN"));
        PERLA = new Item(368, 0, 1);
        PERLA.setCustomName(ChatUtil.fixColor("&9PERLA"));
        DIAMENT = new Item(264, 0, 1);
        DIAMENT.setCustomName(ChatUtil.fixColor("&9DIAMENT"));
        TNT = new Item(46, 0, 1);
        TNT.setCustomName(ChatUtil.fixColor("&9TNT"));
        COBBLESTONE = new Item(4, 0, 1);
        COBBLESTONE.setCustomName(ChatUtil.fixColor("&9COBBLESTONE"));
        GOLD_BLOCK = new Item(41, 0, 1);
        GOLD_BLOCK.setCustomName(ChatUtil.fixColor("&9BLOK ZLOTA"));
        GOLD_BOOTS = new Item(317, 0, 1);
        GOLD_BOOTS.setCustomName(ChatUtil.fixColor("&9ZLOTE BUTY"));
        ENDERCHEST_GUI_ITEM = new Item(58, 0, 1);
        ENDERCHEST_GUI_ITEM.setLore(ChatUtil.fixColor("&9Kliknij, aby stworzyc ENDERCHEST"));
        ENDERCHEST = new Item(130, 0, 1);
        ENDERCHEST.setCustomName(ChatUtil.fixColor("&9ENDERCHEST"));
        STONIARKA_GUI_ITEM = new Item(58, 0, 1);
        STONIARKA_GUI_ITEM.setLore(ChatUtil.fixColor("&9Kliknij, aby stworzyc STONIARKA"));
        STONIARKA = new Item(130, 0, 1);
        STONIARKA.setCustomName(ChatUtil.fixColor("&9STONIARKA"));
        STONIARKA.setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&7Kliknij, PPM aby postawic STONIARKA") });
        RZUCAK_GUI_ITEM = new Item(58, 0, 1);
        RZUCAK_GUI_ITEM.setLore(ChatUtil.fixColor("&9Kliknij, aby stworzyc RZUCAK"));
        RZUCAK = new Item(46, 0, 1);
        RZUCAK.setCustomName(ChatUtil.fixColor("&9RZUCANETNT"));
        RZUCAK.setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&7Kliknij, PPM aby postawic RZUCANETNT") });
        ANTI_LEGS_GUI_ITEM = new Item(58, 0, 1);
        ANTI_LEGS_GUI_ITEM.setLore(ChatUtil.fixColor("&9Kliknij, aby stworzyc ANTY-NOGI"));
        ANTI_LEGS = new Item(317, 0, 1);
        ANTI_LEGS.setCustomName(ChatUtil.fixColor("&9ANTY-NOGI"));
        ANTI_LEGS.setLore(new String[] { ChatUtil.fixColor(""), ChatUtil.fixColor("&7Kliknij, PPM aby postawic ANTY-NOG") });



    }
}
