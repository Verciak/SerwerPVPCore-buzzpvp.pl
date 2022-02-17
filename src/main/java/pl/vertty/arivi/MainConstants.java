package pl.vertty.arivi;

import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.utils.ChatUtil;

public class MainConstants {
    //BORDER MAPY
    public static int BORDER;

    //GLASS GUI
    public static Item BLACK_GLASS;
    public static Item BLUE_GLASS;

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

    //EFFECTS GUI
    public static Item HIGH_JUMP;
    public static Item SPEED;
    public static Item FIRE;
    public static Item HASTE_1;
    public static Item HASTE_2;
    public static Item HASTE_3;


    //ADMINPANEL COMMAND GUI STATUS
    public static Item PANDORA_ITEM_ADMINPANEL;
    public static Item KITS_ADMINPANEL;

    //ENCHANT GUI
    public static Item UNBREAKING_1;
    public static Item UNBREAKING_2;
    public static Item UNBREAKING_3;

    public static Item PROTECTION_1;
    public static Item PROTECTION_2;
    public static Item PROTECTION_3;

    public static void set() {
        //WCZYTYWANIE CFG
        Config config = Main.getPlugin().getConfig();
        //BORDER MAPY
        BORDER = config.getInt("border");

        //GLASS GUI
        BLACK_GLASS = new Item(160, 15, 1);
        BLUE_GLASS = new Item(160, 11, 1);


        //CRAFTINGI
        ANTI_LEGS_ITEM = new Item(317, 0, 1);
        ANTI_LEGS_ITEM.setCustomName(ChatUtil.fixColor("&r&9ANTY-NOGI &8(&fCrafting&8)"));
        ANTI_LEGS_ITEM.setLore(ChatUtil.fixColor("&r&7Kliknij, aby otworzyc crafting"));
        RZUCAK_ITEM = new Item(46, 0, 1);
        RZUCAK_ITEM.setCustomName(ChatUtil.fixColor("&r&9RZUCANETNT &8(&fCrafting&8)"));
        RZUCAK_ITEM.setLore(ChatUtil.fixColor("&r&7Kliknij, aby otworzyc crafting"));
        STONIARKA_ITEM = new Item(121, 0, 1);
        STONIARKA_ITEM.setCustomName(ChatUtil.fixColor("&r&9STONIARKA &8(&fCrafting&8)"));
        STONIARKA_ITEM.setLore(ChatUtil.fixColor("&r&7Kliknij, aby otworzyc crafting"));
        ENDERCHEST_ITEM = new Item(130, 0, 1);
        ENDERCHEST_ITEM.setCustomName(ChatUtil.fixColor("&r&9ENDERCHEST &8(&fCrafting&8)"));
        ENDERCHEST_ITEM.setLore(ChatUtil.fixColor("&r&7Kliknij, aby otworzyc crafting"));
        OBSYDIAN = new Item(49, 0, 1);
        OBSYDIAN.setCustomName(ChatUtil.fixColor("&r&9OBSYDIAN"));
        PERLA = new Item(368, 0, 1);
        PERLA.setCustomName(ChatUtil.fixColor("&r&9PERLA"));
        DIAMENT = new Item(264, 0, 1);
        DIAMENT.setCustomName(ChatUtil.fixColor("&r&9DIAMENT"));
        TNT = new Item(46, 0, 1);
        TNT.setCustomName(ChatUtil.fixColor("&r&9TNT"));
        COBBLESTONE = new Item(4, 0, 1);
        COBBLESTONE.setCustomName(ChatUtil.fixColor("&r&9COBBLESTONE"));
        GOLD_BLOCK = new Item(41, 0, 1);
        GOLD_BLOCK.setCustomName(ChatUtil.fixColor("&r&9BLOK ZLOTA"));
        GOLD_BOOTS = new Item(317, 0, 1);
        GOLD_BOOTS.setCustomName(ChatUtil.fixColor("&r&9ZLOTE BUTY"));
        ENDERCHEST_GUI_ITEM = new Item(58, 0, 1);
        ENDERCHEST_GUI_ITEM.setLore(ChatUtil.fixColor("&r&9Kliknij, aby stworzyc ENDERCHEST"));
        ENDERCHEST = new Item(130, 0, 1);
        ENDERCHEST.setCustomName(ChatUtil.fixColor("&r&9ENDERCHEST"));
        STONIARKA_GUI_ITEM = new Item(58, 0, 1);
        STONIARKA_GUI_ITEM.setLore(ChatUtil.fixColor("&r&9Kliknij, aby stworzyc STONIARKA"));
        STONIARKA = new Item(Item.END_STONE, 0, 1);
        STONIARKA.setCustomName(ChatUtil.fixColor("&r&9STONIARKA"));
        STONIARKA.setLore(ChatUtil.fixColor(""), ChatUtil.fixColor("&r&7Kliknij, PPM aby postawic STONIARKA"));
        RZUCAK_GUI_ITEM = new Item(58, 0, 1);
        RZUCAK_GUI_ITEM.setLore(ChatUtil.fixColor("&r&9Kliknij, aby stworzyc RZUCAK"));
        RZUCAK = new Item(46, 0, 1);
        RZUCAK.setCustomName(ChatUtil.fixColor("&r&9RZUCANETNT"));
        RZUCAK.setLore(ChatUtil.fixColor(""), ChatUtil.fixColor("&r&7Kliknij, PPM aby postawic RZUCANETNT"));
        ANTI_LEGS_GUI_ITEM = new Item(58, 0, 1);
        ANTI_LEGS_GUI_ITEM.setLore(ChatUtil.fixColor("&r&9Kliknij, aby stworzyc ANTY-NOGI"));
        ANTI_LEGS = new Item(317, 0, 1);
        ANTI_LEGS.setCustomName(ChatUtil.fixColor("&r&9ANTY-NOGI"));
        ANTI_LEGS.setLore(ChatUtil.fixColor(""), ChatUtil.fixColor("&r&7Kliknij, PPM aby postawic ANTY-NOG"));


        //EFFECTS GUI
        HIGH_JUMP = new Item(Item.IRON_BOOTS, 0, 1);
        HIGH_JUMP.setCustomName(ChatUtil.fixColor("&r&9WYSOKIE SKAKANIE II"));
        HIGH_JUMP.setLore(ChatUtil.fixColor("&r&8» &7Czas trwania: &32 minuty"), ChatUtil.fixColor("&r&7&8» &7Koszt: &332 emeraldy"), ChatUtil.fixColor(""), ChatUtil.fixColor("&r&8» &7Kliknij, aby zakupic!"));

        SPEED = new Item(Item.SUGAR, 0, 1);
        SPEED.setCustomName(ChatUtil.fixColor("&r&9SPEED I"));
        SPEED.setLore(ChatUtil.fixColor("&r&8» &7Czas trwania: &32 minuty"), ChatUtil.fixColor("&r&7&8» &7Koszt: &364 emeraldy"), ChatUtil.fixColor(""), ChatUtil.fixColor("&r&8» &7Kliknij, aby zakupic!"));

        FIRE = new Item(Item.BLAZE_POWDER, 0, 1);
        FIRE.setCustomName(ChatUtil.fixColor("&r&9OCHRONA PRZED OGNIEM"));
        FIRE.setLore(ChatUtil.fixColor("&r&8» &7Czas trwania: &32 minuty"), ChatUtil.fixColor("&r&7&8» &7Koszt: &364 emeraldy"), ChatUtil.fixColor(""), ChatUtil.fixColor("&r&8» &7Kliknij, aby zakupic!"));

        HASTE_1 = new Item(Item.END_CRYSTAL, 0, 1);
        HASTE_1.setCustomName(ChatUtil.fixColor("&r&9HASTE I"));
        HASTE_1.setLore(ChatUtil.fixColor("&r&8» &7Czas trwania: &32 minuty"), ChatUtil.fixColor("&r&7&8» &7Koszt: &332 emeraldy"), ChatUtil.fixColor(""), ChatUtil.fixColor("&r&8» &7Kliknij, aby zakupic!"));

        HASTE_2 = new Item(Item.END_CRYSTAL, 0, 1);
        HASTE_2.setCustomName(ChatUtil.fixColor("&r&9HASTE II"));
        HASTE_2.setLore(ChatUtil.fixColor("&r&8» &7Czas trwania: &32 minuty"), ChatUtil.fixColor("&r&7&8» &7Koszt: &364 emeraldy"), ChatUtil.fixColor(""), ChatUtil.fixColor("&r&8» &7Kliknij, aby zakupic!"));

        HASTE_3 = new Item(Item.END_CRYSTAL, 0, 1);
        HASTE_3.setCustomName(ChatUtil.fixColor("&r&9HASTE III"));
        HASTE_3.setLore(ChatUtil.fixColor("&r&8» &7Czas trwania: &32 minuty"), ChatUtil.fixColor("&r&7&8» &7Koszt: &3128 emeraldy"), ChatUtil.fixColor(""), ChatUtil.fixColor("&r&8» &7Kliknij, aby zakupic!"));

        //ADMINPANEL COMMAND GUI
        PANDORA_ITEM_ADMINPANEL = new Item(122, 0, 1);
        PANDORA_ITEM_ADMINPANEL.setCustomName(ChatUtil.fixColor("&r&5Pandora"));
        PANDORA_ITEM_ADMINPANEL.setLore(ChatUtil.fixColor("&r&8» &7Aktualny status: " + (config.getBoolean("enable.pandora.status") ? "&a✔" : "&c✖")));

        KITS_ADMINPANEL = new Item(368, 0, 1);
        KITS_ADMINPANEL.setCustomName(ChatUtil.fixColor("&r&5Kity"));
        KITS_ADMINPANEL.setLore(ChatUtil.fixColor("&r&8» &7Aktualny status: " + (config.getBoolean("enable.kits.status") ? "&a✔" : "&c✖")));

        //ENCHANT GUI
        UNBREAKING_3 = new Item(403, 0, 1);
        UNBREAKING_3.setCustomName(ChatUtil.fixColor("&r&9Niezniszczalnosc &eIII"));
        UNBREAKING_3.setLore(ChatUtil.fixColor(new String[] { "&r&9Koszt: &720 LvL", "&r&9Ilosc wymaganych biblioteczek: &715" }));

        UNBREAKING_2 = new Item(403, 0, 1);
        UNBREAKING_2.setCustomName(ChatUtil.fixColor("&r&9Niezniszczalnosc &eII"));
        UNBREAKING_2.setLore(ChatUtil.fixColor(new String[] { "&r&9Koszt: &715 LvL", "&r&9Ilosc wymaganych biblioteczek: &710" }));

        UNBREAKING_1 = new Item(403, 0, 1);
        UNBREAKING_1.setCustomName(ChatUtil.fixColor("&r&9Niezniszczalnosc &eI"));
        UNBREAKING_1.setLore(ChatUtil.fixColor(new String[] { "&r&9Koszt: &710 LvL", "&r&9Ilosc wymaganych biblioteczek: &75" }));


        PROTECTION_1 = new Item(403, 0, 1);
        PROTECTION_1.setCustomName(ChatUtil.fixColor("&r&9Ochrona &eI"));
        PROTECTION_1.setLore(ChatUtil.fixColor(new String[] { "&r&9Koszt: &710 LvL", "&r&9Ilosc wymaganych biblioteczek: &75" }));

        PROTECTION_2 = new Item(403, 0, 1);
        PROTECTION_2.setCustomName(ChatUtil.fixColor("&r&9Ochrona &eII"));
        PROTECTION_2.setLore(ChatUtil.fixColor(new String[] { "&r&9Koszt: &715 LvL", "&r&9Ilosc wymaganych biblioteczek: &710" }));

        PROTECTION_3 = new Item(403, 0, 1);
        PROTECTION_3.setCustomName(ChatUtil.fixColor("&r&9Ochrona &eIII"));
        PROTECTION_3.setLore(ChatUtil.fixColor(new String[] { "&r&9Koszt: &720 LvL", "&r&9Ilosc wymaganych biblioteczek: &715" }));

    }
}
