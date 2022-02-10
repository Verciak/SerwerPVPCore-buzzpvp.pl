package pl.vertty.arivi;

import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.utils.ChatUtil;

public class MainConstants {
    public static Item ANTI_LEGS_ITEM;
    public static int BORDER;

    static {

        //Load default variable from config
        Config config = Main.getPlugin().getConfig();

        BORDER = config.getInt("border");

        //Create default itemstack
        ANTI_LEGS_ITEM = new Item(317, 0, 1);
        ANTI_LEGS_ITEM.setCustomName(ChatUtil.fixColor("&9ANTY-NOGI &8(&fCrafting&8)"));
        ANTI_LEGS_ITEM.setLore(ChatUtil.fixColor("&7Kliknij, aby otworzyc crafting"));
    }
}
