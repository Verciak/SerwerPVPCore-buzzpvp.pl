package pl.vertty.arivi.gui.drop;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;

public class DropObsidianGui {


    public static void openMain(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.setDoubleLeavesServerGui();

        category.addElementAir(new ItemData(Item.OBSIDIAN,0, 1, "&r&9OBSYDIAN"));
        final Item back = new Item(ItemID.NETHER_STAR, 0, 1);
        back.setCustomName(ChatUtil.fixColor("&r&cPOWROT"));
        final Item exp = new Item(384, 0, 1);
        exp.setCustomName(ChatUtil.fixColor("&r&9DOSWIADCZENIE"));
        exp.setLore(ChatUtil.fixColor("&r&8>> &7OBSYDIAN: &34"));

        final Item info = new Item(ItemID.PAPER, 0, 1);
        info.setCustomName(ChatUtil.fixColor("&r&9INFORMACJE"));
        info.setLore(ChatUtil.fixColor("&r&8>> &7Ilos jaka moze wydropic to: &31-3"));

        category.addElement(49, ItemData.fromItem(back), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                DropMainGui.openMain(player);
            }
        });

        category.addElement(51, ItemData.fromItem(exp));
        category.addElement(47, ItemData.fromItem(info));

        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("MainObsydianGUI", category);
        menu.setName(ChatUtil.fixColor("&9MENU DROPU"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("MainObsydianGUI", menu);
    }

}
